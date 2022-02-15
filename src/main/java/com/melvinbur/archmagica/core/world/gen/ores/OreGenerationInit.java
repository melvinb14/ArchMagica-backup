package com.melvinbur.archmagica.core.world.gen.ores;


import com.melvinbur.archmagica.core.world.PlacementFeaturesInit;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.List;
import java.util.function.Supplier;

public class OreGenerationInit {


public static void generateOres(final BiomeLoadingEvent event) {
        List<Supplier<PlacedFeature>> base =
        event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES);

        base.add(() -> PlacementFeaturesInit.JADE_ORE_PLACED);
        base.add(() -> PlacementFeaturesInit.MYTHRIL_ORE_PLACED);
        base.add(() -> PlacementFeaturesInit.STYGIUM_ORE_PLACED);
        base.add(() -> PlacementFeaturesInit.STYGIUM_ORE_PLACED);


        }



}



