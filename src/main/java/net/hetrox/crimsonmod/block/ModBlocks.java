package net.hetrox.crimsonmod.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.hetrox.crimsonmod.CrimsonMod;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.awt.*;
import java.util.function.Function;

public class ModBlocks {
    public static final Block CRIMSONITE_BLOCK = register(
            "crimsonite_block",
            Block::new,
            AbstractBlock.Settings.create()
                    .requiresTool()
                    .strength(3f)
                    .sounds(BlockSoundGroup.NETHERITE)
    );
    public static final Block CRIMSONITE_ORE = register(
            "crimsonite_ore",
            Block::new,
            AbstractBlock.Settings.create()
                    .requiresTool()
                    .strength(3f)
                    .sounds(BlockSoundGroup.ANCIENT_DEBRIS)
    );
    public static final Block DEEPSLATE_CRIMSONITE_ORE = register(
            "deepslate_crimsonite_ore",
            Block::new,
            AbstractBlock.Settings.create()
                    .requiresTool()
                    .strength(3f)
                    .sounds(BlockSoundGroup.ANCIENT_DEBRIS)
    );
    public static final Block RAW_CRIMSONITE_BLOCK = register(
            "raw_crimsonite_block",
            Block::new,
            AbstractBlock.Settings.create()
                    .requiresTool()
                    .strength(3f)
                    .sounds(BlockSoundGroup.ANCIENT_DEBRIS)
    );
    public static final Block CRIMSONITE_STAIRS = register(
            "crimsonite_stairs",
            settings -> new StairsBlock(CRIMSONITE_BLOCK.getDefaultState(), settings),
            AbstractBlock.Settings.create()
                    .requiresTool()
                    .strength(3f)
                    .sounds(BlockSoundGroup.NETHERITE)
    );
    public static final Block CRIMSONITE_SLAB = register(
            "crimsonite_slab",
            SlabBlock::new,
            AbstractBlock.Settings.create()
                    .requiresTool()
                    .strength(3f)
                    .sounds(BlockSoundGroup.NETHERITE)
    );
    public static final Block CRIMSONITE_BUTTON = register(
            "crimsonite_button",
            settings -> new ButtonBlock(BlockSetType.ACACIA, 40, settings),
            AbstractBlock.Settings.create()
                    .requiresTool()
                    .strength(3f)
                    .sounds(BlockSoundGroup.NETHERITE)
    );
    public static final Block CRIMSONITE_PRESSURE_PLATE = register(
            "crimsonite_pressure_plate",
            settings -> new PressurePlateBlock(BlockSetType.ACACIA, settings),
            AbstractBlock.Settings.create()
                    .requiresTool()
                    .strength(3f)
                    .sounds(BlockSoundGroup.NETHERITE)
    );
    public static final Block CRIMSONITE_DOOR = register(
            "crimsonite_door",
            settings -> new DoorBlock(BlockSetType.ACACIA, settings),
            AbstractBlock.Settings.create()
                    .requiresTool()
                    .strength(3f)
                    .sounds(BlockSoundGroup.NETHERITE)
                    .nonOpaque()
    );
    public static final Block CRIMSONITE_TRAPDOOR = register(
            "crimsonite_trapdoor",
            settings -> new TrapdoorBlock(BlockSetType.ACACIA, settings),
            AbstractBlock.Settings.create()
                    .requiresTool()
                    .strength(3f)
                    .sounds(BlockSoundGroup.NETHERITE)
                    .nonOpaque()
    );
    public static final Block CRIMSONITE_FENCE = register(
            "crimsonite_fence",
            FenceBlock::new,
            AbstractBlock.Settings.create()
                    .requiresTool()
                    .strength(3f)
                    .sounds(BlockSoundGroup.NETHERITE)
                    .nonOpaque()
    );
    public static final Block CRIMSONITE_FENCE_GATE = register(
            "crimsonite_fence_gate",
            settings -> new FenceGateBlock(WoodType.ACACIA, settings),
            AbstractBlock.Settings.create()
                    .requiresTool()
                    .strength(3f)
                    .sounds(BlockSoundGroup.NETHERITE)
                    .nonOpaque()
    );
    public static final Block CRIMSONITE_WALL = register(
            "crimsonite_wall",
            WallBlock::new,
            AbstractBlock.Settings.create()
                    .requiresTool()
                    .strength(3f)
                    .sounds(BlockSoundGroup.NETHERITE)
                    .nonOpaque()
    );


    private static Block register(String name, Function<AbstractBlock.Settings, Block> blockFactory, AbstractBlock.Settings settings) {
        RegistryKey<Block> blockKey = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(CrimsonMod.MOD_ID, name));
        Block block = blockFactory.apply(settings.registryKey(blockKey));

        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CrimsonMod.MOD_ID, name));
        BlockItem blockItem = new BlockItem(block, new Item.Settings().registryKey(itemKey));


        Registry.register(Registries.ITEM, itemKey, blockItem);
        return Registry.register(Registries.BLOCK, blockKey, block);
    }
    public static void registerModBlocks() {
        CrimsonMod.LOGGER.info("Registering Mod Items for "+CrimsonMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(CRIMSONITE_BLOCK);
            fabricItemGroupEntries.add(CRIMSONITE_ORE);
            fabricItemGroupEntries.add(DEEPSLATE_CRIMSONITE_ORE);
            fabricItemGroupEntries.add(RAW_CRIMSONITE_BLOCK);
            fabricItemGroupEntries.add(CRIMSONITE_DOOR);
            fabricItemGroupEntries.add(CRIMSONITE_FENCE_GATE);
            fabricItemGroupEntries.add(CRIMSONITE_TRAPDOOR);
            fabricItemGroupEntries.add(CRIMSONITE_FENCE);
            fabricItemGroupEntries.add(CRIMSONITE_BUTTON);
            fabricItemGroupEntries.add(CRIMSONITE_PRESSURE_PLATE);
            fabricItemGroupEntries.add(CRIMSONITE_SLAB);
            fabricItemGroupEntries.add(CRIMSONITE_WALL);
            fabricItemGroupEntries.add(CRIMSONITE_STAIRS);

        });
    }
}
