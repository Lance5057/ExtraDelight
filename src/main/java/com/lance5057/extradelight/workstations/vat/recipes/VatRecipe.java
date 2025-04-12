package com.lance5057.extradelight.workstations.vat.recipes;

import com.lance5057.extradelight.ExtraDelightRecipes;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.util.RecipeMatcher;
import net.neoforged.neoforge.fluids.crafting.SizedFluidIngredient;

public class VatRecipe implements Recipe<VatRecipeWrapper> {
	protected final int cookTime;

	public int getCookTime() {
		return cookTime;
	}

	final ItemStack containerItem;

	final String group;
	final ItemStack result;
	final NonNullList<Ingredient> ingredients;
	final NonNullList<Ingredient> stageIngredients;
	final SizedFluidIngredient fluid;

	protected final int stages;

	public int getStages() {
		return stages;
	}

	public VatRecipe(String pGroup, NonNullList<Ingredient> pIngredients, NonNullList<Ingredient> pStageIngredients,
			SizedFluidIngredient pFluids, ItemStack pResult, int time, int stages, ItemStack usedItem) {
		this.cookTime = time;
		this.containerItem = usedItem;
		this.group = pGroup;
		this.result = pResult;

		this.ingredients = pIngredients;
		this.stageIngredients = pStageIngredients;
		this.fluid = pFluids;
		this.stages = stages;
	}

	public String getGroup() {
		return this.group;
	}

	public NonNullList<Ingredient> getIngredients() {
		return this.ingredients;
	}

	public NonNullList<Ingredient> getStageIngredients() {
		return this.stageIngredients;
	}

	public SizedFluidIngredient getFluid() {
		return this.fluid;
	}

	@Override
	public boolean matches(VatRecipeWrapper input, Level level) {
		StackedContents stackedcontents = new StackedContents();
		java.util.List<ItemStack> inputs = new java.util.ArrayList<>();
		int i = 0;

		for (int j = 0; j < 9; ++j) {
			ItemStack itemstack = input.getItem(j);
			if (!itemstack.isEmpty()) {
				++i;
//				if (isSimple)
//					stackedcontents.accountStack(itemstack, 1);
//				else
				inputs.add(itemstack);
			}
		}

		return i == this.ingredients.size() && RecipeMatcher.findMatches(inputs, this.ingredients) != null
				&& fluid.test(input.getTank().getFluid()) && ItemStack.isSameItem(containerItem, input.getItem(9))
				&& input.getItem(9).getCount() >= containerItem.getCount();
	}

	/**
	 * Returns an Item that is the result of this recipe
	 */
	public ItemStack assemble(SimpleContainer pInv, RegistryAccess p_267165_) {
		return this.result.copy();
	}

	/**
	 * Used to determine if this recipe can fit in a grid of the given width/height
	 */
	public boolean canCraftInDimensions(int pWidth, int pHeight) {
		return pWidth * pHeight >= this.ingredients.size();
	}

	public RecipeSerializer<?> getSerializer() {
		return ExtraDelightRecipes.VAT_SERIALIZER.get();
	}

	public int getStirs() {
		return cookTime;
	}

	public ItemStack getUsedItem() {
		return this.containerItem;
	}

	@Override
	public ItemStack assemble(VatRecipeWrapper input, Provider registries) {
		return this.result.copy();
	}

	@Override
	public ItemStack getResultItem(Provider registries) {
		return this.result;
	}

	@Override
	public RecipeType<?> getType() {
		// TODO Auto-generated method stub
		return ExtraDelightRecipes.MIXING_BOWL.get();
	}

	public static class Serializer implements RecipeSerializer<VatRecipe> {
		private static final MapCodec<VatRecipe> CODEC = RecordCodecBuilder
				.mapCodec(inst -> inst.group(Codec.STRING.optionalFieldOf("group", "").forGetter(VatRecipe::getGroup),

						Ingredient.LIST_CODEC.fieldOf("ingredients").xmap(ing -> {
							NonNullList<Ingredient> nonNullList = NonNullList.create();
							nonNullList.addAll(ing);
							return nonNullList;
						}, ing -> ing).forGetter(VatRecipe::getIngredients),

						Ingredient.LIST_CODEC.fieldOf("stage_ingredients").xmap(ing -> {
							NonNullList<Ingredient> nonNullList = NonNullList.create();
							nonNullList.addAll(ing);
							return nonNullList;
						}, ing -> ing).forGetter(VatRecipe::getStageIngredients),

						SizedFluidIngredient.FLAT_CODEC.fieldOf("fluids").forGetter(VatRecipe::getFluid),

						ItemStack.CODEC.fieldOf("result").forGetter(r -> r.result),

						Codec.INT.optionalFieldOf("time", 24000).forGetter(r -> r.cookTime),
						Codec.INT.optionalFieldOf("stages", 1).forGetter(r -> r.cookTime),

						ItemStack.CODEC.optionalFieldOf("usedItem", ItemStack.EMPTY).forGetter(r -> r.containerItem))
						.apply(inst, VatRecipe::new));

		public static VatRecipe fromNetwork(RegistryFriendlyByteBuf pBuffer) {
			String s = pBuffer.readUtf();
			int i = pBuffer.readVarInt();
			NonNullList<Ingredient> nonnulllist = NonNullList.withSize(i, Ingredient.EMPTY);

			for (int j = 0; j < nonnulllist.size(); ++j) {
				nonnulllist.set(j, Ingredient.CONTENTS_STREAM_CODEC.decode(pBuffer));
			}

			NonNullList<Ingredient> nonnulllist2 = NonNullList.withSize(i, Ingredient.EMPTY);

			for (int j = 0; j < nonnulllist2.size(); ++j) {
				nonnulllist2.set(j, Ingredient.CONTENTS_STREAM_CODEC.decode(pBuffer));
			}

			SizedFluidIngredient f = SizedFluidIngredient.STREAM_CODEC.decode(pBuffer);

			ItemStack itemstack = ItemStack.OPTIONAL_STREAM_CODEC.decode(pBuffer);
			int stirs = pBuffer.readVarInt();
			int stages = pBuffer.readVarInt();
			ItemStack usedItem = ItemStack.OPTIONAL_STREAM_CODEC.decode(pBuffer);
			return new VatRecipe(s, nonnulllist, nonnulllist2, f, itemstack, stirs, stages, usedItem);
		}

		public static void toNetwork(RegistryFriendlyByteBuf pBuffer, VatRecipe pRecipe) {
			pBuffer.writeUtf(pRecipe.getGroup());
			pBuffer.writeVarInt(pRecipe.getIngredients().size());

			for (Ingredient ingredient : pRecipe.getIngredients()) {
				Ingredient.CONTENTS_STREAM_CODEC.encode(pBuffer, ingredient);
			}

			for (Ingredient ingredient : pRecipe.stageIngredients) {
				Ingredient.CONTENTS_STREAM_CODEC.encode(pBuffer, ingredient);
			}

			SizedFluidIngredient.STREAM_CODEC.encode(pBuffer, pRecipe.getFluid());

			ItemStack.OPTIONAL_STREAM_CODEC.encode(pBuffer, pRecipe.result);
			pBuffer.writeVarInt(pRecipe.getStirs());
			pBuffer.writeVarInt(pRecipe.getStages());
			ItemStack.OPTIONAL_STREAM_CODEC.encode(pBuffer, pRecipe.getUsedItem());

		}

		@Override
		public MapCodec<VatRecipe> codec() {
			// TODO Auto-generated method stub
			return CODEC;
		}

		public static final StreamCodec<RegistryFriendlyByteBuf, VatRecipe> STREAM_CODEC = StreamCodec
				.of(VatRecipe.Serializer::toNetwork, VatRecipe.Serializer::fromNetwork);

		@Override
		public StreamCodec<RegistryFriendlyByteBuf, VatRecipe> streamCodec() {
			// TODO Auto-generated method stub
			return STREAM_CODEC;
		}
	}
}