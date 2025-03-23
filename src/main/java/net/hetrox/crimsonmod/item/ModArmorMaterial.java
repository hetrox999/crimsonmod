package net.hetrox.crimsonmod.item;

import net.hetrox.crimsonmod.CrimsonMod;
import net.hetrox.crimsonmod.util.ModTags;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import java.util.Map;

public class ModArmorMaterial {
    public static final int BASE_DURABILITY = 25;
    public static final RegistryKey<EquipmentAsset> CRIMSONITE_ARMOR_MATERIAL_KEY =
            RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY, Identifier.of(CrimsonMod.MOD_ID, "crimsonite"));

    public static final ArmorMaterial INSTANCE = new ArmorMaterial(
            BASE_DURABILITY,
            Map.of(
                    EquipmentType.HELMET, 3,
                    EquipmentType.CHESTPLATE, 7,
                    EquipmentType.LEGGINGS, 6,
                    EquipmentType.BOOTS, 3
            ),
            5,
            SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE,
            0.0F,
            0.0F,
            ModTags.Items.REPAIRS_CRIMSONITE_ARMOR,
            CRIMSONITE_ARMOR_MATERIAL_KEY
    );
}
