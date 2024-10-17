package com.lance5057.extradelight.items;

import com.lance5057.extradelight.ExtraDelight;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.state.BlockState;
import vectorwing.farmersdelight.common.utility.TextUtils;

import java.util.List;

public class FrostingItem extends Item {

	public FrostingItem(Properties pProperties) {
		super(pProperties);
	}

	@Override
	public InteractionResult useOn(UseOnContext pContext) {
		BlockState bs = pContext.getLevel().getBlockState(pContext.getClickedPos());
//		convert(pContext.getLevel(), pContext.getClickedPos(), bs, pContext.getPlayer(), pContext.getHand());

		return InteractionResult.PASS;
	}

//	protected InteractionResult convert(Level level, BlockPos pos, BlockState state, Player player,
//			InteractionHand hand) {
//
//		ItemStack heldStack = player.getItemInHand(hand);
//		Optional<ToolOnBlockRecipe> r = level.getRecipeManager().getRecipeFor(ExtraDelightRecipes.TOOL_ON_BLOCK.get(),
//				new SimpleContainer(heldStack, new ItemStack(state.getBlock().asItem())), level);
//
//		if (r.isPresent()) {
//			Block result = r.get().getResultBlock();
//			level.setBlock(pos, result.defaultBlockState(), 3);
//			if (!player.getAbilities().instabuild) {
//				if (heldStack.isDamageableItem())
//					heldStack.hurtAndBreak(1, player, null);
//				else
//					heldStack.shrink(1);
//			}
//			
//			for (int i = 0; i < 10; i++)
//				level.addParticle(new BlockParticleOption(ParticleTypes.BLOCK, result.defaultBlockState()),
//						pos.getX() + level.random.nextFloat(),
//						pos.getY() + level.random.nextFloat(),
//						pos.getZ() + level.random.nextFloat(), 0, 0, 0);
//			
//			level.playSound(null, pos, SoundEvents.SLIME_BLOCK_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);
//			return InteractionResult.SUCCESS;
//		}
//
//		return InteractionResult.PASS;
//	}
	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip,
								TooltipFlag isAdvanced) {
		TextUtils.addFoodEffectTooltip(stack, tooltip::add, 1.0F, context.tickRate());
	}
}
