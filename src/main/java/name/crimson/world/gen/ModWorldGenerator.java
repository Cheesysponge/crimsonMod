package name.crimson.world.gen;

import name.crimson.world.feature.BlackstoneVegetationFeatures;
import name.crimson.world.feature.ModFeature;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static net.minecraft.world.gen.feature.NetherForestVegetationFeatureConfig.VEGETATION_CODEC;

public class ModWorldGenerator {
    public static void generate(){




        ModOreGeneration.generateOres();
        ModFlowerGeneration.generateFlowers();
        ModSpikeGeneration.generateSpikes();
    }
}
