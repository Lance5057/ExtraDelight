package api.LanceNestAPI.src.recipes.multitoolrecipe;

import api.LanceNestAPI.src.recipes.AnimatedRecipeItemUse;
import api.LanceNestAPI.src.util.recipes.MultiToolRecipeWrapper;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.crafting.Recipe;

public abstract class MultiToolRecipe implements Recipe<MultiToolRecipeWrapper> {

	NonNullList<AnimatedRecipeItemUse> tools;

	public MultiToolRecipe(NonNullList<AnimatedRecipeItemUse> tools) {
		this.tools = tools;
	}

	public NonNullList<AnimatedRecipeItemUse> getTools() {
		return tools;
	}

}