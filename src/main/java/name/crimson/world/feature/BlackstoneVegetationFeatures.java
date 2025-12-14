package name.crimson.world.feature;

import com.mojang.serialization.Codec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NetherForestVegetationFeatureConfig;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class BlackstoneVegetationFeatures extends Feature<NetherForestVegetationFeatureConfig> {


    public BlackstoneVegetationFeatures(Codec<NetherForestVegetationFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean generate(FeatureContext<NetherForestVegetationFeatureConfig> context) {
        StructureWorldAccess structureWorldAccess = context.getWorld();
        BlockPos blockPos = context.getOrigin();

        // ✅ NEW: remember the origin chunk, and never place outside it
        int originChunkX = blockPos.getX() >> 4;
        int originChunkZ = blockPos.getZ() >> 4;

        BlockState blockState = structureWorldAccess.getBlockState(blockPos.down());
        NetherForestVegetationFeatureConfig netherForestVegetationFeatureConfig = context.getConfig();
        Random random = context.getRandom();

        if (!blockState.isOf(Blocks.BLACKSTONE)) {
            return false;
        }

        int i = blockPos.getY();
        if (i < structureWorldAccess.getBottomY() + 1 || i + 1 >= structureWorldAccess.getTopY()) {
            return false;
        }

        int j = 0;
        int spreadWidth = netherForestVegetationFeatureConfig.spreadWidth;
        int spreadHeight = netherForestVegetationFeatureConfig.spreadHeight;

        for (int k = 0; k < spreadWidth * spreadWidth; ++k) {
            BlockPos blockPos2 = blockPos.add(
                    random.nextInt(spreadWidth) - random.nextInt(spreadWidth),
                    random.nextInt(spreadHeight) - random.nextInt(spreadHeight),
                    random.nextInt(spreadWidth) - random.nextInt(spreadWidth)
            );

            // ✅ NEW: skip positions in neighboring chunks (worldgen-safe)
            if ((blockPos2.getX() >> 4) != originChunkX || (blockPos2.getZ() >> 4) != originChunkZ) {
                continue;
            }

            BlockState blockState2 = netherForestVegetationFeatureConfig.stateProvider.get(random, blockPos2);
            if (!structureWorldAccess.isAir(blockPos2)
                    || blockPos2.getY() <= structureWorldAccess.getBottomY()
                    || !blockState2.canPlaceAt(structureWorldAccess, blockPos2)) {
                continue;
            }

            structureWorldAccess.setBlockState(blockPos2, blockState2, Block.NOTIFY_LISTENERS);
            ++j;
        }

        return j > 0;
    }

}
