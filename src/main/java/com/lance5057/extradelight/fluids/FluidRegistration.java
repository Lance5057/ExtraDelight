package com.lance5057.extradelight.fluids;

import java.util.function.Supplier;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.fluids.BaseFlowingFluid.Flowing;
import net.neoforged.neoforge.fluids.BaseFlowingFluid.Source;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class FluidRegistration {
	private BaseFlowingFluid.Properties properties(Supplier<? extends LiquidBlock> block,
			Supplier<? extends Item> bucket) {
		return new BaseFlowingFluid.Properties(TYPE, FLUID, FLUID_FLOWING).block(block).bucket(bucket);
	}

	public final DeferredHolder<FluidType, FluidType> TYPE;

	public final DeferredHolder<Fluid, Source> FLUID;
	public final DeferredHolder<Fluid, Flowing> FLUID_FLOWING;

	public FluidRegistration(String name, Supplier<? extends FluidType> fluid, Supplier<? extends LiquidBlock> block,
			Supplier<? extends Item> bucket, DeferredRegister<FluidType> FLUID_TYPES, DeferredRegister<Fluid> FLUIDS) {
		TYPE = FLUID_TYPES.register(name + "_fluid", fluid);

//		BaseFlowingFluid.Properties p = properties(block, bucket);

		FLUID = FLUIDS.register(name + "_fluid", () -> new BaseFlowingFluid.Source(properties(block, bucket)));
		FLUID_FLOWING = FLUIDS.register(name + "_fluid_flowing", () -> new BaseFlowingFluid.Flowing(properties(block, bucket)));
	}
	
	public FluidRegistration(String name, Supplier<? extends FluidType> fluid, Supplier<? extends LiquidBlock> block,
			Supplier<? extends Item> bucket, DeferredRegister<FluidType> FLUID_TYPES, DeferredRegister<Fluid> FLUIDS, int decrease) {
		TYPE = FLUID_TYPES.register(name + "_fluid", fluid);

//		BaseFlowingFluid.Properties p = properties(block, bucket);

		FLUID = FLUIDS.register(name + "_fluid", () -> new BaseFlowingFluid.Source(properties(block, bucket)));
		FLUID_FLOWING = FLUIDS.register(name + "_fluid_flowing", () -> new BaseFlowingFluid.Flowing(properties(block, bucket).levelDecreasePerBlock(decrease)));
	}
}
