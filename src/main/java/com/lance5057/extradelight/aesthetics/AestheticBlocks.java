package com.lance5057.extradelight.aesthetics;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import org.apache.commons.lang3.text.WordUtils;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.ExtraDelightItems;
import com.lance5057.extradelight.aesthetics.block.MoldingBlock;
import com.lance5057.extradelight.aesthetics.block.RibbonBlock;
import com.lance5057.extradelight.aesthetics.block.cornhuskdoll.CornHuskDollBlock;
import com.lance5057.extradelight.blocks.StepStoolBlock;
import com.lance5057.extradelight.blocks.countercabinet.CounterCabinetBlock;
import com.lance5057.extradelight.blocks.sink.SinkCabinetBlock;
import com.lance5057.extradelight.data.Recipes;
import com.lance5057.extradelight.displays.cabinet.HalfCabinetBlock;
import com.lance5057.extradelight.displays.knife.KnifeBlock;
import com.lance5057.extradelight.displays.spice.SpiceRackBlock;
import com.lance5057.extradelight.displays.wreath.WreathBlock;

import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.PipeBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.client.model.generators.MultiPartBlockStateBuilder;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.CommonTags;

public class AestheticBlocks {
//	public static final CreativeModeTab AESTHETIC_TAB = new CreativeModeTab("extradelight.aesthetic") {
//		@Override
//		public ItemStack makeIcon() {
//			return new ItemStack(SPICE_RACKS_FULL.get(0).get());
//		}
//	};

	public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(ExtraDelight.MOD_ID);
	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ExtraDelight.MOD_ID);

	public static enum WOOD {
		oak, dark_oak, spruce, birch, jungle, acacia, crimson, warped, mangrove, cinnamon, cherry, bamboo, fruit
	};

	public static final List<DeferredBlock<Block>> STEP_STOOLS = new ArrayList<DeferredBlock<Block>>();
	public static final List<DeferredBlock<Block>> SPICE_RACKS = new ArrayList<DeferredBlock<Block>>();
	public static final List<DeferredBlock<Block>> SPICE_RACKS_FULL = new ArrayList<DeferredBlock<Block>>();
	public static final List<DeferredBlock<Block>> KNIFE_BLOCKS = new ArrayList<DeferredBlock<Block>>();
	public static final List<DeferredBlock<Block>> CABINETS = new ArrayList<DeferredBlock<Block>>();
	public static final List<DeferredBlock<Block>> COUNTER_CABINETS = new ArrayList<DeferredBlock<Block>>();

	public static final List<DeferredBlock<Block>> WALLPAPER_BLOCKS = new ArrayList<DeferredBlock<Block>>();
	public static final List<DeferredBlock<Block>> MOLDED_WALLPAPER_BLOCKS = new ArrayList<DeferredBlock<Block>>();

	public static final List<DeferredItem<Item>> STEP_STOOL_ITEMS = new ArrayList<DeferredItem<Item>>();
	public static final List<DeferredItem<Item>> SPICE_RACKS_ITEMS = new ArrayList<DeferredItem<Item>>();
	public static final List<DeferredItem<Item>> SPICE_RACKS_FULL_ITEMS = new ArrayList<DeferredItem<Item>>();
	public static final List<DeferredItem<Item>> KNIFE_BLOCK_ITEMS = new ArrayList<DeferredItem<Item>>();
	public static final List<DeferredItem<Item>> CABINET_ITEMS = new ArrayList<DeferredItem<Item>>();
	public static final List<DeferredItem<Item>> COUNTER_CABINET_ITEMS = new ArrayList<DeferredItem<Item>>();

	public static final List<DeferredItem<Item>> WALLPAPER_ITEMS = new ArrayList<DeferredItem<Item>>();
	public static final List<DeferredItem<Item>> MOLDED_WALLPAPER_ITEMS = new ArrayList<DeferredItem<Item>>();

	public static final DeferredHolder<Block, CornHuskDollBlock> CORN_HUSK_DOLL = BLOCKS.register("corn_husk_doll",
			() -> new CornHuskDollBlock());
	public static final DeferredHolder<Item, BlockItem> CORN_HUSK_DOLL_ITEM = ITEMS.register("corn_husk_doll",
			() -> new BlockItem(CORN_HUSK_DOLL.get(), new Item.Properties()));

	public static final List<DeferredBlock<Block>> DRIED_CORN_FENCE = new ArrayList<DeferredBlock<Block>>();
	public static final List<DeferredItem<Item>> DRIED_CORN_FENCE_ITEMS = new ArrayList<DeferredItem<Item>>();

	public static final List<DeferredBlock<Block>> WREATHS = new ArrayList<DeferredBlock<Block>>();
	public static final List<DeferredItem<Item>> WREATH_ITEMS = new ArrayList<DeferredItem<Item>>();

	public static final List<DeferredBlock<Block>> BOWS = new ArrayList<DeferredBlock<Block>>();
	public static final List<DeferredItem<Item>> BOW_ITEMS = new ArrayList<DeferredItem<Item>>();

	public static final List<DeferredBlock<Block>> SINKS = new ArrayList<DeferredBlock<Block>>();
	public static final List<DeferredItem<Item>> SINK_ITEMS = new ArrayList<DeferredItem<Item>>();

	public static Block[] getRegistryListAsBlocks(List<DeferredBlock<Block>> blocks) {
		List<Block> l = new ArrayList<Block>();

		for (DeferredBlock<Block> b : blocks) {
			l.add(b.get());
		}
		Block[] a = l.toArray(Block[]::new);

		return a;
	}

	public static Item[] getRegistryListAsItems(List<DeferredItem<Item>> items) {
		List<Item> l = new ArrayList<Item>();

		for (DeferredItem<Item> b : items) {
			l.add(b.get());
		}
		Item[] a = l.toArray(Item[]::new);

		return a;
	}

	public static void registerMoldedWallpaper(String name, Supplier<? extends Block> block,
			List<DeferredBlock<Block>> blocks, List<DeferredItem<Item>> items) {
		for (WOOD w : WOOD.values()) {
			for (DyeColor d : DyeColor.values()) {
				DeferredBlock<Block> b = BLOCKS.register(w.toString() + "_molded_" + d.getName() + "_" + name, block);
				DeferredItem<Item> t = ITEMS.register(w.toString() + "_molded_" + d.getName() + "_" + name,
						() -> new BlockItem(b.get(), new Item.Properties()));

				blocks.add(b);
				items.add(t);
			}
		}
	}

	public static void registerAllWood(String name, Supplier<? extends Block> block, List<DeferredBlock<Block>> blocks,
			List<DeferredItem<Item>> items) {
		for (WOOD w : WOOD.values()) {
			DeferredBlock<Block> b = BLOCKS.register(w.toString() + "_" + name, block);
			DeferredItem<Item> t = ITEMS.register(w.toString() + "_" + name,
					() -> new BlockItem(b.get(), new Item.Properties()));

			blocks.add(b);
			items.add(t);
		}
	}

	public static void registerAllColors(String name, Supplier<? extends Block> block,
			List<DeferredBlock<Block>> blocks, List<DeferredItem<Item>> items) {
		for (DyeColor w : DyeColor.values()) {
			DeferredBlock<Block> b = BLOCKS.register(name + "_" + w.getName(), block);
			DeferredItem<Item> t = ITEMS.register(name + "_" + w.toString(),
					() -> new BlockItem(b.get(), new Item.Properties()));

			blocks.add(b);
			items.add(t);
		}
	}

	public static void registerAllWoodHelm(String name, Supplier<? extends Block> block,
			List<DeferredBlock<Block>> blocks, List<DeferredItem<Item>> items) {
		for (WOOD w : WOOD.values()) {
			if (w.toString() != "fruit" && w.toString() != "bamboo") {
				DeferredBlock<Block> b = BLOCKS.register(w.toString() + "_" + name, block);
				DeferredItem<Item> t = ITEMS.register(w.toString() + "_" + name,
						() -> new HelmetBlockItem(b.get(), new Item.Properties()));

				blocks.add(b);
				items.add(t);
			}
		}
	}

	public static void registerAllColorsHelm(String name, Supplier<? extends Block> block,
			List<DeferredBlock<Block>> blocks, List<DeferredItem<Item>> items) {
		for (DyeColor w : DyeColor.values()) {
			DeferredBlock<Block> b = BLOCKS.register(name + "_" + w.getName(), block);
			DeferredItem<Item> t = ITEMS.register(name + "_" + w.toString(),
					() -> new HelmetBlockItem(b.get(), new Item.Properties()));

			blocks.add(b);
			items.add(t);
		}
	}

	public static void setup() {
		registerAllWood("step_stool", StepStoolBlock::new, STEP_STOOLS, STEP_STOOL_ITEMS);
		registerAllWood("spice_rack", SpiceRackBlock::new, SPICE_RACKS, SPICE_RACKS_ITEMS);
		registerAllWood("spice_rack_full", SpiceRackBlock::new, SPICE_RACKS_FULL, SPICE_RACKS_FULL_ITEMS);
		registerAllWood("knife_block", KnifeBlock::new, KNIFE_BLOCKS, KNIFE_BLOCK_ITEMS);
		registerAllWood("half_cabinet", HalfCabinetBlock::new, CABINETS, CABINET_ITEMS);
		registerAllWood("sink", SinkCabinetBlock::new, SINKS, SINK_ITEMS);
		registerAllWood("counter_cabinet", CounterCabinetBlock::new, COUNTER_CABINETS, COUNTER_CABINET_ITEMS);

		registerAllColors("wallpaper",
				() -> new Block(Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.GRASS)),
				WALLPAPER_BLOCKS, WALLPAPER_ITEMS);
		registerMoldedWallpaper("wallpaper",
				() -> new MoldingBlock(
						Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.GRASS)),
				MOLDED_WALLPAPER_BLOCKS, MOLDED_WALLPAPER_ITEMS);

		registerAllWood("dried_corn_fence", () -> new FenceBlock(Block.Properties.ofFullCopy(Blocks.ACACIA_FENCE)),
				DRIED_CORN_FENCE, DRIED_CORN_FENCE_ITEMS);

		registerAllWoodHelm("wreath", WreathBlock::new, WREATHS, WREATH_ITEMS);

		registerAllColorsHelm("ribbon_bow",
				() -> new RibbonBlock(Properties.ofFullCopy(Blocks.BLACK_WOOL).noOcclusion().noCollission()), BOWS,
				BOW_ITEMS);
	}

//	public static void loot(BlockLootSubProvider bl) {
//		for (DeferredBlock<Block> b : STEP_STOOLS)
//			bl..dropSelf(b.get());
//		for (DeferredBlock<Block> b : SPICE_RACKS)
//			bl.dropSelf(b.get());
//		for (DeferredBlock<Block> b : SPICE_RACKS_FULL)
//			bl.dropSelf(b.get());
//		for (DeferredBlock<Block> b : KNIFE_BLOCKS)
//			bl.dropSelf(b.get());
//		for (DeferredBlock<Block> b : CABINETS)
//			bl.dropSelf(b.get());
//		for (DeferredBlock<Block> b : DRIED_CORN_FENCE)
//			bl.dropSelf(b.get());
//
//		for (DeferredBlock<Block> b : WALLPAPER_BLOCKS)
//			bl.dropSelf(b.get());
//		for (DeferredBlock<Block> b : MOLDED_WALLPAPER_BLOCKS)
//			bl.dropSelf(b.get());
//
//		bl.dropSelf(CORN_HUSK_DOLL.get());
//
//		for (DeferredBlock<Block> b : WREATHS)
//			bl.dropSelf(b.get());
//		for (DeferredBlock<Block> b : BOWS)
//			bl.dropSelf(b.get());
//	}

	public static void blockModel(BlockStateProvider bsp) {
		for (int i = 0; i < WOOD.values().length; i++) {
			bsp.horizontalBlock(STEP_STOOLS.get(i).get(), bsp.models()
					.withExistingParent(WOOD.values()[i].toString() + "_step_stool", bsp.modLoc("block/stepstool"))
					.texture("0", bsp.mcLoc("block/" + WOOD.values()[i].toString() + "_planks"))
					.texture("particle", bsp.mcLoc("block/" + WOOD.values()[i].toString() + "_planks"))
					.renderType("cutout"));

			bsp.horizontalBlock(SPICE_RACKS.get(i).get(), bsp.models()
					.withExistingParent(WOOD.values()[i].toString() + "_spice_rack", bsp.modLoc("block/spicerack"))
					.texture("0", bsp.mcLoc("block/" + WOOD.values()[i].toString() + "_planks"))
					.texture("2", bsp.modLoc("block/" + WOOD.values()[i].toString() + "_ornate"))
					.texture("particle", bsp.mcLoc("block/" + WOOD.values()[i].toString() + "_planks"))
					.renderType("cutout"));

			bsp.horizontalBlock(SPICE_RACKS_FULL.get(i).get(),
					bsp.models()
							.withExistingParent(WOOD.values()[i].toString() + "_spice_rack_full",
									bsp.modLoc("block/spicerack_filled"))
							.texture("0", bsp.mcLoc("block/" + WOOD.values()[i].toString() + "_planks"))
							.texture("2", bsp.modLoc("block/" + WOOD.values()[i].toString() + "_ornate"))
							.texture("particle", bsp.mcLoc("block/" + WOOD.values()[i].toString() + "_planks"))
							.renderType("cutout"));

			bsp.horizontalBlock(KNIFE_BLOCKS.get(i).get(), bsp.models()
					.withExistingParent(WOOD.values()[i].toString() + "_knife_block", bsp.modLoc("block/knifeblock"))
					.texture("0", bsp.mcLoc("block/" + WOOD.values()[i].toString() + "_planks"))
					.texture("particle", bsp.mcLoc("block/" + WOOD.values()[i].toString() + "_planks"))
					.renderType("cutout"));

			if (WOOD.values()[i].toString() == "crimson")
				bsp.horizontalBlock(WREATHS.get(i).get(), bsp.models()
						.withExistingParent(WOOD.values()[i].toString() + "_wreath_block", bsp.modLoc("block/wreath"))
						.texture("all", bsp.mcLoc("block/nether_wart_block"))
						.texture("particle", bsp.mcLoc("block/nether_wart_block")).renderType("cutout"));
			else if (WOOD.values()[i].toString() == "warped")
				bsp.horizontalBlock(WREATHS.get(i).get(), bsp.models()
						.withExistingParent(WOOD.values()[i].toString() + "_wreath_block", bsp.modLoc("block/wreath"))
						.texture("all", bsp.mcLoc("block/warped_wart_block"))
						.texture("particle", bsp.mcLoc("block/warped_wart_block")).renderType("cutout"));
			else if (WOOD.values()[i].toString() != "fruit" && WOOD.values()[i].toString() != "bamboo")
				bsp.horizontalBlock(WREATHS.get(i).get(), bsp.models()
						.withExistingParent(WOOD.values()[i].toString() + "_wreath_block", bsp.modLoc("block/wreath"))
						.texture("all", bsp.mcLoc("block/" + WOOD.values()[i].toString() + "_leaves"))
						.renderType("cutout"));

			String s = WOOD.values()[i].toString();

			MultiPartBlockStateBuilder builder = bsp.getMultipartBuilder(DRIED_CORN_FENCE.get(i).get()).part()
					.modelFile(bsp.models().withExistingParent(s + "_dried_corn_fence", bsp.modLoc("dried_corn_fence"))
							.texture("1", bsp.mcLoc("block/" + WOOD.values()[i].toString() + "_planks")))
					.addModel().end();

			PipeBlock.PROPERTY_BY_DIRECTION.entrySet().forEach(e -> {
				Direction dir = e.getKey();
				if (dir.getAxis().isHorizontal()) {
					builder.part().modelFile(bsp.models().fenceSide(s + "_side", bsp.mcLoc("block/" + s + "_planks")))
							.rotationY((((int) dir.toYRot()) + 180) % 360).uvLock(true).addModel()
							.condition(e.getValue(), true);
				}
			});
		}

		for (int i = 0; i < DyeColor.values().length; i++) {
			bsp.simpleBlock(WALLPAPER_BLOCKS.get(i).get());
			bsp.directionalBlock(BOWS.get(i).get(), bsp.models()
					.withExistingParent(DyeColor.values()[i].toString() + "_bow", bsp.modLoc("block/ribbon_bow"))
					.texture("0",
							bsp.modLoc("block/ribbon/" + DyeColor.values()[i].toString().toLowerCase() + "_ribbon"))
					.texture("particle",
							bsp.modLoc("block/ribbon/" + DyeColor.values()[i].toString().toLowerCase() + "_ribbon")));
		}

		for (int i = 0; i < WOOD.values().length; i++) {
			for (int c = 0; c < DyeColor.values().length; c++) {
				int o = (i * DyeColor.values().length) + c;
				Block b = MOLDED_WALLPAPER_BLOCKS.get(o).get();

				bsp.getVariantBuilder(b).partialState().with(MoldingBlock.HALF, Direction.UP).modelForState()
						.modelFile(bsp.models()
								.withExistingParent(b.getName().getString() + "_top", bsp.modLoc("block/molding_top"))
								.texture("0", bsp.modLoc("block/wallpaper_" + DyeColor.values()[c]))
								.texture("1", bsp.mcLoc("block/" + WOOD.values()[i] + "_planks"))
								.texture("particle", bsp.modLoc("block/wallpaper_" + DyeColor.values()[c])))
						.addModel().partialState().with(MoldingBlock.HALF, Direction.DOWN).modelForState()
						.modelFile(bsp.models()
								.withExistingParent(b.getName().getString() + "_bottom",
										bsp.modLoc("block/molding_bottom"))
								.texture("0", bsp.modLoc("block/wallpaper_" + DyeColor.values()[c]))
								.texture("1", bsp.mcLoc("block/" + WOOD.values()[i] + "_planks"))
								.texture("particle", bsp.modLoc("block/wallpaper_" + DyeColor.values()[c])))

						.addModel();

			}
		}

		bsp.simpleBlock(CORN_HUSK_DOLL.get(),
				bsp.models().getExistingFile(ResourceLocation.fromNamespaceAndPath("minecraft", "block/air")));
	}

	public static void itemModel(ItemModelProvider tmp) {
		for (int i = 0; i < WOOD.values().length; i++) {
			tmp.getBuilder(STEP_STOOLS.get(i).getId().getPath())
					.parent(new ModelFile.UncheckedModelFile(tmp.modLoc("block/stepstool")))
					.texture("0", tmp.mcLoc("block/" + WOOD.values()[i].toString() + "_planks"));

			tmp.getBuilder(SPICE_RACKS.get(i).getId().getPath())
					.parent(new ModelFile.UncheckedModelFile(tmp.modLoc("block/spicerack")))
					.texture("0", tmp.mcLoc("block/" + WOOD.values()[i].toString() + "_planks"))
					.texture("2", tmp.modLoc("block/" + WOOD.values()[i].toString() + "_ornate"));

			tmp.getBuilder(SPICE_RACKS_FULL.get(i).getId().getPath())
					.parent(new ModelFile.UncheckedModelFile(tmp.modLoc("block/spicerack_filled")))
					.texture("0", tmp.mcLoc("block/" + WOOD.values()[i].toString() + "_planks"))
					.texture("2", tmp.modLoc("block/" + WOOD.values()[i].toString() + "_ornate"));

			tmp.getBuilder(KNIFE_BLOCKS.get(i).getId().getPath())
					.parent(new ModelFile.UncheckedModelFile(tmp.modLoc("block/knifeblock")))
					.texture("0", tmp.mcLoc("block/" + WOOD.values()[i].toString() + "_planks"));

			tmp.getBuilder(CABINETS.get(i).getId().getPath()).parent(new ModelFile.UncheckedModelFile(
					tmp.modLoc("block/" + WOOD.values()[i].toString() + "_half_cabinet")));

			if (WOOD.values()[i].toString() == "cinnamon")
				tmp.getBuilder(COUNTER_CABINET_ITEMS.get(i).getId().getPath()).parent(new ModelFile.UncheckedModelFile(
						tmp.modLoc("block/" + WOOD.values()[i].toString() + "_cabinet")));
			else if (WOOD.values()[i].toString() == "fruit")
				tmp.getBuilder(COUNTER_CABINET_ITEMS.get(i).getId().getPath()).parent(new ModelFile.UncheckedModelFile(
						tmp.modLoc("block/" + WOOD.values()[i].toString() + "_cabinet")));
			else
				tmp.getBuilder(COUNTER_CABINET_ITEMS.get(i).getId().getPath())
						.parent(new ModelFile.UncheckedModelFile(ResourceLocation.fromNamespaceAndPath("farmersdelight",
								"block/" + WOOD.values()[i].toString() + "_cabinet")));

			tmp.getBuilder(SINKS.get(i).getId().getPath()).parent(new ModelFile.UncheckedModelFile(
					tmp.modLoc("block/" + WOOD.values()[i].toString() + "_sink_cabinet")));

			tmp.getBuilder(DRIED_CORN_FENCE.get(i).getId().getPath()).parent(new ModelFile.UncheckedModelFile(
					tmp.modLoc("block/" + WOOD.values()[i].toString() + "_dried_corn_fence")));

			if (WOOD.values()[i].toString() == "crimson")
				tmp.getBuilder(WREATHS.get(i).getId().getPath())
						.parent(new ModelFile.UncheckedModelFile(tmp.modLoc("block/wreath")))
						.texture("all", tmp.mcLoc("block/nether_wart_block"));
			else if (WOOD.values()[i].toString() == "warped")
				tmp.getBuilder(WREATHS.get(i).getId().getPath())
						.parent(new ModelFile.UncheckedModelFile(tmp.modLoc("block/wreath")))
						.texture("all", tmp.mcLoc("block/warped_wart_block"));
			else if (WOOD.values()[i].toString() != "fruit" && WOOD.values()[i].toString() != "bamboo") {
				tmp.getBuilder(WREATHS.get(i).getId().getPath())
						.parent(new ModelFile.UncheckedModelFile(tmp.modLoc("block/wreath")))
						.texture("all", tmp.mcLoc("block/" + WOOD.values()[i].toString() + "_leaves"));
			}
		}

		for (int i = 0; i < DyeColor.values().length; i++) {
			tmp.getBuilder(WALLPAPER_ITEMS.get(i).getId().getPath())
					.parent(new ModelFile.UncheckedModelFile(ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
							"block/" + BuiltInRegistries.BLOCK
									.getKey(((BlockItem) WALLPAPER_ITEMS.get(i).get()).getBlock()).getPath())));

			tmp.getBuilder(BOWS.get(i).getId().getPath())
					.parent(new ModelFile.UncheckedModelFile(tmp.modLoc("block/ribbon_bow")))
					.texture("0", tmp.modLoc("block/ribbon/" + DyeColor.values()[i].toString() + "_ribbon"));
		}

		for (int i = 0; i < WOOD.values().length; i++) {
			for (int c = 0; c < DyeColor.values().length; c++) {
				int o = (i * DyeColor.values().length) + c;
				tmp.getBuilder(MOLDED_WALLPAPER_ITEMS.get(o).getId().getPath())
						.parent(new ModelFile.UncheckedModelFile(tmp.modLoc("block/molding_bottom")))
						.texture("1", tmp.mcLoc("block/" + WOOD.values()[i].toString() + "_planks"))
						.texture("0", tmp.modLoc("block/wallpaper_" + DyeColor.values()[c].toString()));
			}
		}

		tmp.getBuilder(CORN_HUSK_DOLL.getId().getPath())
				.parent(new ModelFile.UncheckedModelFile(tmp.modLoc("block/corn_husk_doll")));
	}

	public static void EngLoc(LanguageProvider lp) {
		for (int i = 0; i < WOOD.values().length; i++) {
			String w = WOOD.values()[i].toString();
			w = WordUtils.capitalize(w.replace('_', ' '));

			lp.add(STEP_STOOLS.get(i).get(), w + " Step Stool");
			lp.add(SPICE_RACKS.get(i).get(), w + " Spice Rack");
			lp.add(SPICE_RACKS_FULL.get(i).get(), w + " Spice Rack");
			lp.add(KNIFE_BLOCKS.get(i).get(), w + " Knife Block");
			lp.add(SINKS.get(i).get(), w + " Sink");
			lp.add(CABINETS.get(i).get(), w + " Half Cabinet");
			lp.add(DRIED_CORN_FENCE.get(i).get(), "Dried Corn " + w + " Fence");
			lp.add(COUNTER_CABINETS.get(i).get(), w + " Cabinet (Countertop)");
			if (WOOD.values()[i].toString() != "fruit" && WOOD.values()[i].toString() != "bamboo") {
				lp.add(WREATHS.get(i).get(), w + " Wreath");

			}

			for (int j = 0; j < DyeColor.values().length; j++) {
				int o = (i * DyeColor.values().length) + j;
				String d = DyeColor.values()[j].toString();
				d = WordUtils.capitalize(d.replace('_', ' '));

				lp.add(MOLDED_WALLPAPER_ITEMS.get(o).get(), w + " Molded " + d + " Wallpaper");
			}
		}

		for (int i = 0; i < DyeColor.values().length; i++) {
			String w = DyeColor.values()[i].toString();
			w = WordUtils.capitalize(w.replace('_', ' '));

			lp.add(WALLPAPER_ITEMS.get(i).get(), w + " Wallpaper");
			lp.add(BOWS.get(i).get(), w + " Bow");
		}

		lp.add(CORN_HUSK_DOLL.get(), "Corn Husk Doll");
	}

	// oak, dark_oak, spruce, birch, jungle, acacia, crimson, warped, mangrove,
	// cinnamon
	public static void Recipes(RecipeOutput consumer) {
		woodRecipe(consumer, Items.ACACIA_SLAB, Items.ACACIA_TRAPDOOR, Items.ACACIA_FENCE, Items.ACACIA_LEAVES,
				WOOD.acacia);
		woodRecipe(consumer, Items.BIRCH_SLAB, Items.BIRCH_TRAPDOOR, Items.BIRCH_FENCE, Items.BIRCH_LEAVES, WOOD.birch);
		woodRecipe(consumer, Items.CRIMSON_SLAB, Items.CRIMSON_TRAPDOOR, Items.CRIMSON_FENCE, Items.NETHER_WART_BLOCK,
				WOOD.crimson);
		woodRecipe(consumer, Items.DARK_OAK_SLAB, Items.DARK_OAK_TRAPDOOR, Items.DARK_OAK_FENCE, Items.DARK_OAK_LEAVES,
				WOOD.dark_oak);
		woodRecipe(consumer, Items.JUNGLE_SLAB, Items.JUNGLE_TRAPDOOR, Items.JUNGLE_FENCE, Items.JUNGLE_LEAVES,
				WOOD.jungle);
		woodRecipe(consumer, Items.MANGROVE_SLAB, Items.MANGROVE_TRAPDOOR, Items.MANGROVE_FENCE, Items.MANGROVE_LEAVES,
				WOOD.mangrove);
		woodRecipe(consumer, Items.OAK_SLAB, Items.OAK_TRAPDOOR, Items.OAK_FENCE, Items.OAK_LEAVES, WOOD.oak);
		woodRecipe(consumer, Items.SPRUCE_SLAB, Items.SPRUCE_TRAPDOOR, Items.SPRUCE_FENCE, Items.SPRUCE_LEAVES,
				WOOD.spruce);
		woodRecipe(consumer, Items.WARPED_SLAB, Items.WARPED_TRAPDOOR, Items.WARPED_FENCE, Items.WARPED_WART_BLOCK,
				WOOD.warped);
		woodRecipe(consumer, ExtraDelightItems.CINNAMON_SLAB.get(), ExtraDelightItems.CINNAMON_TRAPDOOR.get(),
				ExtraDelightItems.CINNAMON_FENCE.get(), ExtraDelightItems.CINNAMON_LEAVES.get(), WOOD.cinnamon);
		woodRecipe(consumer, ExtraDelightItems.FRUIT_SLAB.get(), ExtraDelightItems.FRUIT_TRAPDOOR.get(),
				ExtraDelightItems.FRUIT_FENCE.get(), WOOD.fruit);
		woodRecipe(consumer, Items.CHERRY_SLAB, Items.CHERRY_TRAPDOOR, Items.CHERRY_FENCE, Items.CHERRY_LEAVES,
				WOOD.cherry);
		woodRecipe(consumer, Items.BAMBOO_SLAB, Items.BAMBOO_TRAPDOOR, Items.BAMBOO_FENCE, WOOD.bamboo);

		moldRecipe(consumer, Items.OAK_SLAB, WOOD.oak, 0);
		moldRecipe(consumer, Items.DARK_OAK_SLAB, WOOD.dark_oak, 1 * 16);
		moldRecipe(consumer, Items.SPRUCE_SLAB, WOOD.spruce, 2 * 16);
		moldRecipe(consumer, Items.BIRCH_SLAB, WOOD.birch, 3 * 16);
		moldRecipe(consumer, Items.JUNGLE_SLAB, WOOD.jungle, 4 * 16);
		moldRecipe(consumer, Items.ACACIA_SLAB, WOOD.acacia, 5 * 16);
		moldRecipe(consumer, Items.CRIMSON_SLAB, WOOD.crimson, 6 * 16);
		moldRecipe(consumer, Items.WARPED_SLAB, WOOD.warped, 7 * 16);
		moldRecipe(consumer, Items.MANGROVE_SLAB, WOOD.mangrove, 8 * 16);
		moldRecipe(consumer, ExtraDelightItems.CINNAMON_SLAB.get(), WOOD.cinnamon, 9 * 16);
		moldRecipe(consumer, Items.CHERRY_SLAB, WOOD.cherry, 10 * 16);
		moldRecipe(consumer, Items.BAMBOO_SLAB, WOOD.bamboo, 11 * 16);
		moldRecipe(consumer, ExtraDelightItems.FRUIT_SLAB.get(), WOOD.fruit, 12 * 16);

		cabinetRecipes(consumer);

		for (int i = 0; i < DyeColor.values().length; i++) {
			DyeColor dye = DyeColor.values()[i];
			ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, WALLPAPER_ITEMS.get(dye.ordinal()).get(), 4)
					.requires(Items.PAPER, 4)
					.requires(ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "dyes/" + dye)))
					.unlockedBy(dye + "_wallpaper", InventoryChangeTrigger.TriggerInstance.hasItems(Items.PAPER))
					.save(consumer);

			ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, BOW_ITEMS.get(dye.ordinal()).get(), 1).pattern(" w ")
					.pattern(" w ").pattern("w w")
					.define('w',
							BuiltInRegistries.ITEM
									.get(ResourceLocation.fromNamespaceAndPath("minecraft", dye + "_wool")))
					.unlockedBy(dye + "_bow", InventoryChangeTrigger.TriggerInstance.hasItems(Items.WHITE_WOOL))
					.save(consumer);
		}

		ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, CORN_HUSK_DOLL.get()).pattern(" c ").pattern(" s ")
				.pattern("ccc").define('c', ExtraDelightItems.DRIED_CORN_HUSK.get()).define('s', Tags.Items.STRINGS)
				.unlockedBy("corn_husk_doll",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.DRIED_CORN_HUSK.get()))
				.save(consumer);
	}

	static void moldRecipe(RecipeOutput consumer, Item slab, WOOD name, int add) {
		for (int j = 0; j < 16; j++) {
			DyeColor d = DyeColor.values()[j];
			String n = d + "_" + name + "_wallpaper";
			ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, MOLDED_WALLPAPER_ITEMS.get(j + add).get(), 4)
					.requires(Items.PAPER, 4)
					.requires(ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "dyes/" + d))).requires(slab)
					.unlockedBy(n, InventoryChangeTrigger.TriggerInstance.hasItems(Items.PAPER)).save(consumer);
		}
	}

	static void woodRecipe(RecipeOutput consumer, Item slab, Item trapdoor, Item fence, Item leaves, WOOD name) {

		ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, STEP_STOOLS.get(name.ordinal()).get()).pattern(" w ")
				.pattern("s s").pattern("s s").define('w', slab).define('s', Items.STICK)
				.unlockedBy(name + "_step_stool", InventoryChangeTrigger.TriggerInstance.hasItems(Items.STICK))
				.save(consumer);

		ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, SPICE_RACKS.get(name.ordinal()).get()).pattern("wsw")
				.pattern("b b").define('w', slab).define('s', Items.STICK).define('b', Items.IRON_BARS)
				.unlockedBy(name + "_spice_rack", InventoryChangeTrigger.TriggerInstance.hasItems(slab)).save(consumer);

		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, SPICE_RACKS_FULL.get(name.ordinal()).get())
				.requires(SPICE_RACKS.get(name.ordinal()).get()).requires(Items.GLASS_BOTTLE, 4)
				.unlockedBy(name + "_spice_rack_full", InventoryChangeTrigger.TriggerInstance.hasItems(slab))
				.save(consumer);

		ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, KNIFE_BLOCKS.get(name.ordinal()).get()).pattern("wkw")
				.define('w', slab).define('k', CommonTags.TOOLS_KNIFE)
				.unlockedBy(name + "_knife_block", InventoryChangeTrigger.TriggerInstance.hasItems(slab))
				.save(consumer);

		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, DRIED_CORN_FENCE.get(name.ordinal()).get())
				.requires(fence).requires(ExtraDelightItems.DRIED_CORN_HUSK.get())
				.unlockedBy(name + "_dried_corn_fence", InventoryChangeTrigger.TriggerInstance.hasItems(fence))
				.save(consumer);

		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, fence)
				.requires(DRIED_CORN_FENCE.get(name.ordinal()).get())
				.unlockedBy(name + "_dried_corn_fence_back",
						InventoryChangeTrigger.TriggerInstance.hasItems(DRIED_CORN_FENCE.get(name.ordinal()).get()))
				.save(consumer, Recipes.EDLoc(name + "_dried_corn_fence_back"));

		ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, WREATHS.get(name.ordinal()).get()).pattern(" l ")
				.pattern("l l").pattern(" l ").define('l', leaves)
				.unlockedBy(name + "_wreath", InventoryChangeTrigger.TriggerInstance.hasItems(leaves)).save(consumer);
	}

	static void woodRecipe(RecipeOutput consumer, Item slab, Item trapdoor, Item fence, WOOD name) {

		ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, STEP_STOOLS.get(name.ordinal()).get()).pattern(" w ")
				.pattern("s s").pattern("s s").define('w', slab).define('s', Items.STICK)
				.unlockedBy(name + "_step_stool", InventoryChangeTrigger.TriggerInstance.hasItems(Items.STICK))
				.save(consumer);

		ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, SPICE_RACKS.get(name.ordinal()).get()).pattern("wsw")
				.pattern("b b").define('w', slab).define('s', Items.STICK).define('b', Items.IRON_BARS)
				.unlockedBy(name + "_spice_rack", InventoryChangeTrigger.TriggerInstance.hasItems(slab)).save(consumer);

		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, SPICE_RACKS_FULL.get(name.ordinal()).get())
				.requires(SPICE_RACKS.get(name.ordinal()).get()).requires(Items.GLASS_BOTTLE, 4)
				.unlockedBy(name + "_spice_rack_full", InventoryChangeTrigger.TriggerInstance.hasItems(slab))
				.save(consumer);

		ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, KNIFE_BLOCKS.get(name.ordinal()).get()).pattern("wkw")
				.define('w', slab).define('k', CommonTags.TOOLS_KNIFE)
				.unlockedBy(name + "_knife_block", InventoryChangeTrigger.TriggerInstance.hasItems(slab))
				.save(consumer);

		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, DRIED_CORN_FENCE.get(name.ordinal()).get())
				.requires(fence).requires(ExtraDelightItems.DRIED_CORN_HUSK.get())
				.unlockedBy(name + "_dried_corn_fence", InventoryChangeTrigger.TriggerInstance.hasItems(fence))
				.save(consumer);

		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, fence)
				.requires(DRIED_CORN_FENCE.get(name.ordinal()).get())
				.unlockedBy(name + "_dried_corn_fence_back",
						InventoryChangeTrigger.TriggerInstance.hasItems(DRIED_CORN_FENCE.get(name.ordinal()).get()))
				.save(consumer, Recipes.EDLoc(name + "_dried_corn_fence_back"));
	}

	static void cabinetRecipes(RecipeOutput consumer) {
		// Mangrove
		ShapelessRecipeBuilder
				.shapeless(RecipeCategory.DECORATIONS, COUNTER_CABINETS.get(WOOD.mangrove.ordinal()).get())
				.requires(ModItems.MANGROVE_CABINET.get())
				.unlockedBy("mangrove_half_cabinet",
						InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.MANGROVE_CABINET.get()))
				.save(consumer, ExtraDelight.MOD_ID + ":half_cabinets/" + WOOD.mangrove + "_cabinet_full_to_counter");

		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModItems.MANGROVE_CABINET.get())
				.requires(CABINETS.get(WOOD.mangrove.ordinal()).get())
				.unlockedBy("mangrove_cabinet",
						InventoryChangeTrigger.TriggerInstance.hasItems(CABINETS.get(WOOD.mangrove.ordinal()).get()))
				.save(consumer, ExtraDelight.MOD_ID + ":half_cabinets/" + WOOD.mangrove + "_cabinet_half_to_full");

		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, CABINETS.get(WOOD.mangrove.ordinal()).get())
				.requires(COUNTER_CABINETS.get(WOOD.mangrove.ordinal()).get())
				.unlockedBy("mangrove_cabinet",
						InventoryChangeTrigger.TriggerInstance.hasItems(CABINETS.get(WOOD.mangrove.ordinal()).get()))
				.save(consumer, ExtraDelight.MOD_ID + ":half_cabinets/" + WOOD.mangrove + "_cabinet_counter_to_half");

		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, SINKS.get(WOOD.mangrove.ordinal()).get())
				.requires(ModItems.MANGROVE_CABINET.get()).requires(ExtraDelightItems.TAP.get())
				.unlockedBy("mangrove_cabinet",
						InventoryChangeTrigger.TriggerInstance.hasItems(CABINETS.get(WOOD.mangrove.ordinal()).get()))
				.save(consumer, ExtraDelight.MOD_ID + ":half_cabinets/" + WOOD.mangrove + "_cabinet_to_sink");

		// Crimson
		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, COUNTER_CABINETS.get(WOOD.crimson.ordinal()).get())
				.requires(ModItems.CRIMSON_CABINET.get())
				.unlockedBy("crimson_half_cabinet",
						InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.CRIMSON_CABINET.get()))
				.save(consumer, ExtraDelight.MOD_ID + ":half_cabinets/" + WOOD.crimson + "_cabinet_full_to_counter");

		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModItems.CRIMSON_CABINET.get())
				.requires(CABINETS.get(WOOD.crimson.ordinal()).get())
				.unlockedBy("crimson_cabinet",
						InventoryChangeTrigger.TriggerInstance.hasItems(CABINETS.get(WOOD.crimson.ordinal()).get()))
				.save(consumer, ExtraDelight.MOD_ID + ":half_cabinets/" + WOOD.crimson + "_cabinet_half_to_full");

		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, CABINETS.get(WOOD.crimson.ordinal()).get())
				.requires(COUNTER_CABINETS.get(WOOD.crimson.ordinal()).get())
				.unlockedBy("crimson_cabinet",
						InventoryChangeTrigger.TriggerInstance.hasItems(CABINETS.get(WOOD.crimson.ordinal()).get()))
				.save(consumer, ExtraDelight.MOD_ID + ":half_cabinets/" + WOOD.crimson + "_cabinet_counter_to_half");

		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, SINKS.get(WOOD.crimson.ordinal()).get())
				.requires(ModItems.CRIMSON_CABINET.get()).requires(ExtraDelightItems.TAP.get())
				.unlockedBy("crimson_cabinet",
						InventoryChangeTrigger.TriggerInstance.hasItems(CABINETS.get(WOOD.crimson.ordinal()).get()))
				.save(consumer, ExtraDelight.MOD_ID + ":half_cabinets/" + WOOD.crimson + "_cabinet_to_sink");

		// Warped
		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, COUNTER_CABINETS.get(WOOD.warped.ordinal()).get())
				.requires(ModItems.WARPED_CABINET.get())
				.unlockedBy("warped_half_cabinet",
						InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.WARPED_CABINET.get()))
				.save(consumer, ExtraDelight.MOD_ID + ":half_cabinets/" + WOOD.warped + "_cabinet_full_to_counter");

		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModItems.WARPED_CABINET.get())
				.requires(CABINETS.get(WOOD.warped.ordinal()).get())
				.unlockedBy("warped_cabinet",
						InventoryChangeTrigger.TriggerInstance.hasItems(CABINETS.get(WOOD.warped.ordinal()).get()))
				.save(consumer, ExtraDelight.MOD_ID + ":half_cabinets/" + WOOD.warped + "_cabinet_half_to_full");

		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, CABINETS.get(WOOD.warped.ordinal()).get())
				.requires(COUNTER_CABINETS.get(WOOD.warped.ordinal()).get())
				.unlockedBy("warped_cabinet",
						InventoryChangeTrigger.TriggerInstance.hasItems(CABINETS.get(WOOD.warped.ordinal()).get()))
				.save(consumer, ExtraDelight.MOD_ID + ":half_cabinets/" + WOOD.warped + "_cabinet_counter_to_half");

		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, SINKS.get(WOOD.warped.ordinal()).get())
				.requires(ModItems.WARPED_CABINET.get()).requires(ExtraDelightItems.TAP.get())
				.unlockedBy("warped_cabinet",
						InventoryChangeTrigger.TriggerInstance.hasItems(CABINETS.get(WOOD.warped.ordinal()).get()))
				.save(consumer, ExtraDelight.MOD_ID + ":half_cabinets/" + WOOD.warped + "_cabinet_to_sink");

		// Acacia
		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, COUNTER_CABINETS.get(WOOD.acacia.ordinal()).get())
				.requires(ModItems.ACACIA_CABINET.get())
				.unlockedBy("acacia_half_cabinet",
						InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ACACIA_CABINET.get()))
				.save(consumer, ExtraDelight.MOD_ID + ":half_cabinets/" + WOOD.acacia + "_cabinet_full_to_counter");

		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModItems.ACACIA_CABINET.get())
				.requires(CABINETS.get(WOOD.acacia.ordinal()).get())
				.unlockedBy("acacia_cabinet",
						InventoryChangeTrigger.TriggerInstance.hasItems(CABINETS.get(WOOD.acacia.ordinal()).get()))
				.save(consumer, ExtraDelight.MOD_ID + ":half_cabinets/" + WOOD.acacia + "_cabinet_half_to_full");

		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, CABINETS.get(WOOD.acacia.ordinal()).get())
				.requires(COUNTER_CABINETS.get(WOOD.acacia.ordinal()).get())
				.unlockedBy("acacia_cabinet",
						InventoryChangeTrigger.TriggerInstance.hasItems(CABINETS.get(WOOD.acacia.ordinal()).get()))
				.save(consumer, ExtraDelight.MOD_ID + ":half_cabinets/" + WOOD.acacia + "_cabinet_counter_to_half");

		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, SINKS.get(WOOD.acacia.ordinal()).get())
				.requires(ModItems.ACACIA_CABINET.get()).requires(ExtraDelightItems.TAP.get())
				.unlockedBy("acacia_cabinet",
						InventoryChangeTrigger.TriggerInstance.hasItems(CABINETS.get(WOOD.acacia.ordinal()).get()))
				.save(consumer, ExtraDelight.MOD_ID + ":half_cabinets/" + WOOD.acacia + "_cabinet_to_sink");

		// Oak
		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, COUNTER_CABINETS.get(WOOD.oak.ordinal()).get())
				.requires(ModItems.OAK_CABINET.get())
				.unlockedBy("oak_half_cabinet",
						InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.OAK_CABINET.get()))
				.save(consumer, ExtraDelight.MOD_ID + ":half_cabinets/" + WOOD.oak + "_cabinet_full_to_counter");

		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModItems.OAK_CABINET.get())
				.requires(CABINETS.get(WOOD.oak.ordinal()).get())
				.unlockedBy("oak_cabinet",
						InventoryChangeTrigger.TriggerInstance.hasItems(CABINETS.get(WOOD.oak.ordinal()).get()))
				.save(consumer, ExtraDelight.MOD_ID + ":half_cabinets/" + WOOD.oak + "_cabinet_half_to_full");

		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, CABINETS.get(WOOD.oak.ordinal()).get())
				.requires(COUNTER_CABINETS.get(WOOD.oak.ordinal()).get())
				.unlockedBy("oak_cabinet",
						InventoryChangeTrigger.TriggerInstance.hasItems(CABINETS.get(WOOD.oak.ordinal()).get()))
				.save(consumer, ExtraDelight.MOD_ID + ":half_cabinets/" + WOOD.oak + "_cabinet_counter_to_half");

		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, SINKS.get(WOOD.oak.ordinal()).get())
				.requires(ModItems.OAK_CABINET.get()).requires(ExtraDelightItems.TAP.get())
				.unlockedBy("oak_cabinet",
						InventoryChangeTrigger.TriggerInstance.hasItems(CABINETS.get(WOOD.oak.ordinal()).get()))
				.save(consumer, ExtraDelight.MOD_ID + ":half_cabinets/" + WOOD.oak + "_cabinet_to_sink");

		// Dark Oak
		ShapelessRecipeBuilder
				.shapeless(RecipeCategory.DECORATIONS, COUNTER_CABINETS.get(WOOD.dark_oak.ordinal()).get())
				.requires(ModItems.DARK_OAK_CABINET.get())
				.unlockedBy("dark_oak_half_cabinet",
						InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.DARK_OAK_CABINET.get()))
				.save(consumer, ExtraDelight.MOD_ID + ":half_cabinets/" + WOOD.dark_oak + "_cabinet_full_to_counter");

		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModItems.DARK_OAK_CABINET.get())
				.requires(CABINETS.get(WOOD.dark_oak.ordinal()).get())
				.unlockedBy("dark_oak_cabinet",
						InventoryChangeTrigger.TriggerInstance.hasItems(CABINETS.get(WOOD.dark_oak.ordinal()).get()))
				.save(consumer, ExtraDelight.MOD_ID + ":half_cabinets/" + WOOD.dark_oak + "_cabinet_half_to_full");

		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, CABINETS.get(WOOD.dark_oak.ordinal()).get())
				.requires(COUNTER_CABINETS.get(WOOD.dark_oak.ordinal()).get())
				.unlockedBy("dark_oak_cabinet",
						InventoryChangeTrigger.TriggerInstance.hasItems(CABINETS.get(WOOD.dark_oak.ordinal()).get()))
				.save(consumer, ExtraDelight.MOD_ID + ":half_cabinets/" + WOOD.dark_oak + "_cabinet_counter_to_half");

		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, SINKS.get(WOOD.dark_oak.ordinal()).get())
				.requires(ModItems.DARK_OAK_CABINET.get()).requires(ExtraDelightItems.TAP.get())
				.unlockedBy("dark_oak_cabinet",
						InventoryChangeTrigger.TriggerInstance.hasItems(CABINETS.get(WOOD.dark_oak.ordinal()).get()))
				.save(consumer, ExtraDelight.MOD_ID + ":half_cabinets/" + WOOD.dark_oak + "_cabinet_to_sink");

		// Spruce
		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, COUNTER_CABINETS.get(WOOD.spruce.ordinal()).get())
				.requires(ModItems.SPRUCE_CABINET.get())
				.unlockedBy("spruce_half_cabinet",
						InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SPRUCE_CABINET.get()))
				.save(consumer, ExtraDelight.MOD_ID + ":half_cabinets/" + WOOD.spruce + "_cabinet_full_to_counter");

		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModItems.SPRUCE_CABINET.get())
				.requires(CABINETS.get(WOOD.spruce.ordinal()).get())
				.unlockedBy("spruce_cabinet",
						InventoryChangeTrigger.TriggerInstance.hasItems(CABINETS.get(WOOD.spruce.ordinal()).get()))
				.save(consumer, ExtraDelight.MOD_ID + ":half_cabinets/" + WOOD.spruce + "_cabinet_half_to_full");

		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, CABINETS.get(WOOD.spruce.ordinal()).get())
				.requires(COUNTER_CABINETS.get(WOOD.spruce.ordinal()).get())
				.unlockedBy("spruce_cabinet",
						InventoryChangeTrigger.TriggerInstance.hasItems(CABINETS.get(WOOD.spruce.ordinal()).get()))
				.save(consumer, ExtraDelight.MOD_ID + ":half_cabinets/" + WOOD.spruce + "_cabinet_counter_to_half");

		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, SINKS.get(WOOD.spruce.ordinal()).get())
				.requires(ModItems.SPRUCE_CABINET.get()).requires(ExtraDelightItems.TAP.get())
				.unlockedBy("spruce_cabinet",
						InventoryChangeTrigger.TriggerInstance.hasItems(CABINETS.get(WOOD.spruce.ordinal()).get()))
				.save(consumer, ExtraDelight.MOD_ID + ":half_cabinets/" + WOOD.spruce + "_cabinet_to_sink");

		// Birch
		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, COUNTER_CABINETS.get(WOOD.birch.ordinal()).get())
				.requires(ModItems.BIRCH_CABINET.get())
				.unlockedBy("birch_half_cabinet",
						InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.BIRCH_CABINET.get()))
				.save(consumer, ExtraDelight.MOD_ID + ":half_cabinets/" + WOOD.birch + "_cabinet_full_to_counter");

		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModItems.BIRCH_CABINET.get())
				.requires(CABINETS.get(WOOD.birch.ordinal()).get())
				.unlockedBy("birch_cabinet",
						InventoryChangeTrigger.TriggerInstance.hasItems(CABINETS.get(WOOD.birch.ordinal()).get()))
				.save(consumer, ExtraDelight.MOD_ID + ":half_cabinets/" + WOOD.birch + "_cabinet_half_to_full");

		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, CABINETS.get(WOOD.birch.ordinal()).get())
				.requires(COUNTER_CABINETS.get(WOOD.birch.ordinal()).get())
				.unlockedBy("birch_cabinet",
						InventoryChangeTrigger.TriggerInstance.hasItems(CABINETS.get(WOOD.birch.ordinal()).get()))
				.save(consumer, ExtraDelight.MOD_ID + ":half_cabinets/" + WOOD.birch + "_cabinet_counter_to_half");

		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, SINKS.get(WOOD.birch.ordinal()).get())
				.requires(ModItems.BIRCH_CABINET.get()).requires(ExtraDelightItems.TAP.get())
				.unlockedBy("birch_cabinet",
						InventoryChangeTrigger.TriggerInstance.hasItems(CABINETS.get(WOOD.birch.ordinal()).get()))
				.save(consumer, ExtraDelight.MOD_ID + ":half_cabinets/" + WOOD.birch + "_cabinet_to_sink");

		// Jungle
		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, COUNTER_CABINETS.get(WOOD.jungle.ordinal()).get())
				.requires(ModItems.JUNGLE_CABINET.get())
				.unlockedBy("jungle_half_cabinet",
						InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.JUNGLE_CABINET.get()))
				.save(consumer, ExtraDelight.MOD_ID + ":half_cabinets/" + WOOD.jungle + "_cabinet_full_to_counter");

		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModItems.JUNGLE_CABINET.get())
				.requires(CABINETS.get(WOOD.jungle.ordinal()).get())
				.unlockedBy("jungle_cabinet",
						InventoryChangeTrigger.TriggerInstance.hasItems(CABINETS.get(WOOD.jungle.ordinal()).get()))
				.save(consumer, ExtraDelight.MOD_ID + ":half_cabinets/" + WOOD.jungle + "_cabinet_half_to_full");

		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, CABINETS.get(WOOD.jungle.ordinal()).get())
				.requires(COUNTER_CABINETS.get(WOOD.jungle.ordinal()).get())
				.unlockedBy("jungle_cabinet",
						InventoryChangeTrigger.TriggerInstance.hasItems(CABINETS.get(WOOD.jungle.ordinal()).get()))
				.save(consumer, ExtraDelight.MOD_ID + ":half_cabinets/" + WOOD.jungle + "_cabinet_counter_to_half");

		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, SINKS.get(WOOD.jungle.ordinal()).get())
				.requires(ModItems.JUNGLE_CABINET.get()).requires(ExtraDelightItems.TAP.get())
				.unlockedBy("jungle_cabinet",
						InventoryChangeTrigger.TriggerInstance.hasItems(CABINETS.get(WOOD.jungle.ordinal()).get()))
				.save(consumer, ExtraDelight.MOD_ID + ":half_cabinets/" + WOOD.jungle + "_cabinet_to_sink");

		// Cinnamon
		ShapelessRecipeBuilder
				.shapeless(RecipeCategory.DECORATIONS, COUNTER_CABINETS.get(WOOD.cinnamon.ordinal()).get())
				.requires(ExtraDelightItems.CINNAMON_CABINET.get())
				.unlockedBy("cinnamon_half_cabinet",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.CINNAMON_CABINET.get()))
				.save(consumer, ExtraDelight.MOD_ID + ":half_cabinets/" + WOOD.cinnamon + "_cabinet_full_to_counter");

		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ExtraDelightItems.CINNAMON_CABINET.get())
				.requires(CABINETS.get(WOOD.cinnamon.ordinal()).get())
				.unlockedBy("cinnamon_cabinet",
						InventoryChangeTrigger.TriggerInstance.hasItems(CABINETS.get(WOOD.cinnamon.ordinal()).get()))
				.save(consumer, ExtraDelight.MOD_ID + ":half_cabinets/" + WOOD.cinnamon + "_cabinet_half_to_full");

		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, CABINETS.get(WOOD.cinnamon.ordinal()).get())
				.requires(COUNTER_CABINETS.get(WOOD.cinnamon.ordinal()).get())
				.unlockedBy("cinnamon_cabinet",
						InventoryChangeTrigger.TriggerInstance.hasItems(CABINETS.get(WOOD.cinnamon.ordinal()).get()))
				.save(consumer, ExtraDelight.MOD_ID + ":half_cabinets/" + WOOD.cinnamon + "_cabinet_counter_to_half");

		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, SINKS.get(WOOD.cinnamon.ordinal()).get())
				.requires(ExtraDelightItems.CINNAMON_CABINET.get()).requires(ExtraDelightItems.TAP.get())
				.unlockedBy("cinnamon_cabinet",
						InventoryChangeTrigger.TriggerInstance.hasItems(CABINETS.get(WOOD.cinnamon.ordinal()).get()))
				.save(consumer, ExtraDelight.MOD_ID + ":half_cabinets/" + WOOD.cinnamon + "_cabinet_to_sink");

		// Cherry
		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, COUNTER_CABINETS.get(WOOD.cherry.ordinal()).get())
				.requires(ModItems.CHERRY_CABINET.get())
				.unlockedBy("cherry_half_cabinet",
						InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.CHERRY_CABINET.get()))
				.save(consumer, ExtraDelight.MOD_ID + ":half_cabinets/" + WOOD.cherry + "_cabinet_full_to_counter");

		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModItems.CHERRY_CABINET.get())
				.requires(CABINETS.get(WOOD.cherry.ordinal()).get())
				.unlockedBy("cherry_cabinet",
						InventoryChangeTrigger.TriggerInstance.hasItems(CABINETS.get(WOOD.cherry.ordinal()).get()))
				.save(consumer, ExtraDelight.MOD_ID + ":half_cabinets/" + WOOD.cherry + "_cabinet_half_to_full");

		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, CABINETS.get(WOOD.cherry.ordinal()).get())
				.requires(COUNTER_CABINETS.get(WOOD.cherry.ordinal()).get())
				.unlockedBy("cherry_cabinet",
						InventoryChangeTrigger.TriggerInstance.hasItems(CABINETS.get(WOOD.cherry.ordinal()).get()))
				.save(consumer, ExtraDelight.MOD_ID + ":half_cabinets/" + WOOD.cherry + "_cabinet_counter_to_half");

		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, SINKS.get(WOOD.cherry.ordinal()).get())
				.requires(ModItems.CHERRY_CABINET.get()).requires(ExtraDelightItems.TAP.get())
				.unlockedBy("cherry_cabinet",
						InventoryChangeTrigger.TriggerInstance.hasItems(CABINETS.get(WOOD.cherry.ordinal()).get()))
				.save(consumer, ExtraDelight.MOD_ID + ":half_cabinets/" + WOOD.cherry + "_cabinet_to_sink");

		// Bamboo
		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, COUNTER_CABINETS.get(WOOD.bamboo.ordinal()).get())
				.requires(ModItems.BAMBOO_CABINET.get())
				.unlockedBy("bamboo_half_cabinet",
						InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.BAMBOO_CABINET.get()))
				.save(consumer, ExtraDelight.MOD_ID + ":half_cabinets/" + WOOD.bamboo + "_cabinet_full_to_counter");

		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModItems.BAMBOO_CABINET.get())
				.requires(CABINETS.get(WOOD.bamboo.ordinal()).get())
				.unlockedBy("bamboo_cabinet",
						InventoryChangeTrigger.TriggerInstance.hasItems(CABINETS.get(WOOD.bamboo.ordinal()).get()))
				.save(consumer, ExtraDelight.MOD_ID + ":half_cabinets/" + WOOD.bamboo + "_cabinet_half_to_full");

		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, CABINETS.get(WOOD.bamboo.ordinal()).get())
				.requires(COUNTER_CABINETS.get(WOOD.bamboo.ordinal()).get())
				.unlockedBy("bamboo_cabinet",
						InventoryChangeTrigger.TriggerInstance.hasItems(CABINETS.get(WOOD.bamboo.ordinal()).get()))
				.save(consumer, ExtraDelight.MOD_ID + ":half_cabinets/" + WOOD.bamboo + "_cabinet_counter_to_half");

		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, SINKS.get(WOOD.bamboo.ordinal()).get())
				.requires(ModItems.BAMBOO_CABINET.get()).requires(ExtraDelightItems.TAP.get())
				.unlockedBy("bamboo_cabinet",
						InventoryChangeTrigger.TriggerInstance.hasItems(CABINETS.get(WOOD.bamboo.ordinal()).get()))
				.save(consumer, ExtraDelight.MOD_ID + ":half_cabinets/" + WOOD.bamboo + "_cabinet_to_sink");

		// Fruit
		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, COUNTER_CABINETS.get(WOOD.fruit.ordinal()).get())
				.requires(ExtraDelightItems.FRUIT_CABINET.get())
				.unlockedBy("fruit_half_cabinet",
						InventoryChangeTrigger.TriggerInstance.hasItems(ExtraDelightItems.FRUIT_CABINET.get()))
				.save(consumer, ExtraDelight.MOD_ID + ":half_cabinets/" + WOOD.fruit + "_cabinet_full_to_counter");

		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ExtraDelightItems.FRUIT_CABINET.get())
				.requires(CABINETS.get(WOOD.fruit.ordinal()).get())
				.unlockedBy("fruit_cabinet",
						InventoryChangeTrigger.TriggerInstance.hasItems(CABINETS.get(WOOD.fruit.ordinal()).get()))
				.save(consumer, ExtraDelight.MOD_ID + ":half_cabinets/" + WOOD.fruit + "_cabinet_half_to_full");

		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, CABINETS.get(WOOD.fruit.ordinal()).get())
				.requires(COUNTER_CABINETS.get(WOOD.fruit.ordinal()).get())
				.unlockedBy("fruit_cabinet",
						InventoryChangeTrigger.TriggerInstance.hasItems(CABINETS.get(WOOD.fruit.ordinal()).get()))
				.save(consumer, ExtraDelight.MOD_ID + ":half_cabinets/" + WOOD.fruit + "_cabinet_counter_to_half");

		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, SINKS.get(WOOD.fruit.ordinal()).get())
				.requires(ExtraDelightItems.FRUIT_CABINET.get()).requires(ExtraDelightItems.TAP.get())
				.unlockedBy("fruit_cabinet",
						InventoryChangeTrigger.TriggerInstance.hasItems(CABINETS.get(WOOD.fruit.ordinal()).get()))
				.save(consumer, ExtraDelight.MOD_ID + ":half_cabinets/" + WOOD.fruit + "_cabinet_to_sink");
	}
}
