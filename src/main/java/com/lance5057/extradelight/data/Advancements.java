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
				.display(new DisplayInfo(new ItemStack(ExtraDelightItems.MIXING_BOWL.get()),
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

		feasts = Advancement.Builder.advancement()
				.display(new DisplayInfo(new ItemStack(ExtraDelightItems.BEEF_WELLINGTON_FEAST_ITEM.get()),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.feasts.name"),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.feasts.desc"), null,
						FrameType.CHALLENGE, true, true, false))
				.parent(start)
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
				.addCriterion("stirfry",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.STIRFRY_FEAST_ITEM.get()))
				.save(consumer, ExtraDelight.MOD_ID + ":feasts");
	}

	@Override
	public String getName() {
		return "Extra Delight Advancements";
	}
}
