package com.lance5057.extradelight.blocks;

import java.util.function.Supplier;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class JellyBlock extends RecipeFeastBlock {
	protected static final VoxelShape PLATE_SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 6.0D, 15.0D);
	protected static final VoxelShape PIE_SHAPE = Shapes.joinUnoptimized(PLATE_SHAPE,
			Block.box(2.0D, 2.0D, 2.0D, 14.0D, 8.0D, 14.0D), BooleanOp.OR);

	public JellyBlock(Properties properties, Supplier<Item> servingItem, boolean hasLeftovers) {
		super(properties, hasLeftovers);
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		return state.getValue(SERVINGS) == 0 ? PLATE_SHAPE : PIE_SHAPE;
	}

	@Override
	public void fallOn(Level pLevel, BlockState pState, BlockPos pPos, Entity pEntity, float pFallDistance) {
		if (pState.getValue(SERVINGS) != 0) {
			if (pEntity.isSuppressingBounce()) {
				super.fallOn(pLevel, pState, pPos, pEntity, pFallDistance);

				this.bounceUp(pEntity);
				squish(pLevel, pPos);
			} else {
				pEntity.causeFallDamage(pFallDistance, 0.0F, pLevel.damageSources().fall());
				this.bounceUp(pEntity);
				squish(pLevel, pPos);
			}

		}
	}

	private void squish(Level pLevel, BlockPos pPos) {
		pLevel.playLocalSound(pPos.getX(), pPos.getY(), pPos.getZ(), SoundEvents.SLIME_BLOCK_FALL, SoundSource.BLOCKS,
				1, 0, false);
		pLevel.setBlock(pPos, this.defaultBlockState().setValue(SERVINGS, 0), 1);
	}

	@Override
	public void updateEntityAfterFallOn(BlockGetter pLevel, Entity pEntity) {
		if (pEntity.isSuppressingBounce()) {
			super.updateEntityAfterFallOn(pLevel, pEntity);
		} else {

		}

	}

	private void bounceUp(Entity pEntity) {
		Vec3 vec3 = pEntity.getDeltaMovement();
		if (vec3.y < 0.0D) {
			double d0 = pEntity instanceof LivingEntity ? 1.0D : 0.8D;
			pEntity.setDeltaMovement(vec3.x, -vec3.y * d0, vec3.z);
		}

	}

	@Override
	public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
		if (pState.getValue(SERVINGS) == 0) {
			double d0 = Math.abs(pEntity.getDeltaMovement().y);
			if (d0 < 0.1D && !pEntity.isSteppingCarefully()) {
				double d1 = 0.4D + d0 * 0.2D;
				pEntity.setDeltaMovement(pEntity.getDeltaMovement().multiply(d1, 1.0D, d1));
			}
		}
		super.stepOn(pLevel, pPos, pState, pEntity);

	}
}
