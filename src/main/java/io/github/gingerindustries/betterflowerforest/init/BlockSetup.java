package io.github.gingerindustries.betterflowerforest.init;

import io.github.gingerindustries.betterflowerforest.BetterFlowerForest;
import io.github.gingerindustries.betterflowerforest.blocks.CherryLeaves;
import io.github.gingerindustries.betterflowerforest.blocks.CherrySapling;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.WoodButtonBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.util.Direction;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockSetup {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			BetterFlowerForest.ID);

	public static final RegistryObject<Block> CHERRY_LEAVES = BLOCKS.register("cherry_leaves",
			() -> new CherryLeaves());
	public static final RegistryObject<Block> CHERRY_LOG = BLOCKS.register("cherry_log",
			() -> log(MaterialColor.TERRACOTTA_PURPLE, MaterialColor.STONE));
	public static final RegistryObject<Block> CHERRY_SAPLING = BLOCKS.register("cherry_sapling",
			() -> new CherrySapling());
	public static final RegistryObject<Block> CHERRY_PLANKS = BLOCKS.register("cherry_planks", () -> new Block(
			AbstractBlock.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_PURPLE).strength(2.0F, 3.0F)));
	public static final RegistryObject<Block> CHERRY_SLAB = BLOCKS.register("cherry_slab",
			() -> new SlabBlock(AbstractBlock.Properties.copy(CHERRY_PLANKS.get())));
	public static final RegistryObject<Block> CHERRY_STAIRS = BLOCKS.register("cherry_stairs",
			() -> new StairsBlock(() -> CHERRY_PLANKS.get().defaultBlockState(),
					AbstractBlock.Properties.copy(CHERRY_PLANKS.get())));
	public static final RegistryObject<Block> CHERRY_BUTTON = BLOCKS.register("cherry_button",
			() -> new WoodButtonBlock(AbstractBlock.Properties.of(Material.DECORATION).noCollission().strength(0.5F)
					.sound(SoundType.WOOD)));

	private static RotatedPillarBlock log(MaterialColor p_235430_0_, MaterialColor p_235430_1_) {
		return new RotatedPillarBlock(AbstractBlock.Properties.of(Material.WOOD, (p_235431_2_) -> {
			return p_235431_2_.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? p_235430_0_ : p_235430_1_;
		}).strength(2.0F).sound(SoundType.WOOD));
	}

}
