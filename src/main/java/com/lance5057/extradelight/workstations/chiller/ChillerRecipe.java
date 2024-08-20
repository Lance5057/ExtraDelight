package com.lance5057.extradelight.workstations.chiller;

import com.lance5057.extradelight.ExtraDelightItems;
import com.lance5057.extradelight.ExtraDelightRecipes;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.util.RecipeMatcher;
import net.neoforged.neoforge.fluids.FluidStack;

public class ChillerRecipe implements Recipe<ChillerRecipeWrapper> {
	public static final int INPUT_SLOTS = 9;

	private final String group;
//	private final ChillerRecipeBookTab tab;
	private final NonNullList<Ingredient> inputItems;
	private final FluidStack fluid;
	public final ItemStack output;
	private final ItemStack container;
	private final float experience;
	private final int cookTime;

	public ChillerRecipe(String group, NonNullList<Ingredient> inputItems, FluidStack inputFluid, ItemStack output,
			ItemStack container, float experience, int cookTime) {
		this.group = group;
		this.fluid = inputFluid;
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

	public ItemStack getContainerOverride() {
		return this.container;
	}

	@Override
	public String getGroup() {
		return this.group;
	}

//	@Nullable
//	public ChillerRecipeBookTab getRecipeBookTab() {
//		return this.tab;
//	}

	@Override
	public NonNullList<Ingredient> getIngredients() {
		return this.inputItems;
	}

	@Override
	public ItemStack getResultItem(Provider registries) {
		return this.output;
	}

	public ItemStack getOutputContainer() {
		return this.container;
	}

	@Override
	public ItemStack assemble(ChillerRecipeWrapper input, Provider registries) {
		return this.output.copy();
	}

	public float getExperience() {
		return this.experience;
	}

	public int getCookTime() {
		return this.cookTime;
	}

	@Override
	public boolean matches(ChillerRecipeWrapper inv, Level level) {
		java.util.List<ItemStack> inputs = new java.util.ArrayList<>();
		int i = 0;

		for (int j = 0; j < INPUT_SLOTS; ++j) {
			ItemStack itemstack = inv.getItem(j);
			if (!itemstack.isEmpty()) {
				++i;
				inputs.add(itemstack);
			}
		}
		return i == this.inputItems.size() && RecipeMatcher.findMatches(inputs, this.inputItems) != null
				&& inv.getItem(INPUT_SLOTS + 1).getItem() == this.container.getItem();
	}

	@Override
	public boolean canCraftInDimensions(int width, int height) {
		return width * height >= this.inputItems.size();
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return ExtraDelightRecipes.CHILLER_SERIALIZER.get();
	}

	@Override
	public RecipeType<?> getType() {
		return ExtraDelightRecipes.OVEN.get();
	}

	@Override
	public ItemStack getToastSymbol() {
		return new ItemStack(ExtraDelightItems.OVEN.get());
	}

	public FluidStack getFluid() {
		return fluid;
	}

	public static class Serializer implements RecipeSerializer<ChillerRecipe> {
		public Serializer() {
		}

		private static final MapCodec<ChillerRecipe> CODEC = RecordCodecBuilder.mapCodec(
				inst -> inst.group(Codec.STRING.optionalFieldOf("group", "").forGetter(ChillerRecipe::getGroup),
//				ChillerRecipeBookTab.CODEC.optionalFieldOf("recipe_book_tab")
//						.xmap(optional -> optional.orElse(null), Optional::of).forGetter(ChillerRecipe::getRecipeBookTab),
						Ingredient.LIST_CODEC.fieldOf("ingredients").xmap(ingredients -> {
							NonNullList<Ingredient> nonNullList = NonNullList.create();
							nonNullList.addAll(ingredients);
							return nonNullList;
						}, ingredients -> ingredients).forGetter(ChillerRecipe::getIngredients),
						FluidStack.CODEC.fieldOf("fluid").forGetter(r -> r.fluid),
						ItemStack.CODEC.fieldOf("result").forGetter(r -> r.output),

						ItemStack.CODEC.lenientOptionalFieldOf("container", ItemStack.EMPTY)
								.forGetter(ChillerRecipe::getContainerOverride),
						Codec.FLOAT.optionalFieldOf("experience", 0.0F).forGetter(ChillerRecipe::getExperience),
						Codec.INT.lenientOptionalFieldOf("cookingtime", 200).forGetter(ChillerRecipe::getCookTime))

						.apply(inst, ChillerRecipe::new));

		public static ChillerRecipe fromNetwork(RegistryFriendlyByteBuf buffer) {
			String groupIn = buffer.readUtf();
//			ChillerRecipeBookTab tabIn = ChillerRecipeBookTab.findByName(buffer.readUtf());
			int i = buffer.readVarInt();
			NonNullList<Ingredient> inputItemsIn = NonNullList.withSize(i, Ingredient.EMPTY);

			for (int j = 0; j < inputItemsIn.size(); ++j) {
				inputItemsIn.set(j, Ingredient.CONTENTS_STREAM_CODEC.decode(buffer));
			}
			FluidStack fluid = FluidStack.STREAM_CODEC.decode(buffer);

			ItemStack outputIn = ItemStack.STREAM_CODEC.decode(buffer);
			ItemStack container = ItemStack.OPTIONAL_STREAM_CODEC.decode(buffer);
			float experienceIn = buffer.readFloat();
			int cookTimeIn = buffer.readVarInt();
			return new ChillerRecipe(groupIn, /* tabIn, */ inputItemsIn, fluid, outputIn, container, experienceIn,
					cookTimeIn);
		}

		public static void toNetwork(RegistryFriendlyByteBuf buffer, ChillerRecipe recipe) {
			buffer.writeUtf(recipe.group);
//			buffer.writeUtf(recipe.tab != null ? recipe.tab.toString() : "");
			buffer.writeVarInt(recipe.inputItems.size());

			for (Ingredient ingredient : recipe.inputItems) {
				Ingredient.CONTENTS_STREAM_CODEC.encode(buffer, ingredient);
			}

			FluidStack.STREAM_CODEC.encode(buffer, recipe.fluid);

			ItemStack.STREAM_CODEC.encode(buffer, recipe.output);
			ItemStack.OPTIONAL_STREAM_CODEC.encode(buffer, recipe.container);
			buffer.writeFloat(recipe.experience);
			buffer.writeVarInt(recipe.cookTime);
		}

		@Override
		public MapCodec<ChillerRecipe> codec() {
			return CODEC;
		}

		public static final StreamCodec<RegistryFriendlyByteBuf, ChillerRecipe> STREAM_CODEC = StreamCodec
				.of(ChillerRecipe.Serializer::toNetwork, ChillerRecipe.Serializer::fromNetwork);

		@Override
		public StreamCodec<RegistryFriendlyByteBuf, ChillerRecipe> streamCodec() {
			return STREAM_CODEC;
		}

	}

}
