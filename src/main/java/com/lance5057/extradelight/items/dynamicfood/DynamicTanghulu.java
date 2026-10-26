package com.lance5057.extradelight.items.dynamicfood;

import com.lance5057.extradelight.ExtraDelight;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;

public class DynamicTanghulu extends DynamicSkewer {
	
	static final ResourceLocation missing_model = ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
			"extra/dynamics/skewer/default_tanghulu");

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
	
	@Override
	public ResourceLocation getMissingModel() {
		return missing_model;
	}
}
