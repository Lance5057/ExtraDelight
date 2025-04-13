package com.lance5057.extradelight.integration.patchouli.builders;

import net.minecraft.resources.ResourceLocation;
import xyz.brassgoggledcoders.patchouliprovider.EntryBuilder;
import xyz.brassgoggledcoders.patchouliprovider.page.CraftingPageBuilder;
import xyz.brassgoggledcoders.patchouliprovider.page.RecipePageBuilder;

public class CookingPotBuilder extends RecipePageBuilder<CraftingPageBuilder> {

	public CookingPotBuilder(ResourceLocation recipe, EntryBuilder parent) {
		super("extradelight:cookingpot", recipe, parent);
	}

}
