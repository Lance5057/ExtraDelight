package com.lance5057.extradelight.blocks;

import javax.annotation.Nullable;

import com.lance5057.extradelight.ExtraDelightBlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import vectorwing.farmersdelight.common.block.CabinetBlock;

public class EDCabinet extends CabinetBlock{

	public EDCabinet(Properties properties) {
		super(properties);
	}

	@Nullable
	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return ExtraDelightBlockEntities.CABINET.get().create(pos, state);
	}
}
