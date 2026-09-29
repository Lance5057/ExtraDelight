package api.LanceNestAPI.src.recipes.multitoolrecipe;

import api.LanceNestAPI.src.recipes.AnimatedRecipeItemUse;
import api.LanceNestAPI.src.util.recipes.MultiToolRecipeWrapper;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public abstract class MultiToolRecipeShaped extends MultiToolRecipe {

	public MultiToolRecipeShapedPattern pattern;
	protected final ItemStack recipeOutput;

	public MultiToolRecipeShaped(MultiToolRecipeShapedPattern pattern, NonNullList<AnimatedRecipeItemUse> recipeToolsIn,
			ItemStack recipeOutputIn) {
		super(recipeToolsIn);
		this.pattern = pattern;
		this.recipeOutput = recipeOutputIn;

	}

	@Override
	public boolean matches(MultiToolRecipeWrapper input, Level level) {
		return pattern.matches(input);
	}

	@Override
	public ItemStack getResultItem(Provider registries) {
		return recipeOutput.copy();
	}

}
