package com.lance5057.extradelight.recipe;

import java.util.ArrayList;
import java.util.List;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.ExtraDelightComponents;
import com.lance5057.extradelight.ExtraDelightRecipes;
import com.lance5057.extradelight.items.dynamicfood.DynamicToast;
import com.lance5057.extradelight.items.dynamicfood.api.DynamicItemComponent;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemContainerContents;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.world.item.crafting.ShapedRecipePattern;

public class DynamicToastRecipe extends ShapedRecipe {

	private final String graphic;

	public DynamicToastRecipe(String group, CraftingBookCategory category, ShapedRecipePattern pattern,
			ItemStack result, String graphic) {
		super(group, category, pattern, result);
		this.graphic = graphic;

	}

	public String getGraphic() {
		return graphic;
	}

	@Override
	public ItemStack assemble(CraftingInput input, HolderLookup.Provider registries) {
		ItemStack stack = super.getResultItem(registries).copy();
		if (stack.getItem() instanceof DynamicToast) {

			int nutrition = 0;
			float saturation = 0;
			List<FoodProperties.PossibleEffect> effects = new ArrayList<FoodProperties.PossibleEffect>();

			NonNullList<ItemStack> l = NonNullList.create();
			for (ItemStack s : input.items())
				if (s != null && !s.isEmpty()) {
					l.add(s);
					if (s.has(DataComponents.FOOD)) {
						FoodProperties f = s.get(DataComponents.FOOD);
						nutrition += f.nutrition();
						saturation += f.saturation();

						effects.addAll(f.effects());
					} else
						ExtraDelight.logger
								.error(s.getDescriptionId() + " doesn't have a food component! How did we get here?!");
				}

			stack.set(ExtraDelightComponents.DYNAMIC_FOOD.get(), new DynamicItemComponent(List.of(graphic)));
			stack.set(ExtraDelightComponents.ITEMSTACK_HANDLER.get(), ItemContainerContents.fromItems(l));

			FoodProperties food = new FoodProperties(nutrition, saturation / input.items().size(), false, 1.6F,
					java.util.Optional.empty(), effects);

			stack.set(DataComponents.FOOD, food);
		} else {
			ExtraDelight.logger.error("DynamicToastRecipe result not DynamicToast!");
		}
		return stack;
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return ExtraDelightRecipes.DYNAMIC_TOAST_SERIALIZER.get();
	}

//	@Override
//	public RecipeType<?> getType() {
//		return ExtraDelightRecipes.DYNAMIC_SANDWICH.get();
//	}

	public static class Serializer implements RecipeSerializer<DynamicToastRecipe> {
		public static final MapCodec<DynamicToastRecipe> CODEC = RecordCodecBuilder.mapCodec(
	            p_340778_ -> p_340778_.group(
	                        Codec.STRING.optionalFieldOf("group", "").forGetter(p_311729_ -> p_311729_.getGroup()),
	                        CraftingBookCategory.CODEC.fieldOf("category").orElse(CraftingBookCategory.MISC).forGetter(p_311732_ -> p_311732_.category()),
	                        ShapedRecipePattern.MAP_CODEC.forGetter(p_311733_ -> p_311733_.pattern),
	                        ItemStack.STRICT_CODEC.fieldOf("result").forGetter(p_311730_ -> p_311730_.getResultItem(null)),
	                        Codec.STRING.optionalFieldOf("graphic", "").forGetter(DynamicToastRecipe::getGraphic)
	                    )
	                    .apply(p_340778_, DynamicToastRecipe::new)
	        );

		public static final StreamCodec<RegistryFriendlyByteBuf, DynamicToastRecipe> STREAM_CODEC = StreamCodec
				.of(DynamicToastRecipe.Serializer::toNetwork, DynamicToastRecipe.Serializer::fromNetwork);

		@Override
		public MapCodec<DynamicToastRecipe> codec() {
			return CODEC;
		}

		@Override
		public StreamCodec<RegistryFriendlyByteBuf, DynamicToastRecipe> streamCodec() {
			return STREAM_CODEC;
		}

		private static DynamicToastRecipe fromNetwork(RegistryFriendlyByteBuf buffer) {
			String s = buffer.readUtf();
			CraftingBookCategory craftingbookcategory = buffer.readEnum(CraftingBookCategory.class);
			ShapedRecipePattern shapedrecipepattern = ShapedRecipePattern.STREAM_CODEC.decode(buffer);
			ItemStack itemstack = ItemStack.STREAM_CODEC.decode(buffer);
			String graphic = buffer.readUtf();
			return new DynamicToastRecipe(s, craftingbookcategory, shapedrecipepattern, itemstack, graphic);
		}

		private static void toNetwork(RegistryFriendlyByteBuf buffer, DynamicToastRecipe recipe) {
			buffer.writeUtf(recipe.getGroup());
			buffer.writeEnum(recipe.category());
			ShapedRecipePattern.STREAM_CODEC.encode(buffer, recipe.pattern);
			ItemStack.STREAM_CODEC.encode(buffer, recipe.getResultItem(null));
			buffer.writeUtf(recipe.getGraphic());
		}
	}
}