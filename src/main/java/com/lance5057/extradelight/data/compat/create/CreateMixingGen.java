package com.lance5057.extradelight.data.compat.create;

import com.lance5057.extradelight.ExtraDelight;
import com.simibubi.create.AllRecipeTypes;
import com.simibubi.create.content.processing.recipe.HeatCondition;
import com.simibubi.create.foundation.data.recipe.ProcessingRecipeGen;
import com.simibubi.create.foundation.recipe.IRecipeTypeInfo;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.Tags;

public class CreateMixingGen extends ProcessingRecipeGen {

	GeneratedRecipe
	
	TEMP_LAVA = create(new ResourceLocation(ExtraDelight.MOD_ID, "lava"), b -> b.require(Tags.Items.COBBLESTONE)
			.output(Fluids.LAVA, 50)
			.requiresHeat(HeatCondition.SUPERHEATED));
	
	public CreateMixingGen(DataGenerator generator) {
		super(generator);
	}

	@Override
	protected IRecipeTypeInfo getRecipeType() {
		return AllRecipeTypes.MIXING;
	}

}
