package com.lance5057.extradelight.network;

import com.lance5057.extradelight.ExtraDelight;

import net.neoforged.neoforge.network.event.RegisterPayloadHandlerEvent;
import net.neoforged.neoforge.network.registration.IPayloadRegistrar;

public class NetworkHandler {
	public static void setupPackets(RegisterPayloadHandlerEvent event) {
		IPayloadRegistrar registrar = event.registrar(ExtraDelight.MOD_ID).versioned("1.0.0").optional();
		
		registrar.play(StyleableMenuSyncPacket.id, StyleableMenuSyncPacket::new, payload -> payload.client(StyleableMenuSyncPacket::handle));
	}
}
