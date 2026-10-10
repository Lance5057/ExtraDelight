//package com.lance5057.extradelight.recipe;
//
//import com.lance5057.extradelight.ExtraDelight;
//import com.lance5057.extradelight.ExtraDelightComponents;
//import com.lance5057.extradelight.ExtraDelightRecipes;
//import com.lance5057.extradelight.items.dynamicfood.DynamicSandwich;
//import com.mojang.serialization.Codec;
//import com.mojang.serialization.MapCodec;
//import com.mojang.serialization.codecs.RecordCodecBuilder;
//
//import net.minecraft.core.HolderLookup;
//import net.minecraft.core.NonNullList;
//import net.minecraft.network.RegistryFriendlyByteBuf;
//import net.minecraft.network.codec.StreamCodec;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.item.component.ItemContainerContents;
//import net.minecraft.world.item.crafting.CraftingBookCategory;
//import net.minecraft.world.item.crafting.CraftingInput;
//import net.minecraft.world.item.crafting.RecipeSerializer;
//import net.minecraft.world.item.crafting.ShapedRecipe;
//import net.minecraft.world.item.crafting.ShapedRecipePattern;
//
//public class DynamicSandwichRecipe extends ShapedRecipe {
//
//	public DynamicSandwichRecipe(String group, CraftingBookCategory category, ShapedRecipePattern pattern,
//			ItemStack result) {
//		super(group, category, pattern, result);
//	}
//
//	@Override
//	public ItemStack assemble(CraftingInput input, HolderLookup.Provider registries) {
//		ItemStack stack = super.getResultItem(registries).copy();
//		if (stack.getItem() instanceof DynamicSandwich) {
//
//			NonNullList<ItemStack> l = NonNullList.create();
//			for (ItemStack s : input.items())
//				if (s != null && !s.isEmpty())
//					l.add(s);
//
//			stack.set(ExtraDelightComponents.ITEMSTACK_HANDLER.get(), ItemContainerContents.fromItems(l));
//		} else {
//			ExtraDelight.logger.error("DynamicSandwichRecipe result not DynamicSandwich!");
//		}
//		return stack;
//	}
//
//	@Override
//	public RecipeSerializer<?> getSerializer() {
//		return ExtraDelightRecipes.DYNAMIC_SANDWICH_SERIALIZER.get();
//	}
//
////	@Override
////	public RecipeType<?> getType() {
////		return ExtraDelightRecipes.DYNAMIC_SANDWICH.get();
////	}
//
//	public static class Serializer implements RecipeSerializer<DynamicSandwichRecipe> {
//		public static final MapCodec<DynamicSandwichRecipe> CODEC = RecordCodecBuilder.mapCodec(p_340778_ -> p_340778_
//				.group(Codec.STRING.optionalFieldOf("group", "").forGetter(p_311729_ -> p_311729_.getGroup()),
//						CraftingBookCategory.CODEC.fieldOf("category").orElse(CraftingBookCategory.MISC)
//								.forGetter(p_311732_ -> p_311732_.category()),
//						ShapedRecipePattern.MAP_CODEC.forGetter(p_311733_ -> p_311733_.pattern),
//						ItemStack.STRICT_CODEC.fieldOf("result").forGetter(p_311730_ -> p_311730_.getResultItem(null)))
//
//				.apply(p_340778_, DynamicSandwichRecipe::new));
//		public static final StreamCodec<RegistryFriendlyByteBuf, DynamicSandwichRecipe> STREAM_CODEC = StreamCodec
//				.of(DynamicSandwichRecipe.Serializer::toNetwork, DynamicSandwichRecipe.Serializer::fromNetwork);
//
//		@Override
//		public MapCodec<DynamicSandwichRecipe> codec() {
//			return CODEC;
//		}
//
//		@Override
//		public StreamCodec<RegistryFriendlyByteBuf, DynamicSandwichRecipe> streamCodec() {
//			return STREAM_CODEC;
//		}
//
//		private static DynamicSandwichRecipe fromNetwork(RegistryFriendlyByteBuf buffer) {
//			String s = buffer.readUtf();
//			CraftingBookCategory craftingbookcategory = buffer.readEnum(CraftingBookCategory.class);
//			ShapedRecipePattern shapedrecipepattern = ShapedRecipePattern.STREAM_CODEC.decode(buffer);
//			ItemStack itemstack = ItemStack.STREAM_CODEC.decode(buffer);
//			return new DynamicSandwichRecipe(s, craftingbookcategory, shapedrecipepattern, itemstack);
//		}
//
//		private static void toNetwork(RegistryFriendlyByteBuf buffer, DynamicSandwichRecipe recipe) {
//			buffer.writeUtf(recipe.getGroup());
//			buffer.writeEnum(recipe.category());
//			ShapedRecipePattern.STREAM_CODEC.encode(buffer, recipe.pattern);
//			ItemStack.STREAM_CODEC.encode(buffer, recipe.getResultItem(null));
//		}
//	}
//}
