package io.github.gingerindustries.betterflowerforest.biomes;

import java.util.Random;

import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;

public class CherryTree extends Tree {

	@Override
	protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getConfiguredFeature(Random p_225546_1_,
			boolean p_225546_2_) {
		if (p_225546_1_.nextInt(10) == 0) {
	         return p_225546_2_ ? CherryTreeFeatures.CHERRY_TREE_BEES_005 : CherryTreeFeatures.CHERRY_TREE_FANCY;
	    } else {
	         return p_225546_2_ ? CherryTreeFeatures.CHERRY_TREE_BEES_005 : CherryTreeFeatures.CHERRY_TREE;
	    }
	}

}
