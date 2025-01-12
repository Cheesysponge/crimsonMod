package name.crimson.entity.client;

import name.crimson.Crimson;
import name.crimson.entity.custom.TigerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class TigerModel extends GeoModel<TigerEntity> {
    @Override
    public Identifier getModelResource(TigerEntity animatable) {
        return new Identifier(Crimson.MODID, "geo/tiger.geo.json");
    }

    @Override
    public Identifier getTextureResource(TigerEntity animatable) {
        return new Identifier(Crimson.MODID, "textures/entity/tiger/tiger.png");
    }

    @Override
    public Identifier getAnimationResource(TigerEntity animatable) {
        return new Identifier(Crimson.MODID, "animations/tiger.animation.json");
    }

    @Override
    public void setCustomAnimations(TigerEntity animatable, long instanceId, AnimationState<TigerEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * MathHelper.RADIANS_PER_DEGREE);
            head.setRotY(entityData.netHeadYaw() * MathHelper.RADIANS_PER_DEGREE);
        }
    }
}