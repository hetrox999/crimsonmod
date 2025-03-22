package net.hetrox.crimsonmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.hetrox.crimsonmod.block.ModBlocks;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.CRIMSONITE_BLOCK)
                .add(ModBlocks.RAW_CRIMSONITE_BLOCK)
                .add(ModBlocks.CRIMSONITE_ORE)
                .add(ModBlocks.DEEPSLATE_CRIMSONITE_ORE)
                .add(ModBlocks.CRIMSONITE_BUTTON)
                .add(ModBlocks.CRIMSONITE_DOOR)
                .add(ModBlocks.CRIMSONITE_FENCE)
                .add(ModBlocks.CRIMSONITE_FENCE_GATE)
                .add(ModBlocks.CRIMSONITE_WALL)
                .add(ModBlocks.CRIMSONITE_PRESSURE_PLATE)
                .add(ModBlocks.CRIMSONITE_TRAPDOOR)
                .add(ModBlocks.CRIMSONITE_SLAB)
                .add(ModBlocks.CRIMSONITE_STAIRS);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.CRIMSONITE_ORE)
                .add(ModBlocks.DEEPSLATE_CRIMSONITE_ORE)
                .add(ModBlocks.RAW_CRIMSONITE_BLOCK)
                .add(ModBlocks.CRIMSONITE_BLOCK);

        getOrCreateTagBuilder(BlockTags.FENCES)
                .add(ModBlocks.CRIMSONITE_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.CRIMSONITE_FENCE_GATE);
        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.CRIMSONITE_WALL);
    }
}
