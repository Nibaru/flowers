package games.twinhead.flowers.entity;

import games.twinhead.flowers.Flowers;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

public class MoobloomEntityRenderer extends MobEntityRenderer<MoobloomEntity, MoobloomEntityModel<MoobloomEntity>> {
    private static final Identifier ALLIUM = new Identifier(Flowers.modID,"textures/entity/moobloom/allium_moobloom.png");
    private static final Identifier AZURE_BLUET = new Identifier(Flowers.modID,"textures/entity/moobloom/azure_bluet_moobloom.png");
    private static final Identifier BLUE_ORCHID = new Identifier(Flowers.modID,"textures/entity/moobloom/blue_orchid_moobloom.png");
    private static final Identifier CORNFLOWER = new Identifier(Flowers.modID,"textures/entity/moobloom/cornflower_moobloom.png");
    private static final Identifier DANDELION = new Identifier(Flowers.modID,"textures/entity/moobloom/dandelion_moobloom.png");
    private static final Identifier LILY_OF_THE_VALLEY = new Identifier(Flowers.modID,"textures/entity/moobloom/lily_of_the_valley_moobloom.png");
    private static final Identifier ORANGE_TULIP = new Identifier(Flowers.modID,"textures/entity/moobloom/orange_tulip_moobloom.png");
    private static final Identifier OXEYE_DAISY = new Identifier(Flowers.modID,"textures/entity/moobloom/oxeye_daisy_moobloom.png");
    private static final Identifier PINK_TULIP = new Identifier(Flowers.modID,"textures/entity/moobloom/pink_tulip_moobloom.png");
    private static final Identifier POPPY = new Identifier(Flowers.modID,"textures/entity/moobloom/poppy_moobloom.png");
    private static final Identifier RED_TULIP = new Identifier(Flowers.modID,"textures/entity/moobloom/red_tulip_moobloom.png");
    private static final Identifier WHITE_TULIP = new Identifier(Flowers.modID,"textures/entity/moobloom/white_tulip_moobloom.png");
    private static final Identifier WITHER_ROSE = new Identifier(Flowers.modID,"textures/entity/moobloom/wither_rose_moobloom.png");

    public MoobloomEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new MoobloomEntityModel<>(context.getPart(EntityModelLayers.COW)), 0.7F);
        this.addFeature(new MoobloomFlowerFeatureRenderer<>(this, context.getBlockRenderManager()));
    }

    @Override
    public Identifier getTexture(MoobloomEntity entity) {
        return switch (entity.getFlowerType()){
            case 0 -> ALLIUM;
            case 1 -> AZURE_BLUET;
            case 2 -> BLUE_ORCHID;
            case 3 -> CORNFLOWER;
            case 4 -> DANDELION;
            case 5 -> LILY_OF_THE_VALLEY;
            case 6 -> ORANGE_TULIP;
            case 7 -> OXEYE_DAISY;
            case 8 -> PINK_TULIP;
            case 9 -> POPPY;
            case 10 -> RED_TULIP;
            case 11 -> WHITE_TULIP;
            case 12 -> WITHER_ROSE;
            default -> DANDELION;
        };
    }

}
