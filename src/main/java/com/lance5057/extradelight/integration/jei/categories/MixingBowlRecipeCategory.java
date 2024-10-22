package com.lance5057.extradelight.integration.jei.categories;

import java.util.Arrays;
import java.util.List;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.ExtraDelightItems;
import com.lance5057.extradelight.ExtraDelightTags;
import com.lance5057.extradelight.workstations.mixingbowl.recipes.MixingBowlRecipe;
import com.mojang.blaze3d.systems.RenderSystem;

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
import net.minecraft.world.phys.Vec2;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.crafting.SizedFluidIngredient;

public class MixingBowlRecipeCategory implements IRecipeCategory<MixingBowlRecipe> {
	public static final RecipeType<MixingBowlRecipe> TYPE = RecipeType.create(ExtraDelight.MOD_ID, "mixingbowl",
			MixingBowlRecipe.class);
	private final IDrawable background;
	private final Component localizedName;
	private final IDrawable icon;

	public MixingBowlRecipeCategory(IGuiHelper guiHelper) {
		background = guiHelper.createDrawable(
				ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "textures/gui/jei.png"), 132, 0, 124, 74);
		localizedName = Component.translatable("extradelight.jei.mixingbowl");
		icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK,
				new ItemStack(ExtraDelightItems.MIXING_BOWL.get()));
	}

	@Override
	public RecipeType<MixingBowlRecipe> getRecipeType() {
		return TYPE;
	}

	@Override
	public Component getTitle() {
		return localizedName;
	}

	@Override
	public IDrawable getBackground() {
		return background;
	}

	@Override
	public IDrawable getIcon() {
		return icon;
	}

	@Override
	public void setRecipe(IRecipeLayoutBuilder builder, MixingBowlRecipe recipe, IFocusGroup focuses) {
		List<Ingredient> input = recipe.getIngredients();
		Ingredient pestle = Ingredient.of(ExtraDelightTags.SPOONS);
		ItemStack used = recipe.getUsedItem();
		ItemStack output = recipe.getResultItem(Minecraft.getInstance().level.registryAccess());

		int x = 0;
		int y = 0;
		for (Ingredient i : input) {
			builder.addSlot(RecipeIngredientRole.INPUT, x * 18 + 24, y * 18 + 11).addIngredients(i);
			x++;
			if (x >= 3) {
				y++;
				x = 0;
			}
		}
		builder.addSlot(RecipeIngredientRole.CATALYST, this.getWidth() / 2 + 16, 12).addIngredients(pestle);
		builder.addSlot(RecipeIngredientRole.CATALYST, this.getWidth() / 2 + 20, 52).addItemStack(used);

		builder.addSlot(RecipeIngredientRole.OUTPUT, this.getWidth() / 2 + 45, 29).addItemStack(output);

		int off = 0;
		for (SizedFluidIngredient i : recipe.getFluids()) {
			builder.addSlot(RecipeIngredientRole.OUTPUT, this.getWidth() / 2 - 61, 61 - (off*12))
					.addIngredients(NeoForgeTypes.FLUID_STACK, Arrays.asList(i.getFluids()))
					.setFluidRenderer(i.amount(), false, 16, 12);
			off++;
		}
	}

	@Override
	public void draw(MixingBowlRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX,
			double mouseY) {
		RenderSystem.enableBlend();

		Minecraft minecraft = Minecraft.getInstance();
		Font fontRenderer = minecraft.font;
		guiGraphics.drawString(fontRenderer, "x" + recipe.getStirs(), this.getWidth() / 2 + 32, 20, 0xffffff);

		RenderSystem.disableBlend();
	}

	public static Vec2 getNextPointOnCircle(Vec2 center, Vec2 lastPoint, float angle) {
		double nextX = center.x + 25 * Math.cos(Math.toRadians(angle));
		double nextY = center.y + 25 * Math.sin(Math.toRadians(angle));
		return new Vec2((float) nextX, (float) nextY);
	}
}