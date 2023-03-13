package com.lance5057.extradelight.integration.jei;

import org.jetbrains.annotations.NotNull;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.ExtraDelightItems;
import com.lance5057.extradelight.ExtraDelightRecipes;
import com.lance5057.extradelight.integration.jei.categories.MixingBowlRecipeCategory;
import com.lance5057.extradelight.integration.jei.categories.MortarRecipeCategory;

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
				new MixingBowlRecipeCategory(registry.getJeiHelpers().getGuiHelper()));
	}

	@Override
	public void registerRecipes(@NotNull IRecipeRegistration registry) {
		registry.addRecipes(MortarRecipeCategory.TYPE,
				Minecraft.getInstance().level.getRecipeManager().getAllRecipesFor(ExtraDelightRecipes.MORTAR.get()));
		registry.addRecipes(MixingBowlRecipeCategory.TYPE, Minecraft.getInstance().level.getRecipeManager()
				.getAllRecipesFor(ExtraDelightRecipes.MIXING_BOWL.get()));
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
		registry.addRecipeCatalyst(new ItemStack(ExtraDelightItems.NETHERITE_SPOON.get()), MixingBowlRecipeCategory.TYPE);
		registry.addRecipeCatalyst(new ItemStack(ExtraDelightItems.MIXING_BOWL.get()), MixingBowlRecipeCategory.TYPE);
	}
}
