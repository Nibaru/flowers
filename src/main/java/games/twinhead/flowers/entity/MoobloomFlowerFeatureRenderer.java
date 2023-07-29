package games.twinhead.flowers.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.BlockRenderManager;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.RotationAxis;

@Environment(EnvType.CLIENT)
public class MoobloomFlowerFeatureRenderer<T extends MoobloomEntity> extends FeatureRenderer<T, MoobloomEntityModel<T>> {
    private final BlockRenderManager blockRenderManager;

    public MoobloomFlowerFeatureRenderer(FeatureRendererContext<T, MoobloomEntityModel<T>> context, BlockRenderManager blockRenderManager) {
        super(context);
        this.blockRenderManager = blockRenderManager;
    }

    public void render(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, T moobloomEntity, float f, float g, float h, float j, float k, float l) {
        if (!moobloomEntity.isBaby() && moobloomEntity.getFlowerState() != null) {
            MinecraftClient minecraftClient = MinecraftClient.getInstance();
            boolean bl = minecraftClient.hasOutline(moobloomEntity) && moobloomEntity.isInvisible();

            if (!moobloomEntity.isInvisible() || bl) {
                BlockState blockState = moobloomEntity.getFlowerState();
                int m = LivingEntityRenderer.getOverlay(moobloomEntity, 0.0F);
                BakedModel bakedModel = this.blockRenderManager.getModel(blockState);
                matrixStack.push();
                matrixStack.translate(0.20000000298023224, -0.3499999940395355, 0.5);
                matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-48.0F));
                matrixStack.scale(-1.0F, -1.0F, 1.0F);
                matrixStack.translate(-0.5, -0.5, -0.5);
                this.renderFlower(matrixStack, vertexConsumerProvider, i, bl, blockState, m, bakedModel);
                matrixStack.pop();
                matrixStack.push();
                matrixStack.translate(0.20000000298023224, -0.3499999940395355, 0.5);
                matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(42.0F));
                matrixStack.translate(0.10000000149011612, 0.0, -0.6000000238418579);
                matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-48.0F));
                matrixStack.scale(-1.0F, -1.0F, 1.0F);
                matrixStack.translate(-0.5, -0.5, -0.5);
                this.renderFlower(matrixStack, vertexConsumerProvider, i, bl, blockState, m, bakedModel);
                matrixStack.pop();
                matrixStack.push();
                ((MoobloomEntityModel)this.getContextModel()).getHead().rotate(matrixStack);
                matrixStack.translate(0.0, -0.699999988079071, -0.20000000298023224);
                matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-78.0F));
                matrixStack.scale(-1.0F, -1.0F, 1.0F);
                matrixStack.translate(-0.5, -0.5, -0.5);
                this.renderFlower(matrixStack, vertexConsumerProvider, i, bl, blockState, m, bakedModel);
                matrixStack.pop();
            }
        }
    }

    private void renderFlower(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, boolean renderAsModel, BlockState mushroomState, int overlay, BakedModel mushroomModel) {
        if (renderAsModel) {
            this.blockRenderManager.getModelRenderer().render(matrices.peek(), vertexConsumers.getBuffer(RenderLayer.getOutline(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE)), mushroomState, mushroomModel, 0.0F, 0.0F, 0.0F, light, overlay);
        } else {
            this.blockRenderManager.renderBlockAsEntity(mushroomState, matrices, vertexConsumers, light, overlay);
        }
    }
}
