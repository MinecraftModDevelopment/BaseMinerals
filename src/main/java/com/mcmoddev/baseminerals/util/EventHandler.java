package com.mcmoddev.baseminerals.util;

import com.mcmoddev.baseminerals.BaseMinerals;
import com.mcmoddev.baseminerals.init.Blocks;
import com.mcmoddev.baseminerals.init.Fluids;
import com.mcmoddev.baseminerals.init.Items;
import com.mcmoddev.baseminerals.init.Materials;
import com.mcmoddev.lib.events.*;

import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

@EventBusSubscriber
public class EventHandler {
	@SubscribeEvent
	public static void mmdlibRegisterMaterials(MMDLibRegisterMaterials ev) {
		Materials.init();
	}
	
	@SubscribeEvent
	public static void mmdlibRegisterBlocks(MMDLibRegisterBlocks ev) {
		Blocks.init();
	}

	@SubscribeEvent
	public static void mmdlibRegisterItems(MMDLibRegisterItems ev) {
		Items.init();
	}
	
	@SubscribeEvent
	public static void mmdlibRegisterFluids(MMDLibRegisterFluids ev) {
		Fluids.init();
	}

	@SubscribeEvent
	public static void onRemapBlock(RegistryEvent.MissingMappings<Block> event) {
		for (final RegistryEvent.MissingMappings.Mapping<Block> mapping : event.getAllMappings()) {
			if (mapping.key.getNamespace().equals(BaseMinerals.MODID)) {
				// dummy
			}
		}
	}

	@SubscribeEvent
	public static void onRemapItem(RegistryEvent.MissingMappings<Item> event) {
		for (final RegistryEvent.MissingMappings.Mapping<Item> mapping : event.getAllMappings()) {
			if (mapping.key.getNamespace().equals(BaseMinerals.MODID)) {
				// dummy
			}
		}
	}

}
