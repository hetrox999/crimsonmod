package net.hetrox.crimsonmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.hetrox.crimsonmod.CrimsonMod;
import net.hetrox.crimsonmod.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup CRIMSONITE_ITEMS_GROUP= Registry.register(Registries.ITEM_GROUP,
            Identifier.of(CrimsonMod.MOD_ID, "crimsonite_items_group"),
            FabricItemGroup.builder().icon(()-> new ItemStack(ModItems.CRIMSONITE_INGOT))
                    .displayName(Text.translatable("itemgroup.crimson-mod.crimsonite_items_group"))
                    .entries((displayContext, entries) -> {
                       entries.add(ModItems.CRIMSONITE_INGOT);
                       entries.add(ModItems.CRIMSONITE_NUGGET);
                       entries.add(ModItems.RAW_CRIMSONITE);
                       entries.add(ModItems.DICE);
                       entries.add(ModItems.STAFF);
                       entries.add(ModItems.CHISEL);
                    }).build());

    public static final ItemGroup CRIMSONITE_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(CrimsonMod.MOD_ID, "crimsonite_blocks_group"),
            FabricItemGroup.builder().icon(()-> new ItemStack(ModBlocks.CRIMSONITE_BLOCK))
                    .displayName(Text.translatable("itemgroup.crimson-mod.crimsonite_blocks_group"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.CRIMSONITE_BLOCK);
                        entries.add(ModBlocks.RAW_CRIMSONITE_BLOCK);
                        entries.add(ModBlocks.CRIMSONITE_ORE);
                        entries.add(ModBlocks.DEEPSLATE_CRIMSONITE_ORE);
                    }).build());

    public static final ItemGroup CRIMSONITE_BUILDING_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(CrimsonMod.MOD_ID, "crimsonite_building_group"),
            FabricItemGroup.builder().icon(()-> new ItemStack(ModBlocks.CRIMSONITE_STAIRS))
                    .displayName(Text.translatable("itemgroup.crimson-mod.crimsonite_building_group"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.CRIMSONITE_STAIRS);
                        entries.add(ModBlocks.CRIMSONITE_SLAB);
                        entries.add(ModBlocks.CRIMSONITE_WALL);
                        entries.add(ModBlocks.CRIMSONITE_FENCE);
                        entries.add(ModBlocks.CRIMSONITE_FENCE_GATE);
                        entries.add(ModBlocks.CRIMSONITE_PRESSURE_PLATE);
                        entries.add(ModBlocks.CRIMSONITE_BUTTON);
                        entries.add(ModBlocks.CRIMSONITE_TRAPDOOR);
                        entries.add(ModBlocks.CRIMSONITE_DOOR);
                    }).build());

    public static final ItemGroup CRIMSONITE_TOOLS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(CrimsonMod.MOD_ID, "crimsonite_tools_group"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.CRIMSONITE_SWORD))
                    .displayName(Text.translatable("itemgroup.crimson-mod.crimsonite_tools_group"))
                    .entries(((displayContext, entries) -> {
                        entries.add(ModItems.CRIMSONITE_SWORD);
                        entries.add(ModItems.CRIMSONITE_AXE);
                        entries.add(ModItems.CRIMSONITE_HOE);
                        entries.add(ModItems.CRIMSONITE_SHOVEL);
                        entries.add(ModItems.CRIMSONITE_PICKAXE);
                        entries.add(ModItems.CRIMSONITE_HELMET);
                        entries.add(ModItems.CRIMSONITE_CHESTPLATE);
                        entries.add(ModItems.CRIMSONITE_LEGGINGS);
                        entries.add(ModItems.CRIMSONITE_BOOTS);
                    })).build());

    public static void registerItemGroups() {
        CrimsonMod.LOGGER.info("Registering Item Groups for "+CrimsonMod.MOD_ID);
    }
}


