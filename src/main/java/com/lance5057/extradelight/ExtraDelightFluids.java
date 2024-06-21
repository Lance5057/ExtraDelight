package com.lance5057.extradelight;

import com.lance5057.extradelight.fluids.BasicFluid;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.fluids.BaseFlowingFluid.Flowing;
import net.neoforged.neoforge.fluids.BaseFlowingFluid.Source;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ExtraDelightFluids {
	public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister
			.create(NeoForgeRegistries.Keys.FLUID_TYPES, ExtraDelight.MOD_ID);
	public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(BuiltInRegistries.FLUID,
			ExtraDelight.MOD_ID);

	// Oil
	private static BaseFlowingFluid.Properties oil() {
		return new BaseFlowingFluid.Properties(OIL_TYPE, OIL_FLUID, OIL_FLUID_FLOWING)
				.block(ExtraDelightBlocks.COOKING_OIL_FLUID_BLOCK).bucket(ExtraDelightItems.OIL_FLUID_BUCKET);
	}

	public static final DeferredHolder<FluidType, FluidType> OIL_TYPE = FLUID_TYPES.register("oil_fluid",
			() -> new BasicFluid(0xd3b945, FluidType.Properties.create().supportsBoating(true).canHydrate(false)
					.density(1800).viscosity(5000).canExtinguish(true)) {

			});

	public static final DeferredHolder<Fluid, Source> OIL_FLUID = FLUIDS.register("oil_fluid",
			() -> new BaseFlowingFluid.Source(oil()));
	public static final DeferredHolder<Fluid, Flowing> OIL_FLUID_FLOWING = FLUIDS.register("oil_fluid_flowing",
			() -> new BaseFlowingFluid.Flowing(oil()));

	// Vinegar
	private static BaseFlowingFluid.Properties vinegar() {
		return new BaseFlowingFluid.Properties(VINEGAR_TYPE, VINEGAR_FLUID, VINEGAR_FLUID_FLOWING)
				.block(ExtraDelightBlocks.VINEGAR_FLUID_BLOCK).bucket(ExtraDelightItems.VINEGAR_FLUID_BUCKET);
	}

	public static final DeferredHolder<FluidType, FluidType> VINEGAR_TYPE = FLUID_TYPES.register("vinegar_fluid",
			() -> new BasicFluid(0xedeac9,
					FluidType.Properties.create().supportsBoating(true).canHydrate(false).canExtinguish(true)) {

			});

	public static final DeferredHolder<Fluid, Source> VINEGAR_FLUID = FLUIDS.register("vinegar_fluid",
			() -> new BaseFlowingFluid.Source(vinegar()));
	public static final DeferredHolder<Fluid, Flowing> VINEGAR_FLUID_FLOWING = FLUIDS.register("vinegar_fluid_flowing",
			() -> new BaseFlowingFluid.Flowing(vinegar()));

	// Gravy
	private static BaseFlowingFluid.Properties gravy() {
		return new BaseFlowingFluid.Properties(GRAVY_TYPE, GRAVY_FLUID, GRAVY_FLUID_FLOWING)
				.block(ExtraDelightBlocks.GRAVY_FLUID_BLOCK).bucket(ExtraDelightItems.GRAVY_FLUID_BUCKET);
	}

	public static final DeferredHolder<FluidType, FluidType> GRAVY_TYPE = FLUID_TYPES.register("gravy_fluid",
			() -> new BasicFluid("gravy", 0, FluidType.Properties.create().supportsBoating(true).canHydrate(false)
					.density(3000).viscosity(6000).temperature(600)) {

			});

	public static final DeferredHolder<Fluid, Source> GRAVY_FLUID = FLUIDS.register("gravy_fluid",
			() -> new BaseFlowingFluid.Source(gravy()));
	public static final DeferredHolder<Fluid, Flowing> GRAVY_FLUID_FLOWING = FLUIDS.register("gravy_fluid_flowing",
			() -> new BaseFlowingFluid.Flowing(gravy()));

	public static void register(IEventBus modBus) {
		FLUID_TYPES.register(modBus);
		FLUIDS.register(modBus);
	}
}
