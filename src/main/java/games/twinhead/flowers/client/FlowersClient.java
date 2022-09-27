package games.twinhead.flowers.client;

import games.twinhead.flowers.Registry;
import games.twinhead.flowers.entity.EntityRegistry;
import games.twinhead.flowers.entity.MoobloomEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;

@Environment(EnvType.CLIENT)
public class FlowersClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        for (Block block: Registry.crops) {
            BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout());
        }


        EntityRendererRegistry.register(EntityRegistry.MOOBLOOM, MoobloomEntityRenderer::new);
    }
}
