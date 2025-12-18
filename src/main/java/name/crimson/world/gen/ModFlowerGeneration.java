package name.crimson.world.gen;
import name.crimson.world.biome.ModBiomes;
import name.crimson.world.feature.ModFeature;
import name.crimson.world.feature.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class ModFlowerGeneration {
    public static void generateFlowers() {
        Registry.register(Registries.FEATURE, ModFeature.BLACKSTONE_VEGETATION_ID, ModFeature.BLACKSTONE_VEGETATION);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.CRIMSON),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.BLACKSTONE_FLOWER_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.CRIMSON),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.BIG_BLACKSTONE_FLOWER_PLACED_KEY);
    }
}