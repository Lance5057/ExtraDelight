package com.lance5057.extradelight.data;

import java.util.function.Consumer;

import javax.annotation.Nonnull;

import org.jetbrains.annotations.NotNull;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.ExtraDelightBlocks;
import com.lance5057.extradelight.ExtraDelightItems;
import com.lance5057.extradelight.ExtraDelightTags;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.DisplayInfo;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.BlockPredicate;
import net.minecraft.advancements.critereon.ConsumeItemTrigger;
import net.minecraft.advancements.critereon.EnterBlockTrigger;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemInteractWithBlockTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.LocationPredicate;
import net.minecraft.advancements.critereon.UsingItemTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.advancements.AdvancementProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import vectorwing.farmersdelight.common.registry.ModItems;

public class Advancements extends AdvancementProvider {
	private final DataGenerator dataGenerator;

	private Advancement start;

	private Advancement grater;

	private Advancement spoon;
	private Advancement mixingbowl;

	private Advancement oven;
	private Advancement trays;

	private Advancement mortar;
	private Advancement grind;

	private Advancement doughshaping;
	private Advancement noodles;

	private Advancement dryingrack;

	private Advancement yeastpot;
	private Advancement vinegarpot;

	private Advancement food;
	private Advancement ingredients;
	private Advancement meals;
	private Advancement feasts;
	private Advancement desert;
	private Advancement badfood;

	private Advancement hellskitchen;

	private Advancement gildedblackstone;
	private Advancement amethyst;

	private Advancement jelly;
	private Advancement jellyall;

	public Advancements(@Nonnull DataGenerator dataGenerator, ExistingFileHelper existingFileHelper) {
		super(dataGenerator, existingFileHelper);
		this.dataGenerator = dataGenerator;
	}

	@Override
	protected void registerAdvancements(@NotNull Consumer<Advancement> consumer,
			@NotNull ExistingFileHelper fileHelper) {
		start = Advancement.Builder.advancement()
				.display(new DisplayInfo(new ItemStack(ExtraDelightItems.WOODEN_SPOON.get()),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.start.name"),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.start.desc"),
						new ResourceLocation("extradelight:textures/block/wallpaper_red.png"), FrameType.TASK, false,
						false, true))
				.addCriterion("start", InventoryChangeTrigger.TriggerInstance.hasItems(new ItemLike[] {}))
				.save(consumer, ExtraDelight.MOD_ID + ":start");

		grater = Advancement.Builder.advancement()
				.display(new DisplayInfo(new ItemStack(ExtraDelightItems.GRATER.get()),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.grater.name"),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.grater.desc"), null, FrameType.TASK,
						true, true, false))
				.parent(start)
				.addCriterion("grater", InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.GRATER.get()))
				.save(consumer, ExtraDelight.MOD_ID + ":grater");

		spoon = Advancement.Builder.advancement()
				.display(new DisplayInfo(new ItemStack(ExtraDelightItems.DIAMOND_SPOON.get()),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.spoon.name"),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.spoon.desc"), null, FrameType.TASK,
						true, true, false))
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
				.requirements(RequirementsStrategy.OR).save(consumer, ExtraDelight.MOD_ID + ":spoon");

		mixingbowl = Advancement.Builder.advancement()
				.display(
						new DisplayInfo(new ItemStack(ExtraDelightItems.MIXING_BOWL.get()),
								Component.translatable(ExtraDelight.MOD_ID + ".advancement.mixingbowl.name"),
								Component.translatable(ExtraDelight.MOD_ID + ".advancement.mixingbowl.desc"), null,
								FrameType.TASK, true, true, false))
				.parent(spoon)
				.addCriterion("mixingbowl",
						ItemInteractWithBlockTrigger.TriggerInstance.itemUsedOnBlock(
								LocationPredicate.Builder.location()
										.setBlock(BlockPredicate.Builder.block()
												.of(ExtraDelightBlocks.MIXING_BOWL.get()).build()),
								ItemPredicate.Builder.item().of(ExtraDelightTags.SPOONS)))
				.save(consumer, ExtraDelight.MOD_ID + ":mixingbowl");

		oven = Advancement.Builder.advancement()
				.display(new DisplayInfo(new ItemStack(ExtraDelightItems.OVEN.get()),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.oven.name"),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.oven.desc"), null, FrameType.TASK,
						true, true, false))
				.parent(start)
				.addCriterion("oven", InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.OVEN.get()))
				.save(consumer, ExtraDelight.MOD_ID + ":oven");

		trays = Advancement.Builder.advancement()
				.display(new DisplayInfo(new ItemStack(ExtraDelightItems.TRAY.get()),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.trays.name"),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.trays.desc"), null, FrameType.TASK,
						true, true, false))
				.parent(oven)
				.addCriterion("tray", InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.TRAY.get()))
				.addCriterion("sheet", InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.SHEET.get()))
				.addCriterion("baking_stone",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.BAKING_STONE.get()))
				.addCriterion("loaf_pan",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.LOAF_PAN.get()))
				.addCriterion("square_pan",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.SQUARE_PAN.get()))
				.addCriterion("round_pan",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.ROUND_PAN.get()))
				.addCriterion("pie_dish",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.PIE_DISH.get()))
				.addCriterion("muffin_tin",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.MUFFIN_TIN.get()))
				.requirements(RequirementsStrategy.AND).save(consumer, ExtraDelight.MOD_ID + ":trays");

		mortar = Advancement.Builder.advancement()
				.display(new DisplayInfo(new ItemStack(ExtraDelightItems.MORTAR_STONE.get()),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.mortar.name"),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.mortar.desc"), null, FrameType.TASK,
						true, true, false))
				.parent(start)
				.addCriterion("mortar",
						InventoryChangeTrigger.TriggerInstance
								.hasItems(ItemPredicate.Builder.item().of(ExtraDelightTags.MORTAR).build()))
				.save(consumer, ExtraDelight.MOD_ID + ":mortar");

		amethyst = Advancement.Builder.advancement()
				.display(new DisplayInfo(new ItemStack(ExtraDelightItems.MORTAR_AMETHYST.get()),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.amethyst.name"),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.amethyst.desc"), null,
						FrameType.CHALLENGE, true, true, true))
				.parent(mortar)
				.addCriterion("amethyst",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.MORTAR_AMETHYST.get()))
				.save(consumer, ExtraDelight.MOD_ID + ":amethyst");

		gildedblackstone = Advancement.Builder.advancement()
				.display(new DisplayInfo(new ItemStack(ExtraDelightItems.MORTAR_GILDED_BLACKSTONE.get()),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.gildedblackstone.name"),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.gildedblackstone.desc"), null,
						FrameType.CHALLENGE, true, true, true))
				.parent(mortar)
				.addCriterion("gildedblackstone",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.MORTAR_AMETHYST.get()))
				.save(consumer, ExtraDelight.MOD_ID + ":gildedblackstone");

		grind = Advancement.Builder.advancement()
				.display(new DisplayInfo(new ItemStack(ExtraDelightItems.PESTLE_ENDSTONE.get()),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.grind.name"),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.grind.desc"), null, FrameType.GOAL,
						true, true, false))
				.parent(mortar)
				.addCriterion("grind",
						ItemInteractWithBlockTrigger.TriggerInstance
								.itemUsedOnBlock(
										LocationPredicate.Builder.location()
												.setBlock(BlockPredicate.Builder.block()
														.of(ExtraDelightTags.MORTAR_BLOCK).build()),
										ItemPredicate.Builder.item().of(ExtraDelightTags.SPOONS)))
				.save(consumer, ExtraDelight.MOD_ID + ":grind");

		doughshaping = Advancement.Builder.advancement()
				.display(new DisplayInfo(new ItemStack(ExtraDelightItems.DOUGH_SHAPING.get()),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.doughshaping.name"),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.doughshaping.desc"), null,
						FrameType.TASK, true, true, false))
				.parent(start)
				.addCriterion("doughshaping",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.DOUGH_SHAPING.get()))
				.save(consumer, ExtraDelight.MOD_ID + ":doughshaping");

		hellskitchen = Advancement.Builder.advancement()
				.display(new DisplayInfo(new ItemStack(ExtraDelightItems.NETHERITE_SPOON.get()),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.hellskitchen.name"),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.hellskitchen.desc"), null,
						FrameType.TASK, true, true, false))
				.parent(spoon)
				.addCriterion("hellskitchen_spoon",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.NETHERITE_SPOON.get()))
				.addCriterion("hellskitchen_knife",
						InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_KNIFE.get()))
				.save(consumer, ExtraDelight.MOD_ID + ":hellskitchen");

		noodles = Advancement.Builder.advancement()
				.display(new DisplayInfo(new ItemStack(ExtraDelightItems.LASAGNA_NOODLES.get()),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.noodles.name"),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.noodles.desc"), null, FrameType.GOAL,
						true, true, false))
				.parent(doughshaping)
				.addCriterion("lasagna_noodles",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.LASAGNA_NOODLES.get()))
				.addCriterion("macaroni_noodles",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.MACARONI.get()))
				.addCriterion("pasta", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.RAW_PASTA.get()))
				.requirements(RequirementsStrategy.OR).save(consumer, ExtraDelight.MOD_ID + ":noodles");

		dryingrack = Advancement.Builder.advancement()
				.display(new DisplayInfo(new ItemStack(ExtraDelightItems.DRYING_RACK.get()),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.dryingrack.name"),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.dryingrack.desc"), null,
						FrameType.TASK, true, true, false))
				.parent(start)
				.addCriterion("dryingrack",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.DRYING_RACK.get()))
				.save(consumer, ExtraDelight.MOD_ID + ":dryingrack");

		yeastpot = Advancement.Builder.advancement()
				.display(new DisplayInfo(new ItemStack(ExtraDelightItems.YEAST_POT.get()),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.yeastpot.name"),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.yeastpot.desc"), null,
						FrameType.TASK, true, true, false))
				.parent(start)
				.addCriterion("yeastpot",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.YEAST_POT.get()))
				.addCriterion("yeast", InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.YEAST.get()))
				.requirements(RequirementsStrategy.AND).save(consumer, ExtraDelight.MOD_ID + ":yeastpot");

		vinegarpot = Advancement.Builder.advancement()
				.display(new DisplayInfo(new ItemStack(ExtraDelightItems.YEAST_POT.get()),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.vinegarpot.name"),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.vinegarpot.desc"), null,
						FrameType.TASK, true, true, false))
				.parent(start)
				.addCriterion("vinegarpot",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.VINEGAR_POT.get()))
				.addCriterion("vinegar",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.VINEGAR.get()))
				.requirements(RequirementsStrategy.AND).save(consumer, ExtraDelight.MOD_ID + ":vinegarpot");

		jelly = Advancement.Builder.advancement()
				.display(new DisplayInfo(new ItemStack(ExtraDelightItems.JELLY_LIME.get()),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.jelly.name"),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.jelly.desc"), null, FrameType.TASK,
						true, true, false))
				.parent(start)
				.addCriterion("jelly",
						InventoryChangeTrigger.TriggerInstance
								.hasItems(ItemPredicate.Builder.item().of(ExtraDelightTags.JELLY).build()))
				.save(consumer, ExtraDelight.MOD_ID + ":jelly");

		jellyall = Advancement.Builder.advancement()
				.display(new DisplayInfo(new ItemStack(ExtraDelightItems.JELLY_MAGENTA.get()),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.jellyall.name"),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.jellyall.desc"), null,
						FrameType.CHALLENGE, true, true, true))
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
				.requirements(RequirementsStrategy.AND).save(consumer, ExtraDelight.MOD_ID + ":jellyall");

		food = Advancement.Builder.advancement()
				.display(new DisplayInfo(new ItemStack(Items.APPLE),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.food.name"),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.food.desc"), null, FrameType.TASK,
						true, true, false))
				.parent(start).addCriterion("food", ConsumeItemTrigger.TriggerInstance.usedItem())
				.save(consumer, ExtraDelight.MOD_ID + ":food");

		badfood = Advancement.Builder.advancement()
				.display(new DisplayInfo(new ItemStack(ExtraDelightItems.BAD_FOOD.get()),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.badfood.name"),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.badfood.desc"), null, FrameType.TASK,
						true, true, false))
				.parent(food)
				.addCriterion("badfood", ConsumeItemTrigger.TriggerInstance.usedItem(ExtraDelightItems.BAD_FOOD.get()))
				.save(consumer, ExtraDelight.MOD_ID + ":badfood");

		feasts = Advancement.Builder.advancement()
				.display(new DisplayInfo(new ItemStack(ExtraDelightItems.BEEF_WELLINGTON_FEAST_ITEM.get()),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.feasts.name"),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.feasts.desc"), null,
						FrameType.CHALLENGE, true, true, false))
				.parent(food)
				.addCriterion("bbq",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.BBQ_RIBS_FEAST_ITEM.get()))
				.addCriterion("beef",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.BEEF_STEW_FEAST.get()))
				.addCriterion("wellington",
						InventoryChangeTrigger.TriggerInstance
								.hasItems(ExtraDelightItems.BEEF_WELLINGTON_FEAST_ITEM.get()))
				.addCriterion("chicken_stew",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CHICKEN_STEW_FEAST.get()))
				.addCriterion("curry",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CURRY_FEAST.get()))
				.addCriterion("fish_stew",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FISH_STEW_FEAST.get()))
				.addCriterion("haggis",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.HAGGIS_FEAST_ITEM.get()))
				.addCriterion("hotdish",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.HOTDISH_FEAST.get()))
				.addCriterion("lamb_stew",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.LAMB_STEW_FEAST.get()))
				.addCriterion("lasagna",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.LASAGNA_FEAST.get()))
				.addCriterion("mac_cheese",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.MACARONI_CHEESE_FEAST.get()))
				.addCriterion("mash_potato",
						InventoryChangeTrigger.TriggerInstance
								.hasItems(ExtraDelightItems.MASHED_POTATO_GRAVY_FEAST_ITEM.get()))
				.addCriterion("meatloaf",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.MEAT_LOAF_FEAST.get()))
				.addCriterion("pork_stew",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.PORK_STEW_FEAST.get()))
				.addCriterion("pot_roast",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.POT_ROAST_FEAST_ITEM.get()))
				.addCriterion("pulled_pork",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.PULLED_PORK_FEAST_ITEM.get()))
				.addCriterion("rabbit_stew",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.RABBIT_STEW_FEAST.get()))
				.addCriterion("rack_lamb",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.RACK_LAMB_FEAST_ITEM.get()))
				.addCriterion("salad",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.SALAD_FEAST_ITEM.get()))
				.addCriterion("salisbury_steak",
						InventoryChangeTrigger.TriggerInstance
								.hasItems(ExtraDelightItems.SALISBURY_STEAK_FEAST_ITEM.get()))
				.addCriterion("quiche", InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.QUICHE.get()))
				.addCriterion("meatpie",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.MEAT_PIE_BLOCK_ITEM.get()))
				.addCriterion("stirfry",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.STIRFRY_FEAST_ITEM.get()))
				.requirements(RequirementsStrategy.AND).save(consumer, ExtraDelight.MOD_ID + ":feasts");

		meals = Advancement.Builder.advancement()
				.display(new DisplayInfo(new ItemStack(ExtraDelightItems.RICEBALL_FILLED.get()),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.meals.name"),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.meals.desc"), null,
						FrameType.CHALLENGE, true, true, false))
				.parent(food)
				.addCriterion("JERKY", InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.JERKY.get()))
				.addCriterion("SCRAMBLED_EGGS",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.SCRAMBLED_EGGS.get()))
				.addCriterion("OMELETTE",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.OMELETTE.get()))
				.addCriterion("QUICHE_SLICE",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.QUICHE_SLICE.get()))
				.addCriterion("COOKED_PASTA",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.COOKED_PASTA.get()))
				.addCriterion("EGG_SALAD",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.EGG_SALAD.get()))
				.addCriterion("JAM_TOAST",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.JAM_TOAST.get()))
				.addCriterion("ROASTED_CARROT",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.ROASTED_CARROT.get()))
				.addCriterion("GLAZED_CARROT",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.GLAZED_CARROT.get()))
				.addCriterion("CARROT_SALAD",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CARROT_SALAD.get()))
				.addCriterion("ROASTED_APPLE",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.ROASTED_APPLE.get()))
				.addCriterion("APPLE_SAUCE",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.APPLE_SAUCE.get()))
				.addCriterion("POTATO_SOUP",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.POTATO_SOUP.get()))
				.addCriterion("TOMATO_SOUP",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.TOMATO_SOUP.get()))
				.addCriterion("FISH_SOUP",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FISH_SOUP.get()))
				.addCriterion("CARROT_SOUP",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CARROT_SOUP.get()))
				.addCriterion("PORK_TENDERLOIN_SANDWICH",
						InventoryChangeTrigger.TriggerInstance
								.hasItems(ExtraDelightItems.PORK_TENDERLOIN_SANDWICH.get()))
				.addCriterion("EGG_SALAD_SANDWICH",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.EGG_SALAD_SANDWICH.get()))
				.addCriterion("CHEESE_SANDWICH",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CHEESE_SANDWICH.get()))
				.addCriterion("MASHED_POTATO_GRAVY",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.MASHED_POTATO_GRAVY.get()))
				.addCriterion("SALISBURY_STEAK",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.SALISBURY_STEAK.get()))
				.addCriterion("BEEF_STEW_RICE",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.BEEF_STEW_RICE.get()))
				.addCriterion("PORK_STEW",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.PORK_STEW.get()))
				.addCriterion("LAMB_STEW",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.LAMB_STEW.get()))
				.addCriterion("SAUSAGE_ROLL",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.SAUSAGE_ROLL.get()))
				.addCriterion("SOS", InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.SOS.get()))
				.addCriterion("LIVER_ONIONS",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.LIVER_ONIONS.get()))
				.addCriterion("FRIED_FISH",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FRIED_FISH.get()))
				.addCriterion("CHICKEN_FRIED_STEAK",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CHICKEN_FRIED_STEAK.get()))
				.addCriterion("PORK_TENDERLOIN",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.PORK_TENDERLOIN.get()))
				.addCriterion("FRIED_CHICKEN",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FRIED_CHICKEN.get()))
				.addCriterion("STUFFED_HEART",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.STUFFED_HEART.get()))
				.addCriterion("FRIED_BRAINS",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FRIED_BRAINS.get()))
				.addCriterion("OXTAIL_SOUP",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.OXTAIL_SOUP.get()))
				.addCriterion("GRILLED_CHEESE",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.GRILLED_CHEESE.get()))
				.addCriterion("HASH", InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.HASH.get()))
				.addCriterion("POT_ROAST",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.POT_ROAST.get()))
				.addCriterion("BBQ_RIBS",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.BBQ_RIBS.get()))
				.addCriterion("MEAT_PIE_SLICE",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.MEAT_PIE_SLICE.get()))
				.addCriterion("PULLED_PORK_SANDWICH",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.PULLED_PORK_SANDWICH.get()))
				.addCriterion("RACK_LAMB",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.RACK_LAMB.get()))
				.addCriterion("STIRFRY",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.STIRFRY.get()))
				.addCriterion("BEEF_WELLINGTON",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.BEEF_WELLINGTON.get()))
				.addCriterion("HAGGIS", InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.HAGGIS.get()))
				.addCriterion("MACARONI_CHEESE",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.MACARONI_CHEESE.get()))
				.addCriterion("LASAGNA",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.LASAGNA.get()))
				.addCriterion("HOTDISH",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.HOTDISH.get()))
				.addCriterion("SEAWEED_CRISPS",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.SEAWEED_CRISPS.get()))
				.addCriterion("SEAWEED_SALAD",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.SEAWEED_SALAD.get()))
				.addCriterion("BUTTERED_PASTA",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.BUTTERED_PASTA.get()))
				.addCriterion("CHICKEN_STEW",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CHICKEN_STEW.get()))
				.addCriterion("CURRY", InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CURRY.get()))
				.addCriterion("FURIKAKE_RICE",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FURIKAKE_RICE.get()))
				.addCriterion("FISH_CAKES",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FISH_CAKES.get()))
				.addCriterion("FISH_AND_CHIPS",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FISH_AND_CHIPS.get()))
				.addCriterion("FRIED_MUSHROOMS",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FRIED_MUSHROOMS.get()))
				.addCriterion("MUSHROOM_RISOTTO",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.MUSHROOM_RISOTTO.get()))
				.addCriterion("STUFFED_MUSHROOMS",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.STUFFED_MUSHROOMS.get()))
				.addCriterion("MUSHROOM_BURGER",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.MUSHROOM_BURGER.get()))
				.addCriterion("MEAT_LOAF_SANDWICH",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.MEAT_LOAF_SANDWICH.get()))
				.addCriterion("MEAT_LOAF",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.MEAT_LOAF.get()))
				.addCriterion("PORK_STEW_RICE",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.PORK_STEW_RICE.get()))
				.addCriterion("LAMB_STEW_RICE",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.LAMB_STEW_RICE.get()))
				.addCriterion("RABBIT_STEW_RICE",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.RABBIT_STEW_RICE.get()))
				.addCriterion("CHICKEN_STEW_RICE",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CHICKEN_STEW_RICE.get()))
				.addCriterion("FISH_STEW_RICE",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FISH_STEW_RICE.get()))
				.addCriterion("CURRY_RICE",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CURRY_RICE.get()))
				.addCriterion("BACON_EGG_CHEESE_SANDWICH",
						InventoryChangeTrigger.TriggerInstance
								.hasItems(ExtraDelightItems.BACON_EGG_CHEESE_SANDWICH.get()))
				.addCriterion("BACON_EGG_SANDWICH",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.BACON_EGG_SANDWICH.get()))
				.addCriterion("BUTTERED_TOAST",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.BUTTERED_TOAST.get()))
				.addCriterion("SALAD", InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.SALAD.get()))
				.addCriterion("PASTA_ALFREDO",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.PASTA_ALFREDO.get()))
				.addCriterion("CHICKEN_ALFREDO",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CHICKEN_ALFREDO.get()))
				.addCriterion("CHICKEN_PARM",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CHICKEN_PARM.get()))
				.addCriterion("PASTA_TOMATO",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.PASTA_TOMATO.get()))
				.addCriterion("CHEESEBURGER",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CHEESEBURGER.get()))
				.addCriterion("BACON_CHEESEBURGER",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.BACON_CHEESEBURGER.get()))
				.addCriterion("RICEBALL",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.RICEBALL.get()))
				.addCriterion("RICEBALL_FILLED",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.RICEBALL_FILLED.get()))
				.addCriterion("FISH_SALAD",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FISH_SALAD.get()))
				.addCriterion("FISH_SALAD_SANDWICH",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FISH_SALAD_SANDWICH.get()))
				.requirements(RequirementsStrategy.AND).save(consumer, ExtraDelight.MOD_ID + ":meals");

		desert = Advancement.Builder.advancement()
				.display(new DisplayInfo(new ItemStack(ExtraDelightItems.GLOW_BERRY_PIE_ITEM.get()),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.desert.name"),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.desert.desc"), null,
						FrameType.CHALLENGE, true, true, true))
				.parent(food)
				.addCriterion("CHOCOLATE_CUSTARD",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CHOCOLATE_CUSTARD.get()))
				.addCriterion("HONEY_CUSTARD",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.HONEY_CUSTARD.get()))
				.addCriterion("PUMPKIN_CUSTARD",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.PUMPKIN_CUSTARD.get()))
				.addCriterion("SWEET_BERRY_CUSTARD",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.SWEET_BERRY_CUSTARD.get()))
				.addCriterion("SWEET_BERRY_PIE_SLICE",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.SWEET_BERRY_PIE_SLICE.get()))
				.addCriterion("CHEESECAKE_SLICE",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CHEESECAKE_SLICE.get()))
				.addCriterion("CHOCOLATE_CHEESECAKE_SLICE",
						InventoryChangeTrigger.TriggerInstance
								.hasItems(ExtraDelightItems.CHOCOLATE_CHEESECAKE_SLICE.get()))
				.addCriterion("GLOW_BERRY_CHEESECAKE_SLICE",
						InventoryChangeTrigger.TriggerInstance
								.hasItems(ExtraDelightItems.GLOW_BERRY_CHEESECAKE_SLICE.get()))
				.addCriterion("GLOW_BERRY_PIE_SLICE",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.GLOW_BERRY_PIE_SLICE.get()))
				.addCriterion("HONEY_CHEESECAKE_SLICE",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.HONEY_CHEESECAKE_SLICE.get()))
				.addCriterion("PUMPKIN_CHEESECAKE_SLICE",
						InventoryChangeTrigger.TriggerInstance
								.hasItems(ExtraDelightItems.PUMPKIN_CHEESECAKE_SLICE.get()))
				.addCriterion("GLOW_BERRY_COOKIE",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.GLOW_BERRY_COOKIE.get()))
				.addCriterion("PUMPKIN_COOKIE",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.PUMPKIN_COOKIE.get()))
				.addCriterion("SUGAR_COOKIE",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.SUGAR_COOKIE.get()))
				.addCriterion("FUDGE_POPSICLE",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FUDGE_POPSICLE.get()))
				.addCriterion("GLOW_BERRY_POPSICLE",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.GLOW_BERRY_POPSICLE.get()))
				.addCriterion("HONEY_POPSICLE",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.HONEY_POPSICLE.get()))
				.addCriterion("SWEET_BERRY_POPSICLE",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.SWEET_BERRY_POPSICLE.get()))
				.requirements(RequirementsStrategy.AND).save(consumer, ExtraDelight.MOD_ID + ":desert");
	}

	@Override
	public String getName() {
		return "Extra Delight Advancements";
	}
}
