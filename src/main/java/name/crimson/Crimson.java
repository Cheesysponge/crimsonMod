package name.crimson;

import name.crimson.world.dimension.ModDimensions;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Crimson implements ModInitializer {
    public static final String MODID = "crimson";
    public static final Logger LOGGER = LoggerFactory.getLogger("crimson");

    @Override
    public void onInitialize() {
        ModDimensions.register();
    }
}
