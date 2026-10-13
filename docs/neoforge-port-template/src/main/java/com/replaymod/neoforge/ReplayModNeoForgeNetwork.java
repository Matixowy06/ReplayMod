package com.replaymod.neoforge;

import io.netty.buffer.Unpooled;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.network.NetworkDirection;
import net.neoforged.neoforge.network.NetworkRegistry;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.simple.SimpleChannel;

import static com.replaymod.neoforge.NeoForgeEntry.MOD_ID;

public final class ReplayModNeoForgeNetwork {
    private static final String PROTOCOL_VERSION = "1";
    private static final ResourceLocation CHANNEL_ID = ResourceLocation.fromNamespaceAndPath("replaymod", "main");
    public static final SimpleChannel CHANNEL = NetworkRegistry.newSimpleChannel(
        CHANNEL_ID,
        () -> PROTOCOL_VERSION,
        PROTOCOL_VERSION::equals,
        PROTOCOL_VERSION::equals
    );

    private static int packetId = 0;

    private ReplayModNeoForgeNetwork() {
    }

    @SubscribeEvent
    public static void onCommonSetup(FMLCommonSetupEvent event) {
        registerPackets();
        NeoForgeEntry.LOG.info("NeoForge network scaffold initialized for ReplayMod port");
    }

    public static void registerPackets() {
        CHANNEL.messageBuilder(ReplayModNeoForgePacket.class, packetId++, NetworkDirection.PLAY_TO_CLIENT)
            .decoder(ReplayModNeoForgePacket::decode)
            .encoder(ReplayModNeoForgePacket::encode)
            .consumerMainThread(ReplayModNeoForgePacket::handle)
            .add();

        CHANNEL.messageBuilder(ReplayModNeoForgePacket.class, packetId++, NetworkDirection.PLAY_TO_SERVER)
            .decoder(ReplayModNeoForgePacket::decode)
            .encoder(ReplayModNeoForgePacket::encode)
            .consumerMainThread(ReplayModNeoForgePacket::handle)
            .add();
    }

    public static void sendToServer(ReplayModNeoForgePacket payload) {
        PacketDistributor.sendToServer(payload);
    }

    public static void encodePayload(FriendlyByteBuf buffer, ReplayModNeoForgePacket payload) {
        payload.encode(buffer);
    }

    public static ReplayModNeoForgePacket decodePayload(FriendlyByteBuf buffer) {
        return ReplayModNeoForgePacket.decode(buffer);
    }

    public static FriendlyByteBuf newBuffer() {
        return new FriendlyByteBuf(Unpooled.buffer());
    }
}
