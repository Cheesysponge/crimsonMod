package name.crimson.client.render;
import name.crimson.Crimson;
import name.crimson.item.custom.WingsItem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.*;
import net.minecraft.client.render.entity.feature.ElytraFeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.ElytraEntityModel;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.EntityModelLoader;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.RotationAxis;
import org.joml.Matrix4f;



@Environment(EnvType.CLIENT)
public class WingsFeatureRenderer<T extends LivingEntity, M extends EntityModel<T>> extends FeatureRenderer<T, M> {

    private static final Identifier WINGS_TEXTURE =
            Identifier.of(Crimson.MODID, "textures/entity/crimson_wings.png");
    private static final Identifier AURA_TEX =
            Identifier.of(Crimson.MODID, "textures/particle/aura.png");

    private final ElytraEntityModel<T> elytra;

    int fullBright = LightmapTextureManager.MAX_LIGHT_COORDINATE;


    public WingsFeatureRenderer(FeatureRendererContext<T, M> context, EntityModelLoader loader) {
        super(context);
        this.elytra = new ElytraEntityModel<>(loader.getModelPart(EntityModelLayers.ELYTRA));
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider providers,
                       int light, T entity,
                       float limbAngle, float limbDistance, float tickDelta,
                       float animationProgress, float headYaw, float headPitch) {

        ItemStack chest = entity.getEquippedStack(EquipmentSlot.CHEST);
        if (!(chest.getItem() instanceof WingsItem)) return;

        this.getContextModel().copyStateTo(this.elytra);
        this.elytra.setAngles(entity, limbAngle, limbDistance, animationProgress, headYaw, headPitch);

        VertexConsumer vc = ItemRenderer.getArmorGlintConsumer(
                providers,
                RenderLayer.getArmorCutoutNoCull(WINGS_TEXTURE),
                chest.hasGlint()
        );


        int count = 64;
        float radius = 0.2F;

        for (int i = 0; i < count; i++) {
            float angle = (360.0F / count) * i;

            matrices.push();
            matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(angle));
            matrices.translate(0.0F, 0.05F, radius);
            this.elytra.render(matrices, vc, light, OverlayTexture.DEFAULT_UV);
            matrices.pop();
        }
//        renderAura(matrices, providers, light, entity, tickDelta);

//        /* ================= BACK ================= */
//        matrices.push();
//        matrices.translate(0.0F, 0.0F, 0.125F);
//        this.elytra.render(matrices, vc, light, OverlayTexture.DEFAULT_UV);
//        matrices.pop();
//
//        /* ================= FRONT ================= */
//        matrices.push();
//        matrices.translate(0.0F, 0.0F, -0.125F);
//        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180.0F));
//        this.elytra.render(matrices, vc, light, OverlayTexture.DEFAULT_UV);
//        matrices.pop();
//
//
//        /* ================= LEFT SIDE ================= */
//        matrices.push();
//        matrices.translate(0.35F, 0F, 0.0F); // move to left side of player
//        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(90.0F));
//        this.elytra.render(matrices, vc, light, OverlayTexture.DEFAULT_UV);
//        matrices.pop();
//
//        /* ================= RIGHT SIDE ================= */
//        matrices.push();
//        matrices.translate(-0.35F, 0F, 0.0F); // move to right side of player
//        matrices.multiply(RotationAxis.NEGATIVE_Y.rotationDegrees(90.0F));
//        this.elytra.render(matrices, vc, light, OverlayTexture.DEFAULT_UV);
//        matrices.pop();
    }




//    private void renderAura(MatrixStack matrices, VertexConsumerProvider providers, int ignoredLight,
//                            LivingEntity entity, float tickDelta) {
//
//        // FULLBRIGHT
//        final int fullBright = LightmapTextureManager.MAX_LIGHT_COORDINATE;
//
//        float t = entity.age + tickDelta;
//        float spin = t * 2.0f; // degrees
//        float pulse = 0.55f + 0.25f * (float)Math.sin(t * 0.18f);
//
//        // ~2x bigger than a normal small ring
//        float baseScale = 2.4f;
//
//        // Two passes = glowier
//        drawAuraLayer(matrices, providers, fullBright, spin, pulse * 0.55f, baseScale);        // inner
//        drawAuraLayer(matrices, providers, fullBright, -spin * 0.7f, pulse * 0.30f, baseScale * 1.25f); // outer
//    }
//
//    private void drawAuraLayer(MatrixStack matrices, VertexConsumerProvider providers, int light,
//                               float spinDeg, float alpha, float scale) {
//
//        VertexConsumer vc = providers.getBuffer(RenderLayer.getEntityTranslucent(AURA_TEX));
//
//        matrices.push();
//
//        // move to around chest/torso height
//        matrices.translate(0.0F, 0.95F, 0.0F);
//
//        // billboard (face camera)
//        matrices.multiply(MinecraftClient.getInstance().getEntityRenderDispatcher().getRotation());
//
//        // animate
//        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(spinDeg));
//
//        // size
//        matrices.scale(scale, scale, scale);
//
//        Matrix4f m = matrices.peek().getPositionMatrix();
//
//        // quad in the XY plane, centered at origin
//        auraVertex(vc, matrices, m, -1f, -1f, 0f, 0f, 1f, light, alpha);
//        auraVertex(vc, matrices, m,  1f, -1f, 0f, 1f, 1f, light, alpha);
//        auraVertex(vc, matrices, m,  1f,  1f, 0f, 1f, 0f, light, alpha);
//        auraVertex(vc, matrices, m, -1f,  1f, 0f, 0f, 0f, light, alpha);
//
//        matrices.pop();
//    }
//
//    private static void auraVertex(VertexConsumer vc, MatrixStack matrices, Matrix4f posMat,
//                                   float x, float y, float z,
//                                   float u, float v,
//                                   int light, float a) {
//
//        vc.vertex(posMat, x, y, z);
//        vc.color(1f, 1f, 1f, a);
//        vc.texture(u, v);
//        vc.overlay(OverlayTexture.DEFAULT_UV);
//        vc.light(light);
//
//        // REQUIRED or you'll crash with "Missing elements in vertex: Normal"
//        vc.normal(matrices.peek(), 0.0f, 0.0f, 1.0f);
//    }






}