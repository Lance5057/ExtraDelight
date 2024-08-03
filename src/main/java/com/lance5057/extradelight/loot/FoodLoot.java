package com.lance5057.extradelight.loot;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;

public class FoodLoot extends LootModifier {
//	public static final Supplier<MapCodec<FoodLoot>> CODEC = Suppliers.memoize(() -> RecordCodecBuilder.mapCodec(
//			inst -> codecStart(inst).and(ResourceKey ResourceLocation.CODEC.fieldOf("loot_table").forGetter(m -> m.lootTableID))
//					.apply(inst, FoodLoot::new)));

	public static final MapCodec<FoodLoot> CODEC = RecordCodecBuilder.mapCodec(instance -> instance
			.group(IGlobalLootModifier.LOOT_CONDITIONS_CODEC.fieldOf("conditions").forGetter(glm -> glm.conditions),
					ResourceKey.codec(Registries.LOOT_TABLE).fieldOf("loot_table").forGetter(FoodLoot::lootTableID))
			.apply(instance, FoodLoot::new));

	private final ResourceKey<LootTable> lootTableID;

	public ResourceKey<LootTable> lootTableID() {
		return this.lootTableID;
	}

	public FoodLoot(final LootItemCondition[] conditions, final ResourceKey<LootTable> table) {
		super(conditions);
		this.lootTableID = table;
	}

	@Override
	protected ObjectArrayList<ItemStack> doApply(final ObjectArrayList<ItemStack> generatedLoot,
			final LootContext context) {
		context.getResolver().get(Registries.LOOT_TABLE, this.lootTableID).ifPresent(extraTable -> {
			// Don't run loot modifiers for subtables;
			// the added loot will be modifiable by downstream loot modifiers modifying the
			// target table,
			// so if we modify it here then it could get modified twice.
			extraTable.value().getRandomItemsRaw(context,
					LootTable.createStackSplitter(context.getLevel(), generatedLoot::add));
		});
		return generatedLoot;
	}

	@Override
	public MapCodec<? extends IGlobalLootModifier> codec() {
		return CODEC;
	}
}
