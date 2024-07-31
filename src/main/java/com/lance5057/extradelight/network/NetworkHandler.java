package com.lance5057.extradelight.network;

import com.lance5057.extradelight.ExtraDelight;

import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

public class NetworkHandler {
	public static void setupPackets(RegisterPayloadHandlersEvent event) {
		PayloadRegistrar registrar = event.registrar(ExtraDelight.MOD_ID).versioned("1.0.0").optional();
		
		registrar.playToClient(StyleableMenuSyncPacket.id, StyleableMenuSyncPacket::new, payload -> payload.client(StyleableMenuSyncPacket::handle));
	}
}
