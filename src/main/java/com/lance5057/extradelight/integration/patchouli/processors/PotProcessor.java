package com.lance5057.extradelight.integration.patchouli.processors;

import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.Level;
import vazkii.patchouli.api.IComponentProcessor;
import vazkii.patchouli.api.IVariable;
import vazkii.patchouli.api.IVariableProvider;
import vectorwing.farmersdelight.common.crafting.CookingPotRecipe;

public class PotProcessor implements IComponentProcessor {
	protected RecipeHolder<?> recipe;

	@Override
	public IVariable process(Level level, String key) {
		if (recipe == null) {
			return null;
		}
		return switch (key) {
		case "recipe" -> IVariable.wrap(recipe.id().toString(), level.registryAccess());
		case "output" -> IVariable.from(recipe.value().getResultItem(level.registryAccess()), level.registryAccess());
		case "container" ->
			IVariable.from(((CookingPotRecipe) recipe.value()).getOutputContainer(), level.registryAccess());
		case "heading" ->
			IVariable.from(recipe.value().getResultItem(level.registryAccess()).getHoverName(), level.registryAccess());
		default -> null;
		};
	}

	@Override
	public void setup(Level level, IVariableProvider variables) {
		ResourceLocation id = ResourceLocation.parse(variables.get("recipe", level.registryAccess()).asString());
		RecipeManager manager = Minecraft.getInstance().level.getRecipeManager();
		recipe = manager.byKey(id).orElse(null);
	}
}
