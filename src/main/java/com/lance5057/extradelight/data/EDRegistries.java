package com.lance5057.extradelight.data;

import java.util.List;
import java.util.Map;
import java.util.OptionalLong;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

import com.lance5057.extradelight.ExtraDelight;
import com.lance5057.extradelight.ExtraDelightBlocks;
import com.lance5057.extradelight.ExtraDelightWorldGen;
import com.lance5057.extradelight.worldgen.features.ExtraDelightFeatures;
import com.mojang.datafixers.util.Pair;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderSet;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.worldgen.Pools;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.AmbientMoodSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.FixedBiomeSource;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.DensityFunctions;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.NoiseRouter;
import net.minecraft.world.level.levelgen.NoiseSettings;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.RandomSpreadFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.BendingTrunkPlacer;
import net.minecraft.world.level.levelgen.heightproviders.ConstantHeight;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadStructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadType;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.structures.JigsawStructure;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;

public class EDRegistries {
	private static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
			.add(Registries.CONFIGURED_FEATURE, bootstrap -> {
				bootstrap.register(ExtraDelightWorldGen.CONFIGURED_CORN_MAZE, new ConfiguredFeature<>(
						ExtraDelightFeatures.CORN_MAZE_FEATURE.get(),
						new SimpleBlockConfiguration(BlockStateProvider.simple(ExtraDelightBlocks.CORN_BOTTOM.get()))));
				bootstrap.register(ExtraDelightWorldGen.CONFIGURED_CORN_RAIL,
						new ConfiguredFeature<>(ExtraDelightFeatures.CORN_RAIL_FEATURE.get(),
								new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.RAIL))));

				bootstrap.register(ExtraDelightWorldGen.CONFIGURED_CINNAMON_TREE,
						new ConfiguredFeature<>(Feature.TREE,
								new TreeConfiguration.TreeConfigurationBuilder(
										BlockStateProvider.simple(ExtraDelightBlocks.CINNAMON_LOG.get()),
										new BendingTrunkPlacer(3, 0, 3, 6, ConstantInt.of(1)),
										BlockStateProvider.simple(ExtraDelightBlocks.CINNAMON_LEAVES.get()),
										new RandomSpreadFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0),
												ConstantInt.of(2), 24),
										new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build()));
			}).add(Registries.PLACED_FEATURE, bootstrap -> {
				HolderGetter<ConfiguredFeature<?, ?>> cfgs = bootstrap.lookup(Registries.CONFIGURED_FEATURE);
				bootstrap.register(ExtraDelightWorldGen.PLACED_CORN_MAZE,
						new PlacedFeature(cfgs.getOrThrow(ExtraDelightWorldGen.CONFIGURED_CORN_MAZE),
								List.of(CountPlacement.of(1), InSquarePlacement.spread(),
										PlacementUtils.HEIGHTMAP_WORLD_SURFACE)));
				bootstrap.register(ExtraDelightWorldGen.PLACED_CORN_RAIL,
						new PlacedFeature(cfgs.getOrThrow(ExtraDelightWorldGen.CONFIGURED_CORN_RAIL),
								List.of(CountPlacement.of(1), InSquarePlacement.spread(),
										PlacementUtils.HEIGHTMAP_WORLD_SURFACE)));

				bootstrap.register(ExtraDelightWorldGen.PLACED_CINNAMON_TREE, new PlacedFeature(
						cfgs.getOrThrow(ExtraDelightWorldGen.CONFIGURED_CINNAMON_TREE),
						List.of(PlacementUtils.filteredByBlockSurvival(ExtraDelightBlocks.CINNAMON_SAPLING.get()))));
			}).add(Registries.BIOME, bootstrap -> {
				HolderGetter<PlacedFeature> placedFeatures = bootstrap.lookup(Registries.PLACED_FEATURE);
				bootstrap.register(ExtraDelightWorldGen.CORNFIELD_BIOME, new Biome.BiomeBuilder()
						.downfall(0.4F)
						.generationSettings(new BiomeGenerationSettings(Map.of(),
								List.of(HolderSet.direct(
										placedFeatures.getOrThrow(ExtraDelightWorldGen.PLACED_CORN_RAIL),
										placedFeatures.getOrThrow(VegetationPlacements.PATCH_PUMPKIN)),
										HolderSet.empty(), HolderSet.empty(), HolderSet.empty(), HolderSet.empty(),
										HolderSet.empty(), HolderSet.empty(), HolderSet.empty(), HolderSet.empty(),
										HolderSet.direct(
												placedFeatures.getOrThrow(ExtraDelightWorldGen.PLACED_CORN_MAZE)))))
						.hasPrecipitation(true)
						.mobSpawnSettings(new MobSpawnSettings.Builder()
								.addSpawn(MobCategory.AMBIENT,
										new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8))
								.addSpawn(MobCategory.MONSTER,
										new MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1))
								.addSpawn(MobCategory.MONSTER,
										new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 95, 4, 4))
								.addSpawn(MobCategory.MONSTER,
										new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 5, 1, 1))
								.build())
						.specialEffects(new BiomeSpecialEffects.Builder()
								.ambientMoodSound(new AmbientMoodSettings(SoundEvents.AMBIENT_CAVE, 6000, 8, 2))
								.fogColor(1248036).foliageColorOverride(4798742).grassColorOverride(4798742).skyColor(0)
								.waterColor(2955861).waterFogColor(1248036).build())
						.temperature(5).build());
			}).add(Registries.DIMENSION_TYPE, bootstrap -> {
				bootstrap.register(ExtraDelightWorldGen.CORNFIELD_TYPE,
						new DimensionType(OptionalLong.of(18000), true, false, true, false, 1, false, false, 0, 64, 64,
								BlockTags.INFINIBURN_OVERWORLD, BuiltinDimensionTypes.OVERWORLD_EFFECTS, 0,
								new DimensionType.MonsterSettings(false, false, UniformInt.of(0, 15), 0)));
			}).add(Registries.LEVEL_STEM, bootstrap -> {
				HolderGetter<Biome> biomes = bootstrap.lookup(Registries.BIOME);
				HolderGetter<DimensionType> dimensionTypes = bootstrap.lookup(Registries.DIMENSION_TYPE);
				HolderGetter<NoiseGeneratorSettings> noiseSettings = bootstrap.lookup(Registries.NOISE_SETTINGS);
				BiomeSource biomeSource = new FixedBiomeSource(biomes.getOrThrow(ExtraDelightWorldGen.CORNFIELD_BIOME));
				NoiseBasedChunkGenerator chunkGenerator = new NoiseBasedChunkGenerator(biomeSource,
						noiseSettings.getOrThrow(ExtraDelightWorldGen.CORNFIELD_NOISE));
				bootstrap.register(ExtraDelightWorldGen.CORNFIELD_STEM,
						new LevelStem(dimensionTypes.getOrThrow(ExtraDelightWorldGen.CORNFIELD_TYPE), chunkGenerator));
			}).add(Registries.NOISE_SETTINGS, bootstrap -> {
				bootstrap.register(ExtraDelightWorldGen.CORNFIELD_NOISE,
						new NoiseGeneratorSettings(new NoiseSettings(0, 128, 2, 2), Blocks.STONE.defaultBlockState(),
								Blocks.STONE.defaultBlockState(),
								new NoiseRouter(DensityFunctions.zero(), DensityFunctions.zero(),
										DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero(),
										DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero(),
										DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero(),
										DensityFunctions.yClampedGradient(0, 64, 1, -1), DensityFunctions.zero(),
										DensityFunctions.zero(), DensityFunctions.zero()),
								SurfaceRules.state(Blocks.GRASS_BLOCK.defaultBlockState()), List.of(), 0, false, false,
								false, false));
			}).add(Registries.STRUCTURE, bootstrap -> {
				HolderGetter<Biome> biomes = bootstrap.lookup(Registries.BIOME);
				HolderGetter<StructureTemplatePool> templatePools = bootstrap.lookup(Registries.TEMPLATE_POOL);
				for (ResourceLocation id : List.of(ExtraDelightWorldGen.BARN, ExtraDelightWorldGen.CAMP1,
						ExtraDelightWorldGen.CAMP2, ExtraDelightWorldGen.DOLL_CIRCLE, ExtraDelightWorldGen.DOLL_CIRCLE1,
						ExtraDelightWorldGen.DOLL_CIRCLE2, ExtraDelightWorldGen.DOLL_CIRCLE3,
						ExtraDelightWorldGen.DOLL_CIRCLE4, ExtraDelightWorldGen.FOUNTAIN,
						ExtraDelightWorldGen.HAUNTEDHOUSE, ExtraDelightWorldGen.PUMPKIN_PATCH2,
						ExtraDelightWorldGen.PUMPKIN_PATCH3, ExtraDelightWorldGen.PUMPKIN_PATCH4,
						ExtraDelightWorldGen.PUMPKIN_PATCH5, ExtraDelightWorldGen.PUMPKIN_PILE1,
						ExtraDelightWorldGen.SACRIFICE, ExtraDelightWorldGen.SACRIFICE2, ExtraDelightWorldGen.SIGN,
						ExtraDelightWorldGen.TABLE1, ExtraDelightWorldGen.TABLE2, ExtraDelightWorldGen.TABLE3,
						ExtraDelightWorldGen.TABLE4)) {
					bootstrap
							.register(ResourceKey.create(Registries.STRUCTURE, id),
									new JigsawStructure(
											new Structure.StructureSettings(
													HolderSet.direct(
															biomes.getOrThrow(ExtraDelightWorldGen.CORNFIELD_BIOME)),
													Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES,
													TerrainAdjustment.BEARD_THIN),
											templatePools.getOrThrow(ResourceKey.create(Registries.TEMPLATE_POOL, id)),
											1, ConstantHeight.ZERO, false, Heightmap.Types.WORLD_SURFACE_WG));
				}
				bootstrap.register(ResourceKey.create(Registries.STRUCTURE, ExtraDelightWorldGen.RAIL_STOP),
						new JigsawStructure(
								new Structure.StructureSettings(
										HolderSet.direct(biomes.getOrThrow(ExtraDelightWorldGen.CORNFIELD_BIOME)),
										Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.NONE),
								templatePools.getOrThrow(
										ResourceKey.create(Registries.TEMPLATE_POOL, ExtraDelightWorldGen.RAIL_STOP)),
								1, ConstantHeight.ZERO, false, Heightmap.Types.WORLD_SURFACE_WG));
			}).add(Registries.STRUCTURE_SET, bootstrap -> {
				HolderGetter<Structure> structures = bootstrap.lookup(Registries.STRUCTURE);
				bootstrap.register(ExtraDelightWorldGen.STRUCTURE_SET,
						new StructureSet(List.of(entry(ExtraDelightWorldGen.BARN, 1, structures),
								entry(ExtraDelightWorldGen.CAMP1, 5, structures),
								entry(ExtraDelightWorldGen.CAMP2, 5, structures),
								entry(ExtraDelightWorldGen.DOLL_CIRCLE, 25, structures),
								entry(ExtraDelightWorldGen.DOLL_CIRCLE1, 25, structures),
								entry(ExtraDelightWorldGen.DOLL_CIRCLE2, 25, structures),
								entry(ExtraDelightWorldGen.DOLL_CIRCLE3, 25, structures),
								entry(ExtraDelightWorldGen.DOLL_CIRCLE4, 25, structures),
								entry(ExtraDelightWorldGen.FOUNTAIN, 5, structures),
								entry(ExtraDelightWorldGen.HAUNTEDHOUSE, 1, structures),
								entry(ExtraDelightWorldGen.PUMPKIN_PATCH2, 100, structures),
//                                entry(PUMPKIN_PATCH3, 100, structures),
								entry(ExtraDelightWorldGen.PUMPKIN_PATCH4, 100, structures),
								entry(ExtraDelightWorldGen.PUMPKIN_PATCH5, 100, structures),
								entry(ExtraDelightWorldGen.PUMPKIN_PILE1, 100, structures),
								entry(ExtraDelightWorldGen.SACRIFICE, 1, structures),
								entry(ExtraDelightWorldGen.SACRIFICE2, 1, structures),
								entry(ExtraDelightWorldGen.SIGN, 1, structures),
								entry(ExtraDelightWorldGen.TABLE1, 25, structures),
								entry(ExtraDelightWorldGen.TABLE2, 25, structures),
								entry(ExtraDelightWorldGen.TABLE3, 25, structures),
								entry(ExtraDelightWorldGen.TABLE4, 25, structures)),
								new RandomSpreadStructurePlacement(15, 5, RandomSpreadType.LINEAR, 1426250756)));
			}).add(Registries.TEMPLATE_POOL, bootstrap -> {
				HolderGetter<StructureTemplatePool> templatePools = bootstrap.lookup(Registries.TEMPLATE_POOL);
				for (ResourceLocation id : List.of(ExtraDelightWorldGen.BARN, ExtraDelightWorldGen.CAMP1,
						ExtraDelightWorldGen.CAMP2, ExtraDelightWorldGen.DOLL_CIRCLE, ExtraDelightWorldGen.DOLL_CIRCLE1,
						ExtraDelightWorldGen.DOLL_CIRCLE2, ExtraDelightWorldGen.DOLL_CIRCLE3,
						ExtraDelightWorldGen.DOLL_CIRCLE4, ExtraDelightWorldGen.FOUNTAIN,
						ExtraDelightWorldGen.HAUNTEDHOUSE, ExtraDelightWorldGen.PUMPKIN_PATCH2,
						ExtraDelightWorldGen.PUMPKIN_PATCH3, ExtraDelightWorldGen.PUMPKIN_PATCH4,
						ExtraDelightWorldGen.PUMPKIN_PATCH5, ExtraDelightWorldGen.PUMPKIN_PILE1,
						ExtraDelightWorldGen.RAIL_STOP, ExtraDelightWorldGen.SACRIFICE, ExtraDelightWorldGen.SACRIFICE2,
						ExtraDelightWorldGen.SIGN, ExtraDelightWorldGen.TABLE1, ExtraDelightWorldGen.TABLE2,
						ExtraDelightWorldGen.TABLE3, ExtraDelightWorldGen.TABLE4)) {
					bootstrap.register(ResourceKey.create(Registries.TEMPLATE_POOL, id),
							new StructureTemplatePool(templatePools.getOrThrow(Pools.EMPTY),
									List.of(Pair.of(StructurePoolElement.single(id.toString()), 1)),
									StructureTemplatePool.Projection.RIGID));
				}
			});

	public static DatapackBuiltinEntriesProvider provider(PackOutput output,
			CompletableFuture<HolderLookup.Provider> lookupProvider) {
		return new DatapackBuiltinEntriesProvider(output, lookupProvider, BUILDER, Set.of(ExtraDelight.MOD_ID));
	}

	private static StructureSet.StructureSelectionEntry entry(ResourceLocation id, int weight,
			HolderGetter<Structure> lookup) {
		return new StructureSet.StructureSelectionEntry(lookup.getOrThrow(ResourceKey.create(Registries.STRUCTURE, id)),
				weight);
	}
}