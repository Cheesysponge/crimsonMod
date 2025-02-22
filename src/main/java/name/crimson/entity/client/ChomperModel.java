package name.crimson.entity.client;

import name.crimson.Crimson;
import name.crimson.entity.custom.ChomperEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.constant.DataTickets;

import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class ChomperModel extends GeoModel<ChomperEntity> {
    @Override
    public Identifier getModelResource(ChomperEntity animatable) {
        return Identifier.of(Crimson.MODID, "geo/chomper.geo.json");
    }

    @Override
    public Identifier getTextureResource(ChomperEntity animatable) {
        return Identifier.of(Crimson.MODID, "textures/entity/chomper/chomper.png");
    }

    @Override
    public Identifier getAnimationResource(ChomperEntity animatable) {
        return Identifier.of(Crimson.MODID, "animations/chomper.animation.json");
    }

    @Override
    public void setCustomAnimations(ChomperEntity animatable, long instanceId, AnimationState<ChomperEntity> animationState) {
        GeoBone head = getAnimationProcessor().getBone("everything");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * MathHelper.RADIANS_PER_DEGREE);
            head.setRotY(entityData.netHeadYaw() * MathHelper.RADIANS_PER_DEGREE + (float)Math.PI);
        }
    }


}