package com.lance5057.extradelight.integration.jei.categories;

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
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.phys.Vec2;

public class MixingBowlRecipeCategory implements IRecipeCategory<MixingBowlRecipe> {
	public static final RecipeType<MixingBowlRecipe> TYPE = RecipeType.create(ExtraDelight.MOD_ID, "mixingbowl",
			MixingBowlRecipe.class);
	private final IDrawable background;
	private final Component localizedName;
	private final IDrawable icon;

	public MixingBowlRecipeCategory(IGuiHelper guiHelper) {
		background = guiHelper.createDrawable(ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "textures/gui/jei.png"), 156, 0,
				100, 100);
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

		float angle = -90;
		Vec2 center = new Vec2(42, 34);
		Vec2 point = getNextPointOnCircle(center, new Vec2(42, 34 - 25), angle);

		for (Ingredient i : input) {
			builder.addSlot(RecipeIngredientRole.INPUT, (int) point.x, (int) point.y).addIngredients(i);

			angle += 360 / input.size();
			point = getNextPointOnCircle(center, point, angle);

		}
		builder.addSlot(RecipeIngredientRole.CATALYST, this.getWidth() / 2 + 12, 83).addIngredients(pestle);
		builder.addSlot(RecipeIngredientRole.CATALYST, this.getWidth() / 2 - 35, 83).addItemStack(used);
		// builder.addSlot(RecipeIngredientRole.CATALYST, (int) center.x, (int)
		// center.y).addIngredients(pestle);
		builder.addSlot(RecipeIngredientRole.OUTPUT, this.getWidth() / 2 - 8, 83).addItemStack(output);
	}

	@Override
	public void draw(MixingBowlRecipe recipe,IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
		RenderSystem.enableBlend();

		Minecraft minecraft = Minecraft.getInstance();
		Font fontRenderer = minecraft.font;
		guiGraphics.drawString(fontRenderer, "x" + recipe.getStirs(), this.getWidth() / 2 + 30, 90, 0);

		RenderSystem.disableBlend();
	}

	public static Vec2 getNextPointOnCircle(Vec2 center, Vec2 lastPoint, float angle) {
		double nextX = center.x + 25 * Math.cos(Math.toRadians(angle));
		double nextY = center.y + 25 * Math.sin(Math.toRadians(angle));
		return new Vec2((float) nextX, (float) nextY);
	}
}