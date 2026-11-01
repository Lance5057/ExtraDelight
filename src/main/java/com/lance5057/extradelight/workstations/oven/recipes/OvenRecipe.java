package com.lance5057.extradelight.workstations.oven.recipes;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.ExtraDelightItems;
import com.lance5057.extradelight.ExtraDelightRecipes;
import com.lance5057.extradelight.items.dynamicfood.DynamicContainerFeastItem;
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
import net.neoforged.neoforge.items.wrapper.RecipeWrapper;
import vectorwing.farmersdelight.common.item.component.ItemStackWrapper;
import vectorwing.farmersdelight.common.registry.ModDataComponents;

public class OvenRecipe implements Recipe<RecipeWrapper> {
	public static final int INPUT_SLOTS = 9;
    public static final int CONTAINER_SLOT = 10;

    private final String group;
//	private final OvenRecipeBookTab tab;
	private final NonNullList<Ingredient> inputItems;
	public final ItemStack output;
	private final ItemStack container;
	private final float experience;
	private final int cookTime;
	private final boolean consumeContainer;

	public OvenRecipe(String group, /* @Nullable OvenRecipeBookTab tab, */ NonNullList<Ingredient> inputItems,
			ItemStack output, ItemStack container, float experience, int cookTime, boolean consumeContainer) {
		this.group = group;
//		this.tab = tab;
		this.inputItems = inputItems;
		this.output = output;

		if (!container.isEmpty()) {
			this.container = container;
		} else {
			this.container = ItemStack.EMPTY;
		}

		this.experience = experience;
		this.cookTime = cookTime;
		this.consumeContainer = consumeContainer;
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

	public boolean shouldConsumeContainer() {
		return this.consumeContainer;
	}

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
	public ItemStack assemble(RecipeWrapper recipeWrapper, Provider registries) {
		ItemStack result = output.copy();
        if(result.getItem() instanceof DynamicContainerFeastItem && !recipeWrapper.getItem(CONTAINER_SLOT).isEmpty()){
            result.set(ModDataComponents.CONTAINER.get(), new ItemStackWrapper(recipeWrapper.getItem(CONTAINER_SLOT).copyWithCount(1)));
        }
        return result;
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
		return i == this.inputItems.size() && RecipeMatcher.findMatches(inputs, this.inputItems) != null
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

		private static final MapCodec<OvenRecipe> CODEC = RecordCodecBuilder
				.mapCodec(inst -> inst.group(Codec.STRING.optionalFieldOf("group", "").forGetter(OvenRecipe::getGroup),
						Ingredient.LIST_CODEC_NONEMPTY.fieldOf("ingredients").xmap(ingredients -> {
							NonNullList<Ingredient> nonNullList = NonNullList.create();
							nonNullList.addAll(ingredients);
							return nonNullList;
						}, ingredients -> ingredients).forGetter(OvenRecipe::getIngredients),
						ItemStack.CODEC.fieldOf("result").forGetter(r -> r.output),
						ItemStack.CODEC.lenientOptionalFieldOf("container", ItemStack.EMPTY)
								.forGetter(OvenRecipe::getContainerOverride),
						Codec.FLOAT.optionalFieldOf("experience", 0.0F).forGetter(OvenRecipe::getExperience),
						Codec.INT.lenientOptionalFieldOf("cookingtime", 200).forGetter(OvenRecipe::getCookTime),
						Codec.BOOL.fieldOf("consumeContainer").forGetter(OvenRecipe::shouldConsumeContainer))
						.apply(inst, OvenRecipe::new));

		public static OvenRecipe fromNetwork(RegistryFriendlyByteBuf buffer) {
			String groupIn = buffer.readUtf();
//			OvenRecipeBookTab tabIn = OvenRecipeBookTab.findByName(buffer.readUtf());
			int i = buffer.readVarInt();
			NonNullList<Ingredient> inputItemsIn = NonNullList.withSize(i, Ingredient.EMPTY);

			for (int j = 0; j < inputItemsIn.size(); ++j) {
				inputItemsIn.set(j, Ingredient.CONTENTS_STREAM_CODEC.decode(buffer));
			}

			ItemStack outputIn = ItemStack.STREAM_CODEC.decode(buffer);
			ItemStack container = ItemStack.STREAM_CODEC.decode(buffer);
			float experienceIn = buffer.readFloat();
			int cookTimeIn = buffer.readVarInt();
			boolean consume = buffer.readBoolean();
			return new OvenRecipe(groupIn, inputItemsIn, outputIn, container, experienceIn, cookTimeIn, consume);
		}

		public static void toNetwork(RegistryFriendlyByteBuf buffer, OvenRecipe recipe) {
			buffer.writeUtf(recipe.group);
//			buffer.writeUtf(recipe.tab != null ? recipe.tab.toString() : "");
			buffer.writeVarInt(recipe.inputItems.size());

			for (Ingredient ingredient : recipe.inputItems) {
				Ingredient.CONTENTS_STREAM_CODEC.encode(buffer, ingredient);
			}

			ItemStack.STREAM_CODEC.encode(buffer, recipe.output);
			ItemStack.STREAM_CODEC.encode(buffer, recipe.container);
			buffer.writeFloat(recipe.experience);
			buffer.writeVarInt(recipe.cookTime);
			buffer.writeBoolean(recipe.consumeContainer);
		}

		@Override
		public MapCodec<OvenRecipe> codec() {
			return CODEC;
		}

		public static final StreamCodec<RegistryFriendlyByteBuf, OvenRecipe> STREAM_CODEC = StreamCodec
				.of(OvenRecipe.Serializer::toNetwork, OvenRecipe.Serializer::fromNetwork);

		@Override
		public StreamCodec<RegistryFriendlyByteBuf, OvenRecipe> streamCodec() {
			return STREAM_CODEC;
		}

	}

}
