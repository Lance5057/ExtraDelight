package com.lance5057.extradelight.blocks.entities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import vectorwing.farmersdelight.common.block.entity.CabinetBlockEntity;
import vectorwing.farmersdelight.common.registry.ModBlockEntityTypes;

public class EDCabinetEntity extends CabinetBlockEntity {
	
	public EDCabinetEntity(BlockPos pos, BlockState state) {
		super(ModBlockEntityTypes.CABINET.get(), pos, state);
	}

}
