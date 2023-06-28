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
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemInteractWithBlockTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.LocationPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.advancements.AdvancementProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
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
	private Advancement jellysplat;
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

		grind = Advancement.Builder.advancement()
				.display(new DisplayInfo(new ItemStack(ExtraDelightItems.MIXING_BOWL.get()),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.grind.name"),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.grind.desc"), null, FrameType.TASK,
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

		noodles = Advancement.Builder.advancement()
				.display(new DisplayInfo(new ItemStack(ExtraDelightItems.LASAGNA_NOODLES.get()),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.noodles.name"),
						Component.translatable(ExtraDelight.MOD_ID + ".advancement.noodles.desc"), null, FrameType.TASK,
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
	}

	@Override
	public String getName() {
		return "Extra Delight Advancements";
	}
}
