package com.lance5057.extradelight;

import com.lance5057.extradelight.loot.FoodLoot;
import com.mojang.serialization.Codec;

import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ExtraDelightLoot {
	private static final DeferredRegister<Codec<? extends IGlobalLootModifier>> SERIALIZERS = DeferredRegister
			.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, ExtraDelight.MOD_ID);

	public static final RegistryObject<Codec<FoodLoot>> LOOT_TABLE = SERIALIZERS.register("food_loot", FoodLoot.CODEC);

	public static void register(final IEventBus modEventBus) {
		SERIALIZERS.register(modEventBus);
	}
}
