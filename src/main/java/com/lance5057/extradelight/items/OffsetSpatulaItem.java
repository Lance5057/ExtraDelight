package com.lance5057.extradelight.items;

import com.lance5057.extradelight.blocks.interfaces.IStyleable;
import com.lance5057.extradelight.gui.StyleableMenu;

import net.minecraft.network.chat.CommonComponents;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.context.UseOnContext;

public class OffsetSpatulaItem extends TieredItem {

	public OffsetSpatulaItem(Tier pTier, Properties pProperties) {
		super(pTier, pProperties);
	}

	@Override
	public InteractionResult useOn(UseOnContext pContext) {

		if (pContext.getLevel().getBlockState(pContext.getClickedPos()).getBlock() instanceof IStyleable s) {
			if (pContext.getPlayer().isCrouching()) {
				if (!pContext.getLevel().isClientSide())
					pContext.getPlayer().openMenu(new SimpleMenuProvider((p_57074_, p_57075_, p_57076_) -> {
						return new StyleableMenu(p_57074_, p_57075_,
								ContainerLevelAccess.create(pContext.getLevel(), pContext.getClickedPos()));
					}, CommonComponents.EMPTY));

//					ClientHelper.openStyleMenu(pContext.getLevel(), pContext.getClickedPos(),
//							pContext.getLevel().getBlockState(pContext.getClickedPos()));

			} else
				s.nextStyle(pContext.getLevel(), pContext.getClickedPos(),
						pContext.getLevel().getBlockState(pContext.getClickedPos()));
		}
		return InteractionResult.PASS;

	}
}
