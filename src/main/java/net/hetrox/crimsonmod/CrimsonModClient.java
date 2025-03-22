package net.hetrox.crimsonmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.hetrox.crimsonmod.block.ModBlocks;
import net.minecraft.client.render.RenderLayer;

public class CrimsonModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CRIMSONITE_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CRIMSONITE_TRAPDOOR, RenderLayer.getCutout());
    }
}
