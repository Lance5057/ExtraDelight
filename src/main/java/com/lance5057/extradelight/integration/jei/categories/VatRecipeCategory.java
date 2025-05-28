package com.lance5057.extradelight.integration.jei.categories;

import java.text.DecimalFormat;
import java.util.List;

import org.jetbrains.annotations.Nullable;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.ExtraDelightItems;
import com.lance5057.extradelight.modules.Fermentation;
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
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "textures/gui/jei3.png"), 0, 47, 101, 31);
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

		for (int i = 0; i < recipe.getStages(); i++) {
			stage.draw(guiGraphics, 0, 47 + (i * 31));
			guiGraphics.drawString(fontRenderer, Component.translatable("extradelight.jei.info.vat.stage", (i + 1)), 0,
					49 + (i * 31), 0xFFFFFFFF);

			if (recipe.getStageIngredients().get(i).lid)
				guiGraphics.drawString(fontRenderer, Component.translatable("extradelight.jei.info.vat.lid.on"), 0,
						58 + (i * 31), 0xFFFF5555);
			else
				guiGraphics.drawString(fontRenderer, Component.translatable("extradelight.jei.info.vat.lid.off"), 0,
						58 + (i * 31), 0xFFFFFFFF);

			float f = ((float) recipe.getStageIngredients().get(i).time / (float) Fermentation.dayTick);
			DecimalFormat df = new DecimalFormat("##.##");
			if (f > 1 || f < 1)
				guiGraphics.drawString(fontRenderer, Component.translatable("extradelight.jei.info.vat.days", df.format(f)), 0,
						67 + (i * 31), 0xFFFFFFFF);
			else
				guiGraphics.drawString(fontRenderer, Component.translatable("extradelight.jei.info.vat.day", df.format(f)), 0,
						67 + (i * 31), 0xFFFFFFFF);
		}

		finish.draw(guiGraphics, 0, 46 + (recipe.getStages() * 31));

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

		builder.addSlot(RecipeIngredientRole.CATALYST, this.getWidth() / 2 - 25, 1)
				.addIngredients(NeoForgeTypes.FLUID_STACK, List.of(recipe.getFluid().getFluids()))
				.setFluidRenderer(1000, false, 16, 34);

		builder.addSlot(RecipeIngredientRole.CATALYST, 1, 10)
				.addIngredients(Ingredient.of(BottleFluidRegistry.getBottleFromFluid(recipe.getFluid().getFluids()[0]),
						new ItemStack(recipe.getFluid().getFluids()[0].getFluid().getBucket())));

		for (int i = 0; i < recipe.getStages(); i++) {
			builder.addSlot(RecipeIngredientRole.CATALYST, 58, 59 + i * 31)
					.addIngredients(recipe.getStageIngredients().get(i).ingredient);

//			if (recipe.getStageIngredients().get(i).lid)
//				builder.addSlot(RecipeIngredientRole.INPUT, 84, 59 + i * 31)
//						.addIngredients(Ingredient.of(ExtraDelightItems.LID.get()));
		}

		builder.addSlot(RecipeIngredientRole.INPUT, 84, (recipe.getStages() * 31) + 62)
				.addIngredients(Ingredient.of(recipe.getUsedItem()));

		builder.addSlot(RecipeIngredientRole.OUTPUT, 58, (recipe.getStages() * 31) + 62)
				.addIngredients(Ingredient.of(recipe.getResultItem(null)));
	}

}
