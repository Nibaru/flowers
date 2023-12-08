package games.twinhead.flowers.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.QuadrupedEntityModel;

@Environment(EnvType.CLIENT)
public class MoobloomEntityModel<T extends MoobloomEntity> extends QuadrupedEntityModel<T> {
    public MoobloomEntityModel(ModelPart root) {
        super(root, false, 10.0F, 4.0F, 2.0F, 2.0F, 24);
    }
    private float headPitchModifier;

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
