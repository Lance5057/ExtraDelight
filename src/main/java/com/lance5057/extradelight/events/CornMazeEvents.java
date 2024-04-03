package com.lance5057.extradelight.events;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.ExtraDelightTags;
import com.lance5057.extradelight.ExtraDelightWorldGen;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ExtraDelight.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CornMazeEvents {
	@SubscribeEvent
	public static void onDeath(LivingHurtEvent event) {
		if (event.getEntity().getLevel().dimension() == ExtraDelightWorldGen.CORNFIELD)
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
}
