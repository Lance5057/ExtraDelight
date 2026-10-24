package com.lance5057.extradelight.items.dynamicfood;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;

public class DynamicTanghulu extends DynamicSkewer {

	public DynamicTanghulu(Properties properties) {
		super(properties);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected String getResourceString() {
		return "extra/dynamics/skewer/glazed_";
	}

	public MutableComponent componentName() {
		return Component.translatable("dynamic.tanghulu");
	}
}
