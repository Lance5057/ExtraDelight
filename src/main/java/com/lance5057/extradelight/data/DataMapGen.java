package com.lance5057.extradelight.data;

import java.util.concurrent.CompletableFuture;

import com.lance5057.extradelight.ExtraDelightItems;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.ComposterBlock;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.Compostable;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;

public class DataMapGen extends DataMapProvider {

	protected DataMapGen(PackOutput packOutput, CompletableFuture<Provider> lookupProvider) {
		super(packOutput, lookupProvider);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void gather() {
		Builder<Compostable, Item> compostables = this.builder(NeoForgeDataMaps.COMPOSTABLES);

		compostables.add(ExtraDelightItems.CORN_COB.asItem().builtInRegistryHolder(), new Compostable(0.2f), false);
		compostables.add(ExtraDelightItems.CORN_COB_BUNDLE.asItem().builtInRegistryHolder(), new Compostable(0.85f), false);
		compostables.add(ExtraDelightItems.CORN_HUSK.asItem().builtInRegistryHolder(), new Compostable(0.2f), false);
		compostables.add(ExtraDelightItems.CORN_HUSK_BUNDLE.asItem().builtInRegistryHolder(), new Compostable(0.85f), false);
		compostables.add(ExtraDelightItems.CORN_ON_COB.asItem().builtInRegistryHolder(), new Compostable(0.2f), false);
		compostables.add(ExtraDelightItems.CORN_SEEDS.asItem().builtInRegistryHolder(), new Compostable(0.2f), false);
		compostables.add(ExtraDelightItems.CORN_SILK.asItem().builtInRegistryHolder(), new Compostable(0.2f), false);
		compostables.add(ExtraDelightItems.DRIED_CORN_HUSK.asItem().builtInRegistryHolder(), new Compostable(0.2f),
				false);
		compostables.add(ExtraDelightItems.DRIED_CORN_HUSK_BUNDLE.asItem().builtInRegistryHolder(),
				new Compostable(0.85f), false);
		compostables.add(ExtraDelightItems.UNSHUCKED_CORN.asItem().builtInRegistryHolder(), new Compostable(0.2f),
				false);
		compostables.add(ExtraDelightItems.BAD_FOOD.asItem().builtInRegistryHolder(), new Compostable(1f), false);
		compostables.add(ExtraDelightItems.CACTUS.asItem().builtInRegistryHolder(), new Compostable(0.2f), false);
		compostables.add(ExtraDelightItems.SLICED_APPLE.asItem().builtInRegistryHolder(), new Compostable(0.2f), false);
		compostables.add(ExtraDelightItems.SLICED_GINGER.asItem().builtInRegistryHolder(), new Compostable(0.2f),
				false);
		compostables.add(ExtraDelightItems.SLICED_ONION.asItem().builtInRegistryHolder(), new Compostable(0.2f), false);
		compostables.add(ExtraDelightItems.SLICED_POTATO.asItem().builtInRegistryHolder(), new Compostable(0.2f),
				false);
		compostables.add(ExtraDelightItems.SLICED_TOMATO.asItem().builtInRegistryHolder(), new Compostable(0.2f),
				false);
		compostables.add(ExtraDelightItems.BREAD_SLICE.asItem().builtInRegistryHolder(), new Compostable(0.2f), false);
		compostables.add(ExtraDelightItems.GINGER.asItem().builtInRegistryHolder(), new Compostable(0.2f), false);
		compostables.add(ExtraDelightItems.MINT.asItem().builtInRegistryHolder(), new Compostable(0.2f), false);
		compostables.add(ExtraDelightItems.COFFEE_CHERRIES.asItem().builtInRegistryHolder(), new Compostable(0.2f),
				false);
		compostables.add(ExtraDelightItems.CINNAMON_LEAVES.asItem().builtInRegistryHolder(), new Compostable(0.2f), false);
		compostables.add(ExtraDelightItems.CINNAMON_SAPLING.asItem().builtInRegistryHolder(), new Compostable(0.2f), false);
		compostables.add(ExtraDelightItems.CINNAMON_BARK.asItem().builtInRegistryHolder(), new Compostable(0.2f), false);
		compostables.add(ExtraDelightItems.HAZELNUT_LEAVES.asItem().builtInRegistryHolder(), new Compostable(0.2f), false);
		compostables.add(ExtraDelightItems.HAZELNUT_SAPLING.asItem().builtInRegistryHolder(), new Compostable(0.2f), false);
		compostables.add(ExtraDelightItems.HAZELNUTS.asItem().builtInRegistryHolder(), new Compostable(0.2f), false);
		compostables.add(ExtraDelightItems.HAZELNUTS_IN_SHELL.asItem().builtInRegistryHolder(), new Compostable(0.2f),
				false);
		compostables.add(ExtraDelightItems.MARSHMALLOW.asItem().builtInRegistryHolder(), new Compostable(0.2f), false);
		compostables.add(ExtraDelightItems.MALLOW_ROOT.asItem().builtInRegistryHolder(), new Compostable(0.2f), false);
		compostables.add(ExtraDelightItems.PEANUTS_IN_SHELL.asItem().builtInRegistryHolder(), new Compostable(0.2f),
				false);
		compostables.add(ExtraDelightItems.PEANUTS.asItem().builtInRegistryHolder(), new Compostable(0.2f), false);
		compostables.add(ExtraDelightItems.CHILI.asItem().builtInRegistryHolder(), new Compostable(0.2f), false);

		compostables.add(ExtraDelightItems.WILD_CHILI_BLOCK.asItem().builtInRegistryHolder(), new Compostable(0.2f),
				false);
		compostables.add(ExtraDelightItems.WILD_MALLOW_ROOT_BLOCK.asItem().builtInRegistryHolder(),
				new Compostable(0.2f), false);
		compostables.add(ExtraDelightItems.WILD_GINGER.asItem().builtInRegistryHolder(), new Compostable(0.2f), false);
		compostables.add(ExtraDelightItems.WILD_PEANUT_BLOCK.asItem().builtInRegistryHolder(), new Compostable(0.2f),
				false);
	}

}
