package com.lance5057.extradelight.worldgen.features.trees;

import java.util.Optional;

import com.lance5057.extradelight.ExtraDelight;

import net.minecraft.world.level.block.grower.TreeGrower;

public class ExtraDelightTreeGrowers {
	public static final TreeGrower CINNAMON = new TreeGrower(ExtraDelight.MOD_ID + "cinnamon", 0.1F, Optional.empty(),
			Optional.empty(), Optional.of(ExtraDelightTreeFeatures.CINNAMON), Optional.empty(), Optional.empty(), Optional.empty());
}
