package name.crimson.world.gen;

import name.crimson.world.feature.BlackstoneVegetationFeatures;
import name.crimson.world.feature.ModFeature;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static net.minecraft.world.gen.feature.NetherForestVegetationFeatureConfig.VEGETATION_CODEC;

public class ModWorldGenerator {
    public static void generate(){
        Registry.register(Registries.FEATURE, ModFeature.BLACKSTONE_VEGETATION_ID, ModFeature.BLACKSTONE_VEGETATION);
        Registry.register(Registries.FEATURE, ModFeature.BLACKSTONE_SPIKES_ID, ModFeature.BLACKSTONE_SPIKES);
        Registry.register(Registries.FEATURE, ModFeature.LARGE_BLACKSTONE_SPIKES_ID, ModFeature.LARGE_BLACKSTONE_SPIKES);


        ModOreGeneration.generateOres();
        ModFlowerGeneration.generateFlowers();
        ModSpikeGeneration.generateSpikes();
    }
}
