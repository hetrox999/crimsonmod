package net.hetrox.crimsonmod;

import net.fabricmc.api.ModInitializer;

import net.hetrox.crimsonmod.block.ModBlocks;
import net.hetrox.crimsonmod.component.ModDataComponentTypes;
import net.hetrox.crimsonmod.item.ModItemGroups;
import net.hetrox.crimsonmod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CrimsonMod implements ModInitializer {

	public static final String MOD_ID = "crimson-mod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();
		ModBlocks.registerModBlocks();
		ModDataComponentTypes.registerDataComponentTypes();

	}
}