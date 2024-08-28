package com.lance5057.extradelight.workstations.mixingbowl.recipes;

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
import net.neoforged.neoforge.items.wrapper.RecipeWrapper;

public class MixingBowlRecipe implements Recipe<RecipeWrapper> {
	protected final int stirs;
	final ItemStack usedItem;

	final String group;
	final ItemStack result;
	final NonNullList<Ingredient> ingredients;
//	private final boolean isSimple;

	public MixingBowlRecipe(String pGroup, NonNullList<Ingredient> pIngredients, ItemStack pResult, int stirs,
			ItemStack usedItem) {
		this.stirs = stirs;
		this.usedItem = usedItem;
		this.group = pGroup;
		this.result = pResult;
		this.ingredients = pIngredients;
//		this.isSimple = pIngredients.stream().allMatch(Ingredient::isSimple);
	}

	public String getGroup() {
		return this.group;
	}

	public NonNullList<Ingredient> getIngredients() {
		return this.ingredients;
	}

	@Override
	public boolean matches(RecipeWrapper input, Level level) {
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
				&& ItemStack.isSameItem(usedItem, input.getItem(9)) && input.getItem(9).getCount() >= usedItem.getCount();
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
		return ExtraDelightRecipes.MIXING_BOWL_SERIALIZER.get();
	}

	public int getStirs() {
		return stirs;
	}

	public ItemStack getUsedItem() {
		return this.usedItem;
	}

	@Override
	public ItemStack assemble(RecipeWrapper input, Provider registries) {
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

	public static class Serializer implements RecipeSerializer<MixingBowlRecipe> {
		private static final MapCodec<MixingBowlRecipe> CODEC = RecordCodecBuilder.mapCodec(
				inst -> inst.group(Codec.STRING.optionalFieldOf("group", "").forGetter(MixingBowlRecipe::getGroup),

						Ingredient.LIST_CODEC_NONEMPTY.fieldOf("ingredients").xmap(ingredients -> {
							NonNullList<Ingredient> nonNullList = NonNullList.create();
							nonNullList.addAll(ingredients);
							return nonNullList;
						}, ingredients -> ingredients).forGetter(MixingBowlRecipe::getIngredients),

						ItemStack.CODEC.fieldOf("result").forGetter(r -> r.result),

						Codec.INT.optionalFieldOf("stirs", 100).forGetter(r -> r.stirs),

						ItemStack.CODEC.optionalFieldOf("usedItem", ItemStack.EMPTY).forGetter(r -> r.usedItem))
						.apply(inst, MixingBowlRecipe::new));

		public static MixingBowlRecipe fromNetwork(RegistryFriendlyByteBuf pBuffer) {
			String s = pBuffer.readUtf();
			int i = pBuffer.readVarInt();
			NonNullList<Ingredient> nonnulllist = NonNullList.withSize(i, Ingredient.EMPTY);

			for (int j = 0; j < nonnulllist.size(); ++j) {
				nonnulllist.set(j, Ingredient.CONTENTS_STREAM_CODEC.decode(pBuffer));
			}

			ItemStack itemstack = ItemStack.OPTIONAL_STREAM_CODEC.decode(pBuffer);
			int stirs = pBuffer.readVarInt();
			ItemStack usedItem = ItemStack.OPTIONAL_STREAM_CODEC.decode(pBuffer);
			return new MixingBowlRecipe(s, nonnulllist, itemstack, stirs, usedItem);
		}

		public static void toNetwork(RegistryFriendlyByteBuf pBuffer, MixingBowlRecipe pRecipe) {
			pBuffer.writeUtf(pRecipe.getGroup());
			pBuffer.writeVarInt(pRecipe.getIngredients().size());

			for (Ingredient ingredient : pRecipe.getIngredients()) {
				Ingredient.CONTENTS_STREAM_CODEC.encode(pBuffer, ingredient);
			}

			ItemStack.OPTIONAL_STREAM_CODEC.encode(pBuffer, pRecipe.result);
			pBuffer.writeVarInt(pRecipe.getStirs());
			ItemStack.OPTIONAL_STREAM_CODEC.encode(pBuffer, pRecipe.getUsedItem());

		}

		@Override
		public MapCodec<MixingBowlRecipe> codec() {
			// TODO Auto-generated method stub
			return CODEC;
		}

		public static final StreamCodec<RegistryFriendlyByteBuf, MixingBowlRecipe> STREAM_CODEC = StreamCodec
				.of(MixingBowlRecipe.Serializer::toNetwork, MixingBowlRecipe.Serializer::fromNetwork);

		@Override
		public StreamCodec<RegistryFriendlyByteBuf, MixingBowlRecipe> streamCodec() {
			// TODO Auto-generated method stub
			return STREAM_CODEC;
		}
	}

}