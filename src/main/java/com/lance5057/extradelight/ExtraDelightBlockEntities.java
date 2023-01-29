package com.lance5057.extradelight;

import com.lance5057.extradelight.blocks.entities.FoodDisplayEntity;
import com.lance5057.extradelight.workstations.oven.OvenBlockEntity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ExtraDelightBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> TILES = DeferredRegister
			.create(ForgeRegistries.BLOCK_ENTITY_TYPES, ExtraDelight.MOD_ID);

	public static final RegistryObject<BlockEntityType<OvenBlockEntity>> OVEN = TILES.register("oven",
			() -> BlockEntityType.Builder.of(OvenBlockEntity::new, ExtraDelightBlocks.OVEN.get()).build(null));
	
	public static final RegistryObject<BlockEntityType<FoodDisplayEntity>> FOOD_DISPLAY = TILES.register("food_display",
			() -> BlockEntityType.Builder.of(FoodDisplayEntity::new,  ExtraDelightBlocks.FOOD_DISPLAY.get()).build(null));
}
