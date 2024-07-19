//package com.lance5057.extradelight;
//
//import net.minecraft.sounds.SoundEvents;
//import net.minecraft.sounds.SoundSource;
//import net.minecraft.world.effect.MobEffectInstance;
//import net.minecraft.world.effect.MobEffects;
//import net.neoforged.bus.api.SubscribeEvent;
//import net.neoforged.fml.common.Mod;
//import net.neoforged.neoforge.event.level.BlockEvent;
//
//@Mod.EventBusSubscriber(modid = ExtraDelight.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
//public class ExtraDelightEvents {
//
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
//}
