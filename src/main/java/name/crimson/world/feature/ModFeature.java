package name.crimson.world.feature;

import net.minecraft.util.Identifier;

import static net.minecraft.world.gen.feature.NetherForestVegetationFeatureConfig.VEGETATION_CODEC;

public class ModFeature {
    public static final Identifier BLACKSTONE_VEGETATION_ID = Identifier.of("crimson","blackstone_vegetation");
    public static final BlackstoneVegetationFeatures BLACKSTONE_VEGETATION =  new BlackstoneVegetationFeatures(VEGETATION_CODEC);


}
