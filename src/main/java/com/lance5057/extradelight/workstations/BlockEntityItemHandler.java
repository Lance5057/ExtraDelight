package com.lance5057.extradelight.workstations;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.items.ItemStackHandler;

public class BlockEntityItemHandler<T extends BlockEntity> extends ItemStackHandler {
	final T be;

	public T getBlockEntity() {
		return be;
	}

	public BlockEntityItemHandler(T be, int size) {
		super(size);
		this.be = be;

	}
}
