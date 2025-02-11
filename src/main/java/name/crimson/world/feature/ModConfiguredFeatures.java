package name.crimson.world.feature;


import name.crimson.Crimson;
import name.crimson.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.floatprovider.ClampedNormalFloatProvider;
import net.minecraft.util.math.floatprovider.UniformFloatProvider;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.EnvironmentScanPlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.minecraft.world.gen.placementmodifier.RandomOffsetPlacementModifier;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

import java.util.List;

public class ModConfiguredFeatures {
    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(Crimson.MODID, name));
    }
    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }


    public static final RegistryKey<ConfiguredFeature<?,?>> NETHER_SAPPHIRE_ORE_KEY = registerKey("nether_sapphire_ore");

    public static final RegistryKey<ConfiguredFeature<?,?>> NETHER_RUBY_ORE_KEY = registerKey("nether_ruby_ore");

    public static final RegistryKey<ConfiguredFeature<?,?>> BLACKSTONE_FLOWER_KEY = registerKey("blackstone_flower");

    public static final RegistryKey<ConfiguredFeature<?,?>> BLACKSTONE_SPIKE_KEY = registerKey("blackstone_spike");

    public static final RegistryKey<ConfiguredFeature<?,?>> LARGE_BLACKSTONE_SPIKE_KEY = registerKey("large_blackstone_spike");

    public static final RegistryKey<ConfiguredFeature<?,?>> BLACKSTONE_SPIKE_CLUSTER_KEY = registerKey("blackstone_spike_cluster");






    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        var placedFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.PLACED_FEATURE);

        RuleTest netherReplaceables = new TagMatchRuleTest(TagKey.of(RegistryKeys.BLOCK, new Identifier(Crimson.MODID, "netherrack")));
        RuleTest blackstone = new TagMatchRuleTest(TagKey.of(RegistryKeys.BLOCK, new Identifier(Crimson.MODID, "blackstone")));


        List<OreFeatureConfig.Target> netherSapphireOres =
                List.of(OreFeatureConfig.createTarget(netherReplaceables, ModBlocks.NETHER_SAPPHIRE_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> netherRubyOres =
                List.of(OreFeatureConfig.createTarget(blackstone, ModBlocks.NETHER_RUBY_ORE.getDefaultState()));

        register(context, NETHER_SAPPHIRE_ORE_KEY, Feature.ORE, new OreFeatureConfig(netherSapphireOres, 8));

        register(context, NETHER_RUBY_ORE_KEY, Feature.ORE, new OreFeatureConfig(netherRubyOres, 8));


        register(context, BLACKSTONE_FLOWER_KEY, ModFeature.BLACKSTONE_VEGETATION,
                new NetherForestVegetationFeatureConfig(BlockStateProvider.of(ModBlocks.BLACKSTONE_FLOWER), 1, 1));

        register(context, BLACKSTONE_SPIKE_KEY, Feature.SIMPLE_RANDOM_SELECTOR,
                new SimpleRandomFeatureConfig(RegistryEntryList.of(PlacedFeatures.createEntry(ModFeature.BLACKSTONE_SPIKES,
                        new SmallDripstoneFeatureConfig(0.2F, 0.7F, 0.5F, 0.5F),
                        EnvironmentScanPlacementModifier.of(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.IS_AIR_OR_WATER, 12),
                        RandomOffsetPlacementModifier.vertically(ConstantIntProvider.create(1))), PlacedFeatures.createEntry(ModFeature.BLACKSTONE_SPIKES,
                        new SmallDripstoneFeatureConfig(0.2F, 0.7F, 0.5F, 0.5F),
                        EnvironmentScanPlacementModifier.of(Direction.UP, BlockPredicate.solid(), BlockPredicate.IS_AIR_OR_WATER, 12),
                        RandomOffsetPlacementModifier.vertically(ConstantIntProvider.create(-1))))));

        register(context, LARGE_BLACKSTONE_SPIKE_KEY, ModFeature.LARGE_BLACKSTONE_SPIKES,
                new LargeDripstoneFeatureConfig(30, UniformIntProvider.create(3, 19), UniformFloatProvider.create(0.4f, 2.0f),
                        0.33f, UniformFloatProvider.create(0.3f, 0.9f), UniformFloatProvider.create(0.4f, 1.0f),
                        UniformFloatProvider.create(0.0f, 0.3f), 4, 0.6f));

        register(context, BLACKSTONE_SPIKE_CLUSTER_KEY, ModFeature.BLACKSTONE_SPIKES_CLUSTER,
                new DripstoneClusterFeatureConfig(12, UniformIntProvider.create(3, 6), UniformIntProvider.create(2, 8),
                        1, 3, UniformIntProvider.create(2, 4), UniformFloatProvider.create(0.3f, 0.7f),
                        ClampedNormalFloatProvider.create(0.1f, 0.3f, 0.1f, 0.9f), 0.1f, 3,
                        8));

    }

//
    public static void registerConfiguredFeatures() {
        System.out.println("Registering ModConfiguredFeatures for " + Crimson.MODID);
    }
}