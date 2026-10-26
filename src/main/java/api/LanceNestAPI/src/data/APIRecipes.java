package api.LanceNestAPI.src.data;

import api.LanceNestAPI.src.LanceNestAPI;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;

public class APIRecipes {

	public static void buildRecipes(RecipeOutput consumer) {
		ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, LanceNestAPI.ADVANCED_DISPLAY_ITEM.get()).pattern(" c ")
				.pattern("cic").pattern(" c ").define('c', Items.COPPER_INGOT).define('i', Items.ITEM_FRAME)
				.unlockedBy("", InventoryChangeTrigger.TriggerInstance.hasItems(Items.ITEM_FRAME))
				.save(consumer);
	}
}
