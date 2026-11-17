package com.lance5057.extradelight.network;

import com.lance5057.extradelight.ExtraDelight;

import api.LanceNestAPI.src.network.AdvancedDisplaySetPacket;
import api.LanceNestAPI.src.network.AdvancedDisplaySyncPacket;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

public class NetworkHandler {
	public static void setupPackets(RegisterPayloadHandlersEvent event) {
		PayloadRegistrar registrar = event.registrar(ExtraDelight.MOD_ID).versioned("1.0.0").optional();

		registrar.playToClient(StyleableMenuSyncPacket.id, StyleableMenuSyncPacket.STREAM_CODEC,
				StyleableMenuSyncPacket::handle);

		if (!ModList.get().isLoaded("compendium")) {
			registrar.playToClient(AdvancedDisplaySyncPacket.id, AdvancedDisplaySyncPacket.STREAM_CODEC,
					AdvancedDisplaySyncPacket::handle);
			registrar.playToServer(AdvancedDisplaySetPacket.id, AdvancedDisplaySetPacket.STREAM_CODEC,
					AdvancedDisplaySetPacket::handle);

		}
	}
}
