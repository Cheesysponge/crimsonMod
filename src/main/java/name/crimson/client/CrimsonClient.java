package name.crimson.client;

import name.crimson.entity.ModEntities;
import name.crimson.entity.client.ChomperRenderer;
import name.crimson.entity.client.TigerRenderer;
import name.crimson.particle.ModParticles;
import name.crimson.particle.custom.BlueDamageParticle;
import name.crimson.particle.custom.BlueSweepParticle;
import name.crimson.particle.custom.RedDamageParticle;
import name.crimson.particle.custom.RedSweepParticle;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class CrimsonClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        EntityRendererRegistry.register(ModEntities.CHOMPER, ChomperRenderer::new);
        EntityRendererRegistry.register(ModEntities.TIGER, TigerRenderer::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.BLUE_SWEEP_PARTICLE, BlueSweepParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.RED_SWEEP_PARTICLE, RedSweepParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.RED_CRIT_PARTICLE, RedDamageParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.BLUE_CRIT_PARTICLE, BlueDamageParticle.Factory::new);





    }
}
