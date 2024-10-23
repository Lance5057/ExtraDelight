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
			() -> new BasicFluid(0xffd3b945, 0xffd3b945,
					BasicFluid.Properties.create().supportsBoating(true).canHydrate(false).density(1800).viscosity(5000)
							.canExtinguish(true)),
			ExtraDelightBlocks.COOKING_OIL_FLUID_BLOCK, ExtraDelightItems.OIL_FLUID_BUCKET, FLUID_TYPES, FLUIDS);

	public static FluidRegistration VINEGAR = new FluidRegistration("vinegar",
			() -> new BasicFluid(0xffedeac9, 0xffedeac9,
					BasicFluid.Properties.create().supportsBoating(true).canHydrate(false).canExtinguish(true)),
			ExtraDelightBlocks.VINEGAR_FLUID_BLOCK, ExtraDelightItems.VINEGAR_FLUID_BUCKET, FLUID_TYPES, FLUIDS);

	public static FluidRegistration GRAVY = new FluidRegistration("gravy",
			() -> new BasicFluid("gravy", 0xffffffff, 0x00461600,
					BasicFluid.Properties.create().supportsBoating(true).canHydrate(false).density(3000).viscosity(6000)
							.temperature(600).motionScale(0.0023333333333333335D))
					.setNearDistance(-1000),
			ExtraDelightBlocks.GRAVY_FLUID_BLOCK, ExtraDelightItems.GRAVY_FLUID_BUCKET, FLUID_TYPES, FLUIDS, 1);

	public static FluidRegistration GLOW_BERRY_JUICE = new FluidRegistration("glow_berry_juice",
			() -> new BasicFluid(0xffff9401, 0xffff9401,
					BasicFluid.Properties.create().supportsBoating(true).canHydrate(true)),
			ExtraDelightBlocks.GLOW_BERRY_JUICE_FLUID_BLOCK, ExtraDelightItems.GLOW_BERRY_JUICE_FLUID_BUCKET,
			FLUID_TYPES, FLUIDS);

	public static FluidRegistration SWEET_BERRY_JUICE = new FluidRegistration("sweet_berry_juice",
			() -> new BasicFluid(0xffbc0303, 0xffbc0303,
					BasicFluid.Properties.create().supportsBoating(true).canHydrate(true)),
			ExtraDelightBlocks.SWEET_BERRY_JUICE_FLUID_BLOCK, ExtraDelightItems.SWEET_BERRY_JUICE_FLUID_BUCKET,
			FLUID_TYPES, FLUIDS);

	public static FluidRegistration TOMATO_JUICE = new FluidRegistration("tomato_juice",
			() -> new BasicFluid(0xffb32b00, 0xffb32b00,
					BasicFluid.Properties.create().supportsBoating(true).canHydrate(true)),
			ExtraDelightBlocks.TOMATO_JUICE_FLUID_BLOCK, ExtraDelightItems.TOMATO_JUICE_FLUID_BUCKET, FLUID_TYPES,
			FLUIDS);

	public static FluidRegistration CACTUS_JUICE = new FluidRegistration("cactus_juice",
			() -> new BasicFluid(0xff527d26, 0xff527d26,
					BasicFluid.Properties.create().supportsBoating(true).canHydrate(true)),
			ExtraDelightBlocks.CACTUS_JUICE_FLUID_BLOCK, ExtraDelightItems.CACTUS_JUICE_FLUID_BUCKET, FLUID_TYPES,
			FLUIDS);

	public static FluidRegistration APPLE_CIDER = new FluidRegistration("apple_cider",
			() -> new BasicFluid(0xffc68a47, 0xffc68a47,
					BasicFluid.Properties.create().supportsBoating(true).canHydrate(true)),
			ExtraDelightBlocks.APPLE_CIDER_FLUID_BLOCK, ExtraDelightItems.APPLE_CIDER_FLUID_BUCKET, FLUID_TYPES,
			FLUIDS);

	public static FluidRegistration HOT_COCOA = new FluidRegistration("hot_cocoa",
			() -> new BasicFluid(0xff8f563b, 0xff8f563b,
					BasicFluid.Properties.create().supportsBoating(true).canHydrate(false).temperature(1300)),
			ExtraDelightBlocks.HOT_COCOA_FLUID_BLOCK, ExtraDelightItems.HOT_COCOA_FLUID_BUCKET, FLUID_TYPES, FLUIDS);

	public static FluidRegistration MELON_JUICE = new FluidRegistration("melon_juice",
			() -> new BasicFluid(0xffe24334, 0xffe24334,
					BasicFluid.Properties.create().supportsBoating(true).canHydrate(true)),
			ExtraDelightBlocks.MELON_JUICE_FLUID_BLOCK, ExtraDelightItems.MELON_JUICE_FLUID_BUCKET, FLUID_TYPES,
			FLUIDS);

	public static FluidRegistration EGG_MIX = new FluidRegistration("egg_mix",
			() -> new BasicFluid("egg_mix", 0xffffffff, 0x66c99937,
					BasicFluid.Properties.create().supportsBoating(true).canHydrate(false).density(3000).viscosity(6000)
							.motionScale(0.0023333333333333335D)),
			ExtraDelightBlocks.EGG_MIX_FLUID_BLOCK, ExtraDelightItems.EGG_MIX_FLUID_BUCKET, FLUID_TYPES, FLUIDS, 2);

	public static FluidRegistration BBQ = new FluidRegistration("bbq",
			() -> new BasicFluid("bbq", 0xffffffff, 0x00180600,
					BasicFluid.Properties.create().supportsBoating(true).canHydrate(false).density(3000).viscosity(6000)
							.motionScale(0.0023333333333333335D))
					.setNearDistance(-1000),
			ExtraDelightBlocks.BBQ_FLUID_BLOCK, ExtraDelightItems.BBQ_FLUID_BUCKET, FLUID_TYPES, FLUIDS, 2);

	public static FluidRegistration KETCHUP = new FluidRegistration("ketchup",
			() -> new BasicFluid("ketchup", 0xffffffff, 0x009b0000,
					BasicFluid.Properties.create().supportsBoating(true).canHydrate(false).density(3000).viscosity(6000)
							.motionScale(0.0023333333333333335D))
					.setNearDistance(-1000),
			ExtraDelightBlocks.KETCHUP_FLUID_BLOCK, ExtraDelightItems.KETCHUP_FLUID_BUCKET, FLUID_TYPES, FLUIDS, 2);

	public static FluidRegistration MAYO = new FluidRegistration("mayo",
			() -> new BasicFluid("mayo", 0xffffffff, 0x00ded6ab,
					BasicFluid.Properties.create().supportsBoating(true).canHydrate(false).density(3000).viscosity(6000)
							.motionScale(0.0023333333333333335D))
					.setNearDistance(-1000),
			ExtraDelightBlocks.MAYO_FLUID_BLOCK, ExtraDelightItems.MAYO_FLUID_BUCKET, FLUID_TYPES, FLUIDS, 3);

	public static FluidRegistration BROTH = new FluidRegistration("broth",
			() -> new BasicFluid(0xffc4b136, 0xffc4b136,
					BasicFluid.Properties.create().supportsBoating(true).canHydrate(true)),
			ExtraDelightBlocks.BROTH_FLUID_BLOCK, ExtraDelightItems.BROTH_FLUID_BUCKET, FLUID_TYPES, FLUIDS);

	public static FluidRegistration CARAMEL_SAUCE = new FluidRegistration("caramel_sauce",
			() -> new BasicFluid("caramel_sauce", 0xffffffff, 0x00431500,
					BasicFluid.Properties.create().supportsBoating(true).canHydrate(false).density(3000).viscosity(6000)
							.motionScale(0.0023333333333333335D))
					.setNearDistance(-1000),
			ExtraDelightBlocks.CARAMEL_SAUCE_FLUID_BLOCK, ExtraDelightItems.CARAMEL_SAUCE_FLUID_BUCKET, FLUID_TYPES,
			FLUIDS, 2);

	public static FluidRegistration MILKSHAKE = new FluidRegistration("milkshake",
			() -> new BasicFluid("milkshake", 0xffffffff, 0x00eae9d5,
					BasicFluid.Properties.create().supportsBoating(true).canHydrate(false).density(3000).viscosity(6000)
							.motionScale(0.0023333333333333335D))
					.setNearDistance(-1000),
			ExtraDelightBlocks.MILKSHAKE_FLUID_BLOCK, ExtraDelightItems.MILKSHAKE_FLUID_BUCKET, FLUID_TYPES, FLUIDS);

	public static FluidRegistration WHIPPED_CREAM = new FluidRegistration("whipped_cream",
			() -> new BasicFluid("whipped_cream", 0xffffffff, 0x00f3f3f3,
					BasicFluid.Properties.create().supportsBoating(false).canHydrate(false).density(300).viscosity(6000)
							.motionScale(0.0023333333333333335D))
					.setNearDistance(-1000),
			ExtraDelightBlocks.WHIPPED_CREAM_FLUID_BLOCK, ExtraDelightItems.WHIPPED_CREAM_FLUID_BUCKET, FLUID_TYPES,
			FLUIDS, 4);

	public static FluidRegistration JAM = new FluidRegistration("jam",
			() -> new BasicFluid("jam", 0xffffffff, 0x00d23b3b,
					BasicFluid.Properties.create().supportsBoating(true).canHydrate(false).density(3000).viscosity(6000)
							.motionScale(0.0023333333333333335D))
					.setNearDistance(-1000),
			ExtraDelightBlocks.JAM_FLUID_BLOCK, ExtraDelightItems.JAM_FLUID_BUCKET, FLUID_TYPES, FLUIDS, 3);

	public static FluidRegistration GOLDEN_JAM = new FluidRegistration("golden_jam",
			() -> new BasicFluid("golden_jam", 0xffffffff, 0x00f2c000,
					BasicFluid.Properties.create().supportsBoating(true).canHydrate(false).density(3000).viscosity(6000)
							.motionScale(0.0023333333333333335D))
					.setNearDistance(-1000),
			ExtraDelightBlocks.GOLDEN_JAM_FLUID_BLOCK, ExtraDelightItems.GOLDEN_JAM_FLUID_BUCKET, FLUID_TYPES, FLUIDS,
			3);

	public static FluidRegistration GLOW_JAM = new FluidRegistration("glow_jam",
			() -> new BasicFluid("glow_jam", 0xffffffff, 0x00f18b00,
					BasicFluid.Properties.create().supportsBoating(true).canHydrate(false).density(3000).viscosity(6000)
							.motionScale(0.0023333333333333335D))
					.setNearDistance(-1000),
			ExtraDelightBlocks.GLOW_JAM_FLUID_BLOCK, ExtraDelightItems.GLOW_JAM_FLUID_BUCKET, FLUID_TYPES, FLUIDS, 3);

	public static FluidRegistration TEA = new FluidRegistration("tea",
			() -> new BasicFluid(0xff562d0f, 0xff562d0f,
					BasicFluid.Properties.create().supportsBoating(true).canHydrate(true)),
			ExtraDelightBlocks.TEA_FLUID_BLOCK, ExtraDelightItems.TEA_FLUID_BUCKET, FLUID_TYPES, FLUIDS);

	public static FluidRegistration COCOA_BUTTER = new FluidRegistration("cocoa_butter",
			() -> new BasicFluid("cocoa_butter", 0xffffffff, 0x00fdd68f,
					BasicFluid.Properties.create().supportsBoating(true).canHydrate(false).density(3000).viscosity(6000)
							.motionScale(0.0023333333333333335D))
					.setNearDistance(-1000),
			ExtraDelightBlocks.COCOA_BUTTER_FLUID_BLOCK, ExtraDelightItems.COCOA_BUTTER_FLUID_BUCKET, FLUID_TYPES,
			FLUIDS, 2);

	public static FluidRegistration WHITE_CHOCOLATE_SYRUP = new FluidRegistration("white_chocolate_syrup",
			() -> new BasicFluid("white_chocolate_syrup", 0xffffffff, 0x00ffd290,
					BasicFluid.Properties.create().supportsBoating(true).canHydrate(false).density(3000).viscosity(6000)
							.motionScale(0.0023333333333333335D))
					.setNearDistance(-1000),
			ExtraDelightBlocks.WHITE_CHOCOLATE_SYRUP_FLUID_BLOCK, ExtraDelightItems.WHITE_CHOCOLATE_SYRUP_FLUID_BUCKET,
			FLUID_TYPES, FLUIDS);

	public static FluidRegistration DARK_CHOCOLATE_SYRUP = new FluidRegistration("dark_chocolate_syrup",
			() -> new BasicFluid("dark_chocolate_syrup", 0xffffffff, 0x00382014,
					BasicFluid.Properties.create().supportsBoating(true).canHydrate(false).density(3000).viscosity(6000)
							.motionScale(0.0023333333333333335D))
					.setNearDistance(-1000),
			ExtraDelightBlocks.DARK_CHOCOLATE_SYRUP_FLUID_BLOCK, ExtraDelightItems.DARK_CHOCOLATE_SYRUP_FLUID_BUCKET,
			FLUID_TYPES, FLUIDS);

	public static FluidRegistration MILK_CHOCOLATE_SYRUP = new FluidRegistration("milk_chocolate_syrup",
			() -> new BasicFluid("milk_chocolate_syrup", 0xffffffff, 0x00573b2c,
					BasicFluid.Properties.create().supportsBoating(true).canHydrate(false).density(3000).viscosity(6000)
							.motionScale(0.0023333333333333335D))
					.setNearDistance(-1000),
			ExtraDelightBlocks.MILK_CHOCOLATE_SYRUP_FLUID_BLOCK, ExtraDelightItems.MILK_CHOCOLATE_SYRUP_FLUID_BUCKET,
			FLUID_TYPES, FLUIDS);

	public static FluidRegistration BLOOD_CHOCOLATE_SYRUP = new FluidRegistration("blood_chocolate_syrup",
			() -> new BasicFluid("blood_chocolate_syrup", 0xffffffff, 0x006c1f1f,
					BasicFluid.Properties.create().supportsBoating(true).canHydrate(false).density(3000).viscosity(6000)
							.motionScale(0.0023333333333333335D))
					.setNearDistance(-1000),
			ExtraDelightBlocks.BLOOD_CHOCOLATE_SYRUP_FLUID_BLOCK, ExtraDelightItems.BLOOD_CHOCOLATE_SYRUP_FLUID_BUCKET,
			FLUID_TYPES, FLUIDS);

	public static FluidRegistration COFFEE = new FluidRegistration("coffee",
			() -> new BasicFluid(0x512e13, 0x512e13,
					BasicFluid.Properties.create().supportsBoating(true).canHydrate(false).temperature(1300))
					.setNearDistance(-1000),
			ExtraDelightBlocks.COFFEE_FLUID_BLOCK, ExtraDelightItems.COFFEE_FLUID_BUCKET, FLUID_TYPES, FLUIDS);

	public static FluidRegistration NUT_BUTTER = new FluidRegistration("nut_butter",
			() -> new BasicFluid("nut_butter", 0xffffffff, 0x9e632b,
					BasicFluid.Properties.create().supportsBoating(true).canHydrate(false).canSwim(false)
							.viscosity(3000).density(6000).motionScale(0.0023333333333333335D))
					.setNearDistance(-1000),
			ExtraDelightBlocks.NUT_BUTTER_FLUID_BLOCK, ExtraDelightItems.NUT_BUTTER_FLUID_BUCKET, FLUID_TYPES, FLUIDS,
			4);

	public static FluidRegistration MARSHMALLOW_FLUFF = new FluidRegistration("marshmallow_fluff",
			() -> new BasicFluid("marshmallow_fluff", 0xffffffff, 0xfff9f1,
					BasicFluid.Properties.create().supportsBoating(true).canHydrate(false).canSwim(false)
							.viscosity(3000).density(6000).motionScale(0.0023333333333333335D))
					.setNearDistance(-1000),
			ExtraDelightBlocks.MARSHMALLOW_FLUFF_FLUID_BLOCK, ExtraDelightItems.MARSHMALLOW_FLUFF_FLUID_BUCKET,
			FLUID_TYPES, FLUIDS, 4);

	public static FluidRegistration COCOA_NUT_BUTTER_SPREAD = new FluidRegistration("cocoa_nut_butter_spread",
			() -> new BasicFluid("cocoa_nut_butter_spread", 0xffffffff, 0x002e1b11,
					BasicFluid.Properties.create().supportsBoating(true).canHydrate(false).canSwim(false)
							.viscosity(3000).density(6000).motionScale(0.0023333333333333335D)),
			ExtraDelightBlocks.COCOA_NUT_BUTTER_SPREAD_FLUID_BLOCK,
			ExtraDelightItems.COCOA_NUT_BUTTER_SPREAD_FLUID_BUCKET, FLUID_TYPES, FLUIDS, 3);

	public static void register(IEventBus modBus) {
		FLUID_TYPES.register(modBus);
		FLUIDS.register(modBus);
	}
}
