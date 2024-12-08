package name.crimson.world.terrablender;

import name.crimson.Crimson;
import net.minecraft.client.sound.MusicType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.carver.ConfiguredCarvers;
import net.minecraft.world.gen.feature.*;

public class ModBiomes {
    public static final RegistryKey<Biome> CRIMSON = RegistryKey.of(RegistryKeys.BIOME,
            new Identifier(Crimson.MODID, "crimson"));

    public static void boostrap(Registerable<Biome> context) {
        context.register(CRIMSON, crimsonBiome(context));
    }

    public static void globalOverworldGeneration(GenerationSettings.LookupBackedBuilder builder) {
        builder.carver(GenerationStep.Carver.AIR, ConfiguredCarvers.NETHER_CAVE);
        //builder.carver(GenerationStep.Carver.AIR, ConfiguredCarvers.CANYON);
        builder.feature(GenerationStep.Feature.LAKES, MiscPlacedFeatures.LAKE_LAVA_UNDERGROUND);
        builder.feature(GenerationStep.Feature.LAKES, MiscPlacedFeatures.LAKE_LAVA_SURFACE);
        //DefaultBiomeFeatures.addAmethystGeodes(builder);
        //DefaultBiomeFeatures.addDungeons(builder);
        //DefaultBiomeFeatures.addMineables(builder);
        //DefaultBiomeFeatures.addSprings(builder);
        //DefaultBiomeFeatures.addFrozenTopLayer(builder);
    }

    public static Biome crimsonBiome(Registerable<Biome> context) {
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();

        spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.STRIDER, 2, 3, 5));

        spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.WOLF, 5, 4, 4));

        DefaultBiomeFeatures.addFarmAnimals(spawnBuilder);
        DefaultBiomeFeatures.addBatsAndMonsters(spawnBuilder);

        GenerationSettings.LookupBackedBuilder biomeBuilder = (new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                        context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER))).carver(GenerationStep.Carver.AIR, ConfiguredCarvers.NETHER_CAVE).feature(GenerationStep.Feature.VEGETAL_DECORATION, MiscPlacedFeatures.SPRING_LAVA);


        DefaultBiomeFeatures.addDefaultMushrooms(biomeBuilder);
        biomeBuilder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, NetherPlacedFeatures.SPRING_OPEN).feature(GenerationStep.Feature.UNDERGROUND_DECORATION, NetherPlacedFeatures.PATCH_FIRE).feature(GenerationStep.Feature.UNDERGROUND_DECORATION, NetherPlacedFeatures.GLOWSTONE_EXTRA).feature(GenerationStep.Feature.UNDERGROUND_DECORATION, NetherPlacedFeatures.GLOWSTONE).feature(GenerationStep.Feature.UNDERGROUND_DECORATION, OrePlacedFeatures.ORE_MAGMA).feature(GenerationStep.Feature.UNDERGROUND_DECORATION, NetherPlacedFeatures.SPRING_CLOSED).feature(GenerationStep.Feature.VEGETAL_DECORATION, NetherPlacedFeatures.WEEPING_VINES).feature(GenerationStep.Feature.VEGETAL_DECORATION, TreePlacedFeatures.CRIMSON_FUNGI).feature(GenerationStep.Feature.VEGETAL_DECORATION, NetherPlacedFeatures.CRIMSON_FOREST_VEGETATION);
        DefaultBiomeFeatures.addNetherMineables(biomeBuilder);
        //return (new Biome.Builder()).precipitation(false).temperature(2.0F).downfall(0.0F).effects((new BiomeEffects.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(3343107).skyColor(OverworldBiomeCreator.getSkyColor(2.0F)).particleConfig(new BiomeParticleConfig(ParticleTypes.CRIMSON_SPORE, 0.025F)).loopSound(SoundEvents.AMBIENT_CRIMSON_FOREST_LOOP).moodSound(new BiomeMoodSound(SoundEvents.AMBIENT_CRIMSON_FOREST_MOOD, 6000, 8, 2.0)).additionsSound(new BiomeAdditionsSound(SoundEvents.AMBIENT_CRIMSON_FOREST_ADDITIONS, 0.0111)).music(MusicType.createIngameMusic(SoundEvents.MUSIC_NETHER_CRIMSON_FOREST)).build()).spawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
        //DefaultBiomeFeatures.addDefaultVegetation(biomeBuilder);

        return new Biome.Builder()
                .precipitation(true)
                .downfall(0.4f)
                .temperature(0.7f)
                .generationSettings(biomeBuilder.build())
                .spawnSettings(spawnBuilder.build())
                .effects((new BiomeEffects.Builder())
                        .waterColor(0xe82e3b)
                        .waterFogColor(0xb50713)
                        .skyColor(0xff0a1b)
                        .particleConfig(new BiomeParticleConfig(ParticleTypes.CRIMSON_SPORE, 0.025F))
                        .grassColor(0xff0a1b)
                        .foliageColor(0xff0a1b)
                        .fogColor(0xff0a1b)
                        .loopSound(SoundEvents.AMBIENT_CRIMSON_FOREST_LOOP)
                        .moodSound(BiomeMoodSound.CAVE)
                        .music(MusicType.createIngameMusic(SoundEvents.MUSIC_NETHER_CRIMSON_FOREST)).build())
                .build();
    }
}