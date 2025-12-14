package name.crimson.world.feature;

import name.crimson.Crimson;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.ClampedNormalIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

import static name.crimson.world.feature.ModOreFeatures.modifiersWithCount;

public class ModPlacedFeatures {

    public static final RegistryKey<PlacedFeature> NETHER_SAPPHIRE_ORE_PLACED_KEY = registerKey("nether_sapphire_ore_placed");
    public static final RegistryKey<PlacedFeature> NETHER_RUBY_ORE_PLACED_KEY = registerKey("nether_ruby_ore_placed");

    public static final RegistryKey<PlacedFeature> BLACKSTONE_FLOWER_PLACED_KEY = registerKey("blackstone_flower_placed");

    public static final RegistryKey<PlacedFeature> BLACKSTONE_SPIKE_PLACED_KEY = registerKey("blackstone_spike_placed");
    public static final RegistryKey<PlacedFeature> LARGE_BLACKSTONE_SPIKE_PLACED_KEY = registerKey("large_blackstone_spike_placed");
    public static final RegistryKey<PlacedFeature> BLACKSTONE_SPIKE_CLUSTER_PLACED_KEY = registerKey("blackstone_spike_cluster_placed");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configured = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, NETHER_SAPPHIRE_ORE_PLACED_KEY, configured.getOrThrow(ModConfiguredFeatures.NETHER_SAPPHIRE_ORE_KEY),
                modifiersWithCount(16, // VeinsPerChunk
                        HeightRangePlacementModifier.uniform(YOffset.aboveBottom(300), YOffset.aboveBottom(600))));
        register(context, NETHER_RUBY_ORE_PLACED_KEY, configured.getOrThrow(ModConfiguredFeatures.NETHER_RUBY_ORE_KEY),
                modifiersWithCount(16, // VeinsPerChunk
                        HeightRangePlacementModifier.uniform(YOffset.aboveBottom(0), YOffset.aboveBottom(600))));


        register(context, BLACKSTONE_FLOWER_PLACED_KEY,
                configured.getOrThrow(ModConfiguredFeatures.BLACKSTONE_FLOWER_KEY),

                // how many patches per chunk
                CountPlacementModifier.of(UniformIntProvider.create(2, 6)),
                SquarePlacementModifier.of(),

                // limit to the band where your blackstone shelf is
                HeightRangePlacementModifier.uniform(YOffset.aboveBottom(76), YOffset.aboveBottom(120)),

                // 🔑 scan down until we hit blackstone, but only while moving through air
                EnvironmentScanPlacementModifier.of(
                        Direction.DOWN,
                        net.minecraft.world.gen.blockpredicate.BlockPredicate.matchingBlocks(Blocks.BLACKSTONE),
                        net.minecraft.world.gen.blockpredicate.BlockPredicate.IS_AIR,
                        32
                ),

                // move to the air block above the found blackstone
                RandomOffsetPlacementModifier.of(net.minecraft.util.math.intprovider.ConstantIntProvider.create(0),
                        net.minecraft.util.math.intprovider.ConstantIntProvider.create(1))



                // IMPORTANT: no BiomePlacementModifier (your region is not a biome)
        );


        register(context, BLACKSTONE_SPIKE_PLACED_KEY, configured.getOrThrow(ModConfiguredFeatures.BLACKSTONE_SPIKE_KEY),
                CountPlacementModifier.of(UniformIntProvider.create(192, 256)), SquarePlacementModifier.of(), PlacedFeatures.BOTTOM_TO_TOP_RANGE,
                CountPlacementModifier.of(UniformIntProvider.create(1, 5)), RandomOffsetPlacementModifier.of(ClampedNormalIntProvider.of(0.0F, 3.0F, -10, 10),
                        ClampedNormalIntProvider.of(0.0F, 0.6F, -2, 2)), BiomePlacementModifier.of());

        register(context, LARGE_BLACKSTONE_SPIKE_PLACED_KEY, configured.getOrThrow(ModConfiguredFeatures.LARGE_BLACKSTONE_SPIKE_KEY),
                CountPlacementModifier.of(UniformIntProvider.create(192, 256)), SquarePlacementModifier.of(), PlacedFeatures.BOTTOM_TO_TOP_RANGE,
                CountPlacementModifier.of(UniformIntProvider.create(1, 5)), RandomOffsetPlacementModifier.of(ClampedNormalIntProvider.of(0.0F, 3.0F, -10, 10),
                        ClampedNormalIntProvider.of(0.0F, 0.6F, -2, 2)), BiomePlacementModifier.of());

        register(context, BLACKSTONE_SPIKE_CLUSTER_PLACED_KEY, configured.getOrThrow(ModConfiguredFeatures.BLACKSTONE_SPIKE_CLUSTER_KEY),
                CountPlacementModifier.of(UniformIntProvider.create(48, 96)), SquarePlacementModifier.of(), PlacedFeatures.BOTTOM_TO_TOP_RANGE, BiomePlacementModifier.of());
    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(Crimson.MODID, name));
    }

    private static void register(Registerable<PlacedFeature> context,
                                 RegistryKey<PlacedFeature> key,
                                 RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context,
                                                                                   RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}
