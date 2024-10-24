package com.lance5057.extradelight.events;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.ExtraDelightTags;
import com.lance5057.extradelight.ExtraDelightWorldGen;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.neoforge.event.level.BlockEvent;

@EventBusSubscriber(modid = ExtraDelight.MOD_ID)
public class CornMazeEvents {
	@SubscribeEvent
	public static void onDeath(LivingIncomingDamageEvent event) {
		if (event.getEntity().level().dimension() == ExtraDelightWorldGen.CORNFIELD)
			if (event.getEntity() instanceof ServerPlayer p) {
				if (p.getHealth() <= event.getAmount()) {
					p.playSound(SoundEvents.WITCH_CELEBRATE, 1, 1);
					event.setCanceled(true);

					p.getInventory().items.stream().filter(i -> i.is(ExtraDelightTags.CORN_CONFISCATE))
							.forEach(i -> p.getInventory().removeItem(i));

					BlockPos pos = p.getRespawnPosition();
					if (pos == null)
						pos = p.server.getLevel(Level.OVERWORLD).getSharedSpawnPos();

					p.teleportTo(p.server.getLevel(p.getRespawnDimension()), pos.getX(), pos.getY(), pos.getZ(), 0, 0);
					p.heal(p.getMaxHealth());

					p.sendSystemMessage(Component.translatable("extradelight.corn_dimension.death"));

				}
			}
	}

	@SubscribeEvent
	public static void stopDimensionDestruction(BlockEvent.BreakEvent event) {
		if (!event.getPlayer().isCreative())
			if (event.getPlayer().level().dimension() == ExtraDelightWorldGen.CORNFIELD) {
				event.getPlayer().hurt(event.getPlayer().damageSources().magic(), 1);
				event.getPlayer().makeSound(SoundEvents.WITCH_CELEBRATE);
//				.level().playLocalSound(event.getPlayer(), SoundEvents.WITCH_AMBIENT,
//						SoundSource.NEUTRAL, 1, 1);
				event.setCanceled(true);

			}
	}
}
