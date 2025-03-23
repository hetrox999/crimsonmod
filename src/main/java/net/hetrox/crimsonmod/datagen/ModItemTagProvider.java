package net.hetrox.crimsonmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.hetrox.crimsonmod.item.ModItems;
import net.hetrox.crimsonmod.util.ModTags;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(ModItems.CRIMSONITE_INGOT)
                .add(ModItems.RAW_CRIMSONITE)
                .add(Items.STICK)
                .add(Items.APPLE)
                .add(Items.QUARTZ);
        getOrCreateTagBuilder(ModTags.Items.CRIMSONITE_TOOL_MATERIALS)
                .add(ModItems.CRIMSONITE_INGOT);

        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.CRIMSONITE_SWORD);
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.CRIMSONITE_PICKAXE);
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.CRIMSONITE_AXE);
        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.CRIMSONITE_SHOVEL);
        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.CRIMSONITE_HOE);
    }
}
