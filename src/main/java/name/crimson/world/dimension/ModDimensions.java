package name.crimson.world.dimension;

import name.crimson.Crimson;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

public class ModDimensions {
    public static final RegistryKey<World> CRIMSON_DIM_DIMENSION_KEY = RegistryKey.of(RegistryKeys.WORLD,
            new Identifier(Crimson.MODID, "crimson_dim"));
    public static final RegistryKey<DimensionType> CRIMSON_DIM_TYPE_KEY = RegistryKey.of(RegistryKeys.DIMENSION_TYPE,
            CRIMSON_DIM_DIMENSION_KEY.getValue());

    public static void register() {
        //Crimson.LOGGER.debug("😀 Registering ModDimensions for " + Crimson.MODID + "!!!!!");
        CustomPortalBuilder.beginPortal().frameBlock(Blocks.CRIMSON_HYPHAE)
                .destDimID(CRIMSON_DIM_DIMENSION_KEY.getValue())
                .tintColor(227, 207, 30)
                .lightWithItem(Items.FIRE_CHARGE)
                .registerPortal();
    }
}