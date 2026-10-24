package com.lance5057.extradelight.recipe.dynamics;

import java.util.Optional;

import com.lance5057.extradelight.ExtraDelightComponents;
import com.lance5057.extradelight.ExtraDelightRecipes;
import com.lance5057.extradelight.items.dynamicfood.DynamicSkewer;
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
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.neoforged.neoforge.items.wrapper.RecipeWrapper;
import vectorwing.farmersdelight.client.recipebook.CookingPotRecipeBookTab;
import vectorwing.farmersdelight.common.crafting.CookingPotRecipe;

public class TanghuluRecipe extends CookingPotRecipe {

	public TanghuluRecipe(String group, CookingPotRecipeBookTab tab, NonNullList<Ingredient> inputItems,
			ItemStack output, ItemStack container, float experience, int cookTime) {
		super(group, tab, inputItems, output, container, experience, cookTime);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ItemStack assemble(RecipeWrapper inv, HolderLookup.Provider registries) {
		ItemStack stack = super.getResultItem(registries).copy();

		ItemStack skewer = getSkewer(inv);
		if (!skewer.isEmpty()) {
			if (skewer.has(ExtraDelightComponents.ITEMSTACK_HANDLER)) {
				ItemContainerContents i = skewer.get(ExtraDelightComponents.ITEMSTACK_HANDLER);
				if (skewer.has(ExtraDelightComponents.DYNAMIC_FOOD)) {
					DynamicItemComponent d = skewer.get(ExtraDelightComponents.DYNAMIC_FOOD);
					if (skewer.has(DataComponents.FOOD)) {
						FoodProperties f = skewer.get(DataComponents.FOOD);

						FoodProperties food = new FoodProperties(f.nutrition() + 1, f.saturation() + 0.1f,
								f.canAlwaysEat(), f.eatSeconds(), f.usingConvertsTo(), f.effects());

						stack.set(DataComponents.FOOD, food);
						stack.set(ExtraDelightComponents.DYNAMIC_FOOD, d);
						stack.set(ExtraDelightComponents.ITEMSTACK_HANDLER, i);
					}
				}
			}
		}

		return stack;
	}

	private ItemStack getSkewer(RecipeWrapper inv) {
		for (int i = 0; i < inv.size(); i++) {
			ItemStack skewer = inv.getItem(i);
			if (skewer.getItem() instanceof DynamicSkewer) {
				return skewer;
			}
		}
		return ItemStack.EMPTY;
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return ExtraDelightRecipes.TANGHULU_SERIALIZER.get();
	}

//	@Override
//	public RecipeType<?> getType() {
//		return ExtraDelightRecipes.DYNAMIC_SANDWICH.get();
//	}

	public static class Serializer implements RecipeSerializer<TanghuluRecipe> {
		private static final MapCodec<TanghuluRecipe> CODEC = RecordCodecBuilder.mapCodec(
				inst -> inst.group(Codec.STRING.optionalFieldOf("group", "").forGetter(CookingPotRecipe::getGroup),
						CookingPotRecipeBookTab.CODEC.optionalFieldOf("recipe_book_tab")
								.xmap(optional -> optional.orElse(null), Optional::of)
								.forGetter(CookingPotRecipe::getRecipeBookTab),
						Ingredient.LIST_CODEC_NONEMPTY.fieldOf("ingredients").xmap(ingredients -> {
							NonNullList<Ingredient> nonNullList = NonNullList.create();
							nonNullList.addAll(ingredients);
							return nonNullList;
						}, ingredients -> ingredients).forGetter(CookingPotRecipe::getIngredients),
						ItemStack.STRICT_CODEC.fieldOf("result").forGetter(r -> r.getResultItem(null)),
						ItemStack.STRICT_CODEC.optionalFieldOf("container", ItemStack.EMPTY)
								.forGetter(CookingPotRecipe::getContainerOverride),
						Codec.FLOAT.optionalFieldOf("experience", 0.0F).forGetter(CookingPotRecipe::getExperience),
						Codec.INT.optionalFieldOf("cookingtime", 200).forGetter(CookingPotRecipe::getCookTime))
						.apply(inst, TanghuluRecipe::new));

		public static final StreamCodec<RegistryFriendlyByteBuf, TanghuluRecipe> STREAM_CODEC = StreamCodec
				.of(TanghuluRecipe.Serializer::toNetwork, TanghuluRecipe.Serializer::fromNetwork);

		public Serializer() {
		}

		@Override
		public MapCodec<TanghuluRecipe> codec() {
			return CODEC;
		}

		@Override
		public StreamCodec<RegistryFriendlyByteBuf, TanghuluRecipe> streamCodec() {
			return STREAM_CODEC;
		}

		private static TanghuluRecipe fromNetwork(RegistryFriendlyByteBuf buffer) {
			String groupIn = buffer.readUtf();
			CookingPotRecipeBookTab tabIn = CookingPotRecipeBookTab.findByName(buffer.readUtf());
			int i = buffer.readVarInt();
			NonNullList<Ingredient> inputItemsIn = NonNullList.withSize(i, Ingredient.EMPTY);

			inputItemsIn.replaceAll(ignored -> Ingredient.CONTENTS_STREAM_CODEC.decode(buffer));

			ItemStack outputIn = ItemStack.STREAM_CODEC.decode(buffer);
			ItemStack container = ItemStack.OPTIONAL_STREAM_CODEC.decode(buffer);
			float experienceIn = buffer.readFloat();
			int cookTimeIn = buffer.readVarInt();

			return new TanghuluRecipe(groupIn, tabIn, inputItemsIn, outputIn, container, experienceIn, cookTimeIn);
		}

		private static void toNetwork(RegistryFriendlyByteBuf buffer, TanghuluRecipe recipe) {
			buffer.writeUtf(recipe.getGroup());
			buffer.writeUtf(recipe.getRecipeBookTab() != null ? recipe.getRecipeBookTab().toString() : "");
			buffer.writeVarInt(recipe.getIngredients().size());

			for (Ingredient ingredient : recipe.getIngredients()) {
				Ingredient.CONTENTS_STREAM_CODEC.encode(buffer, ingredient);
			}

			ItemStack.STREAM_CODEC.encode(buffer, recipe.getResultItem(null));
			ItemStack.OPTIONAL_STREAM_CODEC.encode(buffer, recipe.getOutputContainer());
			buffer.writeFloat(recipe.getExperience());
			buffer.writeVarInt(recipe.getCookTime());
		}
	}
}