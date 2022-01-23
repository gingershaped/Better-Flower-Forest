package io.github.gingerindustries.betterflowerforest.blocks;
import io.github.gingerindustries.betterflowerforest.biomes.CherryTree;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class CherrySapling extends SaplingBlock {

	public CherrySapling() {
		super(new CherryTree(), AbstractBlock.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS));
	}
}
