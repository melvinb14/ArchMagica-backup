package com.melvinbur.archmagica.core.world.features.tree;


import com.melvinbur.archmagica.core.world.ConfiguredFeatureInit;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;


import java.util.Random;

public class CorruptedTreeGrower extends AbstractTreeGrower {



    @Override
    protected ConfiguredFeature<?, ?> getConfiguredFeature(Random p_60014_, boolean p_60015_) {
        return ConfiguredFeatureInit.CORRUPTED_TREE;
    }
}