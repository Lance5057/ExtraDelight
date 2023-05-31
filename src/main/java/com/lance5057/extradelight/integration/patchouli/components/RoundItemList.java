package com.lance5057.extradelight.integration.patchouli.components;

import java.util.List;
import java.util.function.UnaryOperator;

import com.google.common.collect.ImmutableList;
import com.google.gson.annotations.SerializedName;
import com.lance5057.extradelight.ExtraDelightRecipes;
import com.lance5057.extradelight.workstations.mixingbowl.recipes.MixingBowlRecipe;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.Minecraft;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.Level;
import vazkii.patchouli.api.IComponentRenderContext;
import vazkii.patchouli.api.ICustomComponent;
import vazkii.patchouli.api.IVariable;

public class RoundItemList implements ICustomComponent {
	@SerializedName("recipe_name")
	public String recipeName;

	protected transient List<Ingredient> ingredients;
	protected transient int x, y;

	@Override
	public void build(int componentX, int componentY, int pageNum) {
		this.x = componentX != -1 ? componentX : 17;
		this.y = componentY;
		this.ingredients = makeIngredients();
	}

	protected List<Ingredient> makeIngredients() {
		Level world = Minecraft.getInstance().level;

		List<MixingBowlRecipe> recipes = Minecraft.getInstance().level.getRecipeManager()
				.getAllRecipesFor(ExtraDelightRecipes.MIXING_BOWL.get());

		Recipe<?> recipe = recipes.stream().filter(r -> r.getId().toString().equals(recipeName)).findFirst()
				.orElse(null);
		if (recipe == null) {
			return ImmutableList.of();
		}
		return recipe.getIngredients();
	}

	@Override
	public void render(PoseStack ms, IComponentRenderContext context, float pticks, int mouseX, int mouseY) {
		int degreePerInput = (int) (360F / ingredients.size());
		int ticksElapsed = context.getTicksInBook();

		float currentDegree = 0;

		for (Ingredient input : ingredients) {
			renderIngredientAtAngle(ms, context, currentDegree, input, mouseX, mouseY);

			currentDegree += degreePerInput;
		}
	}

	private void renderIngredientAtAngle(PoseStack ms, IComponentRenderContext context, float angle,
			Ingredient ingredient, int mouseX, int mouseY) {
		if (ingredient.isEmpty()) {
			return;
		}

		angle -= 90;
		int radius = 32;
		double xPos = x + Math.cos(angle * Math.PI / 180D) * radius + 32;
		double yPos = y + Math.sin(angle * Math.PI / 180D) * radius + 32;

		ms.pushPose();
		ms.translate(xPos - (int) xPos, yPos - (int) yPos, 0);
		context.renderIngredient(ms, (int) xPos, (int) yPos, mouseX, mouseY, ingredient);
		ms.popPose();
	}

	@Override
	public void onVariablesAvailable(UnaryOperator<IVariable> lookup) {
		recipeName = lookup.apply(IVariable.wrap(recipeName)).asString();
	}

}
