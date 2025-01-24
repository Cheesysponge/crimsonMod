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
import net.minecraft.util.math.intprovider.ConstantIntProvider;
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


    public static final RegistryKey<ConfiguredFeature<?,?>> BLACKSTONE_FLOWER_KEY = registerKey("blackstone_flower");

    public static final RegistryKey<ConfiguredFeature<?,?>> BLACKSTONE_SPIKE_KEY = registerKey("blackstone_spike");




    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        var placedFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.PLACED_FEATURE);

        RuleTest netherReplaceables = new TagMatchRuleTest(TagKey.of(RegistryKeys.BLOCK, new Identifier(Crimson.MODID, "netherrack")));

        List<OreFeatureConfig.Target> netherSapphireOres =
                List.of(OreFeatureConfig.createTarget(netherReplaceables, ModBlocks.NETHER_SAPPHIRE_ORE.getDefaultState()));

        register(context, NETHER_SAPPHIRE_ORE_KEY, Feature.ORE, new OreFeatureConfig(netherSapphireOres, 8));

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

    }

//
    public static void registerConfiguredFeatures() {
        System.out.println("Registering ModConfiguredFeatures for " + Crimson.MODID);
    }
}