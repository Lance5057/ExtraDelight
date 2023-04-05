package com.lance5057.extradelight;

import com.lance5057.extradelight.displays.food.FoodDisplayEntity;
import com.lance5057.extradelight.workstations.dryingrack.DryingRackBlockEntity;
import com.lance5057.extradelight.workstations.mixingbowl.MixingBowlBlockEntity;
import com.lance5057.extradelight.workstations.mortar.MortarBlockEntity;
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
			() -> BlockEntityType.Builder.of(FoodDisplayEntity::new, ExtraDelightBlocks.FOOD_DISPLAY.get())
					.build(null));

	public static final RegistryObject<BlockEntityType<MortarBlockEntity>> MORTAR = TILES.register("mortar",
			() -> BlockEntityType.Builder.of(MortarBlockEntity::new, ExtraDelightBlocks.MORTAR_AMETHYST.get(),
					ExtraDelightBlocks.MORTAR_ANDESITE.get(), ExtraDelightBlocks.MORTAR_BASALT.get(),
					ExtraDelightBlocks.MORTAR_BLACKSTONE.get(), ExtraDelightBlocks.MORTAR_DEEPSLATE.get(),
					ExtraDelightBlocks.MORTAR_DIORITE.get(), ExtraDelightBlocks.MORTAR_ENDSTONE.get(),
					ExtraDelightBlocks.MORTAR_GILDED_BLACKSTONE.get(), ExtraDelightBlocks.MORTAR_GRANITE.get(),
					ExtraDelightBlocks.MORTAR_STONE.get()).build(null));

	public static final RegistryObject<BlockEntityType<MixingBowlBlockEntity>> MIXING_BOWL = TILES
			.register("mixing_bowl", () -> BlockEntityType.Builder
					.of(MixingBowlBlockEntity::new, ExtraDelightBlocks.MIXING_BOWL.get()).build(null));
	
	public static final RegistryObject<BlockEntityType<DryingRackBlockEntity>> DRYING_RACK = TILES
			.register("drying_rack", () -> BlockEntityType.Builder
					.of(DryingRackBlockEntity::new, ExtraDelightBlocks.DRYING_RACK.get()).build(null));
}
