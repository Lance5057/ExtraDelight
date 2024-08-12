package com.lance5057.extradelight;

import com.lance5057.extradelight.fluids.BasicFluid;
import com.lance5057.extradelight.fluids.FluidRegistration;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ExtraDelightFluids {
	public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister
			.create(NeoForgeRegistries.Keys.FLUID_TYPES, ExtraDelight.MOD_ID);
	public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(BuiltInRegistries.FLUID,
			ExtraDelight.MOD_ID);

	public static FluidRegistration OIL = new FluidRegistration("oil",
			() -> new BasicFluid(0xffd3b945,
					BasicFluid.Properties.create().supportsBoating(true).canHydrate(false).density(1800).viscosity(5000)
							.canExtinguish(true)),
			ExtraDelightBlocks.COOKING_OIL_FLUID_BLOCK, ExtraDelightItems.OIL_FLUID_BUCKET, FLUID_TYPES, FLUIDS);

	public static FluidRegistration VINEGAR = new FluidRegistration("vinegar",
			() -> new BasicFluid(0xffedeac9,
					BasicFluid.Properties.create().supportsBoating(true).canHydrate(false).canExtinguish(true)),
			ExtraDelightBlocks.VINEGAR_FLUID_BLOCK, ExtraDelightItems.VINEGAR_FLUID_BUCKET, FLUID_TYPES, FLUIDS);

	public static FluidRegistration GRAVY = new FluidRegistration("gravy",
			() -> new BasicFluid("gravy", 0xffffffff,
					BasicFluid.Properties.create().supportsBoating(true).canHydrate(false).density(3000).viscosity(6000)
							.temperature(600).motionScale(0.5f)),
			ExtraDelightBlocks.GRAVY_FLUID_BLOCK, ExtraDelightItems.GRAVY_FLUID_BUCKET, FLUID_TYPES, FLUIDS);

	public static FluidRegistration GLOW_BERRY_JUICE = new FluidRegistration("glow_berry_juice",
			() -> new BasicFluid(0xffff9401, BasicFluid.Properties.create().supportsBoating(true).canHydrate(true)),
			ExtraDelightBlocks.GLOW_BERRY_JUICE_FLUID_BLOCK, ExtraDelightItems.GLOW_BERRY_JUICE_FLUID_BUCKET,
			FLUID_TYPES, FLUIDS);

	public static FluidRegistration SWEET_BERRY_JUICE = new FluidRegistration("sweet_berry_juice",
			() -> new BasicFluid(0xffbc0303, BasicFluid.Properties.create().supportsBoating(true).canHydrate(true)),
			ExtraDelightBlocks.SWEET_BERRY_JUICE_FLUID_BLOCK, ExtraDelightItems.SWEET_BERRY_JUICE_FLUID_BUCKET,
			FLUID_TYPES, FLUIDS);

	public static FluidRegistration TOMATO_JUICE = new FluidRegistration("tomato_juice",
			() -> new BasicFluid(0xffb32b00, BasicFluid.Properties.create().supportsBoating(true).canHydrate(true)),
			ExtraDelightBlocks.TOMATO_JUICE_FLUID_BLOCK, ExtraDelightItems.TOMATO_JUICE_FLUID_BUCKET, FLUID_TYPES,
			FLUIDS);

	public static FluidRegistration CACTUS_JUICE = new FluidRegistration("cactus_juice",
			() -> new BasicFluid(0xff527d26, BasicFluid.Properties.create().supportsBoating(true).canHydrate(true)),
			ExtraDelightBlocks.CACTUS_JUICE_FLUID_BLOCK, ExtraDelightItems.CACTUS_JUICE_FLUID_BUCKET, FLUID_TYPES,
			FLUIDS);

	public static FluidRegistration APPLE_CIDER = new FluidRegistration("apple_cider",
			() -> new BasicFluid(0xffc68a47, BasicFluid.Properties.create().supportsBoating(true).canHydrate(true)),
			ExtraDelightBlocks.APPLE_CIDER_FLUID_BLOCK, ExtraDelightItems.APPLE_CIDER_FLUID_BUCKET, FLUID_TYPES,
			FLUIDS);

	public static FluidRegistration HOT_COCOA = new FluidRegistration("hot_cocoa",
			() -> new BasicFluid(0xff8f563b,
					BasicFluid.Properties.create().supportsBoating(true).canHydrate(false).temperature(1300)),
			ExtraDelightBlocks.HOT_COCOA_FLUID_BLOCK, ExtraDelightItems.HOT_COCOA_FLUID_BUCKET, FLUID_TYPES, FLUIDS);

	public static FluidRegistration MELON_JUICE = new FluidRegistration("melon_juice",
			() -> new BasicFluid(0xffe24334, BasicFluid.Properties.create().supportsBoating(true).canHydrate(true)),
			ExtraDelightBlocks.MELON_JUICE_FLUID_BLOCK, ExtraDelightItems.MELON_JUICE_FLUID_BUCKET, FLUID_TYPES,
			FLUIDS);

//	public static FluidRegistration CUSTARD = new FluidRegistration("custard",
//			() -> new BasicFluid("custard", 0xffffffff,
//					BasicFluid.Properties.create().supportsBoating(true).canHydrate(false).viscosity(12000)
//							.density(6000).motionScale(0.1)),
//			ExtraDelightBlocks.CUSTARD_FLUID_BLOCK, ExtraDelightItems.CUSTARD_FLUID_BUCKET, FLUID_TYPES, FLUIDS);

	public static FluidRegistration EGG_MIX = new FluidRegistration("egg_mix",
			() -> new BasicFluid("egg_mix", 0xffffffff,
					BasicFluid.Properties.create().supportsBoating(true).canHydrate(false).density(3000).viscosity(6000)
							.motionScale(0.75f)),
			ExtraDelightBlocks.EGG_MIX_FLUID_BLOCK, ExtraDelightItems.EGG_MIX_FLUID_BUCKET, FLUID_TYPES, FLUIDS);

	public static FluidRegistration BBQ = new FluidRegistration("bbq",
			() -> new BasicFluid("bbq", 0xffffffff,
					BasicFluid.Properties.create().supportsBoating(true).canHydrate(false).density(3000).viscosity(6000)
							.motionScale(0.5f)),
			ExtraDelightBlocks.BBQ_FLUID_BLOCK, ExtraDelightItems.BBQ_FLUID_BUCKET, FLUID_TYPES, FLUIDS);

	public static FluidRegistration KETCHUP = new FluidRegistration("ketchup",
			() -> new BasicFluid("ketchup", 0xffffffff,
					BasicFluid.Properties.create().supportsBoating(true).canHydrate(false).density(3000).viscosity(6000)
							.motionScale(0.5f)),
			ExtraDelightBlocks.KETCHUP_FLUID_BLOCK, ExtraDelightItems.KETCHUP_FLUID_BUCKET, FLUID_TYPES, FLUIDS);

	public static FluidRegistration MAYO = new FluidRegistration("mayo",
			() -> new BasicFluid("mayo", 0xffffffff,
					BasicFluid.Properties.create().supportsBoating(true).canHydrate(false).density(3000).viscosity(6000)
							.motionScale(0.5f)),
			ExtraDelightBlocks.MAYO_FLUID_BLOCK, ExtraDelightItems.MAYO_FLUID_BUCKET, FLUID_TYPES, FLUIDS);

	public static FluidRegistration BROTH = new FluidRegistration("broth",
			() -> new BasicFluid(0xffc4b136, BasicFluid.Properties.create().supportsBoating(true).canHydrate(true)),
			ExtraDelightBlocks.BROTH_FLUID_BLOCK, ExtraDelightItems.BROTH_FLUID_BUCKET, FLUID_TYPES, FLUIDS);

	public static FluidRegistration CARAMEL_SAUCE = new FluidRegistration("caramel_sauce",
			() -> new BasicFluid("caramel_sauce", 0xffffffff,
					BasicFluid.Properties.create().supportsBoating(true).canHydrate(false).viscosity(12000)
							.density(6000).motionScale(0.1)),
			ExtraDelightBlocks.CARAMEL_SAUCE_FLUID_BLOCK, ExtraDelightItems.CARAMEL_SAUCE_FLUID_BUCKET, FLUID_TYPES,
			FLUIDS);

	public static FluidRegistration MILKSHAKE = new FluidRegistration("milkshake",
			() -> new BasicFluid("milkshake", 0xffffffff,
					BasicFluid.Properties.create().supportsBoating(true).canHydrate(false).viscosity(12000)
							.density(6000).motionScale(0.1)),
			ExtraDelightBlocks.MILKSHAKE_FLUID_BLOCK, ExtraDelightItems.MILKSHAKE_FLUID_BUCKET, FLUID_TYPES, FLUIDS);

	public static FluidRegistration WHIPPED_CREAM = new FluidRegistration("whipped_cream",
			() -> new BasicFluid("whipped_cream", 0xffffffff,
					BasicFluid.Properties.create().supportsBoating(true).canHydrate(false).viscosity(12000).density(600)
							.motionScale(0.1)),
			ExtraDelightBlocks.WHIPPED_CREAM_FLUID_BLOCK, ExtraDelightItems.WHIPPED_CREAM_FLUID_BUCKET, FLUID_TYPES,
			FLUIDS);

	public static FluidRegistration JAM = new FluidRegistration("jam",
			() -> new BasicFluid("jam", 0xffffffff,
					BasicFluid.Properties.create().supportsBoating(true).canHydrate(false).viscosity(12000)
							.density(6000).motionScale(0.1)),
			ExtraDelightBlocks.JAM_FLUID_BLOCK, ExtraDelightItems.JAM_FLUID_BUCKET, FLUID_TYPES, FLUIDS);

	public static FluidRegistration GOLDEN_JAM = new FluidRegistration("golden_jam",
			() -> new BasicFluid("golden_jam", 0xffffffff,
					BasicFluid.Properties.create().supportsBoating(true).canHydrate(false).viscosity(12000)
							.density(6000).motionScale(0.1)),
			ExtraDelightBlocks.GOLDEN_JAM_FLUID_BLOCK, ExtraDelightItems.GOLDEN_JAM_FLUID_BUCKET, FLUID_TYPES, FLUIDS);

	public static FluidRegistration GLOW_JAM = new FluidRegistration("glow_jam",
			() -> new BasicFluid("glow_jam", 0xffffffff,
					BasicFluid.Properties.create().supportsBoating(true).canHydrate(false).viscosity(12000)
							.density(6000).motionScale(0.1)),
			ExtraDelightBlocks.GLOW_JAM_FLUID_BLOCK, ExtraDelightItems.GLOW_JAM_FLUID_BUCKET, FLUID_TYPES, FLUIDS);

	public static FluidRegistration TEA = new FluidRegistration("tea",
			() -> new BasicFluid(0xff562d0f, BasicFluid.Properties.create().supportsBoating(true).canHydrate(true)),
			ExtraDelightBlocks.TEA_FLUID_BLOCK, ExtraDelightItems.TEA_FLUID_BUCKET, FLUID_TYPES, FLUIDS);

	public static void register(IEventBus modBus) {
		FLUID_TYPES.register(modBus);
		FLUIDS.register(modBus);
	}
}
