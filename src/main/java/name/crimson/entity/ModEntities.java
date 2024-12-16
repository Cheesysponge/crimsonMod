package name.crimson.entity;

import name.crimson.Crimson;
import name.crimson.entity.custom.ChomperEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class ModEntities {
    public static final EntityType<ChomperEntity> CHOMPER = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(Crimson.MODID, "chomper"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, ChomperEntity::new)
                    .dimensions(EntityDimensions.fixed(0.75f, 1.25f)).build());
}
