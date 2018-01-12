package com.mcmoddev.baseminerals.proxy;

import java.util.HashSet;

import com.mcmoddev.baseminerals.BaseMinerals;
import com.mcmoddev.baseminerals.init.*;
import com.mcmoddev.baseminerals.util.Config;
import com.mcmoddev.lib.oregen.FallbackGenerator;
import com.mcmoddev.lib.util.ConfigBase.Options;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.MissingModsException;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.versioning.ArtifactVersion;
import net.minecraftforge.fml.common.versioning.DefaultArtifactVersion;

/**
 * Base Minerals Common Proxy
 *
 * @author Jasmine Iwanek
 *
 */
public class CommonProxy {

	public void preInit(FMLPreInitializationEvent event) {
		BaseMinerals.logger.debug("CommonProxy preInit() with event %s", event.description());

		Config.init();

		if ((Options.requireMMDOreSpawn()) && (!Loader.isModLoaded("orespawn"))) {
			if(Options.fallbackOrespawn()) {
				GameRegistry.registerWorldGenerator(new FallbackGenerator(), 0);
			} else {
				final HashSet<ArtifactVersion> orespawnMod = new HashSet<>();
				orespawnMod.add(new DefaultArtifactVersion("3.2.0"));
				throw new MissingModsException(orespawnMod, "orespawn", "MMD Ore Spawn Mod (fallback generator disabled, MMD OreSpawn enabled)");
			}
		}

		Materials.init();
		Fluids.init();
		ItemGroups.init();
		Blocks.init();
		Items.init();
		VillagerTrades.init();
		ItemGroups.setupIcons();

		MinecraftForge.EVENT_BUS.register(com.mcmoddev.baseminerals.util.EventHandler.class);
	}

	public void init(FMLInitializationEvent event) {
		Recipes.init();

	}

	public void postInit(FMLPostInitializationEvent event) {
		Config.postInit();
	}

	public void onRemapBlock(RegistryEvent.MissingMappings<Block> event) {
		// Currently Unused
	}

	public void onRemapItem(RegistryEvent.MissingMappings<Item> event) {
		// Currently Unused
	}
}
