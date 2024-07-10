package com.lance5057.extradelight.blocks.keg;

import com.lance5057.extradelight.ExtraDelightBlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.fluids.FluidUtil;
import net.neoforged.neoforge.fluids.capability.templates.FluidTank;

public class KegBlockEntity extends BlockEntity {
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
				KegBlockEntity.this.setChanged();
			}
		};

		return tank;
	}

	public boolean use(Player player, InteractionHand hand) {
		return FluidUtil.interactWithFluidHandler(player, hand, tank);
	}

}
