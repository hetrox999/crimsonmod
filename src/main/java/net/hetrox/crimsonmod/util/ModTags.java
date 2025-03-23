package net.hetrox.crimsonmod.util;

import net.hetrox.crimsonmod.CrimsonMod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Items {

        public static final TagKey<Item> TRANSFORMABLE_ITEMS =
                createTag("transformable_items");

        public static final TagKey<Item> CRIMSONITE_TOOL_MATERIALS =
                createTag("crimsonite_tool_materials");

        public static final TagKey<Item> REPAIRS_CRIMSONITE_ARMOR =
                createTag("repairs_crimsonite_armor");




        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(CrimsonMod.MOD_ID, name));
        }
    }


    public static class Blocks {

        public static final TagKey<Block> HAMMER_BLOCKS =
                createTag("hammer_blocks");



        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(CrimsonMod.MOD_ID, name));
        }
    }
}