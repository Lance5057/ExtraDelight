package com.lance5057.extradelight;

import com.lance5057.extradelight.items.components.ChillComponent;

import net.minecraft.world.item.Items;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.ModifyDefaultComponentsEvent;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = ExtraDelight.MOD_ID)
public class ExtraDelightEvents {

//	@SubscribeEvent
//	public static void stopDimensionDestruction(BlockEvent.BreakEvent event) {
//		if (!event.getPlayer().isCreative())
//			if (event.getPlayer().level().dimension() == ExtraDelightWorldGen.CORNFIELD) {
//				if (event.getState().getBlock() == ExtraDelightBlocks.CORN_BOTTOM.get()
//						|| event.getState().getBlock() == ExtraDelightBlocks.CORN_TOP.get()) {
//					event.getPlayer().hurt(event.getPlayer().damageSources().magic(), 1);
//					event.getLevel().playSound(event.getPlayer(), event.getPos(), SoundEvents.WITCH_CELEBRATE,
//							SoundSource.HOSTILE, 0, 1);
//					event.setCanceled(true);
//				} else {
//					event.getPlayer().addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 200, 1));
//				}
//			}
//	}

	@SubscribeEvent
	public static void modifyComponents(ModifyDefaultComponentsEvent event) {
		// Sets the component on melon seeds
		event.modify(Items.ICE, builder -> builder.set(ExtraDelightComponents.CHILL.value(), new ChillComponent(1000)));
	}
}
