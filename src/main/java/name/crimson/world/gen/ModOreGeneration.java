package name.crimson.world.gen;

import name.crimson.world.biome.ModBiomes;
import name.crimson.world.feature.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;

public class ModOreGeneration {
    public static void generateOres() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.CRIMSON),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.NETHER_SAPPHIRE_ORE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.CRIMSON),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.NETHER_RUBY_ORE_PLACED_KEY);
    }
}