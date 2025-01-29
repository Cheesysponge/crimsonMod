package name.crimson.client;

import name.crimson.entity.ModEntities;
import name.crimson.entity.client.ChomperRenderer;
import name.crimson.entity.client.TigerRenderer;
import name.crimson.particle.ModParticles;
import name.crimson.particle.custom.BlueSweepParticle;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class CrimsonClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.CHOMPER, ChomperRenderer::new);
        EntityRendererRegistry.register(ModEntities.TIGER, TigerRenderer::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.BLUE_PARTICLE, BlueSweepParticle.Factory::new);


    }
}
