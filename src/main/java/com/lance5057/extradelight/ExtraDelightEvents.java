package com.lance5057.extradelight;

import com.lance5057.extradelight.items.components.ChillComponent;

import net.minecraft.client.RecipeBookCategories;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterRecipeBookCategoriesEvent;
import net.neoforged.neoforge.event.ModifyDefaultComponentsEvent;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = ExtraDelight.MOD_ID)
public class ExtraDelightEvents {

	@SubscribeEvent
	public static void modifyComponents(ModifyDefaultComponentsEvent event) {
		event.modify(Items.BLUE_ICE,
				builder -> builder.set(ExtraDelightComponents.CHILL.value(), new ChillComponent(2500)));
		event.modify(Items.PACKED_ICE,
				builder -> builder.set(ExtraDelightComponents.CHILL.value(), new ChillComponent(1000)));
		event.modify(Items.ICE, builder -> builder.set(ExtraDelightComponents.CHILL.value(), new ChillComponent(250)));
		event.modify(Items.SNOWBALL,
				builder -> builder.set(ExtraDelightComponents.CHILL.value(), new ChillComponent(100)));

	}

	@SubscribeEvent
	public static void onRegisterRecipeBookCategories(RegisterRecipeBookCategoriesEvent event) {
		event.registerRecipeCategoryFinder(ExtraDelightRecipes.BOTTLE_FLUID_REGISTRY.get(), r-> RecipeBookCategories.UNKNOWN);
		event.registerRecipeCategoryFinder(ExtraDelightRecipes.CHILLER.get(), r-> RecipeBookCategories.UNKNOWN);
		event.registerRecipeCategoryFinder(ExtraDelightRecipes.DOUGH_SHAPING.get(), r-> RecipeBookCategories.UNKNOWN);
		event.registerRecipeCategoryFinder(ExtraDelightRecipes.DRYING_RACK.get(), r-> RecipeBookCategories.UNKNOWN);
		event.registerRecipeCategoryFinder(ExtraDelightRecipes.DYNAMIC_TOAST.get(), r-> RecipeBookCategories.UNKNOWN);
		event.registerRecipeCategoryFinder(ExtraDelightRecipes.EVAPORATOR.get(), r-> RecipeBookCategories.UNKNOWN);
		event.registerRecipeCategoryFinder(ExtraDelightRecipes.FEAST.get(), r-> RecipeBookCategories.UNKNOWN);
		event.registerRecipeCategoryFinder(ExtraDelightRecipes.MELTING_POT.get(), r-> RecipeBookCategories.UNKNOWN);
		event.registerRecipeCategoryFinder(ExtraDelightRecipes.MIXING_BOWL.get(), r-> RecipeBookCategories.UNKNOWN);
		event.registerRecipeCategoryFinder(ExtraDelightRecipes.MORTAR.get(), r-> RecipeBookCategories.UNKNOWN);
		event.registerRecipeCategoryFinder(ExtraDelightRecipes.OVEN.get(), r-> RecipeBookCategories.UNKNOWN);
		event.registerRecipeCategoryFinder(ExtraDelightRecipes.SHAPED_JAR.get(), r-> RecipeBookCategories.UNKNOWN);
		event.registerRecipeCategoryFinder(ExtraDelightRecipes.TOOL_ON_BLOCK.get(), r-> RecipeBookCategories.UNKNOWN);
		event.registerRecipeCategoryFinder(ExtraDelightRecipes.VAT.get(), r-> RecipeBookCategories.UNKNOWN);
	}

}
