package com.lance5057.extradelight.commands;

import com.lance5057.extradelight.ExtraDelightBlocks;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;

import net.minecraft.commands.CommandBuildContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.registries.DeferredHolder;

public class BuildAllDebugCommand {
	public static LiteralArgumentBuilder<CommandSourceStack> register(CommandBuildContext context) {
		return Commands.literal("buildEntireIndex").requires(cs -> cs.hasPermission(2))
				.then(Commands.argument("entity", EntityArgument.entity()).executes(
						p_137784_ -> BuildAllDebugCommand.run(context, EntityArgument.getEntity(p_137784_, "entity"))));
	}

	private static int run(CommandBuildContext ctx, Entity entity) throws CommandSyntaxException {
		Level level = entity.level();
		int x = entity.getBlockX();

		for (DeferredHolder<Block, ? extends Block> b : ExtraDelightBlocks.BLOCKS.getEntries()) {
			int y = 0;
			for (BlockState s : b.get().getStateDefinition().getPossibleStates()) {
				level.setBlock(new BlockPos(x, entity.getBlockY(), y), s, x);
				y += 2;
			}
			x += 2;
		}

		return Command.SINGLE_SUCCESS;

	}

}
