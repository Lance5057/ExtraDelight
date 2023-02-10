package com.lance5057.extradelight.workstations.mixingbowl;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

public class MixingBowlBlock extends Block {

	public MixingBowlBlock() {
		super(Properties.of(Material.WOOD).strength(0.5F, 1.0F).sound(SoundType.WOOD).noOcclusion());
	}

}
