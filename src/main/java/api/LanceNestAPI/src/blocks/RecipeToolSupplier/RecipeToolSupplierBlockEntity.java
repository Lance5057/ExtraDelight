package api.LanceNestAPI.src.blocks.RecipeToolSupplier;

import javax.annotation.Nonnull;

import api.LanceNestAPI.src.blockentities.MultiToolRecipeStation;
import api.LanceNestAPI.src.blocks.RecipeToolSupplier.components.item.BlockEntityItemHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.util.Lazy;
import net.neoforged.neoforge.items.IItemHandler;

public abstract class RecipeToolSupplierBlockEntity extends BlockEntity {
	public static final String TAG = "inv";

	public RecipeToolSupplierBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState blockState) {
		super(type, pos, blockState);
	}

	private final BlockEntityItemHandler inventory = createItemHandler();
	private final Lazy<BlockEntityItemHandler> itemHandler = Lazy.of(() -> inventory);

	protected abstract BlockEntityItemHandler createItemHandler();

	public IItemHandler getItems() {
		return this.itemHandler.get();
	}

	protected abstract boolean canAccept(ItemStack stack);

	public ItemStack supply(Player player, InteractionHand hand, Ingredient itemToGet, int amountNeeded) {
		for (int i = 0; i < inventory.getSlots(); i++) {
			if (itemToGet.test(inventory.getStackInSlot(i)) && inventory.getStackInSlot(i).getCount() >= amountNeeded) {

				ItemStack give = inventory.getStackInSlot(i).copy();
				give.setCount(amountNeeded);

				inventory.getStackInSlot(i).shrink(amountNeeded);

				return give;
			}
		}

		return ItemStack.EMPTY;
	}

	public void searchForWorkstations(Level l) {
		for (int x = worldPosition.getX() - 5; x <= worldPosition.getX() + 5; x++)
			for (int y = worldPosition.getY() - 5; y <= worldPosition.getY() + 5; y++)
				for (int z = worldPosition.getZ() - 5; z <= worldPosition.getZ() + 5; z++) {
					BlockPos pos = new BlockPos(x, y, z);
					BlockEntity ent = l.getBlockEntity(pos);

					if (ent instanceof MultiToolRecipeStation<?> mtrs)
						mtrs.toolSuppliers.add(this.worldPosition);
				}

	}

	public void removeFromWorkstations(LevelAccessor level) {
		for (int x = worldPosition.getX() - 5; x <= worldPosition.getX() + 5; x++)
			for (int y = worldPosition.getY() - 5; y <= worldPosition.getY() + 5; y++)
				for (int z = worldPosition.getZ() - 5; z <= worldPosition.getZ() + 5; z++) {
					BlockPos pos = new BlockPos(x, y, z);
					BlockEntity ent = level.getBlockEntity(pos);

					if (ent instanceof MultiToolRecipeStation<?> mtrs)
						mtrs.toolSuppliers.remove(this.worldPosition);
				}

	}

	@Override
	public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
		CompoundTag nbt = super.getUpdateTag(registries);

		writeNBT(nbt, registries);

		return nbt;
	}

	@Override
	public void handleUpdateTag(CompoundTag tag, HolderLookup.Provider registries) {
		readNBT(tag, registries);
	}

	@Override
	public ClientboundBlockEntityDataPacket getUpdatePacket() {
		return ClientboundBlockEntityDataPacket.create(this);
	}

	@Override
	public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt, HolderLookup.Provider registries) {
		CompoundTag tag = pkt.getTag();
		if (tag != null)
			readNBT(tag, registries);
	}

	void readNBT(CompoundTag nbt, HolderLookup.Provider registries) {
		if (nbt.contains(TAG)) {
			inventory.deserializeNBT(registries, nbt.getCompound(TAG));
		}
	}

	CompoundTag writeNBT(CompoundTag tag, HolderLookup.Provider registries) {
		tag.put(TAG, inventory.serializeNBT(registries));
		return tag;
	}

	@Override
	public void loadAdditional(@Nonnull CompoundTag nbt, HolderLookup.Provider registries) {
		super.loadAdditional(nbt, registries);
		readNBT(nbt, registries);
	}

	@Override
	public void saveAdditional(@Nonnull CompoundTag nbt, HolderLookup.Provider registries) {
		super.saveAdditional(nbt, registries);
		writeNBT(nbt, registries);
	}
}
