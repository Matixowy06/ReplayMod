package com.replaymod.neoforge;

import net.minecraft.network.FriendlyByteBuf;
import net.neoforged.neoforge.network.NetworkEvent;

public class ReplayModNeoForgePacket {
    public enum Type {
        SESSION_START,
        SESSION_STOP,
        RECORDING_STATE,
        REPLAY_STATE,
        CLIENT_SYNC,
        SERVER_SYNC
    }

    private final Type type;
    private final String payload;

    public ReplayModNeoForgePacket(Type type, String payload) {
        this.type = type;
        this.payload = payload;
    }

    public Type getType() {
        return type;
    }

    public String getPayload() {
        return payload;
    }

    public static ReplayModNeoForgePacket decode(FriendlyByteBuf buffer) {
        Type type = Type.values()[buffer.readVarInt()];
        return new ReplayModNeoForgePacket(type, buffer.readUtf(Short.MAX_VALUE));
    }

    public static void encode(ReplayModNeoForgePacket packet, FriendlyByteBuf buffer) {
        buffer.writeVarInt(packet.type.ordinal());
        buffer.writeUtf(packet.payload, Short.MAX_VALUE);
    }

    public boolean handle(NetworkEvent.Context context) {
        context.enqueueWork(() -> {
            ReplayModNeoForgePacketHandler.handle(context, this);
        });
        return true;
    }
}
