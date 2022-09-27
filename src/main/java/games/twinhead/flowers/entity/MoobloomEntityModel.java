package games.twinhead.flowers.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.QuadrupedEntityModel;
import net.minecraft.entity.Entity;

@Environment(EnvType.CLIENT)
public class MoobloomEntityModel<T extends MoobloomEntity> extends QuadrupedEntityModel<T> {
    public MoobloomEntityModel(ModelPart root) {
        super(root, false, 10.0F, 4.0F, 2.0F, 2.0F, 24);
    }
    private float headPitchModifier;

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();

        modelPartData.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -4.0F, -6.0F, 8.0F, 8.0F, 6.0F).uv(22, 0).cuboid("right_horn", -5.0F, -5.0F, -4.0F, 1.0F, 3.0F, 1.0F).uv(22, 0).cuboid("left_horn", 4.0F, -5.0F, -4.0F, 1.0F, 3.0F, 1.0F), ModelTransform.pivot(0.0F, 4.0F, -8.0F));
        modelPartData.addChild("body", ModelPartBuilder.create().uv(18, 4).cuboid(-6.0F, -10.0F, -7.0F, 12.0F, 18.0F, 10.0F).uv(52, 0).cuboid(-2.0F, 2.0F, -8.0F, 4.0F, 6.0F, 1.0F), ModelTransform.of(0.0F, 5.0F, 2.0F, 1.5707964F, 0.0F, 0.0F));
        ModelPartBuilder modelPartBuilder = ModelPartBuilder.create().uv(0, 16).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F);
        modelPartData.addChild("right_hind_leg", modelPartBuilder, ModelTransform.pivot(-4.0F, 12.0F, 7.0F));
        modelPartData.addChild("left_hind_leg", modelPartBuilder, ModelTransform.pivot(4.0F, 12.0F, 7.0F));
        modelPartData.addChild("right_front_leg", modelPartBuilder, ModelTransform.pivot(-4.0F, 12.0F, -6.0F));
        modelPartData.addChild("left_front_leg", modelPartBuilder, ModelTransform.pivot(4.0F, 12.0F, -6.0F));
        return TexturedModelData.of(modelData, 64, 32);
    }

    public void animateModel(T sheepEntity, float f, float g, float h) {
        super.animateModel(sheepEntity, f, g, h);
        this.head.pivotY = 4.0F + sheepEntity.getNeckAngle(h) * 9.0F;
        this.headPitchModifier = sheepEntity.getHeadAngle(h);
    }

    public void setAngles(T sheepEntity, float f, float g, float h, float i, float j) {
        super.setAngles(sheepEntity, f, g, h, i, j);
        this.head.pitch = this.headPitchModifier;
    }

    public ModelPart getHead() {
        return this.head;
    }
}
