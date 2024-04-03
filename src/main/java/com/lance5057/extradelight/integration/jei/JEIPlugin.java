package com.lance5057.extradelight.integration.jei;

import org.jetbrains.annotations.NotNull;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.ExtraDelightItems;
import com.lance5057.extradelight.ExtraDelightRecipes;
import com.lance5057.extradelight.integration.jei.categories.DoughShapingRecipeCategory;
import com.lance5057.extradelight.integration.jei.categories.DryingRackRecipeCategory;
import com.lance5057.extradelight.integration.jei.categories.FeastRecipeCategory;
import com.lance5057.extradelight.integration.jei.categories.MixingBowlRecipeCategory;
import com.lance5057.extradelight.integration.jei.categories.MortarRecipeCategory;
import com.lance5057.extradelight.integration.jei.categories.OvenRecipeCategory;
import com.lance5057.extradelight.integration.jei.categories.ToolOnBlockRecipeCatagory;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

@JeiPlugin
public class JEIPlugin implements IModPlugin {
	private static final ResourceLocation ID = new ResourceLocation(ExtraDelight.MOD_ID, "main");

	@Override
	public ResourceLocation getPluginUid() {
		return ID;
	}

	@Override
	public void registerCategories(IRecipeCategoryRegistration registry) {
		registry.addRecipeCategories(new MortarRecipeCategory(registry.getJeiHelpers().getGuiHelper()),
				new MixingBowlRecipeCategory(registry.getJeiHelpers().getGuiHelper()),
				new OvenRecipeCategory(registry.getJeiHelpers().getGuiHelper()),
				new DryingRackRecipeCategory(registry.getJeiHelpers().getGuiHelper()),
				new DoughShapingRecipeCategory(registry.getJeiHelpers().getGuiHelper()),
				new ToolOnBlockRecipeCatagory(registry.getJeiHelpers().getGuiHelper()),
				new FeastRecipeCategory(registry.getJeiHelpers().getGuiHelper()));
	}

	@Override
	public void registerRecipes(@NotNull IRecipeRegistration registry) {
		registry.addRecipes(MortarRecipeCategory.TYPE,
				Minecraft.getInstance().level.getRecipeManager().getAllRecipesFor(ExtraDelightRecipes.MORTAR.get()));
		registry.addRecipes(MixingBowlRecipeCategory.TYPE, Minecraft.getInstance().level.getRecipeManager()
				.getAllRecipesFor(ExtraDelightRecipes.MIXING_BOWL.get()));
		registry.addRecipes(OvenRecipeCategory.TYPE,
				Minecraft.getInstance().level.getRecipeManager().getAllRecipesFor(ExtraDelightRecipes.OVEN.get()));
		registry.addRecipes(DryingRackRecipeCategory.TYPE, Minecraft.getInstance().level.getRecipeManager()
				.getAllRecipesFor(ExtraDelightRecipes.DRYING_RACK.get()));
		registry.addRecipes(DoughShapingRecipeCategory.TYPE, Minecraft.getInstance().level.getRecipeManager()
				.getAllRecipesFor(ExtraDelightRecipes.DOUGH_SHAPING.get()));
		registry.addRecipes(FeastRecipeCategory.TYPE,
				Minecraft.getInstance().level.getRecipeManager().getAllRecipesFor(ExtraDelightRecipes.FEAST.get()));
		registry.addRecipes(ToolOnBlockRecipeCatagory.TYPE, Minecraft.getInstance().level.getRecipeManager()
				.getAllRecipesFor(ExtraDelightRecipes.TOOL_ON_BLOCK.get()));
	}

	@Override
	public void registerRecipeCatalysts(IRecipeCatalystRegistration registry) {
		registry.addRecipeCatalyst(new ItemStack(ExtraDelightItems.PESTLE_AMETHYST.get()), MortarRecipeCategory.TYPE);
		registry.addRecipeCatalyst(new ItemStack(ExtraDelightItems.PESTLE_ANDESITE.get()), MortarRecipeCategory.TYPE);
		registry.addRecipeCatalyst(new ItemStack(ExtraDelightItems.PESTLE_BASALT.get()), MortarRecipeCategory.TYPE);
		registry.addRecipeCatalyst(new ItemStack(ExtraDelightItems.PESTLE_BLACKSTONE.get()), MortarRecipeCategory.TYPE);
		registry.addRecipeCatalyst(new ItemStack(ExtraDelightItems.PESTLE_DEEPSLATE.get()), MortarRecipeCategory.TYPE);
		registry.addRecipeCatalyst(new ItemStack(ExtraDelightItems.PESTLE_DIORITE.get()), MortarRecipeCategory.TYPE);
		registry.addRecipeCatalyst(new ItemStack(ExtraDelightItems.PESTLE_ENDSTONE.get()), MortarRecipeCategory.TYPE);
		registry.addRecipeCatalyst(new ItemStack(ExtraDelightItems.PESTLE_GILDED_BLACKSTONE.get()),
				MortarRecipeCategory.TYPE);
		registry.addRecipeCatalyst(new ItemStack(ExtraDelightItems.PESTLE_GRANITE.get()), MortarRecipeCategory.TYPE);
		registry.addRecipeCatalyst(new ItemStack(ExtraDelightItems.PESTLE_STONE.get()), MortarRecipeCategory.TYPE);

		registry.addRecipeCatalyst(new ItemStack(ExtraDelightItems.MORTAR_AMETHYST.get()), MortarRecipeCategory.TYPE);
		registry.addRecipeCatalyst(new ItemStack(ExtraDelightItems.MORTAR_ANDESITE.get()), MortarRecipeCategory.TYPE);
		registry.addRecipeCatalyst(new ItemStack(ExtraDelightItems.MORTAR_BASALT.get()), MortarRecipeCategory.TYPE);
		registry.addRecipeCatalyst(new ItemStack(ExtraDelightItems.MORTAR_BLACKSTONE.get()), MortarRecipeCategory.TYPE);
		registry.addRecipeCatalyst(new ItemStack(ExtraDelightItems.MORTAR_DEEPSLATE.get()), MortarRecipeCategory.TYPE);
		registry.addRecipeCatalyst(new ItemStack(ExtraDelightItems.MORTAR_DIORITE.get()), MortarRecipeCategory.TYPE);
		registry.addRecipeCatalyst(new ItemStack(ExtraDelightItems.MORTAR_ENDSTONE.get()), MortarRecipeCategory.TYPE);
		registry.addRecipeCatalyst(new ItemStack(ExtraDelightItems.MORTAR_GILDED_BLACKSTONE.get()),
				MortarRecipeCategory.TYPE);
		registry.addRecipeCatalyst(new ItemStack(ExtraDelightItems.MORTAR_GRANITE.get()), MortarRecipeCategory.TYPE);
		registry.addRecipeCatalyst(new ItemStack(ExtraDelightItems.MORTAR_STONE.get()), MortarRecipeCategory.TYPE);

		registry.addRecipeCatalyst(new ItemStack(ExtraDelightItems.WOODEN_SPOON.get()), MixingBowlRecipeCategory.TYPE);
		registry.addRecipeCatalyst(new ItemStack(ExtraDelightItems.STONE_SPOON.get()), MixingBowlRecipeCategory.TYPE);
		registry.addRecipeCatalyst(new ItemStack(ExtraDelightItems.IRON_SPOON.get()), MixingBowlRecipeCategory.TYPE);
		registry.addRecipeCatalyst(new ItemStack(ExtraDelightItems.GOLD_SPOON.get()), MixingBowlRecipeCategory.TYPE);
		registry.addRecipeCatalyst(new ItemStack(ExtraDelightItems.DIAMOND_SPOON.get()), MixingBowlRecipeCategory.TYPE);
		registry.addRecipeCatalyst(new ItemStack(ExtraDelightItems.NETHERITE_SPOON.get()),
				MixingBowlRecipeCategory.TYPE);
		registry.addRecipeCatalyst(new ItemStack(ExtraDelightItems.MIXING_BOWL.get()), MixingBowlRecipeCategory.TYPE);

		registry.addRecipeCatalyst(new ItemStack(ExtraDelightItems.OVEN.get()), OvenRecipeCategory.TYPE);
//		registry.addRecipeCatalyst(new ItemStack(ExtraDelightItems.BAKING_STONE.get()), OvenRecipeCategory.TYPE);
//		registry.addRecipeCatalyst(new ItemStack(ExtraDelightItems.LOAF_PAN.get()), OvenRecipeCategory.TYPE);
//		registry.addRecipeCatalyst(new ItemStack(ExtraDelightItems.ROUND_PAN.get()), OvenRecipeCategory.TYPE);
//		registry.addRecipeCatalyst(new ItemStack(ExtraDelightItems.SQUARE_PAN.get()), OvenRecipeCategory.TYPE);
//		registry.addRecipeCatalyst(new ItemStack(ExtraDelightItems.SHEET.get()), OvenRecipeCategory.TYPE);
//		registry.addRecipeCatalyst(new ItemStack(ExtraDelightItems.TRAY.get()), OvenRecipeCategory.TYPE);
//		registry.addRecipeCatalyst(new ItemStack(ExtraDelightItems.PIE_DISH.get()), OvenRecipeCategory.TYPE);
//		registry.addRecipeCatalyst(new ItemStack(ExtraDelightItems.MUFFIN_TIN.get()), OvenRecipeCategory.TYPE);

		registry.addRecipeCatalyst(new ItemStack(ExtraDelightItems.DRYING_RACK.get()), DryingRackRecipeCategory.TYPE);

		registry.addRecipeCatalyst(new ItemStack(ExtraDelightItems.DOUGH_SHAPING.get()),
				DoughShapingRecipeCategory.TYPE);
	}

}
