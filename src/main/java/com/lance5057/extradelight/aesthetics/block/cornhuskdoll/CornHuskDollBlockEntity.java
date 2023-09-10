package com.lance5057.extradelight.aesthetics.block.cornhuskdoll;

import com.lance5057.extradelight.ExtraDelightBlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class CornHuskDollBlockEntity extends BlockEntity {

	public CornHuskDollBlockEntity(BlockPos pPos, BlockState pState) {
		super(ExtraDelightBlockEntities.CORN_HUSK_DOLL.get(), pPos, pState);
	}

	@Override
	public ClientboundBlockEntityDataPacket getUpdatePacket() {
		return ClientboundBlockEntityDataPacket.create(this);
	}
}
