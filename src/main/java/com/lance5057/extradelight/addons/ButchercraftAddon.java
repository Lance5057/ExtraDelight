package com.lance5057.extradelight.addons;

import java.util.function.Consumer;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.ExtraDelightBlocks;
import com.lance5057.extradelight.ExtraDelightItems;
import com.lance5057.extradelight.ExtraDelightTags;
import com.lance5057.extradelight.blocks.RecipeFeastBlock;
import com.lance5057.extradelight.data.Recipes;
import com.lance5057.extradelight.data.recipebuilders.FeastRecipeBuilder;
import com.lance5057.extradelight.food.EDFoods;

import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.BowlFoodItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.FoodValues;
import vectorwing.farmersdelight.common.block.FeastBlock;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.ForgeTags;
import vectorwing.farmersdelight.data.builder.CookingPotRecipeBuilder;
import vectorwing.farmersdelight.data.recipe.CookingRecipes;

public class ButchercraftAddon {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
			ExtraDelight.MOD_ID);
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			ExtraDelight.MOD_ID);

	// GOAT
	public static final RegistryObject<RecipeFeastBlock> GOAT_STEW_BLOCK = BLOCKS.register("goat_stew_block",
			() -> new RecipeFeastBlock(BlockBehaviour.Properties.of(Material.METAL).strength(0.8F)
					.sound(SoundType.LANTERN).color(MaterialColor.COLOR_BROWN), true, ExtraDelightBlocks.pot));

	public static final RegistryObject<BowlFoodItem> GOAT_STEW = ITEMS.register("goat_stew",
			() -> new BowlFoodItem(new Item.Properties().food(EDFoods.PORK_STEW).craftRemainder(Items.BOWL).stacksTo(16)
					.tab(ExtraDelightItems.EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<BlockItem> GOAT_STEW_FEAST = ITEMS.register("goat_stew_feast",
			() -> new BlockItem(GOAT_STEW_BLOCK.get(),
					new Item.Properties().stacksTo(1).tab(ExtraDelightItems.EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<BowlFoodItem> GOAT_STEW_RICE = ITEMS.register("goat_stew_rice",
			() -> new BowlFoodItem(new Item.Properties().food(EDFoods.BEEF_STEW_RICE).craftRemainder(Items.BOWL)
					.stacksTo(16).tab(ExtraDelightItems.EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<BowlFoodItem> NASI_KEBULI = ITEMS.register("nasi_kebuli",
			() -> new BowlFoodItem(new Item.Properties().food(EDFoods.BEEF_STEW_RICE).craftRemainder(Items.BOWL)
					.stacksTo(16).tab(ExtraDelightItems.EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<BowlFoodItem> BHUTAN = ITEMS.register("bhutan",
			() -> new BowlFoodItem(new Item.Properties().food(EDFoods.BEEF_STEW_RICE).craftRemainder(Items.BOWL)
					.stacksTo(16).tab(ExtraDelightItems.EXTRA_DELIGHT_TAB)));

	// CHICKEN

	public static final RegistryObject<Item> CHICKEN_NUGGETS = ITEMS.register("chicken_nuggets", () -> new Item(
			new Item.Properties().food(EDFoods.FRIED_CHICKEN).stacksTo(16).tab(ExtraDelightItems.EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<Item> CHICKEN_SALAD = ITEMS.register("chicken_salad", () -> new Item(
			new Item.Properties().food(EDFoods.EGG_SALAD).stacksTo(16).tab(ExtraDelightItems.EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<Item> CHICKEN_SALAD_SANDWICH = ITEMS.register("chicken_salad_sandwich",
			() -> new Item(new Item.Properties().food(EDFoods.EGG_SALAD).stacksTo(16)
					.tab(ExtraDelightItems.EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<BowlFoodItem> CHICKEN_BOG = ITEMS.register("chicken_bog",
			() -> new BowlFoodItem(new Item.Properties().food(EDFoods.CHICKEN_STEW).craftRemainder(Items.BOWL)
					.stacksTo(16).tab(ExtraDelightItems.EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<BowlFoodItem> OYAKODON = ITEMS.register("oyakodon",
			() -> new BowlFoodItem(new Item.Properties().food(EDFoods.CHICKEN_STEW).craftRemainder(Items.BOWL)
					.stacksTo(16).tab(ExtraDelightItems.EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<BowlFoodItem> BBQ_SHREDDED_CHICKEN = ITEMS.register("bbq_shredded_chicken",
			() -> new BowlFoodItem(new Item.Properties().food(EDFoods.PULLED_PORK_SERVING).craftRemainder(Items.BOWL)
					.stacksTo(16).tab(ExtraDelightItems.EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<BowlFoodItem> BBQ_SHREDDED_CHICKEN_SANDWICH = ITEMS.register(
			"bbq_shredded_chicken_sandwich",
			() -> new BowlFoodItem(new Item.Properties().food(EDFoods.PULLED_PORK_SANDWICH).craftRemainder(Items.BOWL)
					.stacksTo(16).tab(ExtraDelightItems.EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<RecipeFeastBlock> BBQ_SHREDDED_CHICKEN_BLOCK = BLOCKS.register(
			"bbq_chicken_block", () -> new RecipeFeastBlock(BlockBehaviour.Properties.of(Material.METAL).strength(0.8F)
					.sound(SoundType.LANTERN).color(MaterialColor.COLOR_BROWN), false, ExtraDelightBlocks.pot));

	public static final RegistryObject<BlockItem> BBQ_SHREDDED_CHICKEN_FEAST = ITEMS
			.register("bbq_shredded_chicken_feast", () -> new BlockItem(BBQ_SHREDDED_CHICKEN_BLOCK.get(),
					new Item.Properties().stacksTo(1).tab(ExtraDelightItems.EXTRA_DELIGHT_TAB)));

	// RABBIT
	public static final RegistryObject<BowlFoodItem> KARMINADLE = ITEMS.register("karminadle",
			() -> new BowlFoodItem(new Item.Properties().food(EDFoods.BEEF_STEW_RICE).craftRemainder(Items.BOWL)
					.stacksTo(16).tab(ExtraDelightItems.EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<BowlFoodItem> HASENPFEFFER = ITEMS.register("hasenpfeffer",
			() -> new BowlFoodItem(new Item.Properties().food(EDFoods.BEEF_STEW_RICE).craftRemainder(Items.BOWL)
					.stacksTo(16).tab(ExtraDelightItems.EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<Item> FRIED_RABBIT = ITEMS.register("fried_rabbit", () -> new Item(
			new Item.Properties().food(EDFoods.FRIED_CHICKEN).stacksTo(16).tab(ExtraDelightItems.EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<BowlFoodItem> RABBIT_RAGU = ITEMS.register("rabbit_ragu",
			() -> new BowlFoodItem(new Item.Properties().food(FoodValues.PASTA_WITH_MUTTON_CHOP)
					.craftRemainder(Items.BOWL).stacksTo(16).tab(ExtraDelightItems.EXTRA_DELIGHT_TAB)));

	// SAUSAGE
	public static final RegistryObject<BowlFoodItem> BANGERS_MASH = ITEMS.register("bangers_mash",
			() -> new BowlFoodItem(new Item.Properties().food(EDFoods.BEEF_STEW_RICE).craftRemainder(Items.BOWL)
					.stacksTo(16).tab(ExtraDelightItems.EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<Item> BRATWURST = ITEMS.register("bratwurst", () -> new Item(
			new Item.Properties().food(EDFoods.FRIED_CHICKEN).stacksTo(16).tab(ExtraDelightItems.EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<BowlFoodItem> CURRYWURST = ITEMS.register("currywurst",
			() -> new BowlFoodItem(new Item.Properties().food(EDFoods.BEEF_STEW_RICE).craftRemainder(Items.BOWL)
					.stacksTo(16).tab(ExtraDelightItems.EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<BowlFoodItem> PASTA_ALLA_NORCINA = ITEMS.register("pasta_alla_norcina",
			() -> new BowlFoodItem(new Item.Properties().food(EDFoods.BEEF_STEW_RICE).craftRemainder(Items.BOWL)
					.stacksTo(16).tab(ExtraDelightItems.EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<BowlFoodItem> MAC_CHEESE_HOT_DOG = ITEMS.register("mac_cheese_hot_dog",
			() -> new BowlFoodItem(new Item.Properties().food(EDFoods.BEEF_STEW_RICE).craftRemainder(Items.BOWL)
					.stacksTo(16).tab(ExtraDelightItems.EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<RecipeFeastBlock> MAC_CHEESE_HOT_DOG_BLOCK = BLOCKS.register(
			"mac_cheese_hot_dog_block",
			() -> new RecipeFeastBlock(BlockBehaviour.Properties.of(Material.METAL).strength(0.8F)
					.sound(SoundType.LANTERN).color(MaterialColor.COLOR_BROWN), true, ExtraDelightBlocks.pot));

	public static final RegistryObject<BlockItem> MAC_CHEESE_HOT_DOG_FEAST = ITEMS.register("mac_cheese_hot_dog_feast",
			() -> new BlockItem(MAC_CHEESE_HOT_DOG_BLOCK.get(),
					new Item.Properties().stacksTo(1).tab(ExtraDelightItems.EXTRA_DELIGHT_TAB)));

	// Other
	public static final RegistryObject<Item> SEXTUPLE_MEAT_TREAT = ITEMS.register("sextuple_meat_treat", () -> new Item(
			new Item.Properties().food(EDFoods.FRIED_CHICKEN).stacksTo(16).tab(ExtraDelightItems.EXTRA_DELIGHT_TAB)));

	public static void loot(BlockLoot bl) {
		bl.dropOther(GOAT_STEW_BLOCK.get(), Items.BOWL);
		bl.dropOther(MAC_CHEESE_HOT_DOG_BLOCK.get(), Items.BOWL);
		bl.dropOther(BBQ_SHREDDED_CHICKEN_BLOCK.get(), Items.BOWL);
	}

	public static void blockModel(BlockStateProvider bsp) {
		recipeFeastBlock(bsp, BBQ_SHREDDED_CHICKEN_BLOCK.get());
		recipeFeastBlock(bsp, MAC_CHEESE_HOT_DOG_BLOCK.get());
		stewBlock(bsp, GOAT_STEW_BLOCK.get(), "goat_stew");
	}

	public static void stewBlock(BlockStateProvider bsp, RecipeFeastBlock block, String texture) {
		bsp.getVariantBuilder(block).forAllStates(state -> {
			int servings = state.getValue(RecipeFeastBlock.SERVINGS);

			String suffix = "_stage" + (block.getMaxServings() - servings);

			ResourceLocation contentsTexture = bsp.modLoc("block/" + texture);
			ResourceLocation particleTexture = bsp.modLoc("block/" + texture);

			if (servings == 0) {
				suffix = block.hasLeftovers ? "_leftover" : "_stage3";
				particleTexture = bsp.modLoc("block/pan");
			}

			return ConfiguredModel.builder()
					.modelFile(bsp.models()
							.withExistingParent(ForgeRegistries.BLOCKS.getKey(block).getPath() + suffix,
									bsp.modLoc("curry_block" + suffix))
							.texture("1", contentsTexture).texture("particle", particleTexture))
					.rotationY(((int) state.getValue(RecipeFeastBlock.FACING).toYRot() + 180) % 360).build();
		});
	}

	public static void recipeFeastBlock(BlockStateProvider bsp, RecipeFeastBlock block) {
		recipeFeastBlock(bsp, block, ForgeRegistries.BLOCKS.getKey(block).getPath());
	}

	public static void recipeFeastBlock(BlockStateProvider bsp, RecipeFeastBlock block, String path) {
		bsp.getVariantBuilder(block).forAllStates(state -> {
			int servings = state.getValue(FeastBlock.SERVINGS);

			String suffix = "_stage" + (block.getMaxServings() - servings);

			if (servings == 0) {
				suffix = block.hasLeftovers ? "_leftover" : "_stage3";
			}

			return ConfiguredModel.builder()
					.modelFile(new ModelFile.ExistingModelFile(
							new ResourceLocation(ExtraDelight.MOD_ID, "block/" + path + suffix),
							bsp.models().existingFileHelper))
					.rotationY(((int) state.getValue(FeastBlock.FACING).toYRot() + 180) % 360).build();
		});
	}

	public static void itemModel(ItemModelProvider tmp) {
		tmp.getBuilder(GOAT_STEW_FEAST.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile(
						new ResourceLocation(ExtraDelight.MOD_ID, "block/curry_block_stage0")))
				.texture("1", tmp.modLoc("block/goat_stew"));

		forItem(tmp, GOAT_STEW, "goat_stew");
		forItem(tmp, GOAT_STEW_RICE, "goat_stew_rice");
		forItem(tmp, NASI_KEBULI, "nasi_kebuli");
		forItem(tmp, BHUTAN, "bhutan");

		forItem(tmp, CHICKEN_NUGGETS, "chicken_nuggets");
		forItem(tmp, CHICKEN_SALAD, "chicken_salad");
		forItem(tmp, CHICKEN_SALAD_SANDWICH, "chicken_salad_sandwich");
		forItem(tmp, CHICKEN_BOG, "chicken_bog");
		forItem(tmp, OYAKODON, "oyakodon");
		forItem(tmp, BBQ_SHREDDED_CHICKEN, "bbq_chicken_bowl");
		forItem(tmp, BBQ_SHREDDED_CHICKEN_SANDWICH, "bbq_chicken_sandwich");
//		forBlockItem(tmp, BBQ_SHREDDED_CHICKEN_FEAST, "bbq_shredded_chicken_feast");

		tmp.getBuilder(BBQ_SHREDDED_CHICKEN_FEAST.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile(tmp.modLoc("block/bbq_chicken_block_stage0")));

		forItem(tmp, KARMINADLE, "karminadle");
		forItem(tmp, HASENPFEFFER, "hasenpfeffer");
		forItem(tmp, FRIED_RABBIT, "fried_rabbit");
		forItem(tmp, RABBIT_RAGU, "rabbit_ragu");

		forItem(tmp, BANGERS_MASH, "bangers_mash");
		forItem(tmp, BRATWURST, "bratwurst");
		forItem(tmp, CURRYWURST, "currywurst");
		forItem(tmp, PASTA_ALLA_NORCINA, "pasta_alla_norcina");
		forItem(tmp, MAC_CHEESE_HOT_DOG, "macaroni_cheese_sausage");

		tmp.getBuilder(MAC_CHEESE_HOT_DOG_FEAST.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile(tmp.modLoc("block/mac_cheese_hot_dog_block_stage0")));

		forItem(tmp, SEXTUPLE_MEAT_TREAT, "sextuple_meat_treat");
	}

	public static void forItem(ItemModelProvider tmp, RegistryObject<? extends Item> item, String name) {
		tmp.singleTexture(item.getId().getPath(), tmp.mcLoc("item/handheld"), "layer0", tmp.modLoc("item/" + name));
	}

	public static void forBlockItem(ItemModelProvider tmp, RegistryObject<? extends BlockItem> item, String name) {
		tmp.getBuilder(item.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile(new ResourceLocation(ExtraDelight.MOD_ID,
						"block/" + ForgeRegistries.BLOCKS.getKey(item.get().getBlock()).getPath())));
	}

	public static void engLoc(LanguageProvider lp) {
		lp.add(GOAT_STEW_FEAST.get(), "Pot of Goat Stew");

		lp.add(GOAT_STEW.get(), "Goat Stew");
		lp.add(GOAT_STEW_RICE.get(), "Goat Stew with Rice");
		lp.add(NASI_KEBULI.get(), "Nasi Kebuli");
		lp.add(BHUTAN.get(), "Bhutan");

		lp.add(CHICKEN_NUGGETS.get(), "Chicken Nuggets");
		lp.add(CHICKEN_SALAD.get(), "Chicken Salad");
		lp.add(CHICKEN_SALAD_SANDWICH.get(), "Chicken Salad Sandwich");
		lp.add(CHICKEN_BOG.get(), "Chicken Bog");
		lp.add(OYAKODON.get(), "Oyakodon");
		lp.add(BBQ_SHREDDED_CHICKEN.get(), "Bowl of BBQ Shredded Chicken");
		lp.add(BBQ_SHREDDED_CHICKEN_SANDWICH.get(), "BBQ Shredded Chicken Sandwich");

		lp.add(BBQ_SHREDDED_CHICKEN_FEAST.get(), "BBQ Shredded Chicken");

		lp.add(KARMINADLE.get(), "Karminadle");
		lp.add(HASENPFEFFER.get(), "Hasenpfeffer");
		lp.add(FRIED_RABBIT.get(), "Fried Rabbit");
		lp.add(RABBIT_RAGU.get(), "Rabbit Ragu");

		lp.add(BANGERS_MASH.get(), "Bangers and Mash");
		lp.add(BRATWURST.get(), "Bratwurst");
		lp.add(CURRYWURST.get(), "Currywurst");
		lp.add(PASTA_ALLA_NORCINA.get(), "Pasta Alla Norcina");
		lp.add(MAC_CHEESE_HOT_DOG.get(), "Mac and Cheese with Hotdogs");

		lp.add(MAC_CHEESE_HOT_DOG_FEAST.get(), "Pot of Mac and Cheese with Hotdogs");

		lp.add(SEXTUPLE_MEAT_TREAT.get(), "Sextuple Meat Treat");
	}

	public static void recipes(Consumer<FinishedRecipe> consumer) {
		FeastRecipeBuilder.feast(Ingredient.of(Items.BOWL), GOAT_STEW.get(), GOAT_STEW_FEAST.get())
				.unlockedBy("has_goat_stew", InventoryChangeTrigger.TriggerInstance.hasItems(GOAT_STEW_FEAST.get()))
				.save(consumer, Recipes.EDLoc("goat_stew_bowl_feast"));

		FeastRecipeBuilder.feast(Ingredient.of(ModItems.COOKED_RICE.get()), GOAT_STEW_RICE.get(), GOAT_STEW_FEAST.get())
				.unlockedBy("has_goat_stew", InventoryChangeTrigger.TriggerInstance.hasItems(GOAT_STEW_FEAST.get()))
				.save(consumer, Recipes.EDLoc("goat_stew_rice_feast"));

		FeastRecipeBuilder.feast(Ingredient.of(Items.BOWL), MAC_CHEESE_HOT_DOG.get(), MAC_CHEESE_HOT_DOG_FEAST.get())
				.unlockedBy("has_mac_cheese_hot_dog",
						InventoryChangeTrigger.TriggerInstance.hasItems(MAC_CHEESE_HOT_DOG_FEAST.get()))
				.save(consumer, Recipes.EDLoc("mac_cheese_hot_dog_feast"));

		FeastRecipeBuilder
				.feast(Ingredient.of(Items.BOWL), BBQ_SHREDDED_CHICKEN.get(), BBQ_SHREDDED_CHICKEN_FEAST.get())
				.unlockedBy("bbq_shredded_chicken",
						InventoryChangeTrigger.TriggerInstance.hasItems(BBQ_SHREDDED_CHICKEN_FEAST.get()))
				.save(consumer, Recipes.EDLoc("bbq_shredded_chicken_bowl_feast"));

		FeastRecipeBuilder
				.feast(Ingredient.of(Items.BREAD), BBQ_SHREDDED_CHICKEN_SANDWICH.get(),
						BBQ_SHREDDED_CHICKEN_FEAST.get())
				.unlockedBy("bbq_shredded_chicken",
						InventoryChangeTrigger.TriggerInstance.hasItems(BBQ_SHREDDED_CHICKEN_FEAST.get()))
				.save(consumer, Recipes.EDLoc("bbq_shredded_chicken_sandwich_feast"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(GOAT_STEW_FEAST.get(), 1, CookingRecipes.SLOW_COOKING, 0.35F, Items.BOWL)
				.addIngredient(ExtraDelightTags.STEW_GOAT).addIngredient(Items.CARROT).addIngredient(Items.POTATO)
				.addIngredient(ExtraDelightTags.PROCESSED_ONION).addIngredient(ModItems.BONE_BROTH.get())
				.addIngredient(ExtraDelightTags.FLOUR).build(consumer, Recipes.EDLoc("pot/" + "goat_stew_bc"));

		CookingPotRecipeBuilder.cookingPotRecipe(NASI_KEBULI.get(), 2, CookingRecipes.SLOW_COOKING, 0.35F, Items.BOWL)
				.addIngredient(ExtraDelightTags.STEW_GOAT).addIngredient(ForgeTags.GRAIN_RICE)
				.addIngredient(Items.MILK_BUCKET).addIngredient(ExtraDelightTags.PROCESSED_ONION)
				.addIngredient(ModItems.BONE_BROTH.get()).addIngredient(ExtraDelightTags.BUTTER)
				.addIngredient(ExtraDelightTags.COOKING_OIL).build(consumer, Recipes.EDLoc("pot/" + "nasi_kebuli_bc"));

		CookingPotRecipeBuilder.cookingPotRecipe(BHUTAN.get(), 2, CookingRecipes.NORMAL_COOKING, 0.35F, Items.BOWL)
				.addIngredient(ExtraDelightTags.SCRAP_GOAT).addIngredient(ExtraDelightTags.OFFAL)
				.addIngredient(ExtraDelightTags.OFFAL).addIngredient(ExtraDelightTags.PROCESSED_TOMATO)
				.addIngredient(ExtraDelightTags.PROCESSED_ONION).addIngredient(ExtraDelightTags.COOKING_OIL)
				.addIngredient(ExtraDelightTags.COOKING_OIL).build(consumer, Recipes.EDLoc("pot/" + "bhutan_bc"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(CHICKEN_NUGGETS.get(), 1, CookingRecipes.NORMAL_COOKING, 0.35F, Items.BOWL)
				.addIngredient(ExtraDelightTags.GROUND_CHICKEN_RAW)
				.addIngredient(ExtraDelightItems.BREADING_MISANPLAS.get())
				.build(consumer, Recipes.EDLoc("pot/" + "chicken_nuggets_bc"));

		ShapelessRecipeBuilder.shapeless(BANGERS_MASH.get()).requires(ExtraDelightItems.MASHED_POTATO_GRAVY.get())
				.requires(Ingredient.of(ExtraDelightTags.SAUSAGE_COOKED), 2)
				.unlockedBy("book",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.MASHED_POTATO_GRAVY.get()))
				.save(consumer, Recipes.EDLoc("bangers_mash_bc"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(BBQ_SHREDDED_CHICKEN_FEAST.get(), 1, CookingRecipes.NORMAL_COOKING, 0.35F, Items.BOWL)
				.addIngredient(ExtraDelightTags.CHICKEN_RAW).addIngredient(ExtraDelightTags.CHICKEN_RAW)
				.addIngredient(ExtraDelightTags.CHICKEN_RAW).addIngredient(ExtraDelightItems.BBQ_SAUCE.get())
				.build(consumer, Recipes.EDLoc("pot/" + "bbq_shredded_chicken_feast_bc"));
	}
}
