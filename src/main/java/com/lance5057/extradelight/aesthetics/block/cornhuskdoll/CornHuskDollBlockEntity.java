package com.lance5057.extradelight.aesthetics.block.cornhuskdoll;

import javax.annotation.Nonnull;

import com.lance5057.extradelight.ExtraDelightBlockEntities;
import com.lance5057.extradelight.ExtraDelightWorldGen;
import com.lance5057.extradelight.util.MathUtil;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class CornHuskDollBlockEntity extends BlockEntity {

	public int maxDistance = 32;
	public int timer = 0;
	public int timerMax = 100;

	public CornHuskDollBlockEntity(BlockPos pPos, BlockState pState) {
		super(ExtraDelightBlockEntities.CORN_HUSK_DOLL.get(), pPos, pState);
	}

	@Override
	public ClientboundBlockEntityDataPacket getUpdatePacket() {
		return ClientboundBlockEntityDataPacket.create(this);
	}

	public static <T extends BlockEntity> void tick(Level level, BlockPos pos, BlockState state, T be) {
		if (level.dimension() == ExtraDelightWorldGen.CORNFIELD) {
			CornHuskDollBlockEntity c = (CornHuskDollBlockEntity) be;

			if (c.timer >= c.timerMax) {
				Player closestP = null;
				double closestL = c.maxDistance;

				for (Player p : level.players()) {
					double d = p.distanceToSqr(pos.getX(), pos.getY(), pos.getZ());

					if (d < closestL) {
						closestL = d;
						closestP = p;
					}
				}

				if (closestP != null) {
					if (Vec3.atCenterOf(pos).closerThan(closestP.getEyePosition(), (double) 64)) {
						BlockPos pPos = closestP.blockPosition();
						float angle = (float) Math.atan2(Math.toRadians(pPos.getZ() - pos.getZ()),
								Math.toRadians(pPos.getX() - pos.getX()));
						float angle2 = (float) Math.toDegrees(angle) + 180 + 90;

						if (angle2 > 360)
							angle2 -= 360;
						if (angle2 < 0)
							angle2 += 360;
						if (angle2 == 360)
							angle2 = 0;

						int i = MathUtil.getAngleIndex(MathUtil.search(angle2));
						level.setBlock(pos, state.setValue(CornHuskDollBlock.FACING, i), 0);
					}
				}
			} else
				c.timer++;
		}
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
	public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt) {
		CompoundTag tag = pkt.getTag();
		// InteractionHandle your Data
		readNBT(tag);
	}

	void readNBT(CompoundTag nbt) {

		this.timer = nbt.getInt("timer");
	}

	CompoundTag writeNBT(CompoundTag tag) {

		tag.putInt("timer", this.timer);

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
