package name.crimson.util;

import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;

public record BoostPayload() implements CustomPayload {
    public static final Id<BoostPayload> ID = new Id<>(Identifier.of("crimson", "boost"));

    // Empty payload codec
    public static final PacketCodec<RegistryByteBuf, BoostPayload> CODEC =
            PacketCodec.unit(new BoostPayload());

    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}