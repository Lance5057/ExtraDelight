package com.lance5057.extradelight.workstations.oven.recipes;

import java.util.Optional;

import javax.annotation.Nullable;

import com.lance5057.extradelight.ExtraDelightItems;
import com.lance5057.extradelight.ExtraDelightRecipes;
import com.lance5057.extradelight.workstations.oven.recipetab.OvenRecipeBookTab;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.util.RecipeMatcher;
import net.neoforged.neoforge.items.wrapper.RecipeWrapper;

public class OvenRecipe implements Recipe<RecipeWrapper> {
	public static final int INPUT_SLOTS = 9;

	private final String group;
	private final OvenRecipeBookTab tab;
	private final NonNullList<Ingredient> inputItems;
	public final ItemStack output;
	private final ItemStack container;
	private final float experience;
	private final int cookTime;

	public OvenRecipe(String group, @Nullable OvenRecipeBookTab tab,
			NonNullList<Ingredient> inputItems, ItemStack output, ItemStack container, float experience, int cookTime) {
		this.group = group;
		this.tab = tab;
		this.inputItems = inputItems;
		this.output = output;

		if (!container.isEmpty()) {
			this.container = container;
		} else {
			this.container = ItemStack.EMPTY;
		}

		this.experience = experience;
		this.cookTime = cookTime;
	}

//	@Override
//	public ResourceLocation getId() {
//		return this.id;
//	}

	public ItemStack getContainerOverride() {
		return this.container;
	}
	
	@Override
	public String getGroup() {
		return this.group;
	}

	@Nullable
	public OvenRecipeBookTab getRecipeBookTab() {
		return this.tab;
	}

	@Override
	public NonNullList<Ingredient> getIngredients() {
		return this.inputItems;
	}

	@Override
	public ItemStack getResultItem(RegistryAccess p_267052_) {
		return this.output;
	}

	public ItemStack getOutputContainer() {
		return this.container;
	}

	@Override
	public ItemStack assemble(RecipeWrapper inv, RegistryAccess p_267165_) {
		return this.output.copy();
	}

	public float getExperience() {
		return this.experience;
	}

	public int getCookTime() {
		return this.cookTime;
	}

	@Override
	public boolean matches(RecipeWrapper inv, Level level) {
		java.util.List<ItemStack> inputs = new java.util.ArrayList<>();
		int i = 0;

		for (int j = 0; j < INPUT_SLOTS; ++j) {
			ItemStack itemstack = inv.getItem(j);
			if (!itemstack.isEmpty()) {
				++i;
				inputs.add(itemstack);
			}
		}
		return i == this.inputItems.size()
				&& RecipeMatcher.findMatches(inputs, this.inputItems) != null
				&& inv.getItem(INPUT_SLOTS + 1).getItem() == this.container.getItem();
	}

	@Override
	public boolean canCraftInDimensions(int width, int height) {
		return width * height >= this.inputItems.size();
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return ExtraDelightRecipes.OVEN_SERIALIZER.get();
	}

	@Override
	public RecipeType<?> getType() {
		return ExtraDelightRecipes.OVEN.get();
	}

	@Override
	public ItemStack getToastSymbol() {
		return new ItemStack(ExtraDelightItems.OVEN.get());
	}

	public static class Serializer implements RecipeSerializer<OvenRecipe> {
		public Serializer() {
		}

		private static final Codec<OvenRecipe> CODEC = RecordCodecBuilder.create(inst -> inst.group(
				ExtraCodecs.strictOptionalField(Codec.STRING, "group", "").forGetter(OvenRecipe::getGroup),
				ExtraCodecs.strictOptionalField(OvenRecipeBookTab.CODEC, "recipe_book_tab").xmap(optional -> optional.orElse(null), Optional::of).forGetter(OvenRecipe::getRecipeBookTab),
				Ingredient.LIST_CODEC_NONEMPTY.fieldOf("ingredients").xmap(ingredients -> {
					NonNullList<Ingredient> nonNullList = NonNullList.create();
					nonNullList.addAll(ingredients);
					return nonNullList;
				}, ingredients -> ingredients).forGetter(OvenRecipe::getIngredients),
				ItemStack.ITEM_WITH_COUNT_CODEC.fieldOf("result").forGetter(r -> r.output),
				ExtraCodecs.strictOptionalField(ItemStack.ITEM_WITH_COUNT_CODEC, "container", ItemStack.EMPTY).forGetter(OvenRecipe::getContainerOverride),
				ExtraCodecs.strictOptionalField(Codec.FLOAT, "experience", 0.0F).forGetter(OvenRecipe::getExperience),
				ExtraCodecs.strictOptionalField(Codec.INT, "cookingtime", 200).forGetter(OvenRecipe::getCookTime)
		).apply(inst, OvenRecipe::new));

//		@Override
//		public OvenRecipe fromJson(ResourceLocation recipeId, JsonObject json) {
//			final String groupIn = GsonHelper.getAsString(json, "group", "");
//			final NonNullList<Ingredient> inputItemsIn = readIngredients(
//					GsonHelper.getAsJsonArray(json, "ingredients"));
//			if (inputItemsIn.isEmpty()) {
//				throw new JsonParseException("No ingredients for cooking recipe");
//			} else if (inputItemsIn.size() > OvenRecipe.INPUT_SLOTS) {
//				throw new JsonParseException(
//						"Too many ingredients for cooking recipe! The max is " + OvenRecipe.INPUT_SLOTS);
//			} else {
//				final String tabKeyIn = GsonHelper.getAsString(json, "recipe_book_tab", null);
//				final OvenRecipeBookTab tabIn = OvenRecipeBookTab.findByName(tabKeyIn);
//				if (tabKeyIn != null && tabIn == null) {
//					ExtraDelight.logger.warn(
//							"Optional field 'recipe_book_tab' does not match any valid tab. If defined, must be one of the following: "
//									+ EnumSet.allOf(OvenRecipeBookTab.class));
//				}
//				final ItemStack outputIn = CraftingHelper.getItemStack(GsonHelper.getAsJsonObject(json, "result"),
//						true);
//				ItemStack container = GsonHelper.isValidNode(json, "container")
//						? CraftingHelper.getItemStack(GsonHelper.getAsJsonObject(json, "container"), true)
//						: ItemStack.EMPTY;
//				final float experienceIn = GsonHelper.getAsFloat(json, "experience", 0.0F);
//				final int cookTimeIn = GsonHelper.getAsInt(json, "cookingtime", 200);
//				return new OvenRecipe(recipeId, groupIn, tabIn, inputItemsIn, outputIn, container, experienceIn,
//						cookTimeIn);
//			}
//		}

//		private static NonNullList<Ingredient> readIngredients(JsonArray ingredientArray) {
//			NonNullList<Ingredient> nonnulllist = NonNullList.create();
//
//			for (int i = 0; i < ingredientArray.size(); ++i) {
//				Ingredient ingredient = Ingredient.fromJson(ingredientArray.get(i));
//				if (!ingredient.isEmpty()) {
//					nonnulllist.add(ingredient);
//				}
//			}
//
//			return nonnulllist;
//		}

		@Nullable
		@Override
		public OvenRecipe fromNetwork(FriendlyByteBuf buffer) {
			String groupIn = buffer.readUtf();
			OvenRecipeBookTab tabIn = OvenRecipeBookTab.findByName(buffer.readUtf());
			int i = buffer.readVarInt();
			NonNullList<Ingredient> inputItemsIn = NonNullList.withSize(i, Ingredient.EMPTY);

			for (int j = 0; j < inputItemsIn.size(); ++j) {
				inputItemsIn.set(j, Ingredient.fromNetwork(buffer));
			}

			ItemStack outputIn = buffer.readItem();
			ItemStack container = buffer.readItem();
			float experienceIn = buffer.readFloat();
			int cookTimeIn = buffer.readVarInt();
			return new OvenRecipe(groupIn, tabIn, inputItemsIn, outputIn, container, experienceIn,
					cookTimeIn);
		}

		@Override
		public void toNetwork(FriendlyByteBuf buffer, OvenRecipe recipe) {
			buffer.writeUtf(recipe.group);
			buffer.writeUtf(recipe.tab != null ? recipe.tab.toString() : "");
			buffer.writeVarInt(recipe.inputItems.size());

			for (Ingredient ingredient : recipe.inputItems) {
				ingredient.toNetwork(buffer);
			}

			buffer.writeItem(recipe.output);
			buffer.writeItem(recipe.container);
			buffer.writeFloat(recipe.experience);
			buffer.writeVarInt(recipe.cookTime);
		}

		@Override
		public Codec<OvenRecipe> codec() {
			return CODEC;
		}
	}
}
