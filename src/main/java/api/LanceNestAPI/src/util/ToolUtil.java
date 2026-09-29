///*
// * Copyright 2021  MelanX / MoreVanillaLib 
// * 			- breakInRadius
// * 			- getBreakBlocks
// * 
// * 			- Modified at line 55
//
//   Licensed under the Apache License, Version 2.0 (the "License");
//   you may not use this file except in compliance with the License.
//   You may obtain a copy of the License at
//
//       http://www.apache.org/licenses/LICENSE-2.0
//
//   Unless required by applicable law or agreed to in writing, software
//   distributed under the License is distributed on an "AS IS" BASIS,
//   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//   See the License for the specific language governing permissions and
//   limitations under the License.
// */
//
package api.LanceNestAPI.src.util;

import java.util.stream.Stream;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class ToolUtil {
//	public static void breakInRadius(Level level, Player player, int radius, BlockPos originPos) {
////		if (level instanceof ServerLevel server) {
//			Stream<BlockPos> brokenBlocks = getBreakBlocks(level, player, radius, 0, originPos);
//			ItemStack heldItem = player.getMainHandItem();
//			brokenBlocks.forEach(pos -> {
//				if (!pos.equals(originPos)) { // Vanilla handles this
//					BlockState state = level.getBlockState(pos);
//					if (player.getMainHandItem().isCorrectToolForDrops(state)) {
//						ServerPlayer serverPlayer = (ServerPlayer) player;
//						if (player.getAbilities().instabuild) {
//							if (state.onDestroyedByPlayer(level, pos, player, true, state.getFluidState()))
//								state.getBlock().destroy(level, pos, state);
//						} else {
//							BlockEvent.BreakEvent event = new BlockEvent.BreakEvent(level, pos, state, player);
//							NeoForge.EVENT_BUS.post(event);
//
//							if (event.isCanceled()) {
//								// Forge copy
//								serverPlayer.connection.send(new ClientboundBlockUpdatePacket(level, pos));
//								BlockEntity tile = level.getBlockEntity(pos);
//								if (tile != null) {
//									Packet<?> packet = tile.getUpdatePacket();
//									if (packet != null) {
//										serverPlayer.connection.send(packet);
//									}
//								}
//							} else {
//								heldItem.getItem().mineBlock(heldItem, level, state, pos, player);
//								BlockEntity blockEntity = level.getBlockEntity(pos);
//								state.getBlock().destroy(level, pos, state);
//								state.getBlock().playerDestroy(level, player, pos, state, blockEntity, heldItem);
////								state.getBlock().popExperience((ServerLevel) level, pos, event.getExpToDrop());
//
//								CommonHooks.handleBlockDrops(level, originPos, state, blockEntity, null, player,
//										heldItem);
//
//								level.removeBlock(pos, false);
//								level.levelEvent(2001, pos, Block.getId(state));
//								serverPlayer.connection.send(new ClientboundBlockUpdatePacket(level, pos));
//							}
//						}
//					}
//				}
//			});
//		}
//	}

	public static Stream<BlockPos> getBreakBlocks(Level level, Player player, int radius, BlockPos originPosition) {
		return getBreakBlocks(level, player, radius, 0, originPosition);
	}

	/**
	 * Returns a list of the blocks that would be broken in breakInRadius, but
	 * doesn't break them.
	 *
	 * @param level  world of player
	 * @param player player breaking
	 * @param radius radius to break in
	 * @param depth  depth to break in
	 * @return a list of blocks that would be broken with the given radius and tool
	 */
	public static Stream<BlockPos> getBreakBlocks(Level level, Player player, int radius, int depth,
			BlockPos originPosition) {
		Stream<BlockPos> potentialBrokenBlocks = Stream.of();

		Vec3 eyePosition = player.getEyePosition();
		Vec3 rotation = player.getViewVector(1);

		double reach = player.getAttributeValue(Attributes.BLOCK_INTERACTION_RANGE);
		Vec3 combined = eyePosition.add(rotation.x * reach, rotation.y * reach, rotation.z * reach);

		BlockHitResult rayTraceResult = level.clip(new ClipContext(player.getEyePosition(), combined,
				ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, player));

		if (rayTraceResult.getType() == HitResult.Type.BLOCK) {
			Direction side = rayTraceResult.getDirection();

			boolean doX = side.getStepX() == 0;
			boolean doY = side.getStepY() == 0;
			boolean doZ = side.getStepZ() == 0;

			BlockPos begin = new BlockPos(doX ? -radius : 0, doY ? -radius : 0, doZ ? -radius : 0);
			BlockPos end = new BlockPos(doX ? radius : depth * -side.getStepX(),
					doY ? radius : depth * -side.getStepY(), doZ ? radius : depth * -side.getStepZ());

			return BlockPos.betweenClosedStream(originPosition.offset(begin), originPosition.offset(end));
		}

		return potentialBrokenBlocks;
	}

	public static Holder<Enchantment> getEnchantment(Level level, ResourceKey<Enchantment> key) {
		return level.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getHolderOrThrow(key);
	}
}
