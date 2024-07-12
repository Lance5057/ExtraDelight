package com.lance5057.extradelight.blocks.keg;

import javax.annotation.Nonnull;

import com.lance5057.extradelight.ExtraDelightBlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
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
	public CompoundTag getUpdateTag() {
		CompoundTag nbt = super.getUpdateTag();

		writeNBT(nbt);

		return nbt;
	}

	@Override
	public void handleUpdateTag(CompoundTag tag) {
		readNBT(tag);
	}

	@Override
	public ClientboundBlockEntityDataPacket getUpdatePacket() {
		CompoundTag tag = new CompoundTag();

		writeNBT(tag);

		return ClientboundBlockEntityDataPacket.create(this);
	}

	@Override
	public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt) {
		CompoundTag tag = pkt.getTag();
		// InteractionHandle your Data
		readNBT(tag);
	}

	void readNBT(CompoundTag nbt) {
			tank.readFromNBT(nbt);
	}

	CompoundTag writeNBT(CompoundTag tag) {

		tank.writeToNBT(tag);

		return tag;
	}

	@Override
	public void load(@Nonnull CompoundTag nbt) {
		super.load(nbt);
		readNBT(nbt);
	}

	@Override
	public void saveAdditional(@Nonnull CompoundTag nbt) {
		super.saveAdditional(nbt);
		writeNBT(nbt);
	}
}
