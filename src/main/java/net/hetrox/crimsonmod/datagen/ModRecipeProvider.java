package net.hetrox.crimsonmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.hetrox.crimsonmod.block.ModBlocks;
import net.hetrox.crimsonmod.item.ModItems;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.data.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                RegistryEntryLookup<Item> itemLookup = registries.getOrThrow(RegistryKeys.ITEM);

                offerReversibleCompactingRecipes(RecipeCategory.BUILDING_BLOCKS, ModItems.CRIMSONITE_INGOT, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRIMSONITE_BLOCK);
                offerReversibleCompactingRecipes(RecipeCategory.MISC, ModItems.RAW_CRIMSONITE, RecipeCategory.MISC, ModBlocks.RAW_CRIMSONITE_BLOCK);

                ShapelessRecipeJsonBuilder.create(itemLookup, RecipeCategory.MISC, ModItems.CONDENSED_LAVA_BUCKET, 1)
                                .input(Items.LAVA_BUCKET, 9)
                                .criterion(hasItem(Items.LAVA_BUCKET), conditionsFromItem(Items.LAVA_BUCKET))
                                .offerTo(exporter);

                ShapelessRecipeJsonBuilder.create(itemLookup, RecipeCategory.MISC, ModItems.CRIMSONITE_NUGGET ,9)
                        .input(ModItems.CRIMSONITE_INGOT)
                        .criterion(hasItem(ModItems.CRIMSONITE_INGOT), conditionsFromItem(ModItems.CRIMSONITE_INGOT))
                        .offerTo(exporter, "crimsonite_nuggets_from_ingot");

                ShapelessRecipeJsonBuilder.create(itemLookup, RecipeCategory.MISC, ModItems.CRIMSONITE_INGOT ,1)
                        .input(ModItems.CRIMSONITE_NUGGET, 9)
                        .criterion(hasItem(ModItems.CRIMSONITE_NUGGET), conditionsFromItem(ModItems.CRIMSONITE_NUGGET))
                        .offerTo(exporter, "crimsonite_ingot_from_nuggets");




                createStairsRecipe(ModBlocks.CRIMSONITE_STAIRS, Ingredient.ofItem(ModItems.CRIMSONITE_INGOT))
                        .criterion(hasItem(ModItems.CRIMSONITE_INGOT), conditionsFromItem(ModItems.CRIMSONITE_INGOT))
                        .offerTo(exporter);

                createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRIMSONITE_SLAB, Ingredient.ofItem(ModItems.CRIMSONITE_INGOT))
                        .criterion(hasItem(ModItems.CRIMSONITE_INGOT), conditionsFromItem(ModItems.CRIMSONITE_INGOT))
                        .offerTo(exporter);

                createFenceRecipe(ModBlocks.CRIMSONITE_FENCE, Ingredient.ofItem(ModItems.CRIMSONITE_INGOT))
                        .criterion(hasItem(ModItems.CRIMSONITE_INGOT), conditionsFromItem(ModItems.CRIMSONITE_INGOT))
                        .offerTo(exporter);

                createFenceGateRecipe(ModBlocks.CRIMSONITE_FENCE_GATE, Ingredient.ofItem(ModItems.CRIMSONITE_INGOT))
                        .criterion(hasItem(ModItems.CRIMSONITE_INGOT), conditionsFromItem(ModItems.CRIMSONITE_INGOT))
                        .offerTo(exporter);

                createPressurePlateRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRIMSONITE_PRESSURE_PLATE, Ingredient.ofItem(ModItems.CRIMSONITE_INGOT))
                        .criterion(hasItem(ModItems.CRIMSONITE_INGOT), conditionsFromItem(ModItems.CRIMSONITE_INGOT))
                        .offerTo(exporter);

                createDoorRecipe(ModBlocks.CRIMSONITE_DOOR, Ingredient.ofItem(ModItems.CRIMSONITE_INGOT))
                        .criterion(hasItem(ModItems.CRIMSONITE_INGOT), conditionsFromItem(ModItems.CRIMSONITE_INGOT))
                        .offerTo(exporter);

                createTrapdoorRecipe(ModBlocks.CRIMSONITE_TRAPDOOR, Ingredient.ofItem(ModItems.CRIMSONITE_NUGGET))
                        .criterion(hasItem(ModItems.CRIMSONITE_NUGGET), conditionsFromItem(ModItems.CRIMSONITE_NUGGET))
                        .offerTo(exporter);

                createButtonRecipe(ModBlocks.CRIMSONITE_BUTTON, Ingredient.ofItem(ModItems.CRIMSONITE_NUGGET))
                        .criterion(hasItem(ModItems.CRIMSONITE_NUGGET), conditionsFromItem(ModItems.CRIMSONITE_NUGGET))
                        .offerTo(exporter);

                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRIMSONITE_WALL, ModItems.CRIMSONITE_INGOT);

                ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.MISC, ModItems.DICE, 1)
                        .pattern("   ")
                        .pattern(" $#")
                        .pattern(" #$")
                        .input('$',ModBlocks.CRIMSONITE_BLOCK)
                        .input('#', Items.GOLD_BLOCK)
                        .criterion(hasItem(ModBlocks.CRIMSONITE_BLOCK), conditionsFromItem(ModBlocks.CRIMSONITE_BLOCK))
                        .offerTo(exporter);

                ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.MISC, ModItems.STAFF, 1)
                        .pattern(" @ ")
                        .pattern(" $ ")
                        .pattern(" $ ")
                        .input('$',ModBlocks.CRIMSONITE_BLOCK)
                        .input('@', Items.NETHER_STAR)
                        .criterion(hasItem(Items.NETHER_STAR), conditionsFromItem(Items.NETHER_STAR))
                        .offerTo(exporter);



            }
        };
    }

    @Override
    public String getName() {
        return "";
    }
}
