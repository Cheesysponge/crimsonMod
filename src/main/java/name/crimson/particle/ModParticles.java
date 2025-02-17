package name.crimson.particle;
import name.crimson.Crimson;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
public class ModParticles {

    public static final SimpleParticleType BLUE_SWEEP_PARTICLE = FabricParticleTypes.simple();
    public static final SimpleParticleType BLUE_CRIT_PARTICLE = FabricParticleTypes.simple();

    public static final SimpleParticleType RED_SWEEP_PARTICLE = FabricParticleTypes.simple();
    public static final SimpleParticleType RED_CRIT_PARTICLE = FabricParticleTypes.simple();



    public static void registerParticles() {
        Registry.register(Registries.PARTICLE_TYPE, Identifier.of(Crimson.MODID, "blue_sweep_particle"),
                BLUE_SWEEP_PARTICLE);
        Registry.register(Registries.PARTICLE_TYPE, Identifier.of(Crimson.MODID, "red_sweep_particle"),
                RED_SWEEP_PARTICLE);
        Registry.register(Registries.PARTICLE_TYPE, Identifier.of(Crimson.MODID, "red_damage_particle"),
                RED_CRIT_PARTICLE);
        Registry.register(Registries.PARTICLE_TYPE, Identifier.of(Crimson.MODID, "blue_damage_particle"),
                BLUE_CRIT_PARTICLE);
    }
}
