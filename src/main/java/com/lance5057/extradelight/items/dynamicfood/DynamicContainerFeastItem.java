package com.lance5057.extradelight.items.dynamicfood;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SolidBucketItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import vectorwing.farmersdelight.common.item.component.ItemStackWrapper;
import vectorwing.farmersdelight.common.registry.ModDataComponents;

import java.util.Optional;

public class DynamicContainerFeastItem extends SolidBucketItem {

    public DynamicContainerFeastItem(
            Block p_151187_,
            SoundEvent p_151188_,
            Properties p_151189_
    ) {
        super(p_151187_, p_151188_, p_151189_);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        ItemStack cached = context.getItemInHand().copy();
        InteractionResult interactionresult = super.useOn(context);
        Player player = context.getPlayer();

        if (interactionresult.consumesAction() && player != null) {
            player.setItemInHand(context.getHand(), getCraftingRemainingItem(cached));
        }

        return interactionresult;
    }

    public ItemStack getCraftingRemainingItem(ItemStack itemStack)
    {
        if (!hasCraftingRemainingItem(itemStack)) {
            return ItemStack.EMPTY;
        }
        var toReturn = Optional.ofNullable(itemStack.get(ModDataComponents.CONTAINER))
                .map(ItemStackWrapper::getStack)
                .orElse(Items.ACACIA_BOAT.getDefaultInstance());
        if (toReturn.isEmpty()) {
            assert this.getCraftingRemainingItem() != null;
            return new ItemStack(this.getCraftingRemainingItem());
        }
        return toReturn;
    }

}
