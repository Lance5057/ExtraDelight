package com.lance5057.extradelight;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ExtraDelightPaintings {
	public static final DeferredRegister<PaintingVariant> PAINTING_VARIANTS = DeferredRegister
			.create(Registries.PAINTING_VARIANT, ExtraDelight.MOD_ID);

	public static DeferredHolder<PaintingVariant, PaintingVariant> BIG_ORANGE_SLICE = PAINTING_VARIANTS.register(
			"big_orange_slice",
			() -> new PaintingVariant(1, 1, ExtraDelight.modLoc("textures/painting/big_orange_slice.png")));

	public static DeferredHolder<PaintingVariant, PaintingVariant> BIG_LIME_SLICE = PAINTING_VARIANTS.register(
			"big_lime_slice",
			() -> new PaintingVariant(1, 1, ExtraDelight.modLoc("textures/painting/big_lime_slice.png")));
	
	public static DeferredHolder<PaintingVariant, PaintingVariant> BIG_LEMON_SLICE = PAINTING_VARIANTS.register(
			"big_lemon_slice",
			() -> new PaintingVariant(1, 1, ExtraDelight.modLoc("textures/painting/big_lemon_slice.png")));
	
	public static DeferredHolder<PaintingVariant, PaintingVariant> BIG_GRAPEFRUIT_SLICE = PAINTING_VARIANTS.register(
			"big_grapefruit_slice",
			() -> new PaintingVariant(1, 1, ExtraDelight.modLoc("textures/painting/big_grapefruit_slice.png")));
}
