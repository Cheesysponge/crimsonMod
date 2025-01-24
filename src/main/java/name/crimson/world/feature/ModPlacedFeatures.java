package name.crimson.world.feature;

import name.crimson.Crimson;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

import static name.crimson.world.feature.ModOreFeatures.modifiersWithCount;


public class ModPlacedFeatures {





    public static final RegistryKey<PlacedFeature> NETHER_SAPPHIRE_ORE_PLACED_KEY = registerKey("nether_sapphire_ore_placed");

    public static final RegistryKey<PlacedFeature> BLACKSTONE_FLOWER_PLACED_KEY = registerKey("blackstone_flower_placed");



    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);


        register(context, NETHER_SAPPHIRE_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.NETHER_SAPPHIRE_ORE_KEY),
                modifiersWithCount(16, // VeinsPerChunk
                        HeightRangePlacementModifier.uniform(YOffset.aboveBottom(300), YOffset.aboveBottom(600))));

        register(context, BLACKSTONE_FLOWER_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BLACKSTONE_FLOWER_KEY),
                RarityFilterPlacementModifier.of(2), SquarePlacementModifier.of(), CountMultilayerPlacementModifier.of(1), BiomePlacementModifier.of());

//        HeightRangePlacementModifier.uniform(YOffset.aboveBottom(0), YOffset.aboveBottom(200)), BiomePlacementModifier.of());
    }


    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(Crimson.MODID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }

}