package com.lance5057.extradelight.items;

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
		
		return InteractionResult.PASS;

	}
}
