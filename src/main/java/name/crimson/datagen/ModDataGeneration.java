package name.crimson.datagen;

import name.crimson.world.biome.ModBiomes;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class ModDataGeneration implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(ModWorldGenerator::new);
        pack.addProvider(ModModelProvider::new);
        pack.addProvider(ModLootTableGenerator::new);


    }

    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
//        registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeatures::boostrap);
//        registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ModPlacedFeatures::boostrap);
        registryBuilder.addRegistry(RegistryKeys.BIOME, ModBiomes::boostrap);
    }
}
