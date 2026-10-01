package api.LanceNestAPI.src;

import java.util.function.Supplier;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.workstations.oven.OvenMenu;

import api.LanceNestAPI.src.AdvancedDisplay.AdvancedDisplayBlock;
import api.LanceNestAPI.src.AdvancedDisplay.AdvancedDisplayBlockEntity;
import api.LanceNestAPI.src.AdvancedDisplay.AdvancedDisplayMenu;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class LanceNestAPI {
	public final static String MOD_ID = "lancenestapi";
	public static final String VERSION = "1.0";

	public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MOD_ID);
	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MOD_ID);
	public static final DeferredRegister<BlockEntityType<?>> TILES = DeferredRegister
			.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, MOD_ID);
	public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(Registries.MENU, MOD_ID);

	public static final DeferredBlock<Block> ADVANCED_DISPLAY_BLOCK = BLOCKS.register("advanced_display_block",
			() -> new AdvancedDisplayBlock(Block.Properties.ofFullCopy(Blocks.BLACK_CARPET)));

	public static final DeferredItem<Item> ADVANCED_DISPLAY_ITEM = ITEMS.register("advanced_display_item",
			() -> new BlockItem(ADVANCED_DISPLAY_BLOCK.get(), new Item.Properties()));

	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<AdvancedDisplayBlockEntity>> ADVANCED_DISPLAY_ENTITY = TILES
			.register("advanced_display_entity", () -> BlockEntityType.Builder
					.of(AdvancedDisplayBlockEntity::new, ADVANCED_DISPLAY_BLOCK.get()).build(null));

	public static final Supplier<MenuType<AdvancedDisplayMenu>> ADVANCED_DISPLAY_MENU = MENU_TYPES
			.register("advanced_display_menu", () -> IMenuTypeExtension.create(AdvancedDisplayMenu::new));

	public LanceNestAPI() {

	}
}
