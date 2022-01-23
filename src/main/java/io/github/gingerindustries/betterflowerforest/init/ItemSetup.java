package io.github.gingerindustries.betterflowerforest.init;

import io.github.gingerindustries.betterflowerforest.BetterFlowerForest;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemSetup {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
			BetterFlowerForest.ID);

	public static final RegistryObject<Item> CHERRY = ITEMS.register("cherry", () -> new Item(new Item.Properties()
			.food((new Food.Builder().nutrition(3).saturationMod(0.1F).build())).tab(BetterFlowerForest.TAB)));

	public static final RegistryObject<Item> CHERRY_LEAVES_ITEM = ITEMS.register("cherry_leaves",
			() -> new BlockItem(BlockSetup.CHERRY_LEAVES.get(), new Item.Properties().tab(BetterFlowerForest.TAB)));
	public static final RegistryObject<Item> CHERRY_SAPLING_ITEM = ITEMS.register("cherry_sapling",
			() -> new BlockItem(BlockSetup.CHERRY_SAPLING.get(), new Item.Properties().tab(BetterFlowerForest.TAB)));
	public static final RegistryObject<Item> CHERRY_LOG_ITEM = ITEMS.register("cherry_log",
			() -> new BlockItem(BlockSetup.CHERRY_LOG.get(), new Item.Properties().tab(BetterFlowerForest.TAB)));
	public static final RegistryObject<Item> CHERRY_PLANKS_ITEM = ITEMS.register("cherry_planks",
			() -> new BlockItem(BlockSetup.CHERRY_PLANKS.get(), new Item.Properties().tab(BetterFlowerForest.TAB)));
	public static final RegistryObject<Item> CHERRY_SLAB_ITEM = ITEMS.register("cherry_slab",
			() -> new BlockItem(BlockSetup.CHERRY_SLAB.get(), new Item.Properties().tab(BetterFlowerForest.TAB)));
	public static final RegistryObject<Item> CHERRY_STAIRS_ITEM = ITEMS.register("cherry_stairs",
			() -> new BlockItem(BlockSetup.CHERRY_STAIRS.get(), new Item.Properties().tab(BetterFlowerForest.TAB)));
	public static final RegistryObject<Item> CHERRY_BUTTON_ITEM = ITEMS.register("cherry_button",
			() -> new BlockItem(BlockSetup.CHERRY_BUTTON.get(), new Item.Properties().tab(BetterFlowerForest.TAB)));

}
