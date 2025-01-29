package name.crimson.world.gen;

import name.crimson.world.biome.ModBiomes;
import name.crimson.world.feature.ModFeature;
import name.crimson.world.feature.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.world.gen.GenerationStep;

public class ModSpikeGeneration {
    public static void generateSpikes() {
        Registry.register(Registries.FEATURE, ModFeature.BLACKSTONE_SPIKES_ID, ModFeature.BLACKSTONE_SPIKES);
        Registry.register(Registries.FEATURE, ModFeature.LARGE_BLACKSTONE_SPIKES_ID, ModFeature.LARGE_BLACKSTONE_SPIKES);
        Registry.register(Registries.FEATURE, ModFeature.BLACKSTONE_SPIKES_CLUSTER_ID, ModFeature.BLACKSTONE_SPIKES_CLUSTER);


        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.CRIMSON),
                GenerationStep.Feature.TOP_LAYER_MODIFICATION, ModPlacedFeatures.BLACKSTONE_SPIKE_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.CRIMSON),
                GenerationStep.Feature.TOP_LAYER_MODIFICATION, ModPlacedFeatures.LARGE_BLACKSTONE_SPIKE_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.CRIMSON),
                GenerationStep.Feature.TOP_LAYER_MODIFICATION, ModPlacedFeatures.BLACKSTONE_SPIKE_CLUSTER_PLACED_KEY);
    }
}