package name.crimson;

import name.crimson.entity.ModEntities;
import name.crimson.entity.custom.ChomperEntity;
import name.crimson.world.dimension.ModDimensions;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib.GeckoLib;

public class Crimson implements ModInitializer {
    public static final String MODID = "crimson";
    public static final Logger LOGGER = LoggerFactory.getLogger("crimson");

    @Override
    public void onInitialize() {
        GeckoLib.initialize();
        ModDimensions.register();
        FabricDefaultAttributeRegistry.register(ModEntities.CHOMPER, ChomperEntity.setAttributes());

    }
}
