package name.crimson.block.custom;

import net.minecraft.block.*;
import net.minecraft.component.type.SuspiciousStewEffectsComponent;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

import java.util.stream.Stream;

public class StrangeFlower extends FlowerBlock {

    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    VoxelShape shape = Stream.of(
            Stream.of(
                    Block.createCuboidShape(4, 7, 8, 6, 11, 10),
                    Block.createCuboidShape(8, 6, 10, 9.5, 10, 11.5),
                    Block.createCuboidShape(10, 6, 6, 12, 10, 8),
                    Block.createCuboidShape(6, 7, 5, 7.5, 11, 6.5)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get(),
            Block.createCuboidShape(7, 6, 7, 9, 8, 9),
            Stream.of(
                    Block.createCuboidShape(6, 3, 8, 8, 7, 10),
                    Block.createCuboidShape(7, 0, 7, 9, 5, 9),
                    Block.createCuboidShape(8, 3, 9, 9.5, 7, 10.5),
                    Block.createCuboidShape(8, 3, 6, 10, 7, 8),
                    Block.createCuboidShape(6, 3, 6, 7.5, 7, 7.5)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get()
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    public StrangeFlower(RegistryEntry<StatusEffect> stewEffect, float effectLengthInSeconds, Settings settings) {
        super(stewEffect, effectLengthInSeconds, settings);
    }


    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Vec3d vec3d = state.getModelOffset(world, pos);
        return shape.offset(vec3d.x, vec3d.y, vec3d.z);
    }
    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Vec3d vec3d = state.getModelOffset(world, pos);
        return shape.offset(vec3d.x, vec3d.y, vec3d.z);
    }
    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return (BlockState)state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate((mirror.getRotation(state.get(FACING))));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(Blocks.BLACKSTONE);
    }
}