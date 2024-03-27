package com.lance5057.extradelight.addons;

import java.util.function.Consumer;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.ExtraDelightBlocks;
import com.lance5057.extradelight.ExtraDelightItems;
import com.lance5057.extradelight.blocks.RecipeFeastBlock;
import com.lance5057.extradelight.food.EDFoods;

import net.minecraft.data.loot.BlockLoot;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.BowlFoodItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.FoodValues;

public class ButchercraftAddon {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
			ExtraDelight.MOD_ID);
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			ExtraDelight.MOD_ID);

	// GOAT
	public static final RegistryObject<Block> GOAT_STEW_BLOCK = BLOCKS.register("goat_stew_block",
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
	public static final RegistryObject<Item> CHICKEN_PATTY = ITEMS.register("chicken_patty", () -> new Item(
			new Item.Properties().food(FoodValues.MINCED_BEEF).stacksTo(16).tab(ExtraDelightItems.EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<Item> COOKED_CHICKEN_PATTY = ITEMS.register("cooked_chicken_patty",
			() -> new Item(new Item.Properties().food(FoodValues.BEEF_PATTY).stacksTo(16)
					.tab(ExtraDelightItems.EXTRA_DELIGHT_TAB)));

	public static final RegistryObject<Item> BREADED_CHICKEN_PATTY = ITEMS.register("breaded_chicken_patty",
			() -> new Item(new Item.Properties().food(EDFoods.FRIED_CHICKEN).stacksTo(16)
					.tab(ExtraDelightItems.EXTRA_DELIGHT_TAB)));

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

	public static final RegistryObject<Block> BBQ_SHREDDED_CHICKEN_BLOCK = BLOCKS.register("bbq_shredded_chicken_block",
			() -> new RecipeFeastBlock(BlockBehaviour.Properties.of(Material.METAL).strength(0.8F)
					.sound(SoundType.LANTERN).color(MaterialColor.COLOR_BROWN), true, ExtraDelightBlocks.pot));

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

	public static final RegistryObject<Block> MAC_CHEESE_HOT_DOG_BLOCK = BLOCKS.register("mac_cheese_hot_dog_block",
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
		bsp.simpleBlock(BBQ_SHREDDED_CHICKEN_BLOCK.get(),
				bsp.models().withExistingParent("bbq_chicken_block", bsp.modLoc("block/pulled_pork_block_stage0"))
						.texture("0", bsp.mcLoc("block/bbq_chicken")).texture("1", bsp.mcLoc("block/bbq_chicken2"))
						.texture("particle", bsp.mcLoc("block/bbq_chicken2")));
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

		forItem(tmp, CHICKEN_PATTY, "chicken_patty");
		forItem(tmp, COOKED_CHICKEN_PATTY, "cooked_chicken_patty");
		forItem(tmp, BREADED_CHICKEN_PATTY, "breaded_chicken_patty");
		forItem(tmp, CHICKEN_NUGGETS, "chicken_nuggets");
		forItem(tmp, CHICKEN_SALAD, "chicken_salad");
		forItem(tmp, CHICKEN_SALAD_SANDWICH, "chicken_salad_sandwich");
		forItem(tmp, CHICKEN_BOG, "chicken_bog");
		forItem(tmp, OYAKODON, "oyakodon");
		forItem(tmp, BBQ_SHREDDED_CHICKEN, "bbq_chicken_bowl");
		forItem(tmp, BBQ_SHREDDED_CHICKEN_SANDWICH, "bbq_chicken_sandwich");
		forBlockItem(tmp, BBQ_SHREDDED_CHICKEN_FEAST, "bbq_shredded_chicken_feast");
		tmp.getBuilder(BBQ_SHREDDED_CHICKEN_BLOCK.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile(tmp.modLoc("block/pulled_pork_block_stage0")))
				.texture("0", tmp.modLoc("block/bbq_chicken")).texture("1", tmp.modLoc("block/bbq_chicken2"))
				.texture("particle", tmp.modLoc("block/bbq_chicken2"));

		forItem(tmp, KARMINADLE, "karminadle");
		forItem(tmp, HASENPFEFFER, "hasenpfeffer");
		forItem(tmp, FRIED_RABBIT, "fried_rabbit");
		forItem(tmp, RABBIT_RAGU, "rabbit_ragu");

		forItem(tmp, BANGERS_MASH, "bangers_mash");
		forItem(tmp, BRATWURST, "bratwurst");
		forItem(tmp, CURRYWURST, "currywurst");
		forItem(tmp, PASTA_ALLA_NORCINA, "pasta_alla_norcina");
		forItem(tmp, MAC_CHEESE_HOT_DOG, "macaroni_cheese_sausage");
		forBlockItem(tmp, MAC_CHEESE_HOT_DOG_FEAST, "mac_cheese_hot_dog_feast");

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

	}

	public static void recipes(Consumer<FinishedRecipe> consumer) {

	}
}
