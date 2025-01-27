package name.crimson.world.gen;

import name.crimson.world.biome.ModBiomes;
import name.crimson.world.feature.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;

public class ModSpikeGeneration {
    public static void generateSpikes() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.CRIMSON),
                GenerationStep.Feature.TOP_LAYER_MODIFICATION, ModPlacedFeatures.BLACKSTONE_SPIKE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.CRIMSON),
                GenerationStep.Feature.TOP_LAYER_MODIFICATION, ModPlacedFeatures.LARGE_BLACKSTONE_SPIKE_PLACED_KEY);
    }
}