package name.crimson.particle;
import name.crimson.Crimson;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
public class ModParticles {

    public static final DefaultParticleType BLUE_PARTICLE = FabricParticleTypes.simple();

    public static void registerParticles() {
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(Crimson.MODID, "blue_sweep_particle"),
                BLUE_PARTICLE);
    }
}
