package com.lance5057.extradelight;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ExtraDelightItems {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
			ExtraDelight.MOD_ID);

	public static final CreativeModeTab EXTRA_DELIGHT_TAB = new CreativeModeTab("extradelight.items") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(OVEN.get());
		}
	};
	
	public static final RegistryObject<Item> OVEN = ITEMS.register("oven",
			() -> new BlockItem(ExtraDelightBlocks.OVEN.get(), new Item.Properties().tab(EXTRA_DELIGHT_TAB)));

	
}
