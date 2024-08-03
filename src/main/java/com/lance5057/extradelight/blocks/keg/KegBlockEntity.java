package com.lance5057.extradelight.blocks.keg;

import javax.annotation.Nonnull;

import com.lance5057.extradelight.ExtraDelightBlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.fluids.FluidUtil;
import net.neoforged.neoforge.fluids.capability.templates.FluidTank;

public class KegBlockEntity extends BlockEntity {
	public static final String FLUID_TAG = "fluid";
	private final FluidTank tank = createFluidHandler();

	public FluidTank getTank() {
		return tank;
	}

	public KegBlockEntity(BlockPos p_155229_, BlockState p_155230_) {
		super(ExtraDelightBlockEntities.KEG.get(), p_155229_, p_155230_);
	}

	private FluidTank createFluidHandler() {
		FluidTank tank = new FluidTank(FluidType.BUCKET_VOLUME * 8) {
			@Override
			protected void onContentsChanged() {
				KegBlockEntity.this.requestModelDataUpdate();
				KegBlockEntity.this.getLevel().sendBlockUpdated(KegBlockEntity.this.getBlockPos(), KegBlockEntity.this.getBlockState(), KegBlockEntity.this.getBlockState(), 3);
				KegBlockEntity.this.setChanged();
			}
		};

		return tank;
	}
	
	public float getFullness()
	{
		return (float)tank.getFluidAmount()/(float)tank.getCapacity();
	}

	public boolean use(Player player, InteractionHand hand) {
		return FluidUtil.interactWithFluidHandler(player, hand, tank);
	}

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
		CompoundTag tag = new CompoundTag();

		writeNBT(tag, null);

		return ClientboundBlockEntityDataPacket.create(this);
	}

	@Override
	public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt, HolderLookup.Provider registries) {
		CompoundTag tag = pkt.getTag();
		// InteractionHandle your Data
		readNBT(tag, registries);
	}

	void readNBT(CompoundTag nbt, HolderLookup.Provider registries) {
			tank.readFromNBT(registries, nbt);
	}

	CompoundTag writeNBT(CompoundTag tag, HolderLookup.Provider registries) {

		tank.writeToNBT(registries, tag);

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
