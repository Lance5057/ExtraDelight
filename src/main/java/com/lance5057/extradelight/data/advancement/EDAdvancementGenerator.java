package com.lance5057.extradelight.data.advancement;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.function.Consumer;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.ExtraDelightBlocks;
import com.lance5057.extradelight.ExtraDelightItems;
import com.lance5057.extradelight.ExtraDelightTags;
import com.lance5057.extradelight.aesthetics.AestheticBlocks;
import com.lance5057.extradelight.modules.Fermentation;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.Advancement.Builder;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.critereon.BlockPredicate;
import net.minecraft.advancements.critereon.ConsumeItemTrigger;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.ItemUsedOnLocationTrigger;
import net.minecraft.advancements.critereon.LocationPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.data.AdvancementProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredItem;
import vectorwing.farmersdelight.common.registry.ModItems;

public class EDAdvancementGenerator implements AdvancementProvider.AdvancementGenerator {

	public static HashMap<String, DeferredItem<Item>> SNACKS = new HashMap<String, DeferredItem<Item>>();
	public static HashMap<String, DeferredItem<Item>> FEASTS = new HashMap<String, DeferredItem<Item>>();
	public static HashMap<String, DeferredItem<Item>> MEALS = new HashMap<String, DeferredItem<Item>>();
	public static HashMap<String, DeferredItem<Item>> DESSERTS = new HashMap<String, DeferredItem<Item>>();
	public static HashMap<String, DeferredItem<Item>> DRINKS = new HashMap<String, DeferredItem<Item>>();
	public static HashMap<String, DeferredItem<Item>> CANDY = new HashMap<String, DeferredItem<Item>>();
	public static HashMap<String, DeferredItem<Item>> COOKIES = new HashMap<String, DeferredItem<Item>>();
	public static HashMap<String, DeferredItem<Item>> INGREDIENTS = new HashMap<String, DeferredItem<Item>>();
	public static HashMap<String, DeferredItem<Item>> BUTCHERCRAFT = new HashMap<String, DeferredItem<Item>>();

	@Override
	public void generate(Provider registries, Consumer<AdvancementHolder> consumer,
			ExistingFileHelper existingFileHelper) {
		AdvancementHolder start = Advancement.Builder.advancement()
				.display(ExtraDelightItems.WOODEN_SPOON.get(),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.start.name"),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.start.desc"),
						ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "textures/block/wallpaper_red.png"),
						AdvancementType.TASK, false, false, true)
				.addCriterion("start", InventoryChangeTrigger.TriggerInstance.hasItems(new ItemLike[] {}))
				.save(consumer, ExtraDelight.MOD_ID + ":start");

		AdvancementHolder grater = Advancement.Builder.advancement()
				.display(ExtraDelightItems.GRATER.get(),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.grater.name"),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.grater.desc"), null,
						AdvancementType.TASK, true, true, false)
				.parent(start)
				.addCriterion("grater", InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.GRATER.get()))
				.save(consumer, ExtraDelight.MOD_ID + ":grater");

		AdvancementHolder spoon = Advancement.Builder.advancement()
				.display(ExtraDelightItems.DIAMOND_SPOON.get(),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.spoon.name"),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.spoon.desc"), null,
						AdvancementType.TASK, true, true, false)
				.parent(start)
				.addCriterion("diamond_spoon",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.DIAMOND_SPOON.get()))
				.addCriterion("gold_spoon",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.GOLD_SPOON.get()))
				.addCriterion("iron_spoon",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.IRON_SPOON.get()))
				.addCriterion("netherite_spoon",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.NETHERITE_SPOON.get()))
				.addCriterion("stone_spoon",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.STONE_SPOON.get()))
				.addCriterion("wooden_spoon",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.WOODEN_SPOON.get()))
				.requirements(AdvancementRequirements.Strategy.OR).save(consumer, ExtraDelight.MOD_ID + ":spoon");

		AdvancementHolder mixingbowl = Advancement.Builder.advancement()
				.display(ExtraDelightItems.MIXING_BOWL.get(),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.mixingbowl.name"),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.mixingbowl.desc"), null,
						AdvancementType.TASK, true, true, false)
				.parent(spoon)
				.addCriterion("mixingbowl",
						ItemUsedOnLocationTrigger.TriggerInstance
								.itemUsedOnBlock(
										LocationPredicate.Builder.location()
												.setBlock(BlockPredicate.Builder.block()
														.of(ExtraDelightBlocks.MIXING_BOWL.get())),
										ItemPredicate.Builder.item().of(ExtraDelightTags.SPOONS)))
				.save(consumer, ExtraDelight.MOD_ID + ":mixingbowl");

		AdvancementHolder burn_mint = Advancement.Builder.advancement()
				.display(ExtraDelightItems.MINT.get(),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.burn_mint.name"),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.burn_mint.desc"), null,
						AdvancementType.GOAL, true, true, true)
				.parent(start)
				.addCriterion("burn_mint",
						ItemUsedOnLocationTrigger.TriggerInstance.itemUsedOnBlock(
								LocationPredicate.Builder.location().setBlock(
										BlockPredicate.Builder.block().of(ExtraDelightBlocks.MINT_CROP.get())),
								ItemPredicate.Builder.item().of(Items.FLINT_AND_STEEL)))
				.save(consumer, ExtraDelight.MOD_ID + ":burn_mint");

		AdvancementHolder oven = Advancement.Builder.advancement()
				.display(ExtraDelightItems.OVEN.get(),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.oven.name"),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.oven.desc"), null,
						AdvancementType.TASK, true, true, false)
				.parent(start)
				.addCriterion("oven", InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.OVEN.get()))
				.save(consumer, ExtraDelight.MOD_ID + ":oven");

		AdvancementHolder evaporator = Advancement.Builder.advancement()
				.display(ExtraDelightItems.EVAPORATOR.get(),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.evaporator.name"),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.evaporator.desc"), null,
						AdvancementType.TASK, true, true, false)
				.parent(start)
				.addCriterion("evaporator",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.EVAPORATOR.get()))
				.save(consumer, ExtraDelight.MOD_ID + ":evaporator");

		AdvancementHolder vat = Advancement.Builder.advancement()
				.display(ExtraDelightItems.VAT.get(),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.vat.name"),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.vat.desc"), null,
						AdvancementType.TASK, true, true, false)
				.parent(start)
				.addCriterion("vat", InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.VAT.get()))
				.save(consumer, ExtraDelight.MOD_ID + ":vat");

		AdvancementHolder lid = Advancement.Builder.advancement()
				.display(ExtraDelightItems.LID.get(),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.lid.name"),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.lid.desc"), null,
						AdvancementType.TASK, true, true, false)
				.parent(vat)
				.addCriterion("lid", InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.LID.get()))
				.save(consumer, ExtraDelight.MOD_ID + ":lid");

		AdvancementHolder pickle = Advancement.Builder.advancement()
				.display(Fermentation.GHERKIN_ITEM.get(),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.pickle.name"),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.pickle.desc"), null,
						AdvancementType.TASK, true, true, false)
				.parent(vat)
				.addCriterion("pickle",
						InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item()
								.of(ExtraDelightTags.PICKLED).withCount(MinMaxBounds.Ints.atLeast(2))))
				.save(consumer, ExtraDelight.MOD_ID + ":pickle");

		AdvancementHolder trays = Advancement.Builder.advancement()
				.display(ExtraDelightItems.TRAY.get(),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.trays.name"),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.trays.desc"), null,
						AdvancementType.TASK, true, true, false)
				.parent(oven)
				.addCriterion("tray", InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.TRAY.get()))
				.addCriterion("sheet", InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.SHEET.get()))
				.addCriterion("baking_stone",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.BAKING_STONE.get()))
				.addCriterion("loaf_pan",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.LOAF_PAN.get()))
				.addCriterion("pie_dish",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.PIE_DISH.get()))
				.addCriterion("muffin_tin",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.MUFFIN_TIN.get()))
				.addCriterion("square_pan",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.SQUARE_PAN.get()))
				.requirements(AdvancementRequirements.Strategy.AND).save(consumer, ExtraDelight.MOD_ID + ":trays");

		AdvancementHolder mortar = Advancement.Builder.advancement()
				.display(ExtraDelightItems.MORTAR_STONE.get(),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.mortar.name"),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.mortar.desc"), null,
						AdvancementType.TASK, true, true, false)
				.parent(start)
				.addCriterion("mortar",
						InventoryChangeTrigger.TriggerInstance
								.hasItems(ItemPredicate.Builder.item().of(ExtraDelightTags.MORTAR).build()))
				.save(consumer, ExtraDelight.MOD_ID + ":mortar");

		AdvancementHolder flour = Advancement.Builder.advancement()
				.display(ExtraDelightItems.FLOUR.get(),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.flour.name"),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.flour.desc"), null,
						AdvancementType.TASK, true, true, false)
				.parent(mortar)
				.addCriterion("flour",
						InventoryChangeTrigger.TriggerInstance
								.hasItems(ItemPredicate.Builder.item().of(ExtraDelightTags.FLOUR).build()))
				.save(consumer, ExtraDelight.MOD_ID + ":flour");

		AdvancementHolder grind = Advancement.Builder.advancement()
				.display(ExtraDelightItems.PESTLE_ENDSTONE.get(),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.grind.name"),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.grind.desc"), null,
						AdvancementType.GOAL, true, true, false)
				.parent(mortar)
				.addCriterion("grind",
						ItemUsedOnLocationTrigger.TriggerInstance
								.itemUsedOnBlock(
										LocationPredicate.Builder.location()
												.setBlock(BlockPredicate.Builder.block()
														.of(ExtraDelightBlocks.MORTAR_STONE.get())),
										ItemPredicate.Builder.item().of(ExtraDelightTags.PESTLES)))
				.save(consumer, ExtraDelight.MOD_ID + ":grind");

		AdvancementHolder doughshaping = Advancement.Builder.advancement()
				.display(ExtraDelightItems.DOUGH_SHAPING.get(),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.doughshaping.name"),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.doughshaping.desc"), null,
						AdvancementType.TASK, true, true, false)
				.parent(start)
				.addCriterion("doughshaping",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.DOUGH_SHAPING.get()))
				.save(consumer, ExtraDelight.MOD_ID + ":doughshaping");

		AdvancementHolder hellskitchen = Advancement.Builder.advancement()
				.display(ExtraDelightItems.NETHERITE_SPOON.get(),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.hellskitchen.name"),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.hellskitchen.desc"), null,
						AdvancementType.TASK, true, true, false)
				.parent(spoon)
				.addCriterion("hellskitchen_spoon",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.NETHERITE_SPOON.get()))
				.addCriterion("hellskitchen_knife",
						InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_KNIFE.get()))
				.save(consumer, ExtraDelight.MOD_ID + ":hellskitchen");

		AdvancementHolder noodles = Advancement.Builder.advancement()
				.display(ExtraDelightItems.LASAGNA_NOODLES.get(),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.noodles.name"),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.noodles.desc"), null,
						AdvancementType.GOAL, true, true, false)
				.parent(doughshaping)
				.addCriterion("lasagna_noodles",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.LASAGNA_NOODLES.get()))
				.addCriterion("macaroni_noodles",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.MACARONI.get()))
				.addCriterion("pasta", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.RAW_PASTA.get()))
				.requirements(AdvancementRequirements.Strategy.AND).save(consumer, ExtraDelight.MOD_ID + ":noodles");

		AdvancementHolder dryingrack = Advancement.Builder.advancement()
				.display(ExtraDelightItems.DRYING_RACK.get(),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.dryingrack.name"),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.dryingrack.desc"), null,
						AdvancementType.TASK, true, true, false)
				.parent(start)
				.addCriterion("dryingrack",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.DRYING_RACK.get()))
				.save(consumer, ExtraDelight.MOD_ID + ":dryingrack");

		AdvancementHolder yeastpot = Advancement.Builder.advancement()
				.display(ExtraDelightItems.YEAST_POT.get(),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.yeastpot.name"),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.yeastpot.desc"), null,
						AdvancementType.TASK, true, true, false)
				.parent(start)
				.addCriterion("yeastpot",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.YEAST_POT.get()))
				.addCriterion("yeast", InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.YEAST.get()))
				.requirements(AdvancementRequirements.Strategy.AND).save(consumer, ExtraDelight.MOD_ID + ":yeastpot");

		AdvancementHolder vinegarpot = Advancement.Builder.advancement()
				.display(ExtraDelightItems.VINEGAR_POT.get(),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.vinegarpot.name"),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.vinegarpot.desc"), null,
						AdvancementType.TASK, true, true, false)
				.parent(start)
				.addCriterion("vinegarpot",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.VINEGAR_POT.get()))
				.addCriterion("vinegar",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.VINEGAR.get()))
				.requirements(AdvancementRequirements.Strategy.AND).save(consumer, ExtraDelight.MOD_ID + ":vinegarpot");

		AdvancementHolder jelly = Advancement.Builder.advancement()
				.display(ExtraDelightItems.JELLY_LIME.get(),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.jelly.name"),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.jelly.desc"), null,
						AdvancementType.TASK, true, true, false)
				.parent(start)
				.addCriterion("jelly",
						InventoryChangeTrigger.TriggerInstance
								.hasItems(ItemPredicate.Builder.item().of(ExtraDelightTags.JELLY).build()))
				.save(consumer, ExtraDelight.MOD_ID + ":jelly");

		AdvancementHolder jellyall = Advancement.Builder.advancement()
				.display(ExtraDelightItems.JELLY_MAGENTA.get(),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.jellyall.name"),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.jellyall.desc"), null,
						AdvancementType.CHALLENGE, true, true, true)
				.parent(jelly)
				.addCriterion("jellyall_white",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightBlocks.JELLY_WHITE.get()))
				.addCriterion("jellyall_orange",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightBlocks.JELLY_ORANGE.get()))
				.addCriterion("jellyall_magenta",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightBlocks.JELLY_MAGENTA.get()))
				.addCriterion("jellyall_light_blue",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightBlocks.JELLY_LIGHT_BLUE.get()))
				.addCriterion("jellyall_yellow",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightBlocks.JELLY_YELLOW.get()))
				.addCriterion("jellyall_lime",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightBlocks.JELLY_LIME.get()))
				.addCriterion("jellyall_pink",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightBlocks.JELLY_PINK.get()))
				.addCriterion("jellyall_grey",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightBlocks.JELLY_GREY.get()))
				.addCriterion("jellyall_light_grey",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightBlocks.JELLY_LIGHT_GREY.get()))
				.addCriterion("jellyall_cyan",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightBlocks.JELLY_CYAN.get()))
				.addCriterion("jellyall_purple",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightBlocks.JELLY_PURPLE.get()))
				.addCriterion("jellyall_blue",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightBlocks.JELLY_BLUE.get()))
				.addCriterion("jellyall_brown",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightBlocks.JELLY_BROWN.get()))
				.addCriterion("jellyall_green",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightBlocks.JELLY_GREEN.get()))
				.addCriterion("jellyall_red",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightBlocks.JELLY_RED.get()))
				.addCriterion("jellyall_black",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightBlocks.JELLY_BLACK.get()))
				.requirements(AdvancementRequirements.Strategy.AND).save(consumer, ExtraDelight.MOD_ID + ":jellyall");

		AdvancementHolder food = Advancement.Builder.advancement()
				.display(Items.APPLE, Component.translatable(ExtraDelight.MOD_ID + ".advancement.food.name"),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.food.desc"), null,
						AdvancementType.TASK, true, true, false)
				.parent(start).addCriterion("food", ConsumeItemTrigger.TriggerInstance.usedItem())
				.save(consumer, ExtraDelight.MOD_ID + ":food");

		AdvancementHolder badfood = Advancement.Builder.advancement()
				.display(ExtraDelightItems.BAD_FOOD.get(),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.badfood.name"),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.badfood.desc"), null,
						AdvancementType.TASK, true, true, false)
				.parent(food)
				.addCriterion("badfood", ConsumeItemTrigger.TriggerInstance.usedItem(ExtraDelightItems.BAD_FOOD.get()))
				.save(consumer, ExtraDelight.MOD_ID + ":badfood");

		AdvancementHolder cactus_juice = Advancement.Builder.advancement()
				.display(ExtraDelightItems.CACTUS_JUICE.get(),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.cactus_juice.name"),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.cactus_juice.desc"), null,
						AdvancementType.GOAL, true, true, true)
				.parent(food)
				.addCriterion("cactus_juice",
						ConsumeItemTrigger.TriggerInstance.usedItem(ExtraDelightItems.CACTUS_JUICE.get()))
				.save(consumer, ExtraDelight.MOD_ID + ":cactus_juice");

		AdvancementHolder frosting = Advancement.Builder.advancement()
				.display(ExtraDelightItems.FROSTING_YELLOW.get(),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.frosting.name"),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.frosting.desc"), null,
						AdvancementType.GOAL, true, true, true)
				.parent(food)
				.addCriterion("frosting_white_frosting",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FROSTING_WHITE.get()))
				.addCriterion("frosting_light_gray_frosting",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FROSTING_LIGHT_GRAY.get()))
				.addCriterion("frosting_gray_frosting",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FROSTING_GRAY.get()))
				.addCriterion("frosting_black_frosting",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FROSTING_BLACK.get()))
				.addCriterion("frosting_brown_frosting",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FROSTING_BROWN.get()))
				.addCriterion("frosting_red_frosting",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FROSTING_RED.get()))
				.addCriterion("frosting_orange_frosting",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FROSTING_ORANGE.get()))
				.addCriterion("frosting_yellow_frosting",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FROSTING_YELLOW.get()))
				.addCriterion("frosting_lime_frosting",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FROSTING_LIME.get()))
				.addCriterion("frosting_green_frosting",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FROSTING_GREEN.get()))
				.addCriterion("frosting_cyan_frosting",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FROSTING_CYAN.get()))
				.addCriterion("frosting_light_blue_frosting",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FROSTING_LIGHT_BLUE.get()))
				.addCriterion("frosting_blue_frosting",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FROSTING_BLUE.get()))
				.addCriterion("frosting_purple_frosting",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FROSTING_PURPLE.get()))
				.addCriterion("frosting_magenta_frosting",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FROSTING_MAGENTA.get()))
				.addCriterion("frosting_pink_frosting",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FROSTING_PINK.get()))
				.save(consumer, ExtraDelight.MOD_ID + ":frosting");

		if (!SNACKS.isEmpty()) {
			Builder snacksBuilder = Advancement.Builder.advancement()
					.display(ExtraDelightItems.POPCORN.get(),
							Component.translatable(ExtraDelight.MOD_ID + ".advancement.snacks.name"),
							Component.translatable(ExtraDelight.MOD_ID + ".advancement.snacks.desc"), null,
							AdvancementType.CHALLENGE, true, true, false)
					.parent(food).requirements(AdvancementRequirements.Strategy.AND);
//				.addCriterion("sunflower_seeds",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.SUNFLOWER_SEEDS.get()))
//				.addCriterion("hard_boiled_egg",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.BOILED_EGG.get()))
//				.addCriterion("potato_chips",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.POTATO_CHIPS.get()))
//				.addCriterion("toast", InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.TOAST.get()))
//				.addCriterion("popcorn",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.POPCORN.get()))
//				.addCriterion("roasted_pumpkin_seeds",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.ROASTED_PUMPKIN_SEEDS.get()))
//				.addCriterion("caramel_popcorn",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CARAMEL_POPCORN.get()))
//				.addCriterion("crackers",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CRACKERS.get()))
//				.addCriterion("bread_roll",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.ROLL.get()))
//				.addCriterion("graham_cracker",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.GRAHAM_CRACKER.get()))
//				.addCriterion("trail_mix",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.TRAIL_MIX.get()))
//				.addCriterion("jerky", InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.JERKY.get()))
//				.addCriterion("apple_chips",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.APPLE_CHIPS.get()))
			for (Entry<String, DeferredItem<Item>> entry : SNACKS.entrySet()) {
				snacksBuilder.addCriterion(entry.getKey(),
						InventoryChangeTrigger.TriggerInstance.hasItems(entry.getValue()));
			}
			AdvancementHolder snacks = snacksBuilder.save(consumer, ExtraDelight.MOD_ID + ":snacks");
		}

		if (!FEASTS.isEmpty()) {
			Builder feastsBuilder = Advancement.Builder.advancement()
					.display(ExtraDelightItems.MACARONI_CHEESE_FEAST.get(),
							Component.translatable(ExtraDelight.MOD_ID + ".advancement.feasts.name"),
							Component.translatable(ExtraDelight.MOD_ID + ".advancement.feasts.desc"), null,
							AdvancementType.CHALLENGE, true, true, false)
					.parent(food).requirements(AdvancementRequirements.Strategy.AND);
//				.addCriterion("sweet_berry_pie",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.SWEET_BERRY_PIE_ITEM.get()))
//				.addCriterion("glow_berry_pie",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.GLOW_BERRY_PIE_ITEM.get()))
//				.addCriterion("cheesecake",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CHEESECAKE_ITEM.get()))
//				.addCriterion("honey_cheesecake",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.HONEY_CHEESECAKE_ITEM.get()))
//				.addCriterion("chocolate_cheesecake",
//						InventoryChangeTrigger.TriggerInstance
//								.hasItems(ExtraDelightItems.CHOCOLATE_CHEESECAKE_ITEM.get()))
//				.addCriterion("pumpkin_cheesecake",
//						InventoryChangeTrigger.TriggerInstance
//								.hasItems(ExtraDelightItems.PUMPKIN_CHEESECAKE_ITEM.get()))
//				.addCriterion("glow_berry_cheesecake",
//						InventoryChangeTrigger.TriggerInstance
//								.hasItems(ExtraDelightItems.GLOW_BERRY_CHEESECAKE_ITEM.get()))
//				.addCriterion("apple_cheesecake",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.APPLE_CHEESECAKE_ITEM.get()))
//				.addCriterion("quiche", InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.QUICHE.get()))
//				.addCriterion("salisbury_steak",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.SALISBURY_STEAK.get()))
//				.addCriterion("mashed_potatoes_with_gravy",
//						InventoryChangeTrigger.TriggerInstance
//								.hasItems(ExtraDelightItems.MASHED_POTATO_GRAVY_FEAST_ITEM.get()))
//				.addCriterion("pot_of_beef_stew",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.BEEF_STEW_FEAST.get()))
//				.addCriterion("pot_of_pork_stew",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.PORK_STEW_FEAST.get()))
//				.addCriterion("pot_of_mutton_stew",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.LAMB_STEW_FEAST.get()))
//				.addCriterion("pot_of_rabbit_stew",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.RABBIT_STEW_FEAST.get()))
//				.addCriterion("pot_of_chicken_stew",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CHICKEN_STEW_FEAST.get()))
//				.addCriterion("pot_of_fish_stew",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FISH_STEW_FEAST.get()))
//				.addCriterion("pot_of_curry",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CURRY.get()))
//				.addCriterion("meat_loaf",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.MEAT_LOAF.get()))
//				.addCriterion("hash", InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.HASH.get()))
//				.addCriterion("meat_pie",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.MEAT_PIE_BLOCK_ITEM.get()))
//				.addCriterion("stirfry",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.STIRFRY.get()))
//				.addCriterion("pot_of_mac_and_cheese",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.MACARONI_CHEESE_FEAST.get()))
//				.addCriterion("pan_of_lasagna",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.LASAGNA_FEAST.get()))
//				.addCriterion("hotdish_dinner",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.HOTDISH_FEAST.get()))
//				.addCriterion("chef_salad_feast",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.SALAD_FEAST_ITEM.get()))
//				.addCriterion("caramel_cheesecake",
//						InventoryChangeTrigger.TriggerInstance
//								.hasItems(ExtraDelightItems.CARAMEL_CHEESECAKE_ITEM.get()))
//				.addCriterion("cornbread",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CORNBREAD.get()))
//				.addCriterion("corn_pudding",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CORN_PUDDING.get()))
//				.addCriterion("pumpkin_pie",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.PUMPKIN_PIE_ITEM.get()))
//				.addCriterion("pumpkin_roll",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.PUMPKIN_ROLL.get()))
//				.addCriterion("apple_crisp",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.APPLE_CRISP.get()))
//				.addCriterion("stuffing",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.STUFFING.get()))
//				.addCriterion("potatoes_au_gratin",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.POTATO_AU_GRATIN_FEAST.get()))
//				.addCriterion("cinnamon_rolls",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CINNAMON_ROLLS_FEAST.get()))
//				.addCriterion("monkey_bread",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.MONKEY_BREAD.get()))
//				.addCriterion("coffee_cake",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.COFFEE_CAKE_FEAST.get()))
//				.addCriterion("charcuterie_board",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CHARCUTERIE_BOARD.get()))
//				.addCriterion("christmas_pudding",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CHRISTMAS_PUDDING.get()))
//				.addCriterion("punch", InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.PUNCH.get()))
//				.addCriterion("milk_tart",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.MILK_TART_FEAST.get()))
//				.addCriterion("brownies",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.BROWNIES_BLOCK.get()))
//				.addCriterion("blondies",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.BLONDIES_BLOCK.get()))
//				.addCriterion("chocolate_cake",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CHOCOLATE_CAKE.get()))
//				.addCriterion("fudge",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FUDGE_BLOCK.get()))
//				.addCriterion("sticky_toffee_pudding",
//						InventoryChangeTrigger.TriggerInstance
//								.hasItems(ExtraDelightItems.STICKY_TOFFEE_PUDDING_BLOCK.get()))
//				.addCriterion("puffed_rice_treats",
//						InventoryChangeTrigger.TriggerInstance
//								.hasItems(ExtraDelightItems.CRISP_RICE_TREATS_BLOCK.get()))
//				.addCriterion("scotcharoos",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.SCOTCHAROO_BLOCK.get()))
//				.addCriterion("black_forest_trifle",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.BLACK_FOREST_TRIFLE.get()))
//				.addCriterion("dark_chocolate_fondue",
//						InventoryChangeTrigger.TriggerInstance
//								.hasItems(ExtraDelightItems.DARK_CHOCOLATE_FONDUE_BLOCK.get()))
//				.addCriterion("milk_chocolate_fondue",
//						InventoryChangeTrigger.TriggerInstance
//								.hasItems(ExtraDelightItems.MILK_CHOCOLATE_FONDUE_BLOCK.get()))
//				.addCriterion("white_chocolate_fondue",
//						InventoryChangeTrigger.TriggerInstance
//								.hasItems(ExtraDelightItems.WHITE_CHOCOLATE_FONDUE_BLOCK.get()))
//				.addCriterion("stuffed_apples",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.STUFFED_APPLES_FEAST.get()))
//				.addCriterion("tarte",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.TARTE_TATIN_IN_PAN.get()))
			for (Entry<String, DeferredItem<Item>> entry : FEASTS.entrySet()) {
				feastsBuilder.addCriterion(entry.getKey(),
						InventoryChangeTrigger.TriggerInstance.hasItems(entry.getValue()));
			}
			AdvancementHolder feasts = feastsBuilder.save(consumer, ExtraDelight.MOD_ID + ":feasts");
		}

		if (!MEALS.isEmpty()) {
			Builder mealsBuilder = Advancement.Builder.advancement()
					.display(ExtraDelightItems.RICEBALL_FILLED.get(),
							Component.translatable(ExtraDelight.MOD_ID + ".advancement.meals.name"),
							Component.translatable(ExtraDelight.MOD_ID + ".advancement.meals.desc"), null,
							AdvancementType.CHALLENGE, true, true, false)
					.parent(food).requirements(AdvancementRequirements.Strategy.AND);
//				.addCriterion("seaweed crisps",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.SEAWEED_CRISPS.get()))
//				.addCriterion("seaweed salad",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.SEAWEED_SALAD.get()))
//				.addCriterion("scrambled eggs",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.SCRAMBLED_EGGS.get()))
//				.addCriterion("omelette",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.OMELETTE.get()))
//				.addCriterion("slice of quiche",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.QUICHE_SLICE.get()))
//				.addCriterion("egg in a basket",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.EGG_BASKET.get()))
//				.addCriterion("egg salad",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.EGG_SALAD.get()))
//				.addCriterion("jam on bread",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.JAM_TOAST.get()))
//				.addCriterion("glowing jam on bread",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.GLOW_JAM_TOAST.get()))
//				.addCriterion("golden jam on bread",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.GOLDEN_JAM_TOAST.get()))
//				.addCriterion("hashbrowns",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.HASHBROWNS.get()))
//				.addCriterion("french fries",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FRENCH_FRIES.get()))
//				.addCriterion("roasted carrot",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.ROASTED_CARROT.get()))
//				.addCriterion("glazed carrot",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.GLAZED_CARROT.get()))
//				.addCriterion("carrot salad",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CARROT_SALAD.get()))
//				.addCriterion("roast apple",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.ROASTED_APPLE.get()))
//				.addCriterion("potato soup",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.POTATO_SOUP.get()))
//				.addCriterion("tomato soup",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.TOMATO_SOUP.get()))
//				.addCriterion("fish soup",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FISH_SOUP.get()))
//				.addCriterion("carrot soup",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CARROT_SOUP.get()))
//				.addCriterion("egg salad sandwich",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.EGG_SALAD_SANDWICH.get()))
//				.addCriterion("plate of salisbury steak",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.SALISBURY_STEAK.get()))
//				.addCriterion("bowl of mashed potatoes with gravy",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.MASHED_POTATO_GRAVY.get()))
//				.addCriterion("pork stew",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.PORK_STEW.get()))
//				.addCriterion("mutton stew",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.LAMB_STEW.get()))
//				.addCriterion("chicken stew",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CHICKEN_STEW.get()))
//				.addCriterion("curry", InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CURRY.get()))
//				.addCriterion("beef stew with rice",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.BEEF_STEW_RICE.get()))
//				.addCriterion("pork stew with rice",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.PORK_STEW_RICE.get()))
//				.addCriterion("mutton stew with rice",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.LAMB_STEW_RICE.get()))
//				.addCriterion("rabbit stew with rice",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.RABBIT_STEW_RICE.get()))
//				.addCriterion("chicken stew with rice",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CHICKEN_STEW_RICE.get()))
//				.addCriterion("fish stew with rice",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FISH_STEW_RICE.get()))
//				.addCriterion("curry rice",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CURRY_RICE.get()))
//				.addCriterion("fried fish",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FRIED_FISH.get()))
//				.addCriterion("chicken fried steak",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CHICKEN_FRIED_STEAK.get()))
//				.addCriterion("pork tenderloin",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.PORK_TENDERLOIN.get()))
//				.addCriterion("tenderloin sandwich",
//						InventoryChangeTrigger.TriggerInstance
//								.hasItems(ExtraDelightItems.PORK_TENDERLOIN_SANDWICH.get()))
//				.addCriterion("fried chicken",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FRIED_CHICKEN.get()))
//				.addCriterion("cheese sandwich",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CHEESE_SANDWICH.get()))
//				.addCriterion("grilled cheese",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.GRILLED_CHEESE.get()))
//				.addCriterion("bowl of hash",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.HASH.get()))
//				.addCriterion("plate of meat loaf",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.MEAT_LOAF.get()))
//				.addCriterion("meat loaf sandwich",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.MEAT_LOAF_SANDWICH.get()))
//				.addCriterion("slice of meat pie",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.MEAT_PIE_SLICE.get()))
//				.addCriterion("bowl of stirfry",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.STIRFRY.get()))
//				.addCriterion("mac and cheese",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.MACARONI_CHEESE.get()))
//				.addCriterion("lasagna",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.LASAGNA.get()))
//				.addCriterion("hotdish",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.HOTDISH.get()))
//				.addCriterion("furikake rice",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FURIKAKE_RICE.get()))
//				.addCriterion("fish cakes",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FISH_CAKES.get()))
//				.addCriterion("fish n' chips",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FISH_AND_CHIPS.get()))
//				.addCriterion("fried mushrooms",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FRIED_MUSHROOMS.get()))
//				.addCriterion("mushroom risotto",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.MUSHROOM_RISOTTO.get()))
//				.addCriterion("stuffed mushrooms",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.STUFFED_MUSHROOMS.get()))
//				.addCriterion("mushroom and swiss burger",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.MUSHROOM_BURGER.get()))
//				.addCriterion("bacon egg sandwich",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.BACON_EGG_SANDWICH.get()))
//				.addCriterion("bacon egg and cheese sandwich",
//						InventoryChangeTrigger.TriggerInstance
//								.hasItems(ExtraDelightItems.BACON_EGG_CHEESE_SANDWICH.get()))
//				.addCriterion("buttered toast",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.BUTTERED_TOAST.get()))
//				.addCriterion("chef salad",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.SALAD.get()))
//				.addCriterion("tomato pasta",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.PASTA_TOMATO.get()))
//				.addCriterion("alfredo pasta",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.PASTA_ALFREDO.get()))
//				.addCriterion("chicken alfredo pasta",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CHICKEN_ALFREDO.get()))
//				.addCriterion("chicken parmesan",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CHICKEN_PARM.get()))
//				.addCriterion("cheeseburger",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CHEESEBURGER.get()))
//				.addCriterion("bacon cheeseburger",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.BACON_CHEESEBURGER.get()))
//				.addCriterion("riceball",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.RICEBALL.get()))
//				.addCriterion("filled riceball",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.RICEBALL_FILLED.get()))
//				.addCriterion("fish salad",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FISH_SALAD.get()))
//				.addCriterion("fish salad sandwich",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FISH_SALAD_SANDWICH.get()))
//				.addCriterion("buttered pasta",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.BUTTERED_PASTA.get()))
//				.addCriterion("cooked cactus paddle",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.COOKED_CACTUS.get()))
//				.addCriterion("cactus and eggs",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CACTUS_EGGS.get()))
//				.addCriterion("cactus soup",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CACTUS_SOUP.get()))
//				.addCriterion("cactus salad",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CACTUS_SALAD.get()))
//				.addCriterion("stuffed cactus",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.STUFFED_CACTUS.get()))
//				.addCriterion("corn chowder",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CORN_CHOWDER.get()))
//				.addCriterion("creamed corn",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CREAM_CORN.get()))
//				.addCriterion("corn fritters",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CORN_FRITTERS.get()))
//				.addCriterion("grilled corn on the cob",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.GRILLED_CORN_ON_COB.get()))
//				.addCriterion("stewed apples",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.STEWED_APPLES.get()))
//				.addCriterion("apple fritters",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.APPLE_FRITTERS.get()))
//				.addCriterion("slice of cornbread",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CORNBREAD.get()))
//				.addCriterion("plate of corn pudding",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CORN_PUDDING.get()))
//				.addCriterion("bowl of stuffing",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.STUFFING.get()))
//				.addCriterion("plate of potatoes au gratin",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.POTATO_AU_GRATIN.get()))
//				.addCriterion("congee", InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CONGEE.get()))
//				.addCriterion("lugaw", InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.LUGAW.get()))
//				.addCriterion("beet mint salad",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.BEET_MINT_SALAD.get()))
//				.addCriterion("croque monsieur",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CROQUE_MONSIEUR.get()))
//				.addCriterion("croque madam",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CROQUE_MADAME.get()))
//				.addCriterion("plate of charcuterie",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CHARCUTERIE_BOARD.get()))
//				.addCriterion("bowl of puffed rice",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CRISP_RICE_CEREAL.get()))
//				.addCriterion("bowl of corn flakes",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CORN_FLAKES_CEREAL.get()))
//				.addCriterion("fluffer nutter",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FLUFFER_NUTTER.get()))
//				.addCriterion("pbj",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.PEANUT_BUTTER_JELLY.get()))
//				.addCriterion("apple_slaw",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.APPLE_SLAW.get()))
//				.addCriterion("mulligatawny_soup",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.MULLIGATAWNY_SOUP.get()))
			for (Entry<String, DeferredItem<Item>> entry : MEALS.entrySet()) {
				mealsBuilder.addCriterion(entry.getKey(),
						InventoryChangeTrigger.TriggerInstance.hasItems(entry.getValue()));
			}
			AdvancementHolder meals = mealsBuilder.save(consumer, ExtraDelight.MOD_ID + ":meals");
		}

		if (!DESSERTS.isEmpty()) {
			Builder dessertBuilder = Advancement.Builder.advancement()
					.display(ExtraDelightItems.CHRISTMAS_PUDDING.get(),
							Component.translatable(ExtraDelight.MOD_ID + ".advancement.desert.name"),
							Component.translatable(ExtraDelight.MOD_ID + ".advancement.desert.desc"), null,
							AdvancementType.CHALLENGE, true, true, false)
					.parent(food).requirements(AdvancementRequirements.Strategy.AND);
//				.addCriterion("sweet_berry_custard",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.SWEET_BERRY_CUSTARD.get()))
//				.addCriterion("chocolate_custard",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CHOCOLATE_CUSTARD.get()))
//				.addCriterion("pumpkin_custard",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.PUMPKIN_CUSTARD.get()))
//				.addCriterion("honey_custard",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.HONEY_CUSTARD.get()))
//				.addCriterion("apple_custard",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.APPLE_CUSTARD.get()))
//				.addCriterion("slice_of_sweet_berry_pie",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.SWEET_BERRY_PIE_SLICE.get()))
//				.addCriterion("slice_of_glow_berry_pie",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.GLOW_BERRY_PIE_SLICE.get()))
//				.addCriterion("slice_of_cheesecake",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CHEESECAKE_SLICE.get()))
//				.addCriterion("slice_of_honey_cheesecake",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.HONEY_CHEESECAKE_SLICE.get()))
//				.addCriterion("slice_of_chocolate_cheesecake",
//						InventoryChangeTrigger.TriggerInstance
//								.hasItems(ExtraDelightItems.CHOCOLATE_CHEESECAKE_SLICE.get()))
//				.addCriterion("slice_of_pumpkin_cheesecake",
//						InventoryChangeTrigger.TriggerInstance
//								.hasItems(ExtraDelightItems.PUMPKIN_CHEESECAKE_SLICE.get()))
//				.addCriterion("slice_of_glow_berry_cheesecake",
//						InventoryChangeTrigger.TriggerInstance
//								.hasItems(ExtraDelightItems.GLOW_BERRY_CHEESECAKE_SLICE.get()))
//				.addCriterion("slice_of_apple_cheesecake",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.APPLE_CHEESECAKE_SLICE.get()))
//				.addCriterion("glowpop",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.GLOW_BERRY_POPSICLE.get()))
//				.addCriterion("sweet_berry_popsicle",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.SWEET_BERRY_POPSICLE.get()))
//				.addCriterion("fudgsicle",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FUDGE_POPSICLE.get()))
//				.addCriterion("honey_cream_popsicle",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.HONEY_POPSICLE.get()))
//				.addCriterion("apple_popsicle",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.APPLE_POPSICLE.get()))
//				.addCriterion("candy_apple",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CANDY_APPLE.get()))
//				.addCriterion("caramel_apple",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CARAMEL_APPLE.get()))
//				.addCriterion("candy_golden_apple",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CANDY_GOLDEN_APPLE.get()))
//				.addCriterion("caramel_golden_apple",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CARAMEL_GOLDEN_APPLE.get()))
//				.addCriterion("caramel_custard",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CARAMEL_CUSTARD.get()))
//				.addCriterion("caramel_pop",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CARAMEL_POPSICLE.get()))
//				.addCriterion("slice_of_caramel_cheesecake",
//						InventoryChangeTrigger.TriggerInstance
//								.hasItems(ExtraDelightItems.CARAMEL_CHEESECAKE_SLICE.get()))
//				.addCriterion("slice_of_pumpkin_pie",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.PUMPKIN_PIE_SLICE.get()))
//				.addCriterion("slice_of_pumpkin_roll",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.PUMPKIN_ROLL.get()))
//				.addCriterion("bowl_of_apple_crisp",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.APPLE_CRISP.get()))
//				.addCriterion("ice_cream",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.ICE_CREAM.get()))
//				.addCriterion("chocolate_ice_cream",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CHOCOLATE_ICE_CREAM.get()))
//				.addCriterion("glow_berry_ice_cream",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.GLOW_BERRY_ICE_CREAM.get()))
//				.addCriterion("sweet_berry_ice_cream",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.SWEET_BERRY_ICE_CREAM.get()))
//				.addCriterion("pumpkin_ice_cream",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.PUMPKIN_ICE_CREAM.get()))
//				.addCriterion("honey_ice_cream",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.HONEY_ICE_CREAM.get()))
//				.addCriterion("apple_ice_cream",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.APPLE_ICE_CREAM.get()))
//				.addCriterion("cookie_dough_ice_cream",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.COOKIE_DOUGH_ICE_CREAM.get()))
//				.addCriterion("mint_chip_ice_cream",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.MINT_CHIP_ICE_CREAM.get()))
//				.addCriterion("french_toast",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FRENCH_TOAST.get()))
//				.addCriterion("rice_pudding",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.RICE_PUDDING.get()))
//				.addCriterion("ginger_muffin",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.MUFFIN_GINGER.get()))
//				.addCriterion("cinnamon_muffin",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.MUFFIN_CINNAMON.get()))
//				.addCriterion("sweet_berry_muffin",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.MUFFIN_SWEET_BERRY.get()))
//				.addCriterion("apple_muffin",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.MUFFIN_APPLE.get()))
//				.addCriterion("fruit_bread",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FRUIT_BREAD.get()))
//				.addCriterion("cinnamon_swirl_creampop",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CINNAMON_POPSICLE.get()))
//				.addCriterion("cinnamon_roll",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CINNAMON_ROLL.get()))
//				.addCriterion("plate_of_monkey_bread",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.MONKEY_BREAD.get()))
//				.addCriterion("slice_of_coffee_cake",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.COFFEE_CAKE_SLICE.get()))
//				.addCriterion("slice_of_christmas_pudding",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CHRISTMAS_PUDDING.get()))
//				.addCriterion("slice_of_milk_tart",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.MILK_TART_SLICE.get()))
//				.addCriterion("lava_cake",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.LAVA_CAKE.get()))
//				.addCriterion("coffee_jelly",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.COFFEE_JELLY.get()))
//				.addCriterion("s'more", InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.SMORE.get()))
//				.addCriterion("dirt_cake",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.DIRT_CAKE.get()))
//				.addCriterion("brownie",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.BROWNIE.get()))
//				.addCriterion("blondie",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.BLONDIE.get()))
//				.addCriterion("slice_of_chocolate_cake",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CHOCOLATE_CAKE.get()))
//				.addCriterion("bowl_of_sticky_toffee_pudding",
//						InventoryChangeTrigger.TriggerInstance
//								.hasItems(ExtraDelightItems.STICKY_TOFFEE_PUDDING_SLICE.get()))
//				.addCriterion("puffed_rice_treat",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CRISP_RICE_TREAT.get()))
//				.addCriterion("scotcharoo",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.SCOTCHAROO.get()))
//				.addCriterion("bowl_of_black_forest_trifle",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.BLACK_FOREST_TRIFLE.get()))
//				.addCriterion("ice_cream_sundae",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.ICE_CREAM_SUNDAE.get()))
//				.addCriterion("white_jelly",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.JELLY_WHITE.get()))
//				.addCriterion("light_gray_jelly",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.JELLY_LIGHT_GREY.get()))
//				.addCriterion("gray_jelly",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.JELLY_GREY.get()))
//				.addCriterion("black_jelly",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.JELLY_BLACK.get()))
//				.addCriterion("brown_jelly",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.JELLY_BROWN.get()))
//				.addCriterion("red_jelly",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.JELLY_RED.get()))
//				.addCriterion("orange_jelly",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.JELLY_ORANGE.get()))
//				.addCriterion("yellow_jelly",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.JELLY_YELLOW.get()))
//				.addCriterion("lime_jelly",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.JELLY_LIME.get()))
//				.addCriterion("green_jelly",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.JELLY_GREEN.get()))
//				.addCriterion("cyan_jelly",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.JELLY_CYAN.get()))
//				.addCriterion("light_blue_jelly",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.JELLY_LIGHT_BLUE.get()))
//				.addCriterion("blue_jelly",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.JELLY_BLUE.get()))
//				.addCriterion("purple_jelly",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.JELLY_PURPLE.get()))
//				.addCriterion("magenta_jelly",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.JELLY_MAGENTA.get()))
//				.addCriterion("pink_jelly",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.JELLY_PINK.get()))
//				.addCriterion("rombosse",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.ROMBOSSE.get()))
//				.addCriterion("stuffed_apple",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.STUFFED_APPLE.get()))
//				.addCriterion("stuffed_apple_ice_cream",
//						InventoryChangeTrigger.TriggerInstance
//								.hasItems(ExtraDelightItems.STUFFED_APPLE_ICE_CREAM.get()))
//				.addCriterion("tarte_tatin_slice",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.TARTE_TATIN_SLICE.get()))
			for (Entry<String, DeferredItem<Item>> entry : DESSERTS.entrySet()) {
				dessertBuilder.addCriterion(entry.getKey(),
						InventoryChangeTrigger.TriggerInstance.hasItems(entry.getValue()));
			}
			AdvancementHolder desserts = dessertBuilder.save(consumer, ExtraDelight.MOD_ID + ":dessert");
		}

		if (!INGREDIENTS.isEmpty()) {
			Builder ingredientsBuilder = Advancement.Builder.advancement()
					.display(ExtraDelightItems.GRATED_CARROT.get(),
							Component.translatable(ExtraDelight.MOD_ID + ".advancement.ingredients.name"),
							Component.translatable(ExtraDelight.MOD_ID + ".advancement.ingredients.desc"), null,
							AdvancementType.CHALLENGE, true, true, false)
					.parent(food).requirements(AdvancementRequirements.Strategy.AND);
//				.addCriterion("yeast", InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.YEAST.get()))
//				.addCriterion("vinegar",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.VINEGAR.get()))
//				.addCriterion("flour", InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FLOUR.get()))
//				.addCriterion("cooking_oil",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.COOKING_OIL.get()))
//				.addCriterion("gravy", InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.GRAVY.get()))
//				.addCriterion("sliced_onion",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.SLICED_ONION.get()))
//				.addCriterion("sliced_tomato",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.SLICED_TOMATO.get()))
//				.addCriterion("agar_agar_powder",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.AGAR_AGAR.get()))
//				.addCriterion("whipped_cream",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.WHIPPED_CREAM.get()))
//				.addCriterion("egg_mix",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.EGG_MIX.get()))
//				.addCriterion("omelette_mix",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.OMELETTE_MIX.get()))
//				.addCriterion("bbq_sauce",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.BBQ_SAUCE.get()))
//				.addCriterion("ketchup",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.KETCHUP.get()))
//				.addCriterion("mayo", InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.MAYO.get()))
//				.addCriterion("furikake",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FURIKAKE.get()))
//				.addCriterion("jam", InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.JAM.get()))
//				.addCriterion("glow_berry_jam",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.GLOW_BERRY_JAM.get()))
//				.addCriterion("golden_jam",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.GOLDEN_APPLE_JAM.get()))
//				.addCriterion("grated_potato",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.GRATED_POTATO.get()))
//				.addCriterion("sliced_potato",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.SLICED_POTATO.get()))
//				.addCriterion("potato_sticks",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.POTATO_STICKS.get()))
//				.addCriterion("grated_carrot",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.GRATED_CARROT.get()))
//				.addCriterion("apple_slices",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.SLICED_APPLE.get()))
//				.addCriterion("apple_sauce",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.APPLE_SAUCE.get()))
//				.addCriterion("cheese", InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CHEESE.get()))
//				.addCriterion("butter", InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.BUTTER.get()))
//				.addCriterion("slice_of_bread",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.BREAD_SLICE.get()))
//				.addCriterion("breadcrumbs",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.BREAD_CRUMBS.get()))
//				.addCriterion("breading_mise_en_place",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.BREADING_MISANPLAS.get()))
//				.addCriterion("macaroni",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.MACARONI.get()))
//				.addCriterion("lasagna_noodles",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.LASAGNA_NOODLES.get()))
//				.addCriterion("fish_flakes",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FISH_FLAKES.get()))
//				.addCriterion("croutons",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CROUTONS.get()))
//				.addCriterion("alfredo_sauce",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.ALFREDO_SAUCE.get()))
//				.addCriterion("cooked_pasta",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.COOKED_PASTA.get()))
//				.addCriterion("cactus_paddle",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CACTUS.get()))
//				.addCriterion("corn",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CORN_SEEDS.get()))
//				.addCriterion("corn_on_the_cob",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CORN_ON_COB.get()))
//				.addCriterion("corn_silk",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CORN_SILK.get()))
//				.addCriterion("cornmeal",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CORN_MEAL.get()))
//				.addCriterion("cooked_corn",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.COOKED_CORN.get()))
//				.addCriterion("caramel_sauce",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CARAMEL_SAUCE.get()))
//				.addCriterion("ground_cinnamon",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.GROUND_CINNAMON.get()))
//				.addCriterion("gingerbread_cookie_dough",
//						InventoryChangeTrigger.TriggerInstance
//								.hasItems(ExtraDelightItems.GINGERBREAD_COOKIE_DOUGH.get()))
//				.addCriterion("sugar_cookie_dough",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.SUGAR_COOKIE_DOUGH.get()))
//				.addCriterion("pumpkin_cookie_dough",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.PUMPKIN_COOKIE_DOUGH.get()))
//				.addCriterion("glow_berry_cookie_dough",
//						InventoryChangeTrigger.TriggerInstance
//								.hasItems(ExtraDelightItems.GLOW_BERRY_COOKIE_DOUGH.get()))
//				.addCriterion("apple_cinnamon_cookie_dough",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.APPLE_COOKIE_DOUGH.get()))
//				.addCriterion("honey_cookie_dough",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.HONEY_COOKIE_DOUGH.get()))
//				.addCriterion("chocolate_chip_cookie_dough",
//						InventoryChangeTrigger.TriggerInstance
//								.hasItems(ExtraDelightItems.CHOCOLATE_CHIP_COOKIE_DOUGH.get()))
//				.addCriterion("mint", InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.MINT.get()))
//				.addCriterion("sliced_ginger",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.SLICED_GINGER.get()))
//				.addCriterion("grated_ginger",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.GRATED_GINGER.get()))
//				.addCriterion("dried_fruit",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.DRIED_FRUIT.get()))
//				.addCriterion("pickled_ginger",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.PICKLED_GINGER.get()))
//				.addCriterion("mint_jelly",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.MINT_JELLY.get()))
//				.addCriterion("cocoa_solids",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.COCOA_SOLIDS.get()))
//				.addCriterion("white_chocolate_chips",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.WHITE_CHOCOLATE_CHIPS.get()))
//				.addCriterion("milk_chocolate_chips",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.MILK_CHOCOLATE_CHIPS.get()))
//				.addCriterion("dark_chocolate_chips",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.DARK_CHOCOLATE_CHIPS.get()))
//				.addCriterion("chili_powder",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CHILI_POWDER.get()))
//				.addCriterion("puffed_rice",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CRISP_RICE.get()))
//				.addCriterion("corn_flakes",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CORN_FLAKES.get()))
//				.addCriterion("peanuts",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.PEANUTS.get()))
//				.addCriterion("roasted_peanuts",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.ROASTED_PEANUTS.get()))
//				.addCriterion("hazelnuts",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.HAZELNUTS.get()))
//				.addCriterion("roasted_hazelnuts",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.ROASTED_HAZELNUTS.get()))
//				.addCriterion("mallow_root_powder",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.MALLOW_POWDER.get()))
//				.addCriterion("ground_coffee",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.GROUND_COFFEE.get()))
//				.addCriterion("cocoa_butter",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.COCOA_BUTTER_BOTTLE.get()))
//				.addCriterion("liquid_white_chocolate",
//						InventoryChangeTrigger.TriggerInstance
//								.hasItems(ExtraDelightItems.WHITE_CHOCOLATE_SYRUP_BOTTLE.get()))
//				.addCriterion("liquid_dark_chocolate",
//						InventoryChangeTrigger.TriggerInstance
//								.hasItems(ExtraDelightItems.DARK_CHOCOLATE_SYRUP_BOTTLE.get()))
//				.addCriterion("liquid_milk_chocolate",
//						InventoryChangeTrigger.TriggerInstance
//								.hasItems(ExtraDelightItems.MILK_CHOCOLATE_SYRUP_BOTTLE.get()))
//				.addCriterion("nut_butter",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.PEANUT_BUTTER_BOTTLE.get()))
//				.addCriterion("marshmallow_fluff",
//						InventoryChangeTrigger.TriggerInstance
//								.hasItems(ExtraDelightItems.MARSHMALLOW_FLUFF_BOTTLE.get()))
//				.addCriterion("chocolate_nut_butter_spread",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.HAZELNUT_SPREAD_BOTTLE.get()))
//				.addCriterion("roasted_cocoa_beans",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.ROASTED_COCOA_BEANS.get()))
//				.addCriterion("green_coffee",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.GREEN_COFFEE.get()))
//				.addCriterion("coffee_beans",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.COFFEE_BEANS.get()))
//				.addCriterion("chili", InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CHILI.get()))
//				.addCriterion("white_frosting",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FROSTING_WHITE.get()))
//				.addCriterion("light_gray_frosting",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FROSTING_LIGHT_GRAY.get()))
//				.addCriterion("gray_frosting",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FROSTING_GRAY.get()))
//				.addCriterion("black_frosting",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FROSTING_BLACK.get()))
//				.addCriterion("brown_frosting",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FROSTING_BROWN.get()))
//				.addCriterion("red_frosting",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FROSTING_RED.get()))
//				.addCriterion("orange_frosting",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FROSTING_ORANGE.get()))
//				.addCriterion("yellow_frosting",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FROSTING_YELLOW.get()))
//				.addCriterion("lime_frosting",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FROSTING_LIME.get()))
//				.addCriterion("green_frosting",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FROSTING_GREEN.get()))
//				.addCriterion("cyan_frosting",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FROSTING_CYAN.get()))
//				.addCriterion("light_blue_frosting",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FROSTING_LIGHT_BLUE.get()))
//				.addCriterion("blue_frosting",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FROSTING_BLUE.get()))
//				.addCriterion("purple_frosting",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FROSTING_PURPLE.get()))
//				.addCriterion("magenta_frosting",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FROSTING_MAGENTA.get()))
//				.addCriterion("pink_frosting",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FROSTING_PINK.get()))
			for (Entry<String, DeferredItem<Item>> entry : INGREDIENTS.entrySet()) {
				ingredientsBuilder.addCriterion(entry.getKey(),
						InventoryChangeTrigger.TriggerInstance.hasItems(entry.getValue()));
			}
			AdvancementHolder ingredients = ingredientsBuilder.save(consumer, ExtraDelight.MOD_ID + ":ingredients");
		}

		if (!DRINKS.isEmpty()) {
			Builder drinksBuilder = Advancement.Builder.advancement()
					.display(ExtraDelightItems.SWEET_BERRY_JUICE.get(),
							Component.translatable(ExtraDelight.MOD_ID + ".advancement.drinks.name"),
							Component.translatable(ExtraDelight.MOD_ID + ".advancement.drinks.desc"), null,
							AdvancementType.CHALLENGE, true, true, false)
					.parent(food).requirements(AdvancementRequirements.Strategy.AND);
//				.addCriterion("glow_berry_juice",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.GLOW_BERRY_JUICE.get()))
//				.addCriterion("sweet_berry_juice",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.SWEET_BERRY_JUICE.get()))
//				.addCriterion("tomato_juice",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.TOMATO_JUICE.get()))
//				.addCriterion("cactus_juice",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CACTUS_JUICE.get()))
//				.addCriterion("tea", InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.TEA.get()))
//				.addCriterion("milkshake",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.MILKSHAKE.get()))
//				.addCriterion("chocolate_milkshake",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CHOCOLATE_MILKSHAKE.get()))
//				.addCriterion("glow_berry_milkshake",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.GLOW_BERRY_MILKSHAKE.get()))
//				.addCriterion("sweet_berry_milkeshake",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.SWEET_BERRY_MILKSHAKE.get()))
//				.addCriterion("pumpkin_milkshake",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.PUMPKIN_MILKSHAKE.get()))
//				.addCriterion("honey_milkshake",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.HONEY_MILKSHAKE.get()))
//				.addCriterion("apple_milkshake",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.APPLE_MILKSHAKE.get()))
//				.addCriterion("cookie_dough_milkshake",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.COOKIE_DOUGH_MILKSHAKE.get()))
//				.addCriterion("mint_chip_milkshake",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.MINT_CHIP_MILKSHAKE.get()))
//				.addCriterion("chocolate_milk",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CHOCOLATE_MILK.get()))
//				.addCriterion("eggnog", InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.EGGNOG.get()))
//				.addCriterion("ginger_beer",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.GINGER_BEER.get()))
//				.addCriterion("horchata",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.HORCHATA.get()))
//				.addCriterion("glass_of_punch",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.PUNCH.get()))
//				.addCriterion("xocolatl",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.XOCOLATL.get()))
//				.addCriterion("gourmet_hot_chocolate",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.GOURMET_HOT_CHOCOLATE.get()))
//				.addCriterion("coffee", InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.COFFEE.get()))
			for (Entry<String, DeferredItem<Item>> entry : DRINKS.entrySet()) {
				drinksBuilder.addCriterion(entry.getKey(),
						InventoryChangeTrigger.TriggerInstance.hasItems(entry.getValue()));
			}
			AdvancementHolder drinks = drinksBuilder.save(consumer, ExtraDelight.MOD_ID + ":drinks");
		}

		if (!CANDY.isEmpty()) {
			Builder candyBuilder = Advancement.Builder.advancement()
					.display(ExtraDelightItems.MINT_CANDY_RED.get(),
							Component.translatable(ExtraDelight.MOD_ID + ".advancement.candy.name"),
							Component.translatable(ExtraDelight.MOD_ID + ".advancement.candy.desc"), null,
							AdvancementType.CHALLENGE, true, true, false)
					.parent(food).requirements(AdvancementRequirements.Strategy.AND);
//				.addCriterion("caramel_candy",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CARAMEL_CANDY.get()))
//				.addCriterion("white_candy",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CANDY_WHITE.get()))
//				.addCriterion("light_gray_candy",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CANDY_LIGHT_GRAY.get()))
//				.addCriterion("gray_candy",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CANDY_GRAY.get()))
//				.addCriterion("black_candy",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CANDY_BLACK.get()))
//				.addCriterion("brown_candy",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CANDY_BROWN.get()))
//				.addCriterion("red_candy",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CANDY_RED.get()))
//				.addCriterion("orange_candy",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CANDY_ORANGE.get()))
//				.addCriterion("yellow_candy",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CANDY_YELLOW.get()))
//				.addCriterion("lime_candy",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CANDY_LIME.get()))
//				.addCriterion("green_candy",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CANDY_GREEN.get()))
//				.addCriterion("cyan_candy",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CANDY_CYAN.get()))
//				.addCriterion("light_blue_candy",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CANDY_LIGHT_BLUE.get()))
//				.addCriterion("blue_candy",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CANDY_BLUE.get()))
//				.addCriterion("purple_candy",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CANDY_PURPLE.get()))
//				.addCriterion("magenta_candy",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CANDY_MAGENTA.get()))
//				.addCriterion("pink_candy",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CANDY_PINK.get()))
//				.addCriterion("spearmint_candy",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.MINT_CANDY_GREEN.get()))
//				.addCriterion("peppermint_candy",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.MINT_CANDY_RED.get()))
//				.addCriterion("wintergeen_candy",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.MINT_CANDY_BLUE.get()))
//				.addCriterion("peppermint_candy_cane",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CANDY_CANE_RED.get()))
//				.addCriterion("spearmint_candy_cane",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CANDY_CANE_GREEN.get()))
//				.addCriterion("wintergreen_candy_cane",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CANDY_CANE_BLUE.get()))
//				.addCriterion("candied_ginger",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CANDIED_GINGER.get()))
//				.addCriterion("white_chocolate_bar",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.WHITE_CHOCOLATE_BAR.get()))
//				.addCriterion("milk_chocolate_bar",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.MILK_CHOCOLATE_BAR.get()))
//				.addCriterion("dark_chocolate_bar",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.DARK_CHOCOLATE_BAR.get()))
//				.addCriterion("white_chocolate_filled_bar",
//						InventoryChangeTrigger.TriggerInstance
//								.hasItems(ExtraDelightItems.WHITE_CHOCOLATE_FILLED_BAR.get()))
//				.addCriterion("milk_chocolate_filled_bar",
//						InventoryChangeTrigger.TriggerInstance
//								.hasItems(ExtraDelightItems.MILK_CHOCOLATE_FILLED_BAR.get()))
//				.addCriterion("white_chocolate_truffle",
//						InventoryChangeTrigger.TriggerInstance
//								.hasItems(ExtraDelightItems.WHITE_CHOCOLATE_TRUFFLE.get()))
//				.addCriterion("milk_chocolate_truffle",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.MILK_CHOCOLATE_TRUFFLE.get()))
//				.addCriterion("dark_chocolate_truffle",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.DARK_CHOCOLATE_TRUFFLE.get()))
//				.addCriterion("marshmallow",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.MARSHMALLOW.get()))
//				.addCriterion("peanut_butter_cup",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.PEANUT_BUTTER_CUP.get()))
//				.addCriterion("mallow_cup",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.MALLOW_CUP.get()))
//				.addCriterion("toffee", InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.TOFFEE.get()))
//				.addCriterion("peppermint_bark",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.PEPPERMINT_BARK.get()))
//				.addCriterion("nougat", InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.NOUGAT.get()))
//				.addCriterion("gummies",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.GUMMIES.get()))
//				.addCriterion("nut_brittle",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.PEANUT_BRITTLE.get()))
//				.addCriterion("butterscotch",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.BUTTERSCOTCH.get()))
//				.addCriterion("piece_of_fudge",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FUDGE_SLICE.get()))
//				.addCriterion("dark_chocolate_dipped_sweet_berry",
//						InventoryChangeTrigger.TriggerInstance
//								.hasItems(ExtraDelightItems.DARK_CHOCOLATE_DIPPED_SWEET_BERRY.get()))
//				.addCriterion("dark_chocolate_dipped_glow_berry",
//						InventoryChangeTrigger.TriggerInstance
//								.hasItems(ExtraDelightItems.DARK_CHOCOLATE_DIPPED_GLOW_BERRY.get()))
//				.addCriterion("dark_chocolate_dipped_apple_slice",
//						InventoryChangeTrigger.TriggerInstance
//								.hasItems(ExtraDelightItems.DARK_CHOCOLATE_DIPPED_APPLE_SLICE.get()))
//				.addCriterion("dark_chocolate_dipped_marshmallow",
//						InventoryChangeTrigger.TriggerInstance
//								.hasItems(ExtraDelightItems.DARK_CHOCOLATE_DIPPED_MARSHMALLOW.get()))
//				.addCriterion("dark_chocolate_dipped_graham_cracker",
//						InventoryChangeTrigger.TriggerInstance
//								.hasItems(ExtraDelightItems.DARK_CHOCOLATE_DIPPED_GRAHAM_CRACKER.get()))
//				.addCriterion("dark_chocolate_dipped_coffee_bean",
//						InventoryChangeTrigger.TriggerInstance
//								.hasItems(ExtraDelightItems.DARK_CHOCOLATE_DIPPED_COFFEE_BEAN.get()))
//				.addCriterion("dark_chocolate_dipped_bacon",
//						InventoryChangeTrigger.TriggerInstance
//								.hasItems(ExtraDelightItems.DARK_CHOCOLATE_DIPPED_BACON.get()))
//				.addCriterion("white_chocolate_dipped_sweet_berry",
//						InventoryChangeTrigger.TriggerInstance
//								.hasItems(ExtraDelightItems.WHITE_CHOCOLATE_DIPPED_SWEET_BERRY.get()))
//				.addCriterion("white_chocolate_dipped_glow_berry",
//						InventoryChangeTrigger.TriggerInstance
//								.hasItems(ExtraDelightItems.WHITE_CHOCOLATE_DIPPED_GLOW_BERRY.get()))
//				.addCriterion("white_chocolate_dipped_apple_slice",
//						InventoryChangeTrigger.TriggerInstance
//								.hasItems(ExtraDelightItems.WHITE_CHOCOLATE_DIPPED_APPLE_SLICE.get()))
//				.addCriterion("white_chocolate_dipped_marshmallow",
//						InventoryChangeTrigger.TriggerInstance
//								.hasItems(ExtraDelightItems.WHITE_CHOCOLATE_DIPPED_MARSHMALLOW.get()))
//				.addCriterion("white_chocolate_dipped_graham_cracker",
//						InventoryChangeTrigger.TriggerInstance
//								.hasItems(ExtraDelightItems.WHITE_CHOCOLATE_DIPPED_GRAHAM_CRACKER.get()))
//				.addCriterion("white_chocolate_dipped_coffee_bean",
//						InventoryChangeTrigger.TriggerInstance
//								.hasItems(ExtraDelightItems.WHITE_CHOCOLATE_DIPPED_COFFEE_BEAN.get()))
//				.addCriterion("white_chocolate_dipped_bacon",
//						InventoryChangeTrigger.TriggerInstance
//								.hasItems(ExtraDelightItems.WHITE_CHOCOLATE_DIPPED_BACON.get()))
//				.addCriterion("milk_chocolate_dipped_sweet_berry",
//						InventoryChangeTrigger.TriggerInstance
//								.hasItems(ExtraDelightItems.MILK_CHOCOLATE_DIPPED_SWEET_BERRY.get()))
//				.addCriterion("milk_chocolate_dipped_glow_berry",
//						InventoryChangeTrigger.TriggerInstance
//								.hasItems(ExtraDelightItems.MILK_CHOCOLATE_DIPPED_GLOW_BERRY.get()))
//				.addCriterion("milk_chocolate_dipped_apple_slice",
//						InventoryChangeTrigger.TriggerInstance
//								.hasItems(ExtraDelightItems.MILK_CHOCOLATE_DIPPED_APPLE_SLICE.get()))
//				.addCriterion("milk_chocolate_dipped_marshmallow",
//						InventoryChangeTrigger.TriggerInstance
//								.hasItems(ExtraDelightItems.MILK_CHOCOLATE_DIPPED_MARSHMALLOW.get()))
//				.addCriterion("milk_chocolate_dipped_graham_cracker",
//						InventoryChangeTrigger.TriggerInstance
//								.hasItems(ExtraDelightItems.MILK_CHOCOLATE_DIPPED_GRAHAM_CRACKER.get()))
//				.addCriterion("milk_chocolate_dipped_coffee_bean",
//						InventoryChangeTrigger.TriggerInstance
//								.hasItems(ExtraDelightItems.MILK_CHOCOLATE_DIPPED_COFFEE_BEAN.get()))
//				.addCriterion("milk_chocolate_dipped_bacon",
//						InventoryChangeTrigger.TriggerInstance
//								.hasItems(ExtraDelightItems.MILK_CHOCOLATE_DIPPED_BACON.get()))

			for (Entry<String, DeferredItem<Item>> entry : CANDY.entrySet()) {
				candyBuilder.addCriterion(entry.getKey(),
						InventoryChangeTrigger.TriggerInstance.hasItems(entry.getValue()));
			}
			AdvancementHolder candy = candyBuilder.save(consumer, ExtraDelight.MOD_ID + ":candy");
		}

		if (!COOKIES.isEmpty()) {
			Builder cookiesBuilder = Advancement.Builder.advancement()
					.display(ExtraDelightItems.GINGERBREAD_COOKIE.get(),
							Component.translatable(ExtraDelight.MOD_ID + ".advancement.cookies.name"),
							Component.translatable(ExtraDelight.MOD_ID + ".advancement.cookies.desc"), null,
							AdvancementType.CHALLENGE, true, true, false)
					.parent(food).requirements(AdvancementRequirements.Strategy.AND);
//				.addCriterion("pumpkin_cookie",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.PUMPKIN_COOKIE.get()))
//				.addCriterion("sugar_cookie",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.SUGAR_COOKIE.get()))
//				.addCriterion("glow_berry_cookie",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.GLOW_BERRY_COOKIE.get()))
//				.addCriterion("apple_cinnamon_cookie",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.APPLE_COOKIE.get()))
//				.addCriterion("gingerbread_cookie",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.GINGERBREAD_COOKIE.get()))
//				.addCriterion("gingerbread_steve",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.GINGERBREAD_STEVE.get()))
//				.addCriterion("gingerbread_alex",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.GINGERBREAD_ALEX.get()))
//				.addCriterion("gingerbread_villager",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.GINGERBREAD_VILLAGER.get()))
//				.addCriterion("gingerbread_creeper",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.GINGERBREAD_CREEPER.get()))
//				.addCriterion("gingerbread_sword",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.GINGERBREAD_SWORD.get()))
//				.addCriterion("gingerbread_pickaxe",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.GINGERBREAD_PICKAXE.get()))
//				.addCriterion("gingerbread_diamond",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.GINGERBREAD_DIAMOND.get()))
//				.addCriterion("gingerbread_emerald",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.GINGERBREAD_EMERALD.get()))
//				.addCriterion("sugar_cookie_steve",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.SUGAR_COOKIE_STEVE.get()))
//				.addCriterion("sugar_cookie_alex",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.SUGAR_COOKIE_ALEX.get()))
//				.addCriterion("sugar_cookie_villager",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.SUGAR_COOKIE_VILLAGER.get()))
//				.addCriterion("sugar_cookie_creeper",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.SUGAR_COOKIE_CREEPER.get()))
//				.addCriterion("sugar_cookie_sword",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.SUGAR_COOKIE_SWORD.get()))
//				.addCriterion("sugar_cookie_pickaxe",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.SUGAR_COOKIE_PICKAXE.get()))
//				.addCriterion("sugar_cookie_diamond",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.SUGAR_COOKIE_DIAMOND.get()))
//				.addCriterion("sugar_cookie_emerald",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.SUGAR_COOKIE_EMERALD.get()))

			for (Entry<String, DeferredItem<Item>> entry : COOKIES.entrySet()) {
				cookiesBuilder.addCriterion(entry.getKey(),
						InventoryChangeTrigger.TriggerInstance.hasItems(entry.getValue()));
			}
			AdvancementHolder cookies = cookiesBuilder.save(consumer, ExtraDelight.MOD_ID + ":cookies");
		}

		if (!BUTCHERCRAFT.isEmpty()) {
			Builder butcherBuilder = Advancement.Builder.advancement()
					.display(ExtraDelightItems.BBQ_RIBS_FEAST_ITEM.get(),
							Component.translatable(ExtraDelight.MOD_ID + ".advancement.butcher.name"),
							Component.translatable(ExtraDelight.MOD_ID + ".advancement.butcher.desc"), null,
							AdvancementType.CHALLENGE, true, true, true)
					.parent(start).requirements(AdvancementRequirements.Strategy.AND);

//				.addCriterion("SAUSAGE_ROLL",
//						InventoryChangeTrigger.TriggerInstance
//								.hasItems(ItemPredicate.Builder.item().of(ExtraDelightItems.SAUSAGE_ROLL).build()))
//				.addCriterion("SOS",
//						InventoryChangeTrigger.TriggerInstance
//								.hasItems(ItemPredicate.Builder.item().of(ExtraDelightItems.SOS).build()))
//				.addCriterion("LIVER_ONIONS",
//						InventoryChangeTrigger.TriggerInstance
//								.hasItems(ItemPredicate.Builder.item().of(ExtraDelightItems.LIVER_ONIONS).build()))
//				.addCriterion("STUFFED_HEART",
//						InventoryChangeTrigger.TriggerInstance
//								.hasItems(ItemPredicate.Builder.item().of(ExtraDelightItems.STUFFED_HEART).build()))
//				.addCriterion("FRIED_BRAINS",
//						InventoryChangeTrigger.TriggerInstance
//								.hasItems(ItemPredicate.Builder.item().of(ExtraDelightItems.FRIED_BRAINS).build()))
//				.addCriterion("OXTAIL_SOUP",
//						InventoryChangeTrigger.TriggerInstance
//								.hasItems(ItemPredicate.Builder.item().of(ExtraDelightItems.OXTAIL_SOUP).build()))
//				.addCriterion("POT_ROAST_FEAST_ITEM",
//						InventoryChangeTrigger.TriggerInstance.hasItems(
//								ItemPredicate.Builder.item().of(ExtraDelightItems.POT_ROAST_FEAST_ITEM).build()))
//				.addCriterion("POT_ROAST",
//						InventoryChangeTrigger.TriggerInstance
//								.hasItems(ItemPredicate.Builder.item().of(ExtraDelightItems.POT_ROAST).build()))
//				.addCriterion("BBQ_RIBS_FEAST_ITEM",
//						InventoryChangeTrigger.TriggerInstance.hasItems(
//								ItemPredicate.Builder.item().of(ExtraDelightItems.BBQ_RIBS_FEAST_ITEM).build()))
//				.addCriterion("BBQ_RIBS",
//						InventoryChangeTrigger.TriggerInstance
//								.hasItems(ItemPredicate.Builder.item().of(ExtraDelightItems.BBQ_RIBS).build()))
//				.addCriterion("PULLED_PORK_FEAST_ITEM",
//						InventoryChangeTrigger.TriggerInstance.hasItems(
//								ItemPredicate.Builder.item().of(ExtraDelightItems.PULLED_PORK_FEAST_ITEM).build()))
//				.addCriterion("PULLED_PORK_SANDWICH",
//						InventoryChangeTrigger.TriggerInstance.hasItems(
//								ItemPredicate.Builder.item().of(ExtraDelightItems.PULLED_PORK_SANDWICH).build()))
//				.addCriterion("RACK_LAMB_FEAST_ITEM",
//						InventoryChangeTrigger.TriggerInstance.hasItems(
//								ItemPredicate.Builder.item().of(ExtraDelightItems.RACK_LAMB_FEAST_ITEM).build()))
//				.addCriterion("RACK_LAMB",
//						InventoryChangeTrigger.TriggerInstance
//								.hasItems(ItemPredicate.Builder.item().of(ExtraDelightItems.RACK_LAMB).build()))
//				.addCriterion("BEEF_WELLINGTON_FEAST_ITEM",
//						InventoryChangeTrigger.TriggerInstance.hasItems(
//								ItemPredicate.Builder.item().of(ExtraDelightItems.BEEF_WELLINGTON_FEAST_ITEM).build()))
//				.addCriterion("BEEF_WELLINGTON",
//						InventoryChangeTrigger.TriggerInstance
//								.hasItems(ItemPredicate.Builder.item().of(ExtraDelightItems.BEEF_WELLINGTON).build()))
//				.addCriterion("HAGGIS_FEAST_ITEM",
//						InventoryChangeTrigger.TriggerInstance
//								.hasItems(ItemPredicate.Builder.item().of(ExtraDelightItems.HAGGIS_FEAST_ITEM).build()))
//				.addCriterion("HAGGIS",
//						InventoryChangeTrigger.TriggerInstance
//								.hasItems(ItemPredicate.Builder.item().of(ExtraDelightItems.HAGGIS).build()))
//				.addCriterion("MINT_LAMB_FEAST",
//						InventoryChangeTrigger.TriggerInstance
//								.hasItems(ItemPredicate.Builder.item().of(ExtraDelightItems.MINT_LAMB_FEAST).build()))
//				.addCriterion("MINT_LAMB",
//						InventoryChangeTrigger.TriggerInstance
//								.hasItems(ItemPredicate.Builder.item().of(ExtraDelightItems.MINT_LAMB).build()))
//				.addCriterion("liquid_blood_chocolate",
//						InventoryChangeTrigger.TriggerInstance
//								.hasItems(ExtraDelightItems.BLOOD_CHOCOLATE_SYRUP_BOTTLE.get()))
//				.addCriterion("BLOOD_CHOCOLATE_BAR",
//						InventoryChangeTrigger.TriggerInstance.hasItems(
//								ItemPredicate.Builder.item().of(ExtraDelightItems.BLOOD_CHOCOLATE_BAR).build()))
//				.addCriterion("BLOOD_CHOCOLATE_CHIPS",
//						InventoryChangeTrigger.TriggerInstance.hasItems(
//								ItemPredicate.Builder.item().of(ExtraDelightItems.BLOOD_CHOCOLATE_CHIPS).build()))
//				.addCriterion("BLOOD_CHOCOLATE_FILLED_BAR",
//						InventoryChangeTrigger.TriggerInstance.hasItems(
//								ItemPredicate.Builder.item().of(ExtraDelightItems.BLOOD_CHOCOLATE_FILLED_BAR).build()))
//				.addCriterion("BLOOD_CHOCOLATE_TRUFFLE",
//						InventoryChangeTrigger.TriggerInstance.hasItems(
//								ItemPredicate.Builder.item().of(ExtraDelightItems.BLOOD_CHOCOLATE_TRUFFLE).build()))
//				.addCriterion("BLOOD_CHOCOLATE_FONDUE_BLOCK",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item()
//								.of(ExtraDelightItems.BLOOD_CHOCOLATE_FONDUE_BLOCK).build()))
//				.addCriterion("BLOOD_CHOCOLATE_DIPPED_SWEET_BERRY",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item()
//								.of(ExtraDelightItems.BLOOD_CHOCOLATE_DIPPED_SWEET_BERRY).build()))
//				.addCriterion("BLOOD_CHOCOLATE_DIPPED_GLOW_BERRY",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item()
//								.of(ExtraDelightItems.BLOOD_CHOCOLATE_DIPPED_GLOW_BERRY).build()))
//				.addCriterion("BLOOD_CHOCOLATE_DIPPED_APPLE_SLICE",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item()
//								.of(ExtraDelightItems.BLOOD_CHOCOLATE_DIPPED_APPLE_SLICE).build()))
//				.addCriterion("BLOOD_CHOCOLATE_DIPPED_MARSHMALLOW",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item()
//								.of(ExtraDelightItems.BLOOD_CHOCOLATE_DIPPED_MARSHMALLOW).build()))
//				.addCriterion("BLOOD_CHOCOLATE_DIPPED_GRAHAM_CRACKER",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item()
//								.of(ExtraDelightItems.BLOOD_CHOCOLATE_DIPPED_GRAHAM_CRACKER).build()))
//				.addCriterion("BLOOD_CHOCOLATE_DIPPED_BACON",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item()
//								.of(ExtraDelightItems.BLOOD_CHOCOLATE_DIPPED_BACON).build()))
//				.addCriterion("BLOOD_CHOCOLATE_DIPPED_COFFEE_BEAN",
//						InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item()
//								.of(ExtraDelightItems.BLOOD_CHOCOLATE_DIPPED_COFFEE_BEAN).build()))
//				.addCriterion("PORK_AND_APPLES_FEAST",
//						InventoryChangeTrigger.TriggerInstance.hasItems(
//								ItemPredicate.Builder.item().of(ExtraDelightItems.PORK_AND_APPLES_FEAST).build()))
//				.addCriterion("PORK_AND_APPLES",
//						InventoryChangeTrigger.TriggerInstance
//								.hasItems(ItemPredicate.Builder.item().of(ExtraDelightItems.PORK_AND_APPLES).build()))
			for (Entry<String, DeferredItem<Item>> entry : BUTCHERCRAFT.entrySet()) {
				butcherBuilder.addCriterion(entry.getKey(),
						InventoryChangeTrigger.TriggerInstance.hasItems(entry.getValue()));
			}
			AdvancementHolder butcher = butcherBuilder.save(consumer, ExtraDelight.MOD_ID + ":butcher");
		}

		AdvancementHolder chiller = Advancement.Builder.advancement()
				.display(ExtraDelightItems.CHILLER.get(),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.chiller.name"),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.chiller.desc"), null,
						AdvancementType.TASK, true, true, false)
				.parent(start)
				.addCriterion("chiller",
						InventoryChangeTrigger.TriggerInstance
								.hasItems(ItemPredicate.Builder.item().of(ExtraDelightItems.CHILLER).build()))
				.save(consumer, ExtraDelight.MOD_ID + ":chiller");

		AdvancementHolder melting_pot = Advancement.Builder.advancement()
				.display(ExtraDelightItems.MELTING_POT.get(),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.melting_pot.name"),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.melting_pot.desc"), null,
						AdvancementType.TASK, true, true, false)
				.parent(start)
				.addCriterion("melting_pot",
						InventoryChangeTrigger.TriggerInstance
								.hasItems(ItemPredicate.Builder.item().of(ExtraDelightItems.MELTING_POT).build()))
				.save(consumer, ExtraDelight.MOD_ID + ":melting_pot");

		AdvancementHolder keg = Advancement.Builder.advancement()
				.display(ExtraDelightItems.KEG.get(),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.keg.name"),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.keg.desc"), null,
						AdvancementType.TASK, true, true, false)
				.parent(start)
				.addCriterion("keg",
						InventoryChangeTrigger.TriggerInstance
								.hasItems(ItemPredicate.Builder.item().of(ExtraDelightItems.KEG).build()))
				.save(consumer, ExtraDelight.MOD_ID + ":keg");

		AdvancementHolder funnel = Advancement.Builder.advancement()
				.display(ExtraDelightItems.FUNNEL.get(),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.funnel.name"),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.funnel.desc"), null,
						AdvancementType.TASK, true, true, false)
				.parent(keg)
				.addCriterion("funnel",
						InventoryChangeTrigger.TriggerInstance
								.hasItems(ItemPredicate.Builder.item().of(ExtraDelightItems.FUNNEL).build()))
				.save(consumer, ExtraDelight.MOD_ID + ":funnel");

		AdvancementHolder chocolate_bar = Advancement.Builder.advancement()
				.display(ExtraDelightItems.MILK_CHOCOLATE_BAR.get(),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.chocolate_bar.name"),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.chocolate_bar.desc"), null,
						AdvancementType.TASK, true, true, false)
				.parent(chiller)
				.addCriterion("chocolate_bar",
						InventoryChangeTrigger.TriggerInstance
								.hasItems(ItemPredicate.Builder.item().of(ExtraDelightTags.CHOCOLATE_BAR).build()))
				.save(consumer, ExtraDelight.MOD_ID + ":chocolate_bar");

		AdvancementHolder fondue = Advancement.Builder.advancement()
				.display(ExtraDelightItems.MILK_CHOCOLATE_FONDUE_BLOCK.get(),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.fondue.name"),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.fondue.desc"), null,
						AdvancementType.TASK, true, true, false)
				.parent(melting_pot)
				.addCriterion("fondue",
						InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item()
								.of(ExtraDelightItems.BLOOD_CHOCOLATE_FONDUE_BLOCK,
										ExtraDelightItems.MILK_CHOCOLATE_FONDUE_BLOCK,
										ExtraDelightItems.DARK_CHOCOLATE_FONDUE_BLOCK,
										ExtraDelightItems.WHITE_CHOCOLATE_FONDUE_BLOCK)
								.build()))
				.save(consumer, ExtraDelight.MOD_ID + ":fondue");

		AdvancementHolder tap = Advancement.Builder.advancement()
				.display(ExtraDelightItems.TAP.get(),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.tap.name"),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.tap.desc"), null,
						AdvancementType.TASK, true, true, false)
				.parent(keg)
				.addCriterion("tap",
						InventoryChangeTrigger.TriggerInstance
								.hasItems(ItemPredicate.Builder.item().of(ExtraDelightItems.TAP).build()))
				.save(consumer, ExtraDelight.MOD_ID + ":tap");

		AdvancementHolder sink = Advancement.Builder.advancement()
				.display(AestheticBlocks.SINK_ITEMS.get(0).get(),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.sink.name"),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.sink.desc"), null,
						AdvancementType.TASK, true, true, false)
				.parent(tap)
				.addCriterion("sink",
						InventoryChangeTrigger.TriggerInstance
								.hasItems(ItemPredicate.Builder.item().of(AestheticBlocks.SINK_ITEMS.get(0)).build()))
				.save(consumer, ExtraDelight.MOD_ID + ":sink");

		AdvancementHolder counter = Advancement.Builder.advancement()
				.display(AestheticBlocks.COUNTER_CABINET_ITEMS.get(0),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.counter.name"),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.counter.desc"), null,
						AdvancementType.TASK, true, true, false)
				.parent(start)
				.addCriterion("counter",
						InventoryChangeTrigger.TriggerInstance.hasItems(
								ItemPredicate.Builder.item().of(AestheticBlocks.COUNTER_CABINET_ITEMS.get(0)).build()))
				.save(consumer, ExtraDelight.MOD_ID + ":counter");

		AdvancementHolder juicer = Advancement.Builder.advancement()
				.display(AestheticBlocks.COUNTER_CABINET_ITEMS.get(0),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.juicer.name"),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.juicer.desc"), null,
						AdvancementType.TASK, true, true, false)
				.parent(start)
				.addCriterion("juicer",
						InventoryChangeTrigger.TriggerInstance
								.hasItems(ItemPredicate.Builder.item().of(ExtraDelightItems.JUICER.get())))
				.save(consumer, ExtraDelight.MOD_ID + ":juicer");
	}

}
