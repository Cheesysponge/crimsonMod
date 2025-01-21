package name.crimson.world.feature;


import name.crimson.Crimson;
import name.crimson.block.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;

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





    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        var placedFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.PLACED_FEATURE);

        RuleTest netherReplaceables = new TagMatchRuleTest(TagKey.of(RegistryKeys.BLOCK, new Identifier(Crimson.MODID, "netherrack")));

        List<OreFeatureConfig.Target> netherSapphireOres =
                List.of(OreFeatureConfig.createTarget(netherReplaceables, ModBlocks.NETHER_SAPPHIRE_ORE.getDefaultState()));

        register(context, NETHER_SAPPHIRE_ORE_KEY, Feature.ORE, new OreFeatureConfig(netherSapphireOres, 8));
        
    }

//    
    public static void registerConfiguredFeatures() {
        System.out.println("Registering ModConfiguredFeatures for " + Crimson.MODID);
    }
}