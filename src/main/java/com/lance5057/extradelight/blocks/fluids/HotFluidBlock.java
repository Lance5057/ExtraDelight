package com.lance5057.extradelight.blocks.fluids;

import java.util.function.Supplier;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;

public class HotFluidBlock extends LiquidBlock {

	public HotFluidBlock(Supplier<? extends FlowingFluid> fluid, Properties p_54695_) {
		super(fluid, p_54695_);
	}

	@Override
	public void entityInside(BlockState p_49260_, Level p_49261_, BlockPos p_49262_, Entity p_49263_) {
		if (!p_49263_.fireImmune()) {
			p_49263_.setRemainingFireTicks(p_49263_.getRemainingFireTicks() + 1);
			if (p_49263_.getRemainingFireTicks() == 0) {
				p_49263_.setSecondsOnFire(8);
			}
		}

		p_49263_.hurt(p_49261_.damageSources().inFire(), 1);
		super.entityInside(p_49260_, p_49261_, p_49262_, p_49263_);
	}
}
