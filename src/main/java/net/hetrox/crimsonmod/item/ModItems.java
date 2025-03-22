package net.hetrox.crimsonmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.hetrox.crimsonmod.CrimsonMod;
import net.hetrox.crimsonmod.item.custom.DiceItem;
import net.hetrox.crimsonmod.item.custom.StaffItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.function.Function;

public class ModItems {

    public static final Item CRIMSONITE_INGOT =
            register("crimsonite_ingot", Item::new, new Item.Settings());
    public static final Item CRIMSONITE_NUGGET =
            register("crimsonite_nugget", Item::new, new Item.Settings());
    public static final Item RAW_CRIMSONITE =
            register("raw_crimsonite", Item::new, new Item.Settings());


    public static final Item DICE =
            register("crimsonite_dice", DiceItem::new, new Item.Settings()
                    .maxDamage(6)
                    .fireproof()
                    .rarity(Rarity.RARE));
    public static final Item STAFF =
            register("crimsonite_staff", StaffItem::new, new Item.Settings()
                    .maxDamage(32)
                    .rarity(Rarity.RARE)
                    .fireproof());



    public static Item register(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrimsonMod.MOD_ID, name));
        return Items.register(registryKey, factory, settings);
    }

    public static void registerModItems() {
        CrimsonMod.LOGGER.info("Registering mod items for " + CrimsonMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(CRIMSONITE_INGOT);
            fabricItemGroupEntries.add(RAW_CRIMSONITE);
            fabricItemGroupEntries.add(CRIMSONITE_NUGGET);
            fabricItemGroupEntries.add(DICE);
        });
    }
}