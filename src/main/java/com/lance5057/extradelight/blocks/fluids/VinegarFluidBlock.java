package com.lance5057.extradelight.blocks.fluids;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;

public class VinegarFluidBlock extends LiquidBlock {

	public VinegarFluidBlock(FlowingFluid fluid, Properties p_54695_) {
		super(fluid, p_54695_);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void entityInside(BlockState state, Level lvl, BlockPos pos, Entity ent) {
		if (!lvl.isClientSide)
			if (ent instanceof LivingEntity l) {
				if (l.getHealth() < l.getMaxHealth()) {
					l.hurt(ent.damageSources().generic(), 0.01f);
				}
			}
	}
}
