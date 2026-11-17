package com.lance5057.extradelight.blocks.entities;

import javax.annotation.Nonnull;

import com.lance5057.extradelight.ExtraDelightBlockEntities;
import com.lance5057.extradelight.ExtraDelightConfig;
import com.lance5057.extradelight.capabilities.WellFluidCapability;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
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
import net.neoforged.neoforge.fluids.capability.templates.FluidTank;

public class TapBlockEntity extends BlockEntity {

	IFluidHandler water;
	private final Lazy<IFluidHandler> fluidHandler = Lazy.of(() -> water);

	public TapBlockEntity(BlockPos pPos, BlockState pState) {
		super(ExtraDelightBlockEntities.TAP.get(), pPos, pState);

		if (ExtraDelightConfig.INFINITE_SINK.isFalse()) {
			FluidTank f = new FluidTank(16000);
			f.setValidator(s -> s.getFluidType() == Fluids.WATER.getFluidType());
			water = f;
		} else
			water = new WellFluidCapability(Fluids.WATER);
	}

	public IFluidHandler getFluidHandler() {
		return fluidHandler.get();
	}

//	public ItemStack fill(ItemStack stack, Player player) {
//		if (stack.getCapability(FluidHandler.ITEM) != null) {
//			FluidActionResult r = FluidUtil.tryFillContainer(stack, water, Integer.MAX_VALUE, player, true);
//			return r.result;
//		}
//		return stack;
//	}
//
//	public ItemStack drain(ItemStack stack, Player player) {
//		FluidActionResult r = FluidUtil.tryEmptyContainer(stack, water, Integer.MAX_VALUE, player, true);
//		return r.result;
//	}

	@Override
	public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
		CompoundTag nbt = super.getUpdateTag(registries);

		writeNBT(nbt, registries);

		return nbt;
	}

	@Override
	public void handleUpdateTag(CompoundTag tag, HolderLookup.Provider registries) {
		readNBT(tag, registries);
	}

	@Override
	public ClientboundBlockEntityDataPacket getUpdatePacket() {
//		CompoundTag tag = new CompoundTag();
//
//		writeNBT(tag, null);

		return ClientboundBlockEntityDataPacket.create(this);
	}

	@Override
	public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt, HolderLookup.Provider registries) {
		CompoundTag tag = pkt.getTag();
		// InteractionHandle your Data
		readNBT(tag, registries);
	}

	void readNBT(CompoundTag nbt, HolderLookup.Provider registries) {
		if (water instanceof FluidTank f)
			f.readFromNBT(registries, nbt);
	}

	CompoundTag writeNBT(CompoundTag tag, HolderLookup.Provider registries) {
		if (water instanceof FluidTank f)
			f.writeToNBT(registries, tag);
		return tag;
	}

	@Override
	public void loadAdditional(@Nonnull CompoundTag nbt, HolderLookup.Provider registries) {
		super.loadAdditional(nbt, registries);
		readNBT(nbt, registries);
	}

	@Override
	public void saveAdditional(@Nonnull CompoundTag nbt, HolderLookup.Provider registries) {
		super.saveAdditional(nbt, registries);
		writeNBT(nbt, registries);
	}
}
