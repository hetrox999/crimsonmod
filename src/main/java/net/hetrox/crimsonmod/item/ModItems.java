package net.hetrox.crimsonmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.hetrox.crimsonmod.CrimsonMod;
import net.hetrox.crimsonmod.CrimsonModClient;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item CRIMSONITE_INGOT =
            register("crimsonite_ingot", new Item.Settings());
    public static final Item CRIMSONITE_NUGGET =
            register("crimsonite_nugget", new Item.Settings());
    public static final Item RAW_CRIMSONITE =
            register("raw_crimsonite", new Item.Settings());

    public static Item register(String name, Item.Settings settings) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrimsonMod.MOD_ID, name));
        Item item = new Item(settings.registryKey(key));
        return Registry.register(Registries.ITEM, key, item);
    }

    public static void registerModItems() {
        CrimsonMod.LOGGER.info("Registering mod items for "+ CrimsonMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(CRIMSONITE_INGOT);
            fabricItemGroupEntries.add(RAW_CRIMSONITE);
            fabricItemGroupEntries.add(CRIMSONITE_NUGGET);
        });


    }
}
