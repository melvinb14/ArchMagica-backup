package com.melvinbur.archmagica.core.world;


import com.melvinbur.archmagica.ArchMagica;
import com.melvinbur.archmagica.core.world.gen.features.flower.FlowerGenerationInit;
import com.melvinbur.archmagica.core.world.gen.features.plant.PlantGenerationInit;
import com.melvinbur.archmagica.core.world.gen.features.tree.TreeGenerationInit;
import com.melvinbur.archmagica.core.world.gen.features.ores.OreGenerationInit;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ArchMagica.MOD_ID)
public class WorldEventInit {

    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void biomeLoadingEvent(final BiomeLoadingEvent event) {
        OreGenerationInit.generateOres(event);


        TreeGenerationInit.generateTrees(event);
        PlantGenerationInit.generatePlants(event);
        FlowerGenerationInit.generateFlowers(event);
    }
}



