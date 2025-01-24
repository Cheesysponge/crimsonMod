package name.crimson;

import name.crimson.block.ModBlocks;
import name.crimson.entity.ModEntities;
import name.crimson.item.ModItemGroup;
import name.crimson.item.ModItems;
import name.crimson.world.dimension.ModDimensions;
import name.crimson.world.entity.ModEntitySpawn;
import name.crimson.world.feature.ModConfiguredFeatures;
import name.crimson.world.gen.ModOreGeneration;
import name.crimson.world.gen.ModWorldGenerator;
import net.fabricmc.api.ModInitializer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib.GeckoLib;

public class Crimson implements ModInitializer {
    public static final String MODID = "crimson";
    public static final Logger LOGGER = LoggerFactory.getLogger("crimson");

    @Override
    public void onInitialize() {
        ModConfiguredFeatures.registerConfiguredFeatures();

        GeckoLib.initialize();
        ModDimensions.register();
        ModEntities.registerAttributes();
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        ModItemGroup.registerItemGroups();
        ModEntitySpawn.addEntitySpawn();
        ModWorldGenerator.generate();
    }
}
