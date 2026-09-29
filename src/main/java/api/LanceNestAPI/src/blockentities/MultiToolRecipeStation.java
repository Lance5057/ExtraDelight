package api.LanceNestAPI.src.blockentities;

import java.util.HashSet;
import java.util.Optional;

import api.LanceNestAPI.src.blocks.RecipeToolSupplier.RecipeToolSupplierBlockEntity;
import api.LanceNestAPI.src.blocks.RecipeToolSupplier.components.item.BlockEntityItemHandler;
import api.LanceNestAPI.src.recipes.AnimatedRecipeItemUse;
import api.LanceNestAPI.src.recipes.multitoolrecipe.MultiToolRecipe;
import api.LanceNestAPI.src.util.ItemUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.neoforged.neoforge.common.util.Lazy;
import net.neoforged.neoforge.items.IItemHandler;

public abstract class MultiToolRecipeStation<V extends MultiToolRecipe> extends WorkstationBasicBlockEntity {
	public static final String INVENTORY_TAG = "inv";

	public boolean recipeLocked = false;
	protected ItemStack lastUsed = ItemStack.EMPTY;
	protected int progress;
	protected int maxProgress;
	protected Ingredient curTool;
	public int toolCount;
	public int stage = 0;
	public final int width;
	public final int height;
	public final int numSlots;

	protected final BlockEntityItemHandler inventory = createItemHandler();
	protected final Lazy<BlockEntityItemHandler> itemHandler = Lazy.of(() -> inventory);

	public HashSet<BlockPos> toolSuppliers = new HashSet<BlockPos>();

	public BlockEntityItemHandler getInventory() {
		return itemHandler.get();
	};

	public MultiToolRecipeStation(int slots, int width, int height, BlockEntityType<?> tileEntityTypeIn, BlockPos pos,
			BlockState state) {
		super(tileEntityTypeIn, pos, state);

		this.width = width;
		this.height = height;
		this.numSlots = slots;
	}

	public void searchForToolSuppliers(Level l) {
		for (int x = worldPosition.getX() - 5; x <= worldPosition.getX() + 5; x++)
			for (int y = worldPosition.getY() - 5; y <= worldPosition.getY() + 5; y++)
				for (int z = worldPosition.getZ() - 5; z <= worldPosition.getZ() + 5; z++) {
					BlockPos pos = new BlockPos(x, y, z);
					BlockEntity ent = l.getBlockEntity(pos);

					if (ent instanceof RecipeToolSupplierBlockEntity)
						toolSuppliers.add(pos);
				}

	}

	public abstract Optional<RecipeHolder<V>> matchRecipe();

	protected abstract void setupRecipe();

	public void setRecipe(Optional<V> r) {
		if (r.isPresent()) {
			this.setupStage(0);
		} else
			this.zeroProgress();
	}

	protected abstract BlockEntityItemHandler createItemHandler();

	public void zeroProgress() {
		this.progress = 0;
		this.maxProgress = 0;
		this.curTool = null;
		this.toolCount = 0;
		this.stage = 0;
	}

	protected void setupStage(int s) {

		this.progress = 0;
		this.stage = s;
	}

	public AnimatedRecipeItemUse getCurrentTool() {
		Optional<RecipeHolder<V>> currentRecipe = matchRecipe();
		if (currentRecipe.isPresent())
			return currentRecipe.get().value().getTools().get(stage);
		return null;
	}

	public void updateInventory() {
		this.setupRecipe();
		requestModelDataUpdate();
		this.setChanged();
		if (this.getLevel() != null) {
			this.getLevel().sendBlockUpdated(this.worldPosition, this.getBlockState(), this.getBlockState(), 3);
		}
	}

	protected void setupStage(V r, int i) {

		this.progress = 0;
		this.maxProgress = r.getTools().get(i).uses();
		this.curTool = r.getTools().get(i).tool();
		this.toolCount = r.getTools().get(i).count();

		this.stage = i;
	}

	protected boolean isFinalStage(V r) {
		int i = r.getTools().size();
		if (i - 1 > stage) {
			return false;
		}
		return true;
	}

	public ItemStack insertItem(ItemStack item) {
		for (int i = 0; i < inventory.getSlots(); i++) {
			item = inventory.insertItem(0, item, false);
			if (item.isEmpty())
				return item;

		}
		return item;
	}

	public ItemStack extractItem() {
		for (int i = inventory.getSlots() - 1; i >= 0; i--) {
			ItemStack stack = inventory.extractItem(i, 64, false);
			if (!stack.isEmpty())
				return stack;
		}
		return ItemStack.EMPTY;
	}

	public boolean use(Level pLevel, Player player, InteractionHand hand, ItemStack tool) {
		if (!pLevel.isClientSide) {
			Optional<RecipeHolder<V>> currentRecipe = matchRecipe();

			if (currentRecipe.isPresent()) {
				RecipeHolder<V> r = currentRecipe.get();

				if (this.curTool == null) {
					setupStage(r.value(), stage);
					if (searchForNextItem(pLevel, player, hand, curTool))
						return true;
					return false;
				}
				if (this.curTool.test(tool)) {
					level.playSound(player, worldPosition, SoundEvents.METAL_HIT, SoundSource.BLOCKS, 1, 0);
					if (tool.getCount() >= this.toolCount) {

						if (this.progress >= this.maxProgress - 1) {

							if (isFinalStage(r.value())) {
								doFinalStage(player, tool, r);
								return true;
							} else {

								doNextStage(pLevel, player, hand, r);
								return true;
							}
						} else {
							if (tool.isDamageableItem())
								tool.hurtAndBreak(1, player, null);
							else
								tool.setCount(tool.getCount() - this.toolCount);

							progress++;
							return true;
						}
					}
				} else {
					if (searchForNextItem(pLevel, player, hand, curTool))
						return true;
					return false;
				}
			}
			this.updateInventory();
			return false;
		}
		return false;
	}

	protected void doNextStage(Level pLevel, Player player, InteractionHand hand, RecipeHolder<V> r) {
		dropLoot(r.value().getTools().get(stage), player);
		setupStage(r.value(), stage + 1);
		searchForNextItem(pLevel, player, hand, curTool);
	}

	protected void dropLoot(AnimatedRecipeItemUse recipeToolsIn, Player player) {
		if (level != null && !level.isClientSide()) {
			final LootParams pParams = new LootParams.Builder((ServerLevel) level)
					.withParameter(LootContextParams.TOOL, player.getMainHandItem())
					.withParameter(LootContextParams.THIS_ENTITY, player)
					.withLuck(player.getLuck() + player.getMainHandItem()
							.getEnchantmentLevel(player.registryAccess().holderOrThrow(Enchantments.FORTUNE)))
					.create(LootContextParamSets.EMPTY);

			player.getServer().reloadableRegistries()
					.getLootTable(ResourceKey.create(Registries.LOOT_TABLE, recipeToolsIn.lootTable()))
					.getRandomItems(pParams).forEach(itemStack -> {
						level.addFreshEntity(new ItemEntity(level, getBlockPos().getX() + 0.5f,
								getBlockPos().getY() + 1.5f, getBlockPos().getZ() + 0.5f, itemStack, 0, 0, 0));
					});

		}
	}

	protected void doFinalStage(Player player, ItemStack tool, RecipeHolder<V> r) {
		for (int i = 0; i < 5; i++) {
			addParticle();
		}
		playFinalSound(player);

		if (tool.isDamageableItem())
			tool.hurtAndBreak(1, player, null);
		else
			tool.setCount(tool.getCount() - this.toolCount);
		dropLoot(r.value().getTools().get(stage), player);
		this.finishRecipe(player, r.value());
		this.zeroProgress();
	}

	protected void playFinalSound(Player player) {
		level.playSound(player, worldPosition, SoundEvents.ANVIL_USE, SoundSource.BLOCKS, 1, 0);
	}

	public boolean searchForNextItem(Level pLevel, Player player, InteractionHand hand, Ingredient ing) {

		if (!ing.test(player.getItemInHand(hand))) {
			if (player.getInventory().contains(ing)) {

				ItemStack h = player.getItemInHand(hand);
				int slot = ItemUtil.getSlotFromInventory(player.getInventory(), ing);

				player.setItemInHand(hand, player.getInventory().getItem(slot));
				player.getInventory().setItem(slot, h);
				return true;
			} else {
				if (toolSuppliers != null && toolSuppliers.size() != 0) {
					for (BlockPos pos : toolSuppliers) {
						BlockEntity be = level.getBlockEntity(pos);
						if (be != null) {
							if (be instanceof RecipeToolSupplierBlockEntity rtsb) {
								Inventory inv = player.getInventory();
								int free = inv.getFreeSlot();
								if (free != -1) {

									ItemStack tool = rtsb.supply(player, hand, ing, 1);
									if (tool != null && tool != ItemStack.EMPTY) {
										inv.add(free, player.getItemInHand(hand));
										player.setItemInHand(hand, tool);
										return true;
									}
								}
							} else {
								// How did you get in here?
								toolSuppliers.remove(pos);
							}
						} else {
							toolSuppliers.remove(pos);
						}
					}
				} else
					return false;
			}
		} else
			return true;
		return false;
	}

	public abstract void addParticle();

	public abstract void finishRecipe(Player Player, V recipe);

	protected ItemStack dropItemBelow(IItemHandler InteractionHandler, ItemStack insert) {
		for (int i = 0; i < InteractionHandler.getSlots(); i++) {
			insert = InteractionHandler.insertItem(i, insert, false);

			if (insert.isEmpty()) {
				return ItemStack.EMPTY;
			}
		}

		return insert;
	}

	@Override
	void readNBT(CompoundTag nbt, HolderLookup.Provider registries) {
		super.readNBT(nbt, registries);
		readInventory(nbt, registries);
		readNBTExtra(nbt, registries);
	}

	@Override
	CompoundTag writeNBT(CompoundTag tag, HolderLookup.Provider registries) {
		tag = super.writeNBT(tag, registries);
		writeInventory(tag, registries);
		writeNBTExtra(tag, registries);
		return tag;
	}

//	@Override
//	public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
//		CompoundTag tag = super.getUpdateTag(registries);
//		
//		writeNBT(tag, registries);
//		
//
//		return tag;
//	}
//
//	@Override
//	public void handleUpdateTag(CompoundTag tag, HolderLookup.Provider registries) {
//		readInventory(tag, registries);
//		readNBT(tag, registries);
//		readNBTExtra(tag, registries);
//	}

	@Override
	public ClientboundBlockEntityDataPacket getUpdatePacket() {
		return ClientboundBlockEntityDataPacket.create(this);
	}

	@Override
	public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt, HolderLookup.Provider registries) {
		CompoundTag tag = pkt.getTag();
		readInventory(tag, registries);
		readNBT(tag, registries);
//		readNBTExtra(tag, registries);
	}

	void writeInventory(CompoundTag nbt, HolderLookup.Provider registries) {
		nbt.put(INVENTORY_TAG, inventory.serializeNBT(registries));

		CompoundTag t = new CompoundTag();
		int count = 0;

		nbt.putInt("connected_count", toolSuppliers.size());
		for (BlockPos pos : toolSuppliers) {
			CompoundTag bp = new CompoundTag();
			bp.putInt("x", pos.getX());
			bp.putInt("y", pos.getY());
			bp.putInt("z", pos.getZ());
			t.put("pos" + count, bp);
			count++;
		}

		nbt.put("connected", t);

	}

	void readInventory(CompoundTag nbt, HolderLookup.Provider registries) {
		if (nbt.contains(INVENTORY_TAG)) {
			inventory.deserializeNBT(registries, nbt.getCompound(INVENTORY_TAG));
		}

		if (nbt.contains("connected")) {
			CompoundTag t = nbt.getCompound("connected");

			int count = nbt.getInt("connected_count");

			for (int i = 0; i < count; i++) {
				CompoundTag pos = t.getCompound("pos" + i);

				BlockPos bp = new BlockPos(pos.getInt("x"), pos.getInt("y"), pos.getInt("z"));

				toolSuppliers.add(bp);
			}
		}
	}

	protected abstract void readNBTExtra(CompoundTag nbt, HolderLookup.Provider registries);

	protected abstract void writeNBTExtra(CompoundTag nbt, HolderLookup.Provider registries);
}
