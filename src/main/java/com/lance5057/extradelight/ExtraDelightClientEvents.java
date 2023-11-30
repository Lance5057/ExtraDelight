package com.lance5057.extradelight;

import java.util.Map;

import com.lance5057.extradelight.aesthetics.AestheticBlocks;
import com.lance5057.extradelight.aesthetics.block.cornhuskdoll.CornHuskDollRenderer;
import com.lance5057.extradelight.displays.food.FoodDisplayRenderer;
import com.lance5057.extradelight.displays.knife.KnifeBlockRenderer;
import com.lance5057.extradelight.displays.spice.SpiceRackRenderer;
import com.lance5057.extradelight.displays.wreath.WreathRenderer;
import com.lance5057.extradelight.workstations.dryingrack.DryingRackRenderer;
import com.lance5057.extradelight.workstations.mixingbowl.MixingBowlRenderer;
import com.lance5057.extradelight.workstations.mortar.MortarRenderer;
import com.lance5057.extradelight.workstations.oven.recipetab.OvenRecipeCatagories;

import net.minecraft.client.Minecraft;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelEvent.RegisterAdditional;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.client.event.RegisterRecipeBookCategoriesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = ExtraDelight.MOD_ID, value = Dist.CLIENT)
public class ExtraDelightClientEvents {

	@SubscribeEvent
	public static void onRegisterRecipeBookCategories(RegisterRecipeBookCategoriesEvent event) {
		OvenRecipeCatagories.init(event);
	}

	public static void setTERenderers() {
		BlockEntityRenderers.register(ExtraDelightBlockEntities.FOOD_DISPLAY.get(), FoodDisplayRenderer::new);
		BlockEntityRenderers.register(ExtraDelightBlockEntities.KNIFE_BLOCK.get(), KnifeBlockRenderer::new);
		BlockEntityRenderers.register(ExtraDelightBlockEntities.SPICE_RACK.get(), SpiceRackRenderer::new);
		BlockEntityRenderers.register(ExtraDelightBlockEntities.MORTAR.get(), MortarRenderer::new);
		BlockEntityRenderers.register(ExtraDelightBlockEntities.MIXING_BOWL.get(), MixingBowlRenderer::new);
		BlockEntityRenderers.register(ExtraDelightBlockEntities.DRYING_RACK.get(), DryingRackRenderer::new);
		BlockEntityRenderers.register(ExtraDelightBlockEntities.CORN_HUSK_DOLL.get(), CornHuskDollRenderer::new);
		BlockEntityRenderers.register(ExtraDelightBlockEntities.WREATH.get(), WreathRenderer::new);
	}

	@SubscribeEvent
	public static void RegisterExtraModels(RegisterAdditional event) {
		Map<ResourceLocation, Resource> rrs = Minecraft.getInstance().getResourceManager().listResources("models/extra",
				(p_215600_) -> {
					return p_215600_.getPath().endsWith(".json");
				});

		rrs.forEach((rl, r) -> {
			String s = rl.toString();

			s = s.substring(s.indexOf('/') + 1, s.indexOf('.'));

			ExtraDelight.logger.debug(s);

			ResourceLocation rl2 = new ResourceLocation(rl.getNamespace(), s);

			event.register(rl2);
		});
	}

	@SubscribeEvent
	public static void registerBlockColourHandlers(final RegisterColorHandlersEvent.Block event) {

		final BlockColor bc = (state, blockAccess, pos, tintIndex) -> {
			if (blockAccess != null && pos != null) {
				return BiomeColors.getAverageFoliageColor(blockAccess, pos);
			}

			return FoliageColor.getDefaultColor();
		};

		event.register((p_92636_, p_92637_, p_92638_, p_92639_) -> {
			return FoliageColor.getEvergreenColor();
		}, AestheticBlocks.WREATHS.get(AestheticBlocks.WOOD.spruce.ordinal()).get());

		event.register((p_92631_, p_92632_, p_92633_, p_92634_) -> {
			return FoliageColor.getBirchColor();
		}, AestheticBlocks.WREATHS.get(AestheticBlocks.WOOD.birch.ordinal()).get());
		event.register((p_92626_, p_92627_, p_92628_, p_92629_) -> {
			return p_92627_ != null && p_92628_ != null ? BiomeColors.getAverageFoliageColor(p_92627_, p_92628_)
					: FoliageColor.getDefaultColor();
		}, AestheticBlocks.WREATHS.get(AestheticBlocks.WOOD.oak.ordinal()).get(),
				AestheticBlocks.WREATHS.get(AestheticBlocks.WOOD.jungle.ordinal()).get(),
				AestheticBlocks.WREATHS.get(AestheticBlocks.WOOD.acacia.ordinal()).get(),
				AestheticBlocks.WREATHS.get(AestheticBlocks.WOOD.dark_oak.ordinal()).get(),
				AestheticBlocks.WREATHS.get(AestheticBlocks.WOOD.mangrove.ordinal()).get());
	}

	@SubscribeEvent
	public static void registerItemColourHandlers(final RegisterColorHandlersEvent.Item event) {
		final BlockColors blockColors = event.getBlockColors();

		// Use the Block's colour handler for an ItemBlock
		final ItemColor itemBlockColourHandler = (stack, tintIndex) -> {
			final BlockState state = ((BlockItem) stack.getItem()).getBlock().defaultBlockState();
			return blockColors.getColor(state, null, null, tintIndex);
		};

//		for (RegistryObject<Item> b : AestheticBlocks.WREATH_ITEMS)
		event.register(itemBlockColourHandler, AestheticBlocks.getRegistryListAsItems(AestheticBlocks.WREATH_ITEMS));
	}
}
