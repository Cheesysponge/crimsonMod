package name.crimson.world.entity;

import name.crimson.entity.ModEntities;
import name.crimson.entity.custom.ChomperEntity;
import name.crimson.world.biome.ModBiomes;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.ZoglinEntity;
import net.minecraft.entity.passive.StriderEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.BiomeKeys;

public class ModEntitySpawn {
    public static void addEntitySpawn() {
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(ModBiomes.CRIMSON,BiomeKeys.CRIMSON_FOREST),
                SpawnGroup.CREATURE, ModEntities.CHOMPER, 10, 1, 6);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(ModBiomes.CRIMSON,BiomeKeys.CRIMSON_FOREST),
                SpawnGroup.CREATURE, ModEntities.TIGER, 10, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(ModBiomes.CRIMSON),
                SpawnGroup.CREATURE, EntityType.STRIDER, 2, 3, 6);
    }
}