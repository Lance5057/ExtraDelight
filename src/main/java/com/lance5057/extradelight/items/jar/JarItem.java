package com.lance5057.extradelight.items.jar;

import java.util.List;

import com.lance5057.extradelight.ExtraDelightComponents;
import com.lance5057.extradelight.blocks.IDisplayInteractable;
import com.lance5057.extradelight.blocks.jar.JarBlock;
import com.lance5057.extradelight.blocks.jar.JarBlockEntity;
import com.lance5057.extradelight.blocks.jardisplay.JarDisplayBlockEntity;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.fluids.SimpleFluidContent;
import net.neoforged.neoforge.fluids.capability.IFluidHandler.FluidAction;
import net.neoforged.neoforge.items.ItemStackHandler;

public class JarItem extends BlockItem implements IDisplayInteractable {

	public JarItem(JarBlock jarBlock, Properties p_41383_) {
		super(jarBlock, p_41383_);
	}

	@Override
	public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents,
			TooltipFlag tooltipFlag) {
		SimpleFluidContent f = stack.getComponents().get(ExtraDelightComponents.FLUID.get());

		if (f != null && !f.isEmpty()) {
			ResourceLocation r = BuiltInRegistries.FLUID.getKey(f.getFluid());
			tooltipComponents.add(Component.literal("Contains: " + f.getAmount() + "mb - ")
					.append(Component.translatable(f.getFluidType().getDescriptionId()))
					.withStyle(ChatFormatting.WHITE));
		}
	}

	@Override
	public ItemInteractionResult itemInteract(ItemStack heldItem, ItemStack interactItem, BlockState state, Level level,
			BlockPos pos, Player player, InteractionHand hand) {
		// TODO Auto-generated method stub
		return ItemInteractionResult.CONSUME;
	}

	@Override
	public void extractItem(Level level, BlockPos pos, Player player, JarDisplayBlockEntity jdbe,
			ItemStackHandler handler, ItemStack s, int index) {
//		if (s.getItem() instanceof BlockItem bi) {
//			BlockItemStateProperties state = s.get(DataComponents.BLOCK_STATE);
//			if (state != null) {
//				int servings = state.get(JarSingularBlock.SERVINGS);
//				if (servings == 0) {
//					List<ItemStack> drops = Block.getDrops(state.apply(bi.getBlock().defaultBlockState()),
//							(ServerLevel) level, pos, null);
//					drops.forEach(item -> {
//						if (!player.addItem(item))
//							level.addFreshEntity(
//									new ItemEntity(level, pos.getX(), pos.getY() + 0.5, pos.getZ(), item.copy()));
//					});
//					handler.setStackInSlot(index, ItemStack.EMPTY);
//				} else {
		if (!player.addItem(s)) {
			level.addFreshEntity(new ItemEntity(level, pos.getX(), pos.getY() + 0.5, pos.getZ(), s.copy()));
			handler.setStackInSlot(index, ItemStack.EMPTY);
		}
//				}
//			}
//		}

	}

	@Override
	public void convertToSingular(BlockPos pos, Level level, JarDisplayBlockEntity jdbe, ItemStack stack) {
		BlockState bs = this.getBlock().defaultBlockState();
		SimpleFluidContent fluid = SimpleFluidContent.EMPTY;
		if (stack.has(ExtraDelightComponents.FLUID.get())) {
			fluid = stack.get(ExtraDelightComponents.FLUID.get());
		}
		level.setBlock(pos, bs, Block.UPDATE_ALL);
		BlockEntity be = level.getBlockEntity(pos);
		if (be instanceof JarBlockEntity jbe)
			jbe.getTank().fill(fluid.copy(), FluidAction.EXECUTE);
	}

}
