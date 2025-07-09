package com.lance5057.extradelight.data;

import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.Nullable;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.ExtraDelightFluids;
import com.lance5057.extradelight.ExtraDelightTags;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.FluidTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class EDFluidTags extends FluidTagsProvider {

	public EDFluidTags(PackOutput output, CompletableFuture<Provider> provider,
			@Nullable ExistingFileHelper existingFileHelper) {
		super(output, provider, ExtraDelight.MOD_ID, existingFileHelper);
	}

	@Override
	protected void addTags(HolderLookup.Provider provider) {
		tag(ExtraDelightTags.CHOCOLATE_FLUID).add(ExtraDelightFluids.BLOOD_CHOCOLATE_SYRUP.FLUID.get(),
				ExtraDelightFluids.WHITE_CHOCOLATE_SYRUP.FLUID.get(),
				ExtraDelightFluids.MILK_CHOCOLATE_SYRUP.FLUID.get(),
				ExtraDelightFluids.DARK_CHOCOLATE_SYRUP.FLUID.get());

		tag(ExtraDelightTags.LEMON_LIME).add(ExtraDelightFluids.LEMON_JUICE.FLUID.get(),
				ExtraDelightFluids.LIME_JUICE.FLUID.get());
	}
}
