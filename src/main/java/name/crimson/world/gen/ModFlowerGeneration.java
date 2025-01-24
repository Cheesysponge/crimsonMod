package name.crimson.world.gen;
import name.crimson.world.biome.ModBiomes;
import name.crimson.world.feature.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class ModFlowerGeneration {
    public static void generateFlowers() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.CRIMSON),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.BLACKSTONE_FLOWER_PLACED_KEY);
    }
}