package name.crimson.entity.client;

import name.crimson.Crimson;
import name.crimson.entity.custom.ChomperEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class ChomperRenderer extends GeoEntityRenderer<ChomperEntity> {
    public ChomperRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new ChomperModel());
    }

    @Override
    public Identifier getTextureLocation(ChomperEntity animatable) {
        return new Identifier(Crimson.MODID, "textures/entity/chomper/chomper.png");
    }

    @Override
    public void render(ChomperEntity entity, float entityYaw, float partialTick, MatrixStack poseStack,
                       VertexConsumerProvider bufferSource, int packedLight) {
        if(entity.isBaby()) {
            poseStack.scale(0.4f, 0.4f, 0.4f);
        }

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}