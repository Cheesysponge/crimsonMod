package name.crimson.client;

import name.crimson.entity.ModEntities;
import name.crimson.entity.client.ChomperRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class CrimsonClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.CHOMPER, ChomperRenderer::new);

    }
}
