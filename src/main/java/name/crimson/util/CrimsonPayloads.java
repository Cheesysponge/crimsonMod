package name.crimson.util;

import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;

public final class CrimsonPayloads {
    private static boolean registered = false;

    private CrimsonPayloads() {}

    public static void registerCommon() {
        if (registered) return;
        registered = true;

        // C2S payload type (client->server)
        PayloadTypeRegistry.playC2S().register(BoostPayload.ID, BoostPayload.CODEC);
    }
}
