package com.lance5057.extradelight.integration.patchouli;

import com.lance5057.extradelight.workstations.mixingbowl.recipes.MixingBowlRecipe;

import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeManager;
import vazkii.patchouli.api.IComponentProcessor;
import vazkii.patchouli.api.IVariable;
import vazkii.patchouli.api.IVariableProvider;

public class MixingBowlProcessor implements IComponentProcessor {
	protected Recipe<?> recipe;

	@Override
	public void setup(IVariableProvider variables) {
		ResourceLocation id = new ResourceLocation(variables.get("recipe").asString());
		RecipeManager manager = Minecraft.getInstance().level.getRecipeManager();
		recipe = manager.byKey(id).orElse(null);
	}

	@Override
	public IVariable process(String key) {
		if (recipe == null) {
			return null;
		}
		return switch (key) {
		case "recipe" -> IVariable.wrap(recipe.getId().toString());
		case "output" -> IVariable.from(recipe.getResultItem());
		case "stirs" -> IVariable.wrap(Integer.toString(((MixingBowlRecipe) recipe).getStirs()));
		case "used" -> IVariable.from(((MixingBowlRecipe) recipe).getUsedItem());
		case "heading" -> IVariable.from(recipe.getResultItem().getHoverName());
		default -> null;
		};
	}
}
