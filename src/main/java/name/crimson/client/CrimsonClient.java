package name.crimson.client;

import name.crimson.client.render.WingsFeatureRenderer;
import name.crimson.entity.ModEntities;
import name.crimson.entity.client.ChomperRenderer;
import name.crimson.entity.client.TigerRenderer;
import name.crimson.particle.ModParticles;
import name.crimson.particle.custom.BlueDamageParticle;
import name.crimson.particle.custom.BlueSweepParticle;
import name.crimson.particle.custom.RedDamageParticle;
import name.crimson.particle.custom.RedSweepParticle;
import name.crimson.util.BoostPayload;
import name.crimson.util.CrimsonPayloads;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRendererRegistrationCallback;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.util.Identifier;

public class CrimsonClient implements ClientModInitializer {
    public static final Identifier BOOST_PACKET =
            Identifier.of("crimson", "boost");

    @Override
    public void onInitializeClient() {
        CrimsonKeybinds.register();
        CrimsonPayloads.registerCommon(); // ✅ safe

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player == null) return;

            while (CrimsonKeybinds.BOOST.wasPressed()) {
                ClientPlayNetworking.send(new BoostPayload());
            }
        });

        //PayloadTypeRegistry.playC2S().register(BoostPayload.ID, BoostPayload.CODEC);

        EntityRendererRegistry.register(ModEntities.CHOMPER, ChomperRenderer::new);
        EntityRendererRegistry.register(ModEntities.TIGER, TigerRenderer::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.BLUE_SWEEP_PARTICLE, BlueSweepParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.RED_SWEEP_PARTICLE, RedSweepParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.RED_CRIT_PARTICLE, RedDamageParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.BLUE_CRIT_PARTICLE, BlueDamageParticle.Factory::new);
        LivingEntityFeatureRendererRegistrationCallback.EVENT.register((entityType, entityRenderer, registrationHelper, context) -> {
            if (entityRenderer instanceof LivingEntityRenderer<?, ?> renderer) {
                registrationHelper.register(new WingsFeatureRenderer<>(renderer, context.getModelLoader()));
            }
        });





    }
}
