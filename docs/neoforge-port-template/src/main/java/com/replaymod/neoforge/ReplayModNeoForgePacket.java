package com.replaymod.neoforge;

import net.minecraft.network.FriendlyByteBuf;
import net.neoforged.neoforge.network.NetworkEvent;

public class ReplayModNeoForgePacket {
    public static ReplayModNeoForgePacket decode(FriendlyByteBuf buffer) {
        // TODO: replace with concrete ReplayMod packet payload decoding.
        return new ReplayModNeoForgePacket();
    }

    public void encode(FriendlyByteBuf buffer) {
        // TODO: replace with concrete ReplayMod packet serialization.
    }

    public boolean handle(NetworkEvent.Context context) {
        // TODO: route ReplayMod packet handling to real server/client listeners.
        context.setPacketHandled(true);
        return true;
    }
}
