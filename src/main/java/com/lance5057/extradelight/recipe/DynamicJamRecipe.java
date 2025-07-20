package com.lance5057.extradelight.recipe;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.ExtraDelightComponents;
import com.lance5057.extradelight.ExtraDelightRecipes;
import com.lance5057.extradelight.items.dynamicfood.DynamicJam;
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

public class DynamicJamRecipe extends CookingPotRecipe {

	public DynamicJamRecipe(String group, CookingPotRecipeBookTab tab, NonNullList<Ingredient> inputItems,
			ItemStack output, ItemStack container, float experience, int cookTime) {
		super(group, tab, inputItems, output, container, experience, cookTime);
	}

	@Override
	public ItemStack getResultItem(HolderLookup.Provider provider) {
		ItemStack stack = super.getResultItem(provider);
		if (stack.getItem() instanceof DynamicJam jam) {
			DynamicItemComponent comp = stack.getComponents().get(ExtraDelightComponents.DYNAMIC_FOOD.get());
			if (comp != null) {
				comp.addItem(stack);
			} else
				ExtraDelight.logger.error("DynamicJam lost its component!");
		} else {
			ExtraDelight.logger.error("DynamicJamRecipe result not DynamicJam!");
		}

		return stack;
	}

	@Override
	public ItemStack assemble(RecipeWrapper inv, HolderLookup.Provider provider) {
		ItemStack stack = super.getResultItem(provider).copy();
		if (stack.getItem() instanceof DynamicJam) {

			int nutrition = 0;
			float saturation = 0;
			List<FoodProperties.PossibleEffect> effects = new ArrayList<FoodProperties.PossibleEffect>();

			NonNullList<ItemStack> l = NonNullList.create();
			for (int i = 0; i < inv.size()-2; i++) {
				ItemStack s = inv.getItem(i);
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
			}

			stack.set(ExtraDelightComponents.ITEMSTACK_HANDLER.get(), ItemContainerContents.fromItems(l));

			FoodProperties food = new FoodProperties(nutrition, saturation / inv.size(), false, 1.6F,
					java.util.Optional.empty(), effects);

			stack.set(DataComponents.FOOD, food);
		} else {
			ExtraDelight.logger.error("DynamicToastRecipe result not DynamicToast!");
		}
		return stack;
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return ExtraDelightRecipes.DYNAMIC_JAM_SERIALIZER.get();
	}

//	@Override
//	public RecipeType<?> getType() {
//		return ExtraDelightRecipes.DYNAMIC_JAM.get();
//	}

	public static class Serializer implements RecipeSerializer<DynamicJamRecipe> {
		private static final MapCodec<DynamicJamRecipe> CODEC = RecordCodecBuilder.mapCodec(
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
						.apply(inst, DynamicJamRecipe::new));

		public static final StreamCodec<RegistryFriendlyByteBuf, DynamicJamRecipe> STREAM_CODEC = StreamCodec
				.of(DynamicJamRecipe.Serializer::toNetwork, DynamicJamRecipe.Serializer::fromNetwork);

		public Serializer() {
		}

		@Override
		public MapCodec<DynamicJamRecipe> codec() {
			return CODEC;
		}

		@Override
		public StreamCodec<RegistryFriendlyByteBuf, DynamicJamRecipe> streamCodec() {
			return STREAM_CODEC;
		}

		private static DynamicJamRecipe fromNetwork(RegistryFriendlyByteBuf buffer) {
			String groupIn = buffer.readUtf();
			CookingPotRecipeBookTab tabIn = CookingPotRecipeBookTab.findByName(buffer.readUtf());
			int i = buffer.readVarInt();
			NonNullList<Ingredient> inputItemsIn = NonNullList.withSize(i, Ingredient.EMPTY);

			inputItemsIn.replaceAll(ignored -> Ingredient.CONTENTS_STREAM_CODEC.decode(buffer));

			ItemStack outputIn = ItemStack.STREAM_CODEC.decode(buffer);
			ItemStack container = ItemStack.OPTIONAL_STREAM_CODEC.decode(buffer);
			float experienceIn = buffer.readFloat();
			int cookTimeIn = buffer.readVarInt();
			return new DynamicJamRecipe(groupIn, tabIn, inputItemsIn, outputIn, container, experienceIn, cookTimeIn);
		}

		private static void toNetwork(RegistryFriendlyByteBuf buffer, DynamicJamRecipe recipe) {
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
