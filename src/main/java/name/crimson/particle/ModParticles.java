package name.crimson.particle;
import name.crimson.Crimson;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
public class ModParticles {

    public static final DefaultParticleType BLUE_SWEEP_PARTICLE = FabricParticleTypes.simple();
    public static final DefaultParticleType BLUE_CRIT_PARTICLE = FabricParticleTypes.simple();

    public static final DefaultParticleType RED_SWEEP_PARTICLE = FabricParticleTypes.simple();
    public static final DefaultParticleType RED_CRIT_PARTICLE = FabricParticleTypes.simple();



    public static void registerParticles() {
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(Crimson.MODID, "blue_sweep_particle"),
                BLUE_SWEEP_PARTICLE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(Crimson.MODID, "red_sweep_particle"),
                RED_SWEEP_PARTICLE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(Crimson.MODID, "red_damage_particle"),
                RED_CRIT_PARTICLE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(Crimson.MODID, "blue_damage_particle"),
                BLUE_CRIT_PARTICLE);
    }
}
