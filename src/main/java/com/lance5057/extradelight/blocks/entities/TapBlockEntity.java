package com.lance5057.extradelight.blocks.entities;

import com.lance5057.extradelight.ExtraDelightBlockEntities;
import com.lance5057.extradelight.capabilities.WellFluidCapability;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.capabilities.Capabilities.FluidHandler;
import net.neoforged.neoforge.common.util.Lazy;
import net.neoforged.neoforge.fluids.FluidActionResult;
import net.neoforged.neoforge.fluids.FluidUtil;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;

public class TapBlockEntity extends BlockEntity {

	WellFluidCapability water = new WellFluidCapability(Fluids.WATER);
	private final Lazy<IFluidHandler> fluidHandler = Lazy.of(() -> water);

	public TapBlockEntity(BlockPos pPos, BlockState pState) {
		super(ExtraDelightBlockEntities.TAP.get(), pPos, pState);
	}

	public IFluidHandler getFluidHandler() {
		return fluidHandler.get();
	}

	public ItemStack fill(ItemStack stack, Player player) {
		if (stack.getCapability(FluidHandler.ITEM) != null) {
			FluidActionResult r = FluidUtil.tryFillContainer(stack, water, Integer.MAX_VALUE, player, true);
			return r.result;
		}
		return stack;
	}

	public ItemStack drain(ItemStack stack, Player player) {
		FluidActionResult r = FluidUtil.tryEmptyContainer(stack, water, Integer.MAX_VALUE, player, true);
		return r.result;
	}
}
