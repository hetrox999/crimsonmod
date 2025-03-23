package net.hetrox.crimsonmod.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.hetrox.crimsonmod.block.ModBlocks;
import net.hetrox.crimsonmod.item.ModArmorMaterial;
import net.hetrox.crimsonmod.item.ModItems;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;
import net.minecraft.item.ArmorItem;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool crimsonitePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CRIMSONITE_BLOCK);
        crimsonitePool.wall(ModBlocks.CRIMSONITE_WALL);
        crimsonitePool.fenceGate(ModBlocks.CRIMSONITE_FENCE_GATE);
        crimsonitePool.fence(ModBlocks.CRIMSONITE_FENCE);
        crimsonitePool.button(ModBlocks.CRIMSONITE_BUTTON);
        crimsonitePool.pressurePlate(ModBlocks.CRIMSONITE_PRESSURE_PLATE);
        crimsonitePool.stairs(ModBlocks.CRIMSONITE_STAIRS);
        crimsonitePool.slab(ModBlocks.CRIMSONITE_SLAB);


        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_CRIMSONITE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_CRIMSONITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CRIMSONITE_ORE);

        blockStateModelGenerator.registerDoor(ModBlocks.CRIMSONITE_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.CRIMSONITE_TRAPDOOR);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
            itemModelGenerator.register(ModItems.CRIMSONITE_INGOT, Models.GENERATED);
            itemModelGenerator.register(ModItems.CRIMSONITE_NUGGET, Models.GENERATED);
            itemModelGenerator.register(ModItems.RAW_CRIMSONITE, Models.GENERATED);

            itemModelGenerator.register(ModItems.DICE, Models.GENERATED);
            itemModelGenerator.register(ModItems.STAFF, Models.GENERATED);
            itemModelGenerator.register(ModItems.CHISEL, Models.GENERATED);
            itemModelGenerator.register(ModItems.PIZZA, Models.GENERATED);
            itemModelGenerator.register(ModItems.DZIK, Models.GENERATED);

            itemModelGenerator.register(ModItems.CRIMSONITE_SWORD, Models.HANDHELD);
            itemModelGenerator.register(ModItems.CRIMSONITE_AXE, Models.HANDHELD);
            itemModelGenerator.register(ModItems.CRIMSONITE_SHOVEL, Models.HANDHELD);
            itemModelGenerator.register(ModItems.CRIMSONITE_PICKAXE, Models.HANDHELD);
            itemModelGenerator.register(ModItems.CRIMSONITE_HOE, Models.HANDHELD);
            itemModelGenerator.register(ModItems.CRIMSONITE_HAMMER, Models.HANDHELD);

            itemModelGenerator.registerArmor(ModItems.CRIMSONITE_HELMET, ModArmorMaterial.CRIMSONITE_ARMOR_MATERIAL_KEY, "crimsonite", false);
            itemModelGenerator.registerArmor(ModItems.CRIMSONITE_CHESTPLATE, ModArmorMaterial.CRIMSONITE_ARMOR_MATERIAL_KEY, "crimsonite", false);
            itemModelGenerator.registerArmor(ModItems.CRIMSONITE_LEGGINGS, ModArmorMaterial.CRIMSONITE_ARMOR_MATERIAL_KEY, "crimsonite", false);
            itemModelGenerator.registerArmor(ModItems.CRIMSONITE_BOOTS, ModArmorMaterial.CRIMSONITE_ARMOR_MATERIAL_KEY, "crimsonite", false);
    }
}
