package games.twinhead.flowers.entity;

import games.twinhead.flowers.block.Flower;
import games.twinhead.flowers.Flowers;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.util.Identifier;

public class MoobloomEntityRenderer extends MobEntityRenderer<MoobloomEntity, MoobloomEntityModel<MoobloomEntity>> {

    public MoobloomEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new MoobloomEntityModel<>(context.getPart(EntityModelLayers.COW)), 0.7F);
        this.addFeature(new MoobloomFlowerFeatureRenderer<>(this, context.getBlockRenderManager()));
    }

    @Override
    public Identifier getTexture(MoobloomEntity entity) {
        return new Identifier(Flowers.MOD_ID,"textures/entity/moobloom/" + Flower.values()[entity.getFlowerType()] + "_moobloom.png");
    }

}
