package name.crimson;

import name.crimson.world.dimension.ModDimensions;
import net.fabricmc.api.ModInitializer;

public class Crimson implements ModInitializer {
    public static final String MODID = "crimson";
    @Override
    public void onInitialize() {
        ModDimensions.register();
    }
}
