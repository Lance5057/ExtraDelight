package com.lance5057.extradelight.aesthetics;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.blocks.StepStoolBlock;
import com.lance5057.extradelight.displays.knife.KnifeBlock;
import com.lance5057.extradelight.displays.spice.SpiceRackBlock;

import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AestheticBlocks {
	public static final CreativeModeTab AESTHETIC_TAB = new CreativeModeTab("extradelight.aesthetic") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(SPICE_RACKS_FULL.get(0).get());
		}
	};

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			ExtraDelight.MOD_ID);
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
			ExtraDelight.MOD_ID);

	public static enum WOOD {
		oak, dark_oak, spruce, birch, jungle, acacia, crimson, warped, mangrove
	};

	public static final List<RegistryObject<Block>> STEP_STOOLS = new ArrayList<RegistryObject<Block>>();
	public static final List<RegistryObject<Block>> SPICE_RACKS = new ArrayList<RegistryObject<Block>>();
	public static final List<RegistryObject<Block>> SPICE_RACKS_FULL = new ArrayList<RegistryObject<Block>>();
	public static final List<RegistryObject<Block>> KNIFE_BLOCKS = new ArrayList<RegistryObject<Block>>();
	
	public static final List<RegistryObject<Block>> WALLPAPER_BLOCKS = new ArrayList<RegistryObject<Block>>();

	public static final List<RegistryObject<Item>> STEP_STOOL_ITEMS = new ArrayList<RegistryObject<Item>>();
	public static final List<RegistryObject<Item>> SPICE_RACKS_ITEMS = new ArrayList<RegistryObject<Item>>();
	public static final List<RegistryObject<Item>> SPICE_RACKS_FULL_ITEMS = new ArrayList<RegistryObject<Item>>();
	public static final List<RegistryObject<Item>> KNIFE_BLOCK_ITEMS = new ArrayList<RegistryObject<Item>>();
	
	public static final List<RegistryObject<Item>> WALLPAPER_ITEMS = new ArrayList<RegistryObject<Item>>();

	public static void registerAllWood(String name, Supplier<? extends Block> block, List<RegistryObject<Block>> blocks,
			List<RegistryObject<Item>> items) {
		for (WOOD w : WOOD.values()) {
			RegistryObject<Block> b = BLOCKS.register(w.toString() + "_" + name, block);
			RegistryObject<Item> t = ITEMS.register(w.toString() + "_" + name,
					() -> new BlockItem(b.get(), new Item.Properties().tab(AESTHETIC_TAB)));

			blocks.add(b);
			items.add(t);
		}
	}
	
	public static void registerAllColors(String name, Supplier<? extends Block> block, List<RegistryObject<Block>> blocks,
			List<RegistryObject<Item>> items) {
		for (DyeColor w : DyeColor.values()) {
			RegistryObject<Block> b = BLOCKS.register(name + "_" + w.getName(), block);
			RegistryObject<Item> t = ITEMS.register(name + "_" + w.toString(),
					() -> new BlockItem(b.get(), new Item.Properties().tab(AESTHETIC_TAB)));

			blocks.add(b);
			items.add(t);
		}
	}

	public static void setup() {
		registerAllWood("step_stool", StepStoolBlock::new, STEP_STOOLS, STEP_STOOL_ITEMS);
		registerAllWood("spice_rack", SpiceRackBlock::new, SPICE_RACKS, SPICE_RACKS_ITEMS);
		registerAllWood("spice_rack_full", SpiceRackBlock::new, SPICE_RACKS_FULL, SPICE_RACKS_FULL_ITEMS);
		registerAllWood("knife_block", KnifeBlock::new, KNIFE_BLOCKS, KNIFE_BLOCK_ITEMS);
		
		registerAllColors("wallpaper", () -> new Block(Properties.of(Material.WOOD)), WALLPAPER_BLOCKS, WALLPAPER_ITEMS);
	}

	public static void loot(BlockLoot bl) {
		for (RegistryObject<Block> b : STEP_STOOLS)
			bl.dropSelf(b.get());
		for (RegistryObject<Block> b : SPICE_RACKS)
			bl.dropSelf(b.get());
		for (RegistryObject<Block> b : SPICE_RACKS_FULL)
			bl.dropSelf(b.get());
		for (RegistryObject<Block> b : KNIFE_BLOCKS)
			bl.dropSelf(b.get());
		
		for (RegistryObject<Block> b : WALLPAPER_BLOCKS)
			bl.dropSelf(b.get());
	}

	public static void blockModel(BlockStateProvider bsp) {
		for (int i = 0; i < WOOD.values().length; i++) {
			bsp.horizontalBlock(STEP_STOOLS.get(i).get(), bsp.models()
					.withExistingParent(WOOD.values()[i].toString() + "_step_stool", bsp.modLoc("block/stepstool"))
					.texture("0", bsp.mcLoc("block/" + WOOD.values()[i].toString() + "_planks")).renderType("cutout"));

			bsp.horizontalBlock(SPICE_RACKS.get(i).get(), bsp.models()
					.withExistingParent(WOOD.values()[i].toString() + "_spice_rack", bsp.modLoc("block/spicerack"))
					.texture("0", bsp.mcLoc("block/" + WOOD.values()[i].toString() + "_planks"))
					.texture("2", bsp.modLoc("block/" + WOOD.values()[i].toString() + "_ornate")).renderType("cutout"));

			bsp.horizontalBlock(SPICE_RACKS_FULL.get(i).get(), bsp.models()
					.withExistingParent(WOOD.values()[i].toString() + "_spice_rack_full", bsp.modLoc("block/spicerack_filled"))
					.texture("0", bsp.mcLoc("block/" + WOOD.values()[i].toString() + "_planks"))
					.texture("2", bsp.modLoc("block/" + WOOD.values()[i].toString() + "_ornate")).renderType("cutout"));

			bsp.horizontalBlock(KNIFE_BLOCKS.get(i).get(), bsp.models()
					.withExistingParent(WOOD.values()[i].toString() + "_knife_block", bsp.modLoc("block/knifeblock"))
					.texture("0", bsp.mcLoc("block/" + WOOD.values()[i].toString() + "_planks")).renderType("cutout"));
		}
		
		for (int i = 0; i < DyeColor.values().length; i++) {
			bsp.simpleBlock(WALLPAPER_BLOCKS.get(i).get());
		}
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
		}
	}
}
