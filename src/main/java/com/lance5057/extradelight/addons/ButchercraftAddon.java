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
import net.minecraft.world.food.Foods;
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
import net.minecraftforge.common.crafting.CompoundIngredient;
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
			() -> new BowlFoodItem(new Item.Properties().food(EDFoods.NASI_KEBULI).craftRemainder(Items.BOWL)
					.stacksTo(16).tab(ExtraDelightItems.EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<BowlFoodItem> BHUTAN = ITEMS.register("bhutan",
			() -> new BowlFoodItem(new Item.Properties().food(EDFoods.BHUTAN).craftRemainder(Items.BOWL).stacksTo(16)
					.tab(ExtraDelightItems.EXTRA_DELIGHT_TAB)));

	// CHICKEN

	public static final RegistryObject<Item> CHICKEN_NUGGETS = ITEMS.register("chicken_nuggets", () -> new Item(
			new Item.Properties().food(EDFoods.FRIED_CHICKEN).stacksTo(16).tab(ExtraDelightItems.EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<Item> CHICKEN_SALAD = ITEMS.register("chicken_salad",
			() -> new Item(new Item.Properties().food(EDFoods.FISH_SALAD).stacksTo(16)
					.tab(ExtraDelightItems.EXTRA_DELIGHT_TAB).craftRemainder(Items.BOWL)));

	public static final RegistryObject<Item> CHICKEN_SALAD_SANDWICH = ITEMS.register("chicken_salad_sandwich",
			() -> new Item(new Item.Properties().food(EDFoods.FISH_SALAD_SANDWICH).stacksTo(16)
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
			() -> new BowlFoodItem(new Item.Properties().food(EDFoods.PULLED_PORK_SANDWICH)
					.stacksTo(16).tab(ExtraDelightItems.EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<RecipeFeastBlock> BBQ_SHREDDED_CHICKEN_BLOCK = BLOCKS.register(
			"bbq_chicken_block", () -> new RecipeFeastBlock(BlockBehaviour.Properties.of(Material.METAL).strength(0.8F)
					.sound(SoundType.LANTERN).color(MaterialColor.COLOR_BROWN), false, ExtraDelightBlocks.pot));

	public static final RegistryObject<BlockItem> BBQ_SHREDDED_CHICKEN_FEAST = ITEMS
			.register("bbq_shredded_chicken_feast", () -> new BlockItem(BBQ_SHREDDED_CHICKEN_BLOCK.get(),
					new Item.Properties().stacksTo(1).tab(ExtraDelightItems.EXTRA_DELIGHT_TAB)));

	// RABBIT
	public static final RegistryObject<BowlFoodItem> KARMINADLE = ITEMS.register("karminadle",
			() -> new BowlFoodItem(new Item.Properties().food(EDFoods.KARMINADLE).craftRemainder(Items.BOWL)
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
			() -> new BowlFoodItem(new Item.Properties().food(EDFoods.BANGERS_MASH).craftRemainder(Items.BOWL)
					.stacksTo(16).tab(ExtraDelightItems.EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<Item> BRATWURST = ITEMS.register("bratwurst", () -> new Item(
			new Item.Properties().food(Foods.COOKED_PORKCHOP).stacksTo(16).tab(ExtraDelightItems.EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<BowlFoodItem> CURRYWURST = ITEMS.register("currywurst",
			() -> new BowlFoodItem(new Item.Properties().food(Foods.COOKED_PORKCHOP).craftRemainder(Items.BOWL)
					.stacksTo(16).tab(ExtraDelightItems.EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<BowlFoodItem> PASTA_ALLA_NORCINA = ITEMS.register("pasta_alla_norcina",
			() -> new BowlFoodItem(new Item.Properties().food(EDFoods.PASTA_ALLA_NORCINA).craftRemainder(Items.BOWL)
					.stacksTo(16).tab(ExtraDelightItems.EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<BowlFoodItem> MAC_CHEESE_HOT_DOG = ITEMS.register("mac_cheese_hot_dog",
			() -> new BowlFoodItem(new Item.Properties().food(EDFoods.MAC_CHEESE_HOT_DOG).craftRemainder(Items.BOWL)
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
			new Item.Properties().food(FoodValues.BEEF_PATTY).stacksTo(16).tab(ExtraDelightItems.EXTRA_DELIGHT_TAB)));

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
				.feast(Ingredient.of(ExtraDelightTags.SANDWICH_BREAD), BBQ_SHREDDED_CHICKEN_SANDWICH.get(),
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
				.addIngredient(ForgeTags.MILK).addIngredient(ExtraDelightTags.PROCESSED_ONION)
				.addIngredient(ModItems.BONE_BROTH.get()).addIngredient(ExtraDelightTags.BUTTER)
				.build(consumer, Recipes.EDLoc("pot/" + "nasi_kebuli_bc"));

		CookingPotRecipeBuilder.cookingPotRecipe(BHUTAN.get(), 2, CookingRecipes.NORMAL_COOKING, 0.35F, Items.BOWL)
				.addIngredient(ExtraDelightTags.SCRAP_GOAT).addIngredient(ExtraDelightTags.OFFAL)
				.addIngredient(ExtraDelightTags.OFFAL).addIngredient(ExtraDelightTags.PROCESSED_TOMATO)
				.addIngredient(ExtraDelightTags.PROCESSED_ONION).addIngredient(ExtraDelightTags.COOKING_OIL)
				.build(consumer, Recipes.EDLoc("pot/" + "bhutan_bc"));

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

		Recipes.mixing(CHICKEN_SALAD.get(), Recipes.FAST_GRIND, Items.BOWL, 2,
				new Ingredient[] { Ingredient.of(ExtraDelightTags.MAYO),
						Ingredient.of(ExtraDelightTags.CUBED_CHICKEN_COOKED),
						Ingredient.of(ExtraDelightTags.CUBED_CHICKEN_COOKED) },
				consumer, "chicken_salad_bc");

		ShapelessRecipeBuilder.shapeless(CHICKEN_SALAD_SANDWICH.get()).requires(ExtraDelightTags.SANDWICH_BREAD)
				.requires(CHICKEN_SALAD.get())
				.unlockedBy("book", InventoryChangeTrigger.TriggerInstance.hasItems(CHICKEN_SALAD.get()))
				.save(consumer, Recipes.EDLoc("chicken_salad_sandwich_bread_bc"));

		CookingPotRecipeBuilder.cookingPotRecipe(CHICKEN_BOG.get(), 2, CookingRecipes.NORMAL_COOKING, 0.35F, Items.BOWL)
				.addIngredient(ExtraDelightTags.SCRAP_CHICKEN).addIngredient(ExtraDelightTags.SAUSAGE)
				.addIngredient(ExtraDelightTags.PROCESSED_ONION).addIngredient(ExtraDelightTags.BUTTER)
				.addIngredient(ForgeTags.GRAIN_RICE).build(consumer, Recipes.EDLoc("pot/" + "chicken_bog_bc"));

		CookingPotRecipeBuilder.cookingPotRecipe(OYAKODON.get(), 1, CookingRecipes.NORMAL_COOKING, 0.35F, Items.BOWL)
				.addIngredient(ExtraDelightTags.CUBED_CHICKEN).addIngredient(ExtraDelightItems.EGG_MIX.get())
				.addIngredient(ForgeTags.GRAIN_RICE).build(consumer, Recipes.EDLoc("pot/" + "oyakodon_bc"));

		CookingPotRecipeBuilder.cookingPotRecipe(KARMINADLE.get(), 1, CookingRecipes.NORMAL_COOKING, 0.35F, Items.AIR)
				.addIngredient(ExtraDelightTags.GROUND_RABBIT_RAW)
				.addIngredient(ExtraDelightItems.BREADING_MISANPLAS.get()).addIngredient(ForgeTags.BREAD)
				.build(consumer, Recipes.EDLoc("pot/" + "karminadle_bc"));

		CookingPotRecipeBuilder
				.cookingPotRecipe(HASENPFEFFER.get(), 2, CookingRecipes.NORMAL_COOKING, 0.35F, Items.BOWL)
				.addIngredient(ExtraDelightTags.RABBIT_SADDLE_RAW).addIngredient(ExtraDelightTags.VINEGAR)
				.addIngredient(ExtraDelightTags.FLOUR).addIngredient(ExtraDelightTags.FLOUR)
				.addIngredient(ExtraDelightTags.BUTTER).addIngredient(ForgeTags.RAW_BACON)
				.build(consumer, Recipes.EDLoc("pot/" + "hasenpfeffer_bc"));

		CookingPotRecipeBuilder.cookingPotRecipe(FRIED_RABBIT.get(), 1, CookingRecipes.NORMAL_COOKING, 0.35F, Items.AIR)
				.addIngredient(CompoundIngredient.of(Ingredient.of(ExtraDelightTags.RABBIT_LEG_RAW),
						Ingredient.of(ExtraDelightTags.RABBIT_SADDLE_RAW),
						Ingredient.of(ExtraDelightTags.RABBIT_THIGH_RAW)))
				.addIngredient(ExtraDelightItems.BREADING_MISANPLAS.get())
				.build(consumer, Recipes.EDLoc("pot/" + "fried_rabbit_bc"));

		Recipes.mixing(RABBIT_RAGU.get(), Recipes.FAST_GRIND, Items.BOWL, 1,
				new Ingredient[] { Ingredient.of(ModItems.TOMATO_SAUCE.get()), Ingredient.of(ModItems.RAW_PASTA.get()),
						Ingredient.of(ExtraDelightTags.RABBIT_COOKED) },
				consumer, "rabbit_ragu");

		ShapelessRecipeBuilder.shapeless(BRATWURST.get()).requires(ExtraDelightTags.SAUSAGE_COOKED)
				.requires(Ingredient.of(ExtraDelightItems.BREAD_SLICE.get())).requires(ExtraDelightTags.CONDIMENTS)
				.unlockedBy("book",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.BREAD_SLICE.get()))
				.save(consumer, Recipes.EDLoc("bratwurst_bc"));

		ShapelessRecipeBuilder.shapeless(BRATWURST.get()).requires(ExtraDelightTags.SAUSAGE_COOKED)
				.requires(Ingredient.of(Items.BREAD)).requires(ExtraDelightTags.CONDIMENTS)
				.unlockedBy("book", InventoryChangeTrigger.TriggerInstance.hasItems(Items.BREAD))
				.save(consumer, Recipes.EDLoc("bratwurst_bread_bc"));

		Recipes.mixing(CURRYWURST.get(), Recipes.FAST_GRIND, Items.BOWL, 1,
				new Ingredient[] { Ingredient.of(ExtraDelightTags.SAUSAGE_COOKED),
						Ingredient.of(ExtraDelightItems.CURRY_POWDER.get()),
						Ingredient.of(ExtraDelightItems.KETCHUP.get()) },
				consumer, "currywurst_bc");

		Recipes.mixing(PASTA_ALLA_NORCINA.get(), Recipes.FAST_GRIND, Items.BOWL, 1,
				new Ingredient[] { Ingredient.of(ExtraDelightItems.ALFREDO_SAUCE.get()),
						Ingredient.of(ModItems.RAW_PASTA.get()), Ingredient.of(ExtraDelightTags.SAUSAGE_COOKED) },
				consumer, "pasta_alla_norcina_bc");

		ShapelessRecipeBuilder.shapeless(MAC_CHEESE_HOT_DOG_FEAST.get()).requires(ExtraDelightTags.SAUSAGE_COOKED)
				.requires(ExtraDelightTags.SAUSAGE_COOKED)
				.requires(Ingredient.of(ExtraDelightItems.MACARONI_CHEESE_FEAST.get()))
				.unlockedBy("book",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.MACARONI_CHEESE_FEAST.get()))
				.save(consumer, Recipes.EDLoc("mac_cheese_hot_dog_bc"));

		ShapelessRecipeBuilder.shapeless(SEXTUPLE_MEAT_TREAT.get(), 3).requires(ExtraDelightTags.CUBED_BEEF_COOKED)
				.requires(ExtraDelightTags.CUBED_PORK_COOKED).requires(ExtraDelightTags.CUBED_MUTTON_COOKED)
				.requires(ExtraDelightTags.CUBED_GOAT_COOKED).requires(ExtraDelightTags.CUBED_CHICKEN_COOKED)
				.requires(ExtraDelightTags.CUBED_RABBIT_COOKED).requires(Items.SUGAR)
				.unlockedBy("book",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.MACARONI_CHEESE_FEAST.get()))
				.save(consumer, Recipes.EDLoc("sextuple_meat_treat_bc"));

//		CookingPotRecipeBuilder.cookingPotRecipe(NASI_KEBULI.get(), 2, CookingRecipes.SLOW_COOKING, 0.35F, Items.BOWL)
//				.addIngredient(ExtraDelightTags.CUBED_GOAT_RAW).addIngredient(ExtraDelightTags.PROCESSED_ONION)
//				.addIngredient(ExtraDelightTags.BUTTER).addIngredient(ModItems.BONE_BROTH.get())
//				.addIngredient(ForgeTags.MILK_BOTTLE).build(consumer, Recipes.EDLoc("pot/" + "nasi_kebuli_bc"));
//
//		CookingPotRecipeBuilder.cookingPotRecipe(BHUTAN.get(), 1, CookingRecipes.FAST_COOKING, 0.35F, Items.BOWL)
//				.addIngredient(ExtraDelightTags.OFFAL).addIngredient(ExtraDelightTags.OFFAL)
//				.addIngredient(ExtraDelightTags.PROCESSED_ONION).addIngredient(ExtraDelightTags.PROCESSED_TOMATO)
//				.addIngredient(ForgeTags.MILK_BOTTLE).build(consumer, Recipes.EDLoc("pot/" + "bhutan_bc"));
	}
}
