package com.lance5057.extradelight.recipe;

import java.util.ArrayList;
import java.util.List;

import com.lance5057.extradelight.ExtraDelightItems;
import com.lance5057.extradelight.ExtraDelightRecipes;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.HolderLookup;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.world.item.crafting.ShapedRecipePattern;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.capability.IFluidHandler.FluidAction;

public class ShapedWithJarRecipe extends ShapedRecipe {

	private final List<FluidStack> fluids;

	public ShapedWithJarRecipe(String group, CraftingBookCategory category, ShapedRecipePattern pattern,
			List<FluidStack> fluid, ItemStack result) {
		super(group, category, pattern, result, true);
		this.fluids = fluid;
	}

	public ShapedWithJarRecipe(String group, CraftingBookCategory category, ShapedRecipePattern pattern,
			List<FluidStack> fluid, ItemStack result, boolean showNotification) {
		super(group, category, pattern, result, showNotification);
		this.fluids = fluid;
	}

	@Override
	public boolean matches(CraftingInput input, Level level) {
		if (!this.pattern.matches(input))
			return false;

		List<ItemStack> jars = gatherJars(input);
		if (jars.size() != fluids.size())
			return false;

		if (!testJars(jars))
			return false;

		return true;
	}

	private List<ItemStack> gatherJars(CraftingInput input) {
		return input.items().stream().filter(j -> j.is(ExtraDelightItems.JAR.get())).toList();
	}

	private boolean testJars(List<ItemStack> jars) {
		List<FluidStack> jarFluids = jars.stream()
				.map(j -> j.getCapability(Capabilities.FluidHandler.ITEM).getFluidInTank(0)).toList();
		for (int i = 0; i < fluids.size(); i++) {
			if (!compareFluid(jarFluids, i))
				return false;
		}
		return true;
	}

	private boolean compareFluid(List<FluidStack> jarFluids, int i) {
		return jarFluids.stream().anyMatch(j -> j.containsFluid(fluids.get(i)));
	}

	@Override
	public ItemStack assemble(CraftingInput input, HolderLookup.Provider registries) {
		List<ItemStack> jars = gatherJars(input);

		for (FluidStack f : fluids) {
			ItemStack i = jars.stream()
					.filter(j -> j.getCapability(Capabilities.FluidHandler.ITEM).getFluidInTank(0).containsFluid(f))
					.findFirst().get();
			i.getCapability(Capabilities.FluidHandler.ITEM).drain(f, FluidAction.EXECUTE);
		}

		return this.getResultItem(registries).copy();
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return ExtraDelightRecipes.SHAPED_JAR_SERIALIZER.get();
	}

//	@Override
//	public RecipeType<?> getType() {
//		return ExtraDelightRecipes.SHAPED_JAR.get();
//	}

	public static class Serializer implements RecipeSerializer<ShapedWithJarRecipe> {
		public static final MapCodec<ShapedWithJarRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance
				.group(Codec.STRING.optionalFieldOf("group", "").forGetter(p_311729_ -> p_311729_.getGroup()),
						CraftingBookCategory.CODEC.fieldOf("category").orElse(CraftingBookCategory.MISC)
								.forGetter(p_311732_ -> p_311732_.category()),
						ShapedRecipePattern.MAP_CODEC.forGetter(p_311733_ -> p_311733_.pattern),
						FluidStack.OPTIONAL_CODEC.listOf().fieldOf("fluids").forGetter(recipe -> recipe.fluids),
						ItemStack.STRICT_CODEC.fieldOf("result").forGetter(p_311730_ -> p_311730_.getResultItem(null)),
						Codec.BOOL.optionalFieldOf("show_notification", Boolean.valueOf(true))
								.forGetter(p_311731_ -> p_311731_.showNotification()))
				.apply(instance, ShapedWithJarRecipe::new));

		public static final StreamCodec<RegistryFriendlyByteBuf, ShapedWithJarRecipe> STREAM_CODEC = StreamCodec
				.of(ShapedWithJarRecipe.Serializer::toNetwork, ShapedWithJarRecipe.Serializer::fromNetwork);

		@Override
		public MapCodec<ShapedWithJarRecipe> codec() {
			return CODEC;
		}

		@Override
		public StreamCodec<RegistryFriendlyByteBuf, ShapedWithJarRecipe> streamCodec() {
			return STREAM_CODEC;
		}

		private static ShapedWithJarRecipe fromNetwork(RegistryFriendlyByteBuf buffer) {
			ShapedRecipe shapedRecipe = RecipeSerializer.SHAPED_RECIPE.streamCodec().decode(buffer);
			int f = buffer.readVarInt();
			List<FluidStack> fluids = new ArrayList<FluidStack>();
			for (int i = 0; i < f; i++) {
				FluidStack op = FluidStack.OPTIONAL_STREAM_CODEC.decode(buffer);
				if (op != null)
					fluids.add(op);
			}

			return new ShapedWithJarRecipe(shapedRecipe.getGroup(), shapedRecipe.category(), shapedRecipe.pattern,
					fluids, shapedRecipe.getResultItem(null), shapedRecipe.showNotification());
		}

		private static void toNetwork(RegistryFriendlyByteBuf buffer, ShapedWithJarRecipe recipe) {
			RecipeSerializer.SHAPED_RECIPE.streamCodec().encode(buffer, recipe);
			buffer.writeVarInt(recipe.fluids.size());
			for (int i = 0; i < recipe.fluids.size(); i++) {
				FluidStack.OPTIONAL_STREAM_CODEC.encode(buffer, recipe.fluids.get(i));
			}
		}
	}
}
