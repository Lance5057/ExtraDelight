package api.LanceNestAPI.src.recipes.multitoolrecipe;

import api.LanceNestAPI.src.recipes.AnimatedRecipeItemUse;
import api.LanceNestAPI.src.util.recipes.MultiToolRecipeWrapper;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public abstract class MultiToolRecipeShapeless extends MultiToolRecipe {

	public MultiToolRecipeShapeless(NonNullList<AnimatedRecipeItemUse> tools) {
		super(tools);
	}

	@Override
	public boolean matches(MultiToolRecipeWrapper input, Level level) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canCraftInDimensions(int width, int height) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public ItemStack getResultItem(Provider registries) {
		// TODO Auto-generated method stub
		return null;
	}

}
