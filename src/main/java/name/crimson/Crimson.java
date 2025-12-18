package name.crimson;

import name.crimson.block.ModBlocks;
import name.crimson.entity.ModEntities;
import name.crimson.item.ModItemGroup;
import name.crimson.item.ModItems;
import name.crimson.particle.ModParticles;
import name.crimson.util.BoostPayload;
import name.crimson.util.CrimsonNetworking;
import name.crimson.util.CrimsonPayloads;
import name.crimson.world.dimension.ModDimensions;
import name.crimson.world.entity.ModEntitySpawn;
import name.crimson.world.feature.ModConfiguredFeatures;
import name.crimson.world.gen.ModOreGeneration;
import name.crimson.world.gen.ModWorldGenerator;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.server.network.ServerPlayerEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib.GeckoLib;

import static name.crimson.util.CrimsonNetworking.applyBoost;

public class Crimson implements ModInitializer {
    public static final String MODID = "crimson";
    public static final Logger LOGGER = LoggerFactory.getLogger("crimson");

    @Override
    public void onInitialize() {

        ModConfiguredFeatures.registerConfiguredFeatures();

        ModDimensions.register();
        ModEntities.registerAttributes();
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        ModItemGroup.registerItemGroups();
        ModEntitySpawn.addEntitySpawn();
        ModWorldGenerator.generate();
        ModParticles.registerParticles();
        CrimsonPayloads.registerCommon(); // ✅ safe

        ServerPlayNetworking.registerGlobalReceiver(BoostPayload.ID, (payload, ctx) -> {
            ServerPlayerEntity player = ctx.player();
            ctx.server().execute(() -> applyBoost(player));
        });

    }
}
