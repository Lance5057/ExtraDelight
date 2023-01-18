package com.lance5057.extradelight.blocks.entities;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.ItemStackHandler;

public class FoodDisplayEntity extends BlockEntity {
	private final LazyOptional<IItemHandlerModifiable> handler = LazyOptional.of(this::createHandler);
	public static final int NUM_SLOTS = 6;

	public FoodDisplayEntity(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState) {
		super(pType, pPos, pBlockState);
		// TODO Auto-generated constructor stub
	}

	@Nonnull
	@Override
	public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
		if (side != Direction.DOWN)
			if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
				return handler.cast();
			}
		return super.getCapability(cap, side);
	}

	private IItemHandlerModifiable createHandler() {
		return new ItemStackHandler(NUM_SLOTS) {
			@Override
			protected int getStackLimit(int slot, @Nonnull ItemStack stack) {
				return 1;
			}
		};
	}

}
