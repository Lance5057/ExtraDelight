package com.lance5057.extradelight.blocks.fluids;

import java.util.function.Supplier;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;

public class GlowBerryFluidBlock extends LiquidBlock {

	public GlowBerryFluidBlock(Supplier<? extends FlowingFluid> fluid, Properties p_54695_) {
		super(fluid, p_54695_);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void entityInside(BlockState state, Level lvl, BlockPos pos, Entity ent) {
		if (!lvl.isClientSide)
			if (ent instanceof LivingEntity l) {
				if(!l.hasEffect(MobEffects.GLOWING))
					l.addEffect(new MobEffectInstance(MobEffects.GLOWING, 100));
			}
	}
}