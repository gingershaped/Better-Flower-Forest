package io.github.gingerindustries.betterflowerforest.init;

import java.util.Objects;

import io.github.gingerindustries.betterflowerforest.BetterFlowerForest;
import io.github.gingerindustries.betterflowerforest.biomes.BetterFlowerForestBiome;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = BetterFlowerForest.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BiomeSetup {
	public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES,
            BetterFlowerForest.ID);
	
	public static final RegistryObject<Biome> BETTER_FLOWER_FOREST = BIOMES.register("better_flower_forest", BetterFlowerForestBiome::buildBetterFlowerForestBiome);
	
	@SubscribeEvent
	public static void setupBiomes(FMLCommonSetupEvent event) {
        event.enqueueWork(() ->
                setupBiome(BETTER_FLOWER_FOREST.get(), BiomeManager.BiomeType.WARM, 100000, 
                        BiomeDictionary.Type.OVERWORLD, BiomeDictionary.Type.FOREST)
        );

    }
    private static void setupBiome(Biome biome, BiomeManager.BiomeType type, int weight, BiomeDictionary.Type... types) {
        RegistryKey<Biome> key = RegistryKey.create(
                ForgeRegistries.Keys.BIOMES,
                Objects.requireNonNull(ForgeRegistries.BIOMES.getKey(biome))
        );

        BiomeDictionary.addTypes(key, types);
        BiomeManager.addBiome(type, new BiomeManager.BiomeEntry(key, weight));
    }

}
