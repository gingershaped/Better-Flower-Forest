package io.github.gingerindustries.betterflowerforest.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class CherryLeaves extends LeavesBlock {

	public CherryLeaves() {
		super(AbstractBlock.Properties.of(Material.LEAVES).strength(0.2F).randomTicks().sound(SoundType.GRASS)
				.noOcclusion().isSuffocating((BlockState x, IBlockReader y, BlockPos z) -> {
					return false;
				}).isViewBlocking((BlockState x, IBlockReader y, BlockPos z) -> {
					return false;
				}));
	}

}
