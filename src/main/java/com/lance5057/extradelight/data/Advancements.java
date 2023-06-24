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

public class Advancements extends AdvancementProvider {
	private final DataGenerator dataGenerator;

	private Advancement start;

	private Advancement grater;

	private Advancement spoon;
	private Advancement mixingbowl;

	private Advancement oven;
	private Advancement trays;

	private Advancement mortar;
	private Advancement pestle;
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
	}

	@Override
	public String getName() {
		return "Extra Delight Advancements";
	}
}
