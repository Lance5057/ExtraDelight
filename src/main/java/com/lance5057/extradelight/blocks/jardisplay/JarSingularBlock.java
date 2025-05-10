package com.lance5057.extradelight.blocks.jardisplay;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.blocks.IDisplayInteractable;
import com.lance5057.extradelight.blocks.RecipeFeastBlock;
import com.lance5057.extradelight.modules.Fermentation;
import com.lance5057.extradelight.util.BlockEntityUtils;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.VoxelShape;

public class JarSingularBlock extends RecipeFeastBlock {
	public static VoxelShape SHAPE = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 8.0D, 11.0D);

	public JarSingularBlock(Properties properties) {
		super(properties, true, SHAPE);
	}

	@Override
	public ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player,
			InteractionHand hand, BlockHitResult result) {
		if (!level.isClientSide) {
			if (this.takeServing(stack, level, pos, state, player, hand).consumesAction()) {
				return ItemInteractionResult.SUCCESS;
			}

			if (stack.getItem() instanceof IDisplayInteractable bi) {
				ItemStack clone = this.getCloneItemStack(state, result, level, pos, player).copy();

				level.setBlock(pos,
						Fermentation.JAR_DISPLAY_BLOCK.get().defaultBlockState().setValue(JarDisplayBlock.FACING,
								result.getDirection() == Direction.UP || result.getDirection() == Direction.DOWN
										? player.getDirection()
										: result.getDirection().getOpposite()),
						UPDATE_ALL);
//					level.setBlockEntity(new JarDisplayBlockEntity(pos, state));

				BlockEntity be = level.getBlockEntity(pos);
				if (be != null && be instanceof JarDisplayBlockEntity jdbe) {
					BlockEntityUtils.Inventory.insertItem(jdbe.getItems(), clone, JarDisplayBlockEntity.NUM_SLOTS);
					BlockEntityUtils.Inventory.insertItem(jdbe.getItems(), stack, JarDisplayBlockEntity.NUM_SLOTS);
				}
				// Something went wrong, put it back!
				else {
					level.setBlock(pos, state, UPDATE_ALL);
					ExtraDelight.logger.error("Jar Display Entity Invalid!");
				}

				return ItemInteractionResult.SUCCESS;
			}
			return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
		}
		return this.takeServing(stack, level, pos, state, player, hand);
	}

}
