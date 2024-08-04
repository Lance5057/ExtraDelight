package com.lance5057.extradelight;

import java.util.function.Supplier;

import com.lance5057.extradelight.loot.FoodLoot;
import com.mojang.serialization.MapCodec;

import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ExtraDelightLootModifiers {
	public static final DeferredRegister<MapCodec<? extends IGlobalLootModifier>> LOOT_MODIFIERS = DeferredRegister
			.create(NeoForgeRegistries.GLOBAL_LOOT_MODIFIER_SERIALIZERS, ExtraDelight.MOD_ID);

	public static final Supplier<MapCodec<FoodLoot>> FOOD_LOOT = LOOT_MODIFIERS.register("food_loot", FoodLoot.CODEC);
}
