package com.lance5057.extradelight.worldgen.features.trees;

import java.util.Optional;

import com.lance5057.extradelight.ExtraDelight;

import net.minecraft.world.level.block.grower.TreeGrower;

public class ExtraDelightTreeGrowers {
	public static final TreeGrower CINNAMON = new TreeGrower(ExtraDelight.MOD_ID + "cinnamon", 0.1F, Optional.empty(),
			Optional.empty(), Optional.of(ExtraDelightTreeFeatures.CINNAMON), Optional.empty(), Optional.empty(),
			Optional.empty());
	public static final TreeGrower HAZELNUT = new TreeGrower(ExtraDelight.MOD_ID + "hazelnut", 0.1F, Optional.empty(),
			Optional.empty(), Optional.of(ExtraDelightTreeFeatures.HAZELNUT), Optional.empty(), Optional.empty(),
			Optional.empty());
	public static final TreeGrower APPLE = new TreeGrower(ExtraDelight.MOD_ID + "apple", 0.1F, Optional.empty(),
			Optional.empty(), Optional.of(ExtraDelightTreeFeatures.APPLE), Optional.empty(), Optional.empty(),
			Optional.empty());
	public static final TreeGrower LEMON = new TreeGrower(ExtraDelight.MOD_ID + "lemon", 0.1F, Optional.empty(),
			Optional.empty(), Optional.of(ExtraDelightTreeFeatures.LEMON), Optional.empty(), Optional.empty(),
			Optional.empty());
	public static final TreeGrower LIME = new TreeGrower(ExtraDelight.MOD_ID + "lime", 0.1F, Optional.empty(),
			Optional.empty(), Optional.of(ExtraDelightTreeFeatures.LIME), Optional.empty(), Optional.empty(),
			Optional.empty());
	public static final TreeGrower ORANGE = new TreeGrower(ExtraDelight.MOD_ID + "orange", 0.1F, Optional.empty(),
			Optional.empty(), Optional.of(ExtraDelightTreeFeatures.ORANGE), Optional.empty(), Optional.empty(),
			Optional.empty());
	public static final TreeGrower GRAPEFRUIT = new TreeGrower(ExtraDelight.MOD_ID + "grapefruit", 0.1F, Optional.empty(),
			Optional.empty(), Optional.of(ExtraDelightTreeFeatures.GRAPEFRUIT), Optional.empty(), Optional.empty(),
			Optional.empty());
}
