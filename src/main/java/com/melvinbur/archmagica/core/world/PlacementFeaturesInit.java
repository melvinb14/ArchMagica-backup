package com.melvinbur.archmagica.core.world;

import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;



public class PlacementFeaturesInit {

// Trees
    public static final PlacedFeature CORRUPTED_PLACED = PlacementUtils.register("corrupted_placed",
            ConfiguredFeatureInit.CORRUPTED_TREE_CHECKED.placed(VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(1, 0.1f, 2))));

// Flowers
    public static final PlacedFeature AAPHUSH_FLOWER_PLACED = PlacementUtils.register("aaphush_flower_placed",
    ConfiguredFeatureInit.AAPHUSH_FLOWER.placed(InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));


// Ores

    public static final PlacedFeature JADE_ORE_PLACED = PlacementUtils.register("jade_ore_placed",
            ConfiguredFeatureInit.JADE_ORE.placed(OrePlacementInit.commonOrePlacement(7, // VeinsPerChunk
                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));

    public static final PlacedFeature MYTHRIL_ORE_PLACED = PlacementUtils.register("mythril_ore_placed",
            ConfiguredFeatureInit.MYTHRIL_ORE.placed(OrePlacementInit.commonOrePlacement(5, // VeinsPerChunk
                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));

    public static final PlacedFeature STYGIUM_ORE_PLACED = PlacementUtils.register("stygium_ore_placed",
            ConfiguredFeatureInit.STYGIUM_ORE.placed(OrePlacementInit.commonOrePlacement(4, // VeinsPerChunk
                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));





}

