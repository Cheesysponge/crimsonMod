package name.crimson.world.terrablender.surface;

import name.crimson.world.terrablender.ModBiomes;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;

public class ModMaterialRules {
    private static final MaterialRules.MaterialRule CRIMSON_HYPHAE = makeStateRule(Blocks.CRIMSON_HYPHAE);
    private static final MaterialRules.MaterialRule RED_MUSHROOM_BLOCK = makeStateRule(Blocks.RED_MUSHROOM_BLOCK);
    private static final MaterialRules.MaterialRule NETHERRACK = makeStateRule(Blocks.NETHERRACK);
    private static final MaterialRules.MaterialRule CRIMSON_NYLIUM = makeStateRule(Blocks.CRIMSON_NYLIUM);

    public static MaterialRules.MaterialRule makeRules() {
        MaterialRules.MaterialCondition isAtOrAboveWaterLevel = MaterialRules.water(-1, 0);

        MaterialRules.MaterialRule redSurface = MaterialRules.sequence(MaterialRules.condition(isAtOrAboveWaterLevel, RED_MUSHROOM_BLOCK), CRIMSON_HYPHAE);

        return MaterialRules.sequence(
                MaterialRules.sequence(MaterialRules.condition(MaterialRules.biome(ModBiomes.CRIMSON),
                                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, CRIMSON_NYLIUM)),
                        MaterialRules.condition(MaterialRules.STONE_DEPTH_CEILING, NETHERRACK)),

                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, redSurface),
                MaterialRules.condition(MaterialRules.steepSlope(),NETHERRACK)
        );
    }

    private static MaterialRules.MaterialRule makeStateRule(Block block) {
        return MaterialRules.block(block.getDefaultState());
    }
}