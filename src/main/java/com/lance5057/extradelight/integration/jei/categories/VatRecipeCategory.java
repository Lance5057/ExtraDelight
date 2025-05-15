package com.lance5057.extradelight.integration.jei.categories;

import java.util.List;

import org.jetbrains.annotations.Nullable;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.ExtraDelightItems;
import com.lance5057.extradelight.util.BottleFluidRegistry;
import com.lance5057.extradelight.workstations.vat.recipes.VatRecipe;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.neoforge.NeoForgeTypes;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

public class VatRecipeCategory implements IRecipeCategory<VatRecipe> {
	public static final RecipeType<VatRecipe> TYPE = RecipeType.create(ExtraDelight.MOD_ID, "vat", VatRecipe.class);
	private final IDrawable background;
	private final IDrawable stage;
	private final IDrawable finish;
	private final Component localizedName;
	private final IDrawable icon;

	public VatRecipeCategory(IGuiHelper guiHelper) {
		background = guiHelper.createDrawable(
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "textures/gui/jei3.png"), 0, 0, 101, 47);
		stage = guiHelper.createDrawable(
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "textures/gui/jei3.png"), 0, 47, 101, 32);
		finish = guiHelper.createDrawable(
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "textures/gui/jei3.png"), 0, 78, 101, 33);
		localizedName = Component.translatable("extradelight.jei.vat");
		icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ExtraDelightItems.VAT.get()));
	}

	@Override
	public RecipeType<VatRecipe> getRecipeType() {
		return TYPE;
	}

	@Override
	public Component getTitle() {
		return localizedName;
	}

	@Override
	public @Nullable IDrawable getIcon() {
		return icon;
	}

	@Override
	public int getWidth() {
		return 101;
	}

	@Override
	public int getHeight() {
		return 47 + (32 * 3);
	}

	public void draw(VatRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX,
			double mouseY) {
		Minecraft minecraft = Minecraft.getInstance();
		Font fontRenderer = minecraft.font;

		background.draw(guiGraphics, 0, 0);

		for (int i = 0; i < recipe.getStages(); i++)
			stage.draw(guiGraphics, 0, 47 + (i * 32));

		finish.draw(guiGraphics, 0, 57 + (recipe.getStages() * 32));

		guiGraphics.drawString(fontRenderer, recipe.getStages() + "", 0, 0, 0xFFFFFFFF);
	}

	@Override
	public void setRecipe(IRecipeLayoutBuilder builder, VatRecipe recipe, IFocusGroup focuses) {

		for (int i = 0; i < recipe.getIngredients().size(); i++) {
			if (i < 3)
				builder.addSlot(RecipeIngredientRole.INPUT, 48 + i % 3 * 18, 1)
						.addIngredients(recipe.getIngredients().get(i));
			else
				builder.addSlot(RecipeIngredientRole.INPUT, 48 + i % 3 * 18, 19)
						.addIngredients(recipe.getIngredients().get(i));
		}

		builder.addSlot(RecipeIngredientRole.INPUT, this.getWidth() / 2 - 25, 1)
				.addIngredients(NeoForgeTypes.FLUID_STACK, List.of(recipe.getFluid().getFluids()))
				.setFluidRenderer(1000, false, 16, 34);

		builder.addSlot(RecipeIngredientRole.INPUT, 1, 10)
				.addIngredients(Ingredient.of(BottleFluidRegistry.getBottleFromFluid(recipe.getFluid().getFluids()[0]),
						new ItemStack(recipe.getFluid().getFluids()[0].getFluid().getBucket())));

		for (int i = 0; i < recipe.getStages(); i++) {
			builder.addSlot(RecipeIngredientRole.INPUT, 47, 59 + i * 32)
					.addIngredients(recipe.getStageIngredients().get(i).ingredient);

			if (recipe.getStageIngredients().get(i).lid)
				builder.addSlot(RecipeIngredientRole.INPUT, 66, 59 + i * 32)
						.addIngredients(Ingredient.of(ExtraDelightItems.LID.get()));
		}

		builder.addSlot(RecipeIngredientRole.CATALYST, 85, (recipe.getStages() * 32) + 62)
				.addIngredients(Ingredient.of(recipe.getUsedItem()));

		builder.addSlot(RecipeIngredientRole.OUTPUT, 59, (recipe.getStages() * 32) + 62)
				.addIngredients(Ingredient.of(recipe.getResultItem(null)));
	}

}
