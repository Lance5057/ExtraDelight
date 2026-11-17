//package lance5057.compendium.core.recipes;
//
//import javax.annotation.Nonnull;
//import javax.annotation.Nullable;
//
//import com.google.gson.JsonObject;
//
//import lance5057.compendium.CompendiumRecipes;
//import net.minecraft.network.FriendlyByteBuf;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.item.crafting.Ingredient;
//import net.minecraft.world.item.crafting.RecipeSerializer;
//import net.minecraft.world.item.crafting.RecipeType;
//import net.minecraft.world.item.crafting.ShapedRecipe;
//import net.minecraftforge.registries.ForgeRegistryEntry;
//
//public class HammerHandedToolRecipe extends InWorldHandedToolRecipe {
//
//	public HammerHandedToolRecipe(ResourceLocation id, ItemStack block, Ingredient offInteractionHand,
//			ItemStack output) {
//		super(id, block, offInteractionHand, output);
//	}
//
//	@Override
//	public RecipeType<?> getType() {
//		return CompendiumRecipes.HAMMERING_TOOL_RECIPE;
//	}
//
//	@Override
//	public RecipeSerializer<?> getSerializer() {
//		return CompendiumRecipes.HAMMERING_TOOL_SERIALIZER.get();
//	}
//
//	public static class Serializer extends ForgeRegistryEntry<RecipeSerializer<?>>
//			implements RecipeSerializer<HammerHandedToolRecipe> {
//		@Nonnull
//		@Override
//		public HammerHandedToolRecipe fromJson(@Nonnull ResourceLocation recipeId, JsonObject json) {
//			final Ingredient input = Ingredient.fromJson(json.get("input"));
//			final ItemStack block = ShapedRecipe.itemStackFromJson(json.getAsJsonObject("block"));
//			final ItemStack result = ShapedRecipe.itemStackFromJson(json.getAsJsonObject("result"));
//
//			return new HammerHandedToolRecipe(recipeId, block, input, result);
//		}
//
//		@Nullable
//		@Override
//		public HammerHandedToolRecipe fromNetwork(@Nonnull ResourceLocation recipeId, FriendlyByteBuf buffer) {
//			ItemStack result = buffer.readItem();
//			ItemStack block = buffer.readItem();
//			Ingredient input = Ingredient.fromNetwork(buffer);
//
//			return new HammerHandedToolRecipe(recipeId, block, input, result);
//		}
//
//		@Override
//		public void toNetwork(FriendlyByteBuf buffer, HammerHandedToolRecipe recipe) {
//
//			buffer.writeItem(recipe.getResultItem());
//			buffer.writeItem(recipe.getBlock());
//			recipe.getIngredient().toNetwork(buffer);
//
//		}
//	}
//}
