package name.crimson.util;

import name.crimson.block.ModBlocks;
import name.crimson.block.custom.BlackstoneSpike;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.enums.Thickness;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.WorldAccess;

import java.util.function.Consumer;

public class SpikeHelper {
    public SpikeHelper() {
    }

    public static double scaleHeightFromRadius(double radius, double scale, double heightScale, double bluntness) {
        if (radius < bluntness) {
            radius = bluntness;
        }

        double d = 0.384;
        double e = radius / scale * 0.384;
        double f = 0.75 * Math.pow(e, 1.3333333333333333);
        double g = Math.pow(e, 0.6666666666666666);
        double h = 0.3333333333333333 * Math.log(e);
        double i = heightScale * (f - g - h);
        i = Math.max(i, 0.0);
        return i / 0.384 * scale;
    }

    public static boolean canGenerateBase(StructureWorldAccess world, BlockPos pos, int height) {
        if (canGenerateOrLava(world, pos)) {
            return false;
        } else {
            float f = 6.0F;
            float g = 6.0F / (float)height;

            for(float h = 0.0F; h < 6.2831855F; h += g) {
                int i = (int)(MathHelper.cos(h) * (float)height);
                int j = (int)(MathHelper.sin(h) * (float)height);
                if (canGenerateOrLava(world, pos.add(i, 0, j))) {
                    return false;
                }
            }

            return true;
        }
    }

    public static boolean canGenerate(WorldAccess world, BlockPos pos) {
        return world.testBlockState(pos, SpikeHelper::canGenerate);
    }

    public static boolean canGenerateOrLava(WorldAccess world, BlockPos pos) {
        return world.testBlockState(pos, SpikeHelper::canGenerateOrLava);
    }

    protected static void getDripstoneThickness(Direction direction, int height, boolean merge, Consumer<BlockState> callback) {
        if (height >= 3) {
            callback.accept(getState(direction, Thickness.BASE));

            for(int i = 0; i < height - 3; ++i) {
                callback.accept(getState(direction, Thickness.MIDDLE));
            }
        }

        if (height >= 2) {
            callback.accept(getState(direction, Thickness.FRUSTUM));
        }

        if (height >= 1) {
            callback.accept(getState(direction, merge ? Thickness.TIP_MERGE : Thickness.TIP));
        }

    }

    public static void generatePointedDripstone(WorldAccess world, BlockPos pos, Direction direction, int height, boolean merge) {
        if (canReplace(world.getBlockState(pos.offset(direction.getOpposite())))) {
            BlockPos.Mutable mutable = pos.mutableCopy();
            getDripstoneThickness(direction, height, merge, (state) -> {
                if (state.isOf(ModBlocks.BLACKSTONE_SPIKE)) {
                    state = (BlockState)state.with(BlackstoneSpike.WATERLOGGED, world.isWater(mutable));
                }

                world.setBlockState(mutable, state, 2);
                mutable.move(direction);
            });
        }
    }

    public static boolean generateDripstoneBlock(WorldAccess world, BlockPos pos) {
        BlockState blockState = world.getBlockState(pos);
        if (blockState.isIn(BlockTags.DRIPSTONE_REPLACEABLE_BLOCKS)) {
            world.setBlockState(pos, Blocks.DRIPSTONE_BLOCK.getDefaultState(), 2);
            return true;
        } else {
            return false;
        }
    }

    private static BlockState getState(Direction direction, Thickness thickness) {
        return (BlockState)((BlockState)ModBlocks.BLACKSTONE_SPIKE.getDefaultState().with(BlackstoneSpike.VERTICAL_DIRECTION, direction)).with(BlackstoneSpike.THICKNESS, thickness);
    }

    public static boolean canReplaceOrLava(BlockState state) {
        return canReplace(state) || state.isOf(Blocks.LAVA);
    }

    public static boolean canReplace(BlockState state) {
        return state.isOf(Blocks.BLACKSTONE);// || state.isIn(BlockTags.DRIPSTONE_REPLACEABLE_BLOCKS);
    }

    public static boolean canGenerate(BlockState state) {
        return state.isAir() || state.isOf(Blocks.WATER);
    }

    public static boolean cannotGenerate(BlockState state) {
        return !state.isAir() && !state.isOf(Blocks.WATER);
    }

    public static boolean canGenerateOrLava(BlockState state) {
        return state.isAir() || state.isOf(Blocks.WATER) || state.isOf(Blocks.LAVA);
    }
}
