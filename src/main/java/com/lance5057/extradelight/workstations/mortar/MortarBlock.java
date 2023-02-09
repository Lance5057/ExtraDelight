package com.lance5057.extradelight.workstations.mortar;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

public class MortarBlock extends Block {

	public MortarBlock() {
		super(Properties.of(Material.STONE).strength(1.5F, 2.0F).sound(SoundType.STONE).noOcclusion());
	}

}
