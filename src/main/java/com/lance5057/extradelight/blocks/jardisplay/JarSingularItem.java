package com.lance5057.extradelight.blocks.jardisplay;

import java.util.List;
import java.util.Optional;

import com.lance5057.extradelight.ExtraDelightRecipes;
import com.lance5057.extradelight.blocks.IDisplayInteractable;
import com.lance5057.extradelight.recipe.FeastRecipe;
import com.lance5057.extradelight.recipe.SimpleRecipeWrapper;

import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.BlockItemStateProperties;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.ItemStackHandler;

public class JarSingularItem extends BlockItem implements IDisplayInteractable {

	public JarSingularItem(Block block, Properties properties) {
		super(block, properties);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ItemInteractionResult itemInteract(ItemStack heldItem, ItemStack interactItem, BlockState state, Level level,
			BlockPos pos, Player player, InteractionHand hand) {
		BlockItemStateProperties itemState = interactItem.get(DataComponents.BLOCK_STATE);

		int servings = itemState.get(JarSingularBlock.SERVINGS);

		if (servings == 0) {
			level.playSound(null, pos, SoundEvents.WOOD_BREAK, SoundSource.PLAYERS, 0.8F, 0.8F);
//				level.destroyBlock(pos, true);
			return ItemInteractionResult.SUCCESS;
		}

		ItemStack heldheldItem = player.getItemInHand(hand);
		Optional<RecipeHolder<FeastRecipe>> r = level.getRecipeManager().getRecipeFor(ExtraDelightRecipes.FEAST.get(),
				new SimpleRecipeWrapper(interactItem, heldItem), level);

		if (r.isPresent()) {
			if (servings > 0) {
				ItemStack output = r.get().value().getResultItem(player.level().registryAccess()).copy();

				interactItem.update(DataComponents.BLOCK_STATE, BlockItemStateProperties.EMPTY,
						s -> s.with(JarSingularBlock.SERVINGS, servings - 1));

				if (!player.getAbilities().instabuild) {
					if (heldheldItem.isDamageableItem())
						heldheldItem.hurtAndBreak(1, player, null);
					else
						heldheldItem.shrink(1);
				}
				if (!player.getInventory().add(output)) {
					player.drop(output, false);
				}
//				if (servings - 1 <= 0) {
//					List<ItemheldItem> drops = Block.getDrops(state, (ServerLevel) level, pos, null);
//					interactItem.setCount(0);
//				}
				level.playSound(null, pos, SoundEvents.ARMOR_EQUIP_GENERIC.value(), SoundSource.BLOCKS, 1.0F, 1.0F);
				level.sendBlockUpdated(pos, state, state, Block.UPDATE_ALL);

				return ItemInteractionResult.SUCCESS;
			}
		} else
			player.displayClientMessage(Component.translatable("extradelight.block.recipefeast.use_container"), true);

		return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
	}

	@Override
	public void extractItem(Level level, BlockPos pos, Player player, JarDisplayBlockEntity jdbe,
			ItemStackHandler handler, ItemStack s, int index) {

//		if (s.getItem() instanceof BlockItem bi) {
//			BlockItemStateProperties state = s.get(DataComponents.BLOCK_STATE);
//			if (state != null) {
//				int servings = state.get(JarSingularBlock.SERVINGS);
//				if (servings == 0) {
//					List<ItemStack> drops = Block.getDrops(state.apply(bi.getBlock().defaultBlockState()),
//							(ServerLevel) level, pos, null);
//					drops.forEach(item -> {
//						if (!player.addItem(item))
//							level.addFreshEntity(
//									new ItemEntity(level, pos.getX(), pos.getY() + 0.5, pos.getZ(), item.copy()));
//					});
//					handler.setStackInSlot(index, ItemStack.EMPTY);
//				} else {
//					if (!player.addItem(s)) {
//						level.addFreshEntity(new ItemEntity(level, pos.getX(), pos.getY() + 0.5, pos.getZ(), s.copy()));
//						handler.setStackInSlot(index, ItemStack.EMPTY);
//					}
//				}
//			}
//		}

		if (!player.addItem(s)) {
			level.addFreshEntity(new ItemEntity(level, pos.getX(), pos.getY() + 0.5, pos.getZ(), s.copy()));
			handler.setStackInSlot(index, ItemStack.EMPTY);
		}
	}

	@Override
	public void convertToSingular(BlockPos pos, Level level, JarDisplayBlockEntity jdbe, ItemStack stack) {
		BlockState bs = this.getBlock().defaultBlockState();
		if (stack.has(DataComponents.BLOCK_STATE))
			bs = stack.get(DataComponents.BLOCK_STATE).apply(bs);
		level.setBlock(pos, bs, Block.UPDATE_CLIENTS);
	}

}
