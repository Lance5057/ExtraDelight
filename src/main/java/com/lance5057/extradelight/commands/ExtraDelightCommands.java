package com.lance5057.extradelight.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import com.mojang.brigadier.tree.LiteralCommandNode;

import net.minecraft.commands.CommandBuildContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;

public class ExtraDelightCommands {
	public static void register(CommandDispatcher<CommandSourceStack> dispatcher,
			CommandBuildContext commandBuildContext) {
		LiteralArgumentBuilder<CommandSourceStack> builder = Commands.literal("extradelight")
				.then(BuildAllDebugCommand.register(commandBuildContext));

		LiteralCommandNode<CommandSourceStack> node = dispatcher.register(builder);
		dispatcher.register(Commands.literal("ed").executes(ExtraDelightCommands::run).redirect(node));
	}

	private static int run(CommandContext<CommandSourceStack> ctx) throws CommandSyntaxException {
		throw new SimpleCommandExceptionType(Component.translatable("commands.compendium.usage", ctx.getInput()))
				.create();
	}
}
