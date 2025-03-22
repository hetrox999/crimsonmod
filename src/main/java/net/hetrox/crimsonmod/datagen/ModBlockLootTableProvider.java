package net.hetrox.crimsonmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceCondition;
import net.hetrox.crimsonmod.block.ModBlocks;
import net.hetrox.crimsonmod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.data.loottable.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class ModBlockLootTableProvider extends FabricBlockLootTableProvider {
    public ModBlockLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.CRIMSONITE_BLOCK);
        addDrop(ModBlocks.RAW_CRIMSONITE_BLOCK);
        addDrop(ModBlocks.CRIMSONITE_TRAPDOOR);
        addDrop(ModBlocks.CRIMSONITE_STAIRS);
        addDrop(ModBlocks.CRIMSONITE_PRESSURE_PLATE);
        addDrop(ModBlocks.CRIMSONITE_FENCE);
        addDrop(ModBlocks.CRIMSONITE_FENCE_GATE);
        addDrop(ModBlocks.CRIMSONITE_BUTTON);
        addDrop(ModBlocks.CRIMSONITE_WALL);

        addDrop(ModBlocks.CRIMSONITE_SLAB,
                slabDrops(ModBlocks.CRIMSONITE_SLAB));
        addDrop(ModBlocks.CRIMSONITE_DOOR,
                doorDrops(ModBlocks.CRIMSONITE_DOOR));


        addDrop(ModBlocks.CRIMSONITE_ORE,
                oreDrops(ModBlocks.CRIMSONITE_ORE, ModItems.RAW_CRIMSONITE));
        addDrop(ModBlocks.DEEPSLATE_CRIMSONITE_ORE,
                multipleOreDrops(ModBlocks.DEEPSLATE_CRIMSONITE_ORE, ModItems.RAW_CRIMSONITE, 2, 5));

    }

    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        RegistryWrapper.Impl<Enchantment> impl = this.registries.getOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop,(LeafEntry.Builder<?>)
                        ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops,maxDrops)))))
                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)));

    }


}
