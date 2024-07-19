package com.lance5057.extradelight.items;

import com.lance5057.extradelight.blocks.interfaces.IStyleable;
import com.lance5057.extradelight.gui.StylableScreen;

import net.minecraft.client.Minecraft;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.context.UseOnContext;

public class OffsetSpatulaItem extends TieredItem {

	public OffsetSpatulaItem(Tier pTier, Properties pProperties) {
		super(pTier, pProperties);
	}

	@Override
	public InteractionResult useOn(UseOnContext pContext) {
		if (pContext.getLevel().isClientSide())
			if (pContext.getLevel().getBlockState(pContext.getClickedPos()).getBlock() instanceof IStyleable s) {
				if (pContext.getPlayer().isCrouching()) {
					Minecraft.getInstance()
							.setScreen(new StylableScreen(pContext.getLevel().getBlockState(pContext.getClickedPos()),
									pContext.getClickedPos(), pContext.getLevel()));

				} else
					s.nextStyle(pContext.getLevel(), pContext.getClickedPos(),
							pContext.getLevel().getBlockState(pContext.getClickedPos()));
			}
		return InteractionResult.PASS;

	}
}
