package com.lance5057.extradelight.recipe;

import com.google.gson.JsonObject;
import com.lance5057.extradelight.ExtraDelightRecipes;

import net.minecraft.core.Registry;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

public class ToolOnBlockRecipe implements Recipe<Container> {

	protected final ResourceLocation id;
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

	public ToolOnBlockRecipe(ResourceLocation pId, BlockItem in, Ingredient tool, BlockItem out) {
		this.id = pId;
		this.tool = tool;
		this.in = in;
		this.out = out;
	}

	@Override
	public boolean matches(Container pContainer, Level pLevel) {
		if (tool.test(pContainer.getItem(0)))
			return this.in == pContainer.getItem(1).getItem();
		return false;
	}

	public static class Serializer implements RecipeSerializer<ToolOnBlockRecipe> {
		@Override
		public ToolOnBlockRecipe fromJson(ResourceLocation pRecipeId, JsonObject pJson) {
			Ingredient ingredient;
			if (GsonHelper.isArrayNode(pJson, "ingredient")) {
				ingredient = Ingredient.fromJson(GsonHelper.getAsJsonArray(pJson, "ingredient"));
			} else {
				ingredient = Ingredient.fromJson(GsonHelper.getAsJsonObject(pJson, "ingredient"));
			}

			BlockItem bIn = (BlockItem) GsonHelper.getAsItem(pJson, "blockIn");
			BlockItem bOut = (BlockItem) GsonHelper.getAsItem(pJson, "blockOut");

			return new ToolOnBlockRecipe(pRecipeId, bIn, ingredient, bOut);
		}

		public ToolOnBlockRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
			Ingredient ingredient = Ingredient.fromNetwork(pBuffer);
			BlockItem bIn = (BlockItem) pBuffer.readById(Registry.ITEM);
			BlockItem bOut = (BlockItem) pBuffer.readById(Registry.ITEM);
			return new ToolOnBlockRecipe(pRecipeId, bIn, ingredient, bOut);
		}

		public void toNetwork(FriendlyByteBuf pBuffer, ToolOnBlockRecipe pRecipe) {
			pRecipe.tool.toNetwork(pBuffer);
			pBuffer.writeId(Registry.ITEM, pRecipe.in);
			pBuffer.writeId(Registry.ITEM, pRecipe.out);
		}
	}

	@Override
	public ItemStack assemble(Container pContainer) {
		return new ItemStack(out);
	}

	@Override
	public boolean canCraftInDimensions(int pWidth, int pHeight) {
		return true;
	}

	@Override
	public ItemStack getResultItem() {
		return new ItemStack(out);
	}
	
	public Block getResultBlock()
	{
		return out.getBlock();
	}

	@Override
	public ResourceLocation getId() {
		return this.id;
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return ExtraDelightRecipes.TOOL_ON_BLOCK_SERIALIZER.get();
	}

	@Override
	public RecipeType<?> getType() {
		return ExtraDelightRecipes.TOOL_ON_BLOCK.get();
	}
}
