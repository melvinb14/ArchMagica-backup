package com.melvinbur.archmagica.core.world;





import com.melvinbur.archmagica.core.block.BlockInit;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

import java.util.List;




// Trees
public class ConfiguredFeatureInit {
    public static final ConfiguredFeature<TreeConfiguration, ?> CORRUPTED_TREE =
            FeatureUtils.register("corrupted_tree", Feature.TREE.configured(
                    new TreeConfiguration.TreeConfigurationBuilder(
                            BlockStateProvider.simple(BlockInit.CORRUPTED_LOG.get()),
                            new StraightTrunkPlacer(5, 6, 3),
                            BlockStateProvider.simple(BlockInit.CORRUPTED_LEAVES.get()),
                            new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 4),
                            new TwoLayersFeatureSize(1, 0, 2)).build()));





    public static final ConfiguredFeature<RandomFeatureConfiguration, ?> CORRUPTED_TREE_CHECKED =
            FeatureUtils.register("corrupted_tree_feature",
                    Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(
                            CORRUPTED_TREE.filteredByBlockSurvival(BlockInit.CORRUPTED_LEAVES.get()), 0.1f)),
                            CORRUPTED_TREE.filteredByBlockSurvival(BlockInit.CORRUPTED_LEAVES.get()))));




// Flowers
    public static final ConfiguredFeature<RandomPatchConfiguration, ?> AAPHUSH_FLOWER = FeatureUtils.register("flower_aaphush_flower",
            Feature.FLOWER.configured(new RandomPatchConfiguration(32, 6, 2, () -> {
                return Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(BlockInit.AAPHUSH_FLOWER.get()))).onlyWhenEmpty();
            })));

// Ores





    public static final List<OreConfiguration.TargetBlockState> OVERWORLD_JADE_ORES = List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, BlockInit.JADE_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, BlockInit.JADE_DEEPSLATE_ORE.get().defaultBlockState()));

    public static final ConfiguredFeature<?, ?> JADE_ORE = FeatureUtils.register("jade_ore",
            Feature.ORE.configured(new OreConfiguration(OVERWORLD_JADE_ORES, 6)));


    public static final List<OreConfiguration.TargetBlockState> OVERWORLD_MYTHRIL_ORES = List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, BlockInit.MYTHRIL_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, BlockInit.MYTHRIL_DEEPSLATE_ORE.get().defaultBlockState()));

    public static final ConfiguredFeature<?, ?> MYTHRIL_ORE = FeatureUtils.register("mythril_ore",
            Feature.ORE.configured(new OreConfiguration(OVERWORLD_MYTHRIL_ORES, 6)));

    public static final List<OreConfiguration.TargetBlockState> OVERWORLD_STYGIUM_ORES = List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, BlockInit.STYGIUM_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, BlockInit.STYGIUM_DEEPSLATE_ORE.get().defaultBlockState()));

    public static final ConfiguredFeature<?, ?> STYGIUM_ORE = FeatureUtils.register("stygium_ore",
            Feature.ORE.configured(new OreConfiguration(OVERWORLD_STYGIUM_ORES, 6)));









}