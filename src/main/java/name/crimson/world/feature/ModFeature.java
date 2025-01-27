package name.crimson.world.feature;

import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.LargeDripstoneFeatureConfig;
import net.minecraft.world.gen.feature.SmallDripstoneFeatureConfig;

import static net.minecraft.world.gen.feature.NetherForestVegetationFeatureConfig.VEGETATION_CODEC;

public class ModFeature {
    public static final Identifier BLACKSTONE_VEGETATION_ID = Identifier.of("crimson","blackstone_vegetation");
    public static final BlackstoneVegetationFeatures BLACKSTONE_VEGETATION =  new BlackstoneVegetationFeatures(VEGETATION_CODEC);
    public static final Identifier BLACKSTONE_SPIKES_ID = Identifier.of("crimson","blackstone_spikes");
    public static final SmallSpikeFeature BLACKSTONE_SPIKES = new SmallSpikeFeature(SmallDripstoneFeatureConfig.CODEC);

    public static final Identifier LARGE_BLACKSTONE_SPIKES_ID = Identifier.of("crimson","large_blackstone_spikes");
    public static final LargeSpikeFeature LARGE_BLACKSTONE_SPIKES = new LargeSpikeFeature(LargeDripstoneFeatureConfig.CODEC);


}
