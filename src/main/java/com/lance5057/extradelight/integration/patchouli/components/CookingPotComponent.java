package com.lance5057.extradelight.integration.patchouli.components;

import java.util.List;
import java.util.function.UnaryOperator;

import com.google.common.collect.ImmutableList;
import com.google.gson.annotations.SerializedName;
import com.lance5057.extradelight.ExtraDelight;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeHolder;
import vazkii.patchouli.api.IComponentRenderContext;
import vazkii.patchouli.api.ICustomComponent;
import vazkii.patchouli.api.IVariable;
import vectorwing.farmersdelight.common.crafting.CookingPotRecipe;
import vectorwing.farmersdelight.common.registry.ModRecipeTypes;

public class CookingPotComponent implements ICustomComponent {
	@SerializedName("recipe_name")
	public String recipeName;

	protected transient List<Ingredient> ingredients;
	protected transient int x, y;

	private static final ResourceLocation POT_GRID = ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
			"textures/gui/patchouli.png");

	@Override
	public void build(int componentX, int componentY, int pageNum) {
		this.x = componentX != -1 ? componentX : 17;
		this.y = componentY;
		this.ingredients = makeIngredients();
	}

	protected List<Ingredient> makeIngredients() {
		List<RecipeHolder<CookingPotRecipe>> recipes = Minecraft.getInstance().level.getRecipeManager()
				.getAllRecipesFor(ModRecipeTypes.COOKING.get());

		RecipeHolder<CookingPotRecipe> recipe = recipes.stream().filter(r -> r.id().toString().equals(recipeName))
				.findFirst().orElse(null);
		if (recipe == null) {
			return ImmutableList.of();
		}
		return recipe.value().getIngredients();
	}

	@Override
	public void onVariablesAvailable(UnaryOperator<IVariable> lookup, Provider registries) {
		recipeName = lookup.apply(IVariable.wrap(recipeName)).asString();
	}

	@Override
	public void render(GuiGraphics graphics, IComponentRenderContext context, float pticks, int mouseX, int mouseY) {
		graphics.pose().pushPose();

		RenderSystem.setShaderTexture(0, POT_GRID);
		RenderSystem.enableBlend();
		graphics.blit(POT_GRID, 22, 22, 86, 0, 76, 128, 256, 256);

		int x = 0;
		int y = 0;
		int xOff = 27;
		int yOff = 27;

		int size = 19;
		int count = 0;
		for (Ingredient input : ingredients) {
			// ms.translate(x - (int) x, y - (int) y, 0);
			context.renderIngredient(graphics, xOff + x, yOff + y, mouseX, mouseY, input);
			x += size;
			if (x >= size * 3) {
				x = 0;
				y += size;
			}
		}
		graphics.pose().popPose();
	}

}
