package com.melvinbur.archmagica.core.world;





import com.melvinbur.archmagica.core.block.BlockInit;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;


import net.minecraft.world.level.levelgen.feature.trunkplacers.GiantTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

import static net.minecraft.data.worldgen.features.FeatureUtils.register;


// Trees
public class ConfiguredFeatureInit {
    public static final ConfiguredFeature<TreeConfiguration, ?> CORRUPTED_TREE =
            register("corrupted_tree", Feature.TREE.configured(
                    new TreeConfiguration.TreeConfigurationBuilder(
                            BlockStateProvider.simple(BlockInit.CORRUPTED_LOG.get()),
                            new GiantTrunkPlacer(5, 2, 2), BlockStateProvider.simple
                           (BlockInit.CORRUPTED_LEAVES.get()),
                            new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 1),
                            new TwoLayersFeatureSize(1, 0, 2)).build()));





    public static final ConfiguredFeature<RandomFeatureConfiguration, ?> CORRUPTED_TREE_CHECKED =
            register("corrupted_tree_feature",
                    Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(
                            CORRUPTED_TREE.filteredByBlockSurvival(BlockInit.CORRUPTED_LEAVES.get()), 0.1f)),
                            CORRUPTED_TREE.filteredByBlockSurvival(BlockInit.CORRUPTED_LEAVES.get()))));







// Flowers
    public static final ConfiguredFeature<RandomPatchConfiguration, ?> AAPHUSH_FLOWER = register("flower_aaphush_flower",
        Feature.FLOWER.configured(new RandomPatchConfiguration(64, 6, 2, () ->
                Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(BlockInit.AAPHUSH_FLOWER.get()))).onlyWhenEmpty())));

// Environment

    public static final ConfiguredFeature<RandomPatchConfiguration, ?> WATERPLANT = FeatureUtils.register("waterplant", Feature.RANDOM_PATCH.configured(new RandomPatchConfiguration(5, 3, 3, () ->
            Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(BlockInit.WATERPLANT.get()))).onlyWhenEmpty())));





// Ores

    public static final RuleTest NATURAL_STONE = new TagMatchTest(BlockTags.BASE_STONE_OVERWORLD);
    public static final RuleTest NETHERRACK = new BlockMatchTest(Blocks.NETHERRACK);
    public static final RuleTest ENDSTONE = new BlockMatchTest(Blocks.END_STONE);
    public static final RuleTest NETHER_ORE_REPLACEABLES = new TagMatchTest(BlockTags.BASE_STONE_NETHER);



    public static final List<OreConfiguration.TargetBlockState> OVERWORLD_JADE_ORES = List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, BlockInit.JADE_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, BlockInit.JADE_DEEPSLATE_ORE.get().defaultBlockState()));

    public static final ConfiguredFeature<?, ?> JADE_ORE = register("jade_ore",
            Feature.ORE.configured(new OreConfiguration(OVERWORLD_JADE_ORES, 9)));


    public static final List<OreConfiguration.TargetBlockState> OVERWORLD_MYTHRIL_ORES = List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, BlockInit.MYTHRIL_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, BlockInit.MYTHRIL_DEEPSLATE_ORE.get().defaultBlockState()));

    public static final ConfiguredFeature<?, ?> MYTHRIL_ORE = register("mythril_ore",
            Feature.ORE.configured(new OreConfiguration(OVERWORLD_MYTHRIL_ORES, 9)));

    public static final List<OreConfiguration.TargetBlockState> OVERWORLD_STYGIUM_ORES = List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, BlockInit.STYGIUM_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, BlockInit.STYGIUM_DEEPSLATE_ORE.get().defaultBlockState()));

    public static final ConfiguredFeature<?, ?> STYGIUM_ORE = register("stygium_ore",
            Feature.ORE.configured(new OreConfiguration(OVERWORLD_STYGIUM_ORES, 6)));


    public static final List<OreConfiguration.TargetBlockState> OVERWORLD_CELESTINE_ORES = List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, BlockInit.CELESTINE_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, BlockInit.CELESTINE_DEEPSLATE_ORE.get().defaultBlockState()));

    public static final ConfiguredFeature<?, ?> CELESTINE_ORE = register("celestine_ore",
            Feature.ORE.configured(new OreConfiguration(OVERWORLD_CELESTINE_ORES, 5)));

    // Natural Stone
    public static final ConfiguredFeature<?, ?> BRECCIA_STONE = register("breccia_stone",
            Feature.ORE.configured(new OreConfiguration(NATURAL_STONE, BlockInit.BRECCIA_STONE.get().defaultBlockState(), 64)));

    // Nether
    public static final ConfiguredFeature<?, ?> ORASINE_ORE = register("orasine_ore",
            Feature.ORE.configured(new OreConfiguration(NETHER_ORE_REPLACEABLES , BlockInit.ORASINE_ORE.get().defaultBlockState(), 8)));

    // Nether Stone
    public static final ConfiguredFeature<?, ?> PURGATORY_STONE = register("purgatory_stone",
            Feature.ORE.configured(new OreConfiguration(NETHERRACK , BlockInit.PURGATORY_STONE.get().defaultBlockState(), 33)));

    // End
    public static final ConfiguredFeature<?, ?> EDAPHINE_ORE = register("edaphine_ore",
            Feature.ORE.configured(new OreConfiguration(ENDSTONE , BlockInit.EDAPHINE_ORE.get().defaultBlockState(), 5)));











}