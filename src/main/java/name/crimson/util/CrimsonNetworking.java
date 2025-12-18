package name.crimson.util;


import name.crimson.Crimson;
import name.crimson.particle.ModParticles;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.s2c.play.EntityVelocityUpdateS2CPacket;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;
import name.crimson.item.custom.WingsItem;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CrimsonNetworking {
    private static final Map<UUID, Long> BOOST_COOLDOWNS = new HashMap<>();
    private static final int BOOST_COOLDOWN_TICKS = 20; // 1 second
    public static void registerServer() {
        // ✅ Register the payload type for SERVERBOUND (C2S)
        PayloadTypeRegistry.playC2S().register(BoostPayload.ID, BoostPayload.CODEC);

        // ✅ Now you can register the handler
        ServerPlayNetworking.registerGlobalReceiver(BoostPayload.ID, (payload, ctx) -> {
            ServerPlayerEntity player = ctx.player();
            ctx.server().execute(() -> applyBoost(player));
        });
    }

    public static void applyBoost(ServerPlayerEntity player) {
//        Crimson.LOGGER.warn("BOOST PACKET RECEIVED from " + player.getName().getString());
        ItemStack chest = player.getEquippedStack(EquipmentSlot.CHEST);
        if (!(chest.getItem() instanceof WingsItem)) return;

        long tick = player.getServerWorld().getTime();
        UUID id = player.getUuid();

        // ---- cooldown check ----
        Long nextAllowed = BOOST_COOLDOWNS.get(id);
        if (nextAllowed != null && tick < nextAllowed) return;

        // start cooldown
        BOOST_COOLDOWNS.put(id, tick + BOOST_COOLDOWN_TICKS);
        // Optional: only while gliding
        // if (!player.isFallFlying()) return;

        double strength = 1.2;
        Vec3d look = player.getRotationVector();
        //player.addVelocity(look.x * strength, look.y * 0.4, look.z * strength);
        if(player.isOnGround()){
            player.addVelocity(0, 10, 0);
            player.velocityDirty = true;

        }
        else if(player.isFallFlying()){
            player.setVelocity(0,-2,0);
        }
        else{
//            player.setVelocity(0,0,0);
            player.jump();

        }
        player.networkHandler.sendPacket(new EntityVelocityUpdateS2CPacket(player));
        ServerWorld sw = player.getServerWorld();
        sw.spawnParticles(
                ParticleTypes.SONIC_BOOM,                 // white-ish puff
                player.getX(), player.getBodyY(0.5), player.getZ(),
                30,                                 // count
                0.25, 0.25, 0.25,                   // spread (x,y,z)
                0.08                                // speed
        );

        // If you want a sharper "burst", also add:
        sw.spawnParticles(
                ParticleTypes.SONIC_BOOM,
                player.getX(), player.getBodyY(0.5), player.getZ(),
                12,
                0.15, 0.15, 0.15,
                0.12
        );
    }
}