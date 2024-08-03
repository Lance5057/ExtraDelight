package com.lance5057.extradelight.loot;

import java.util.Optional;
import java.util.function.Supplier;

import org.antlr.v4.runtime.misc.NotNull;

import com.google.common.base.Suppliers;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.Holder.Reference;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;

public class FoodLoot extends LootModifier {
	public static final Supplier<MapCodec<FoodLoot>> CODEC = Suppliers.memoize(() -> RecordCodecBuilder.mapCodec(
			inst -> codecStart(inst).and(ResourceLocation.CODEC.fieldOf("loot_table").forGetter(m -> m.lootTableID))
					.apply(inst, FoodLoot::new)));

	private final ResourceKey<LootTable> lootTableID;

	public FoodLoot(final LootItemCondition[] conditions, final ResourceKey<LootTable> mortar_dungeon) {
		super(conditions);
		this.lootTableID = mortar_dungeon;
	}

	@Override
	protected ObjectArrayList<ItemStack> doApply(final ObjectArrayList<ItemStack> generatedLoot,
			final LootContext context) {
		Optional<Reference<LootTable>> extraTable = context.getResolver().get(Registries.LOOT_TABLE, lootTableID);

		extraTable.getRandomItemsRaw(context, generatedLoot::add);

		return generatedLoot;
	}

	@Override
	public MapCodec<? extends IGlobalLootModifier> codec() {
		return CODEC.get();
	}
}
