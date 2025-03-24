package net.hetrox.crimsonmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.hetrox.crimsonmod.CrimsonMod;
import net.hetrox.crimsonmod.item.custom.ChiselItem;
import net.hetrox.crimsonmod.item.custom.DiceItem;
import net.hetrox.crimsonmod.item.custom.HammerItem;
import net.hetrox.crimsonmod.item.custom.StaffItem;
import net.hetrox.crimsonmod.util.ModTags;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.*;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.function.Function;

public class ModItems {

    public static final ToolMaterial CRIMSONITE_TOOL_MATERIAL = new ToolMaterial(
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            1091,
            7F,
            2.5F,
            12,
            ModTags.Items.CRIMSONITE_TOOL_MATERIALS);


    public static final Item CRIMSONITE_INGOT =
            register("crimsonite_ingot", Item::new, new Item.Settings());
    public static final Item CRIMSONITE_NUGGET =
            register("crimsonite_nugget", Item::new, new Item.Settings());
    public static final Item RAW_CRIMSONITE =
            register("raw_crimsonite", Item::new, new Item.Settings());


    public static final Item CRIMSONITE_SWORD =
            register("crimsonite_sword",
                    settings -> new SwordItem(CRIMSONITE_TOOL_MATERIAL,3.0f,-2.4F,settings),
                    new Item.Settings());

    public static final Item CRIMSONITE_PICKAXE =
            register("crimsonite_pickaxe",
                    settings -> new PickaxeItem(CRIMSONITE_TOOL_MATERIAL, 1f, -2.8f, settings),
                    new Item.Settings());

    public static final Item CRIMSONITE_SHOVEL =
            register("crimsonite_shovel",
                    settings -> new ShovelItem(CRIMSONITE_TOOL_MATERIAL, 1.5f, -3f, settings),
                    new Item.Settings());

    public static final Item CRIMSONITE_AXE =
            register("crimsonite_axe",
                    settings -> new AxeItem(CRIMSONITE_TOOL_MATERIAL, 5.5f, -3f, settings),
                    new Item.Settings());

    public static final Item CRIMSONITE_HOE =
            register("crimsonite_hoe",
                    settings -> new HoeItem(CRIMSONITE_TOOL_MATERIAL, -2.5f, 0f, settings),
                    new Item.Settings());
    public static final Item CRIMSONITE_HAMMER =
            register("crimsonite_hammer",
                    settings -> new HammerItem(CRIMSONITE_TOOL_MATERIAL,BlockTags.PICKAXE_MINEABLE,  7f, -3.4f, settings),
                    new Item.Settings());



    public static final Item CRIMSONITE_HELMET = register(
            "crimsonite_helmet",
            settings -> new ArmorItem(ModArmorMaterial.INSTANCE, EquipmentType.HELMET, settings),
            new Item.Settings().maxDamage(EquipmentType.HELMET.getMaxDamage(ModArmorMaterial.BASE_DURABILITY))
    );
    public static final Item CRIMSONITE_CHESTPLATE = register(
            "crimsonite_chestplate",
            settings -> new ArmorItem(ModArmorMaterial.INSTANCE, EquipmentType.CHESTPLATE, settings),
            new Item.Settings().maxDamage(EquipmentType.CHESTPLATE.getMaxDamage(ModArmorMaterial.BASE_DURABILITY))
    );

    public static final Item CRIMSONITE_LEGGINGS = register(
            "crimsonite_leggings",
            settings -> new ArmorItem(ModArmorMaterial.INSTANCE, EquipmentType.LEGGINGS, settings),
            new Item.Settings().maxDamage(EquipmentType.LEGGINGS.getMaxDamage(ModArmorMaterial.BASE_DURABILITY))
    );

    public static final Item CRIMSONITE_BOOTS = register(
            "crimsonite_boots",
            settings -> new ArmorItem(ModArmorMaterial.INSTANCE, EquipmentType.BOOTS, settings),
            new Item.Settings().maxDamage(EquipmentType.BOOTS.getMaxDamage(ModArmorMaterial.BASE_DURABILITY))
    );





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
    public static final Item CHISEL =
            register("crimsonite_chisel", ChiselItem::new, new Item.Settings()
                    .maxDamage(128)
                    .rarity(Rarity.COMMON));
    public static final Item PIZZA = register("pizza",
            settings -> new Item(settings.food(ModFoodComponents.PIZZA, ModConsumableComponents.PIZZA)),
            new Item.Settings()
    );

    public static final Item DZIK = register("dzik",
            settings -> new Item(settings.food(ModFoodComponents.DRINK, ModConsumableComponents.DZIK)
                    .component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)),
            new Item.Settings()
    );

    public static final Item CONDENSED_LAVA_BUCKET = register("condensed_lava_bucket",
            Item::new, new Item.Settings());




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
            fabricItemGroupEntries.add(CHISEL);
            fabricItemGroupEntries.add(CONDENSED_LAVA_BUCKET);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(CRIMSONITE_PICKAXE);
            fabricItemGroupEntries.add(CRIMSONITE_AXE);
            fabricItemGroupEntries.add(CRIMSONITE_SHOVEL);
            fabricItemGroupEntries.add(CRIMSONITE_HOE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(CRIMSONITE_HELMET);
            fabricItemGroupEntries.add(CRIMSONITE_CHESTPLATE);
            fabricItemGroupEntries.add(CRIMSONITE_LEGGINGS);
            fabricItemGroupEntries.add(CRIMSONITE_BOOTS);
            fabricItemGroupEntries.add(CRIMSONITE_SWORD);
        });
    }
}