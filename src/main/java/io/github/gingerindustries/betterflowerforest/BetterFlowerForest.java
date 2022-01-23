package io.github.gingerindustries.betterflowerforest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.github.gingerindustries.betterflowerforest.init.BiomeSetup;
import io.github.gingerindustries.betterflowerforest.init.BlockSetup;
import io.github.gingerindustries.betterflowerforest.init.ItemSetup;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("betterflowerforest")
public class BetterFlowerForest
{
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String ID = "betterflowerforest";

    public BetterFlowerForest() {
        // Register the setup method for modloading
    	final IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::setup);
        bus.addListener(this::clientSetup);
        
        ItemSetup.ITEMS.register(bus);
        BlockSetup.BLOCKS.register(bus);
        BiomeSetup.BIOMES.register(bus);
        

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
    	
        LOGGER.info("Hello from Better Flower Forest!");
    }
    private void clientSetup(final FMLClientSetupEvent event) {
    	RenderTypeLookup.setRenderLayer(BlockSetup.CHERRY_SAPLING.get(), RenderType.cutout());
    	LOGGER.info("Client-side setup complete");
    }
    public static final ItemGroup TAB = new ItemGroup("betterflowerforest") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemSetup.CHERRY_LEAVES_ITEM.get());
        }
    };


    
}
