package com.melvinbur.archmagica.core.world.gen.features.plant;

import com.melvinbur.archmagica.core.world.PlacementFeaturesInit;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

public class PlantGenerationInit {

    public static void generatePlants(final BiomeLoadingEvent event) {
        ResourceKey<Biome> key = ResourceKey.create(Registry.BIOME_REGISTRY, event.getName());
        Set<BiomeDictionary.Type> types = BiomeDictionary.getTypes(key);


            if  (types.contains(BiomeDictionary.Type.SWAMP)) {
                List<Supplier<PlacedFeature>> base =
                        event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION);


                base.add(() -> PlacementFeaturesInit.WATERPLANT_PLACED);
            }
        }
    }


