package com.lance5057.extradelight.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.neoforged.neoforge.common.ToolAction;
import net.neoforged.neoforge.common.ToolActions;

public class StrippableLog extends RotatedPillarBlock {

	final RotatedPillarBlock stripped;
	final ResourceLocation drop;

	public StrippableLog(RotatedPillarBlock stripped, ResourceLocation drop, Properties pProperties) {

		super(pProperties);
		this.stripped = stripped;
		this.drop = drop;
	}

	public BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction,
			boolean simulate) {

		if (ToolActions.AXE_STRIP == toolAction) {
			if (stripped != null) {
				dropLoot(context.getLevel(), context.getPlayer(), context.getClickedPos());

				return stripped.defaultBlockState().setValue(RotatedPillarBlock.AXIS,
						state.getValue(RotatedPillarBlock.AXIS));
			}
		}
		return state;
	}

	private void dropLoot(Level level, Player player, BlockPos pos) {
		if (level != null && !level.isClientSide()) {
			final LootParams pContext = new LootParams.Builder((ServerLevel) level)
					.withParameter(LootContextParams.TOOL, player.getMainHandItem())
					.withParameter(LootContextParams.THIS_ENTITY, player).withLuck(player.getLuck() + EnchantmentHelper
							.getItemEnchantmentLevel(Enchantments.BLOCK_FORTUNE, player.getMainHandItem()))
					.create(LootContextParamSets.EMPTY);

			player.getServer().getLootData().getLootTable(drop).getRandomItems(pContext).forEach(itemStack -> {
				level.addFreshEntity(new ItemEntity(level, pos.getX() + 0.5f, pos.getY() + 1.5f, pos.getZ() + 0.5f,
						itemStack, 0, 0, 0));
			});

		}
	}
}
