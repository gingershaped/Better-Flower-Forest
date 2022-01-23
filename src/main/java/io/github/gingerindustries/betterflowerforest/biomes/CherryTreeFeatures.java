package io.github.gingerindustries.betterflowerforest.biomes;

import java.util.OptionalInt;

import com.google.common.collect.ImmutableList;

import io.github.gingerindustries.betterflowerforest.init.BlockSetup;
import net.minecraft.block.BlockState;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureSpread;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.MultipleRandomFeatureConfig;
import net.minecraft.world.gen.feature.TwoLayerFeature;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.FancyFoliagePlacer;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.treedecorator.BeehiveTreeDecorator;
import net.minecraft.world.gen.trunkplacer.FancyTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;

public class CherryTreeFeatures {
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> CHERRY_TREE = register("cherry_tree",
			Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(CherryTreeFeatures.States.CHERRY_TREE_LOG),
					new SimpleBlockStateProvider(CherryTreeFeatures.States.CHERRY_TREE_LEAVES),
					new BlobFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(0), 3),
					new StraightTrunkPlacer(4, 2, 0), new TwoLayerFeature(1, 0, 1))).ignoreVines().build()));
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> CHERRY_TREE_FANCY = register("cherry_tree_fancy",
			Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(CherryTreeFeatures.States.CHERRY_TREE_LOG),
					new SimpleBlockStateProvider(CherryTreeFeatures.States.CHERRY_TREE_LEAVES),
					new FancyFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(4), 4),
					new FancyTrunkPlacer(3, 11, 0), new TwoLayerFeature(0, 0, 0, OptionalInt.of(4)))).ignoreVines()
							.heightmap(Heightmap.Type.MOTION_BLOCKING).build()));
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> CHERRY_TREE_FANCY_BEES_005 = register(
			"cherry_tree_fancy_bees_005", Feature.TREE.configured(CHERRY_TREE_FANCY.config()
					.withDecorators(ImmutableList.of(CherryTreeFeatures.Placements.BEEHIVE_005))));
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> CHERRY_TREE_BEES_005 = register(
			"cherry_tree_bees_005", Feature.TREE.configured(
					CHERRY_TREE.config().withDecorators(ImmutableList.of(CherryTreeFeatures.Placements.BEEHIVE_005))));
	public static final ConfiguredFeature<?, ?> CHERRY_TREES = register("better_flower_forest_trees",
			Feature.RANDOM_SELECTOR
					.configured(new MultipleRandomFeatureConfig(ImmutableList.of(CHERRY_TREE_BEES_005.weighted(0.2F),
							CHERRY_TREE_FANCY_BEES_005.weighted(0.1F)), CHERRY_TREE_BEES_005))
					.decorated(Features.Placements.HEIGHTMAP_SQUARE)
					.decorated(Placement.COUNT_EXTRA.configured(new AtSurfaceWithExtraConfig(0, 0.075F, 2))));

	public static final class States {

		protected static final BlockState CHERRY_TREE_LOG = BlockSetup.CHERRY_LOG.get().defaultBlockState(); // TODO:
																												// Add
																												// custom
																												// logs
																												// and
																												// shit
		protected static final BlockState CHERRY_TREE_LEAVES = BlockSetup.CHERRY_LEAVES.get().defaultBlockState();

	}

	public static final class Placements {

		public static final BeehiveTreeDecorator BEEHIVE_005 = new BeehiveTreeDecorator(0.05F);

	}

	private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String p_243968_0_,
			ConfiguredFeature<FC, ?> p_243968_1_) {
		return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, p_243968_0_, p_243968_1_);
	}
}
