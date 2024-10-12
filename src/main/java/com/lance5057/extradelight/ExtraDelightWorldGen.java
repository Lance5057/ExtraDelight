package com.lance5057.extradelight;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ExtraDelightWorldGen {
	public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(BuiltInRegistries.FEATURE,
			ExtraDelight.MOD_ID);

	public static final ResourceKey<Level> CORNFIELD = ResourceKey.create(Registries.DIMENSION,
			ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "cornfield"));
	public static final ResourceKey<Biome> CORNFIELD_BIOME = ResourceKey.create(Registries.BIOME,
			ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "cornfield"));
	public static final ResourceKey<DimensionType> CORNFIELD_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE,
			ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "corn"));
	public static final ResourceKey<LevelStem> CORNFIELD_STEM = ResourceKey.create(Registries.LEVEL_STEM,
			ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "cornfield"));
	public static final ResourceKey<NoiseGeneratorSettings> CORNFIELD_NOISE = ResourceKey
			.create(Registries.NOISE_SETTINGS, ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "cornfield"));

	public static final ResourceKey<ConfiguredFeature<?, ?>> CONFIGURED_CORN_MAZE = ResourceKey.create(
			Registries.CONFIGURED_FEATURE,
			ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "corn_maze_feature"));
	public static final ResourceKey<PlacedFeature> PLACED_CORN_MAZE = ResourceKey.create(Registries.PLACED_FEATURE,
			ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "corn_placer"));

	public static final ResourceKey<ConfiguredFeature<?, ?>> CONFIGURED_CORN_RAIL = ResourceKey.create(
			Registries.CONFIGURED_FEATURE,
			ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "corn_rail_feature"));
	public static final ResourceKey<PlacedFeature> PLACED_CORN_RAIL = ResourceKey.create(Registries.PLACED_FEATURE,
			ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "rail_placer"));

	public static final ResourceKey<ConfiguredFeature<?, ?>> CONFIGURED_CINNAMON_TREE = ResourceKey.create(
			Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "cinnamon"));
	public static final ResourceKey<PlacedFeature> PLACED_CINNAMON_TREE = ResourceKey.create(Registries.PLACED_FEATURE,
			ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "cinnamon"));

	public static final ResourceKey<StructureSet> STRUCTURE_SET = ResourceKey.create(Registries.STRUCTURE_SET,
			ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "structure_set"));

	public static final ResourceLocation BARN = ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "barn");
	public static final ResourceLocation CAMP1 = ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "camp1");
	public static final ResourceLocation CAMP2 = ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "camp2");
	public static final ResourceLocation DOLL_CIRCLE = ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
			"doll_circle");
	public static final ResourceLocation DOLL_CIRCLE1 = ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
			"doll_circle1");
	public static final ResourceLocation DOLL_CIRCLE2 = ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
			"doll_circle2");
	public static final ResourceLocation DOLL_CIRCLE3 = ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
			"doll_circle3");
	public static final ResourceLocation DOLL_CIRCLE4 = ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
			"doll_circle4");
	public static final ResourceLocation FOUNTAIN = ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
			"fountain");
	public static final ResourceLocation HAUNTEDHOUSE = ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
			"hauntedhouse");
	public static final ResourceLocation PUMPKIN_PATCH2 = ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
			"pumpkin_patch2");
	public static final ResourceLocation PUMPKIN_PATCH3 = ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
			"pumpkin_patch3");
	public static final ResourceLocation PUMPKIN_PATCH4 = ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
			"pumpkin_patch4");
	public static final ResourceLocation PUMPKIN_PATCH5 = ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
			"pumpkin_patch5");
	public static final ResourceLocation PUMPKIN_PILE1 = ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
			"pumpkin_pile1");
	public static final ResourceLocation RAIL_STOP = ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
			"rail_stop");
	public static final ResourceLocation SACRIFICE = ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
			"sacrifice");
	public static final ResourceLocation SACRIFICE2 = ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID,
			"sacrifice2");
	public static final ResourceLocation SIGN = ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "sign");
	public static final ResourceLocation TABLE1 = ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "table1");
	public static final ResourceLocation TABLE2 = ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "table2");
	public static final ResourceLocation TABLE3 = ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "table3");
	public static final ResourceLocation TABLE4 = ResourceLocation.fromNamespaceAndPath(ExtraDelight.MOD_ID, "table4");
}
