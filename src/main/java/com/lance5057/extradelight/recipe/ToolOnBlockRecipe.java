package com.lance5057.extradelight.recipe;

import com.lance5057.extradelight.ExtraDelightRecipes;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.items.wrapper.RecipeWrapper;

public class ToolOnBlockRecipe implements Recipe<SimpleRecipeWrapper> {

	protected final Ingredient tool;

	public Ingredient getTool() {
		return tool;
	}

	public BlockItem getIn() {
		return in;
	}

	public BlockItem getOut() {
		return out;
	}

	protected final BlockItem in;
	protected final BlockItem out;

	public ToolOnBlockRecipe(BlockItem in, Ingredient tool, BlockItem out) {
		this.tool = tool;
		this.in = in;
		this.out = out;
	}

	public ToolOnBlockRecipe(ItemStack in, Ingredient tool, ItemStack out) {
		this.tool = tool;
		this.in = (BlockItem) in.getItem();
		this.out = (BlockItem) out.getItem();
	}

	@Override
	public boolean canCraftInDimensions(int pWidth, int pHeight) {
		return true;
	}

	public Block getResultBlock() {
		return out.getBlock();
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return ExtraDelightRecipes.TOOL_ON_BLOCK_SERIALIZER.get();
	}

	@Override
	public RecipeType<?> getType() {
		return ExtraDelightRecipes.TOOL_ON_BLOCK.get();
	}

	@Override
	public boolean matches(SimpleRecipeWrapper input, Level level) {
		if (tool.test(input.getItem(0)))
			return this.in == input.getItem(1).getItem();
		return false;
	}

	@Override
	public ItemStack assemble(SimpleRecipeWrapper input, Provider registries) {
		// TODO Auto-generated method stub
		return new ItemStack(out);
	}

	@Override
	public ItemStack getResultItem(Provider registries) {
		// TODO Auto-generated method stub
		return new ItemStack(out);
	}

	public static class Serializer implements RecipeSerializer<ToolOnBlockRecipe> {
		private static final MapCodec<ToolOnBlockRecipe> CODEC = RecordCodecBuilder
				.mapCodec(
						inst -> inst
								.group(ItemStack.SINGLE_ITEM_CODEC.fieldOf("in").forGetter(r -> new ItemStack(r.in)),
										Ingredient.CODEC_NONEMPTY.fieldOf("ingredient")
												.forGetter(p_301068_ -> p_301068_.tool),
										ItemStack.SINGLE_ITEM_CODEC.fieldOf("out").forGetter(r -> new ItemStack(r.out)))
								.apply(inst, ToolOnBlockRecipe::new));

		public static ToolOnBlockRecipe fromNetwork(RegistryFriendlyByteBuf pBuffer) {
			Ingredient ingredient = Ingredient.CONTENTS_STREAM_CODEC.decode(pBuffer);
			BlockItem bIn = (BlockItem) ItemStack.STREAM_CODEC.decode(pBuffer).getItem();
			BlockItem bOut = (BlockItem) ItemStack.STREAM_CODEC.decode(pBuffer).getItem();
			return new ToolOnBlockRecipe(bIn, ingredient, bOut);
		}

		public static void toNetwork(RegistryFriendlyByteBuf pBuffer, ToolOnBlockRecipe pRecipe) {
			Ingredient.CONTENTS_STREAM_CODEC.encode(pBuffer, pRecipe.tool);
			ItemStack.STREAM_CODEC.encode(pBuffer, new ItemStack(pRecipe.in));
			ItemStack.STREAM_CODEC.encode(pBuffer, new ItemStack(pRecipe.out));
		}

		@Override
		public MapCodec<ToolOnBlockRecipe> codec() {
			return CODEC;
		}

		public static final StreamCodec<RegistryFriendlyByteBuf, ToolOnBlockRecipe> STREAM_CODEC = StreamCodec
				.of(ToolOnBlockRecipe.Serializer::toNetwork, ToolOnBlockRecipe.Serializer::fromNetwork);

		@Override
		public StreamCodec<RegistryFriendlyByteBuf, ToolOnBlockRecipe> streamCodec() {
			return STREAM_CODEC;
		}
	}

}
