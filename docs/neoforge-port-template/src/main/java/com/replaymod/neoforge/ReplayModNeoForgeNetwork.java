package com.replaymod.neoforge;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.network.NetworkDirection;
import net.neoforged.neoforge.network.NetworkRegistry;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.simple.SimpleChannel;

import static com.replaymod.neoforge.NeoForgeEntry.MOD_ID;

@EventBusSubscriber(modid = MOD_ID, bus = net.neoforged.bus.api.EventBus.MOD)
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
            .consumerMainThread((packet, context) -> {
                context.setPacketHandled(true);
                ReplayModNeoForgePacketHandler.handleClient(packet, context);
            })
            .add();

        CHANNEL.messageBuilder(ReplayModNeoForgePacket.class, packetId++, NetworkDirection.PLAY_TO_SERVER)
            .decoder(ReplayModNeoForgePacket::decode)
            .encoder(ReplayModNeoForgePacket::encode)
            .consumerMainThread((packet, context) -> {
                context.setPacketHandled(true);
                ReplayModNeoForgePacketHandler.handleServer(packet, context);
            })
            .add();
    }

    public static void sendToServer(ReplayModNeoForgePacket packet) {
        PacketDistributor.sendToServer(packet);
    }

    public static void sendToClient(Object player, ReplayModNeoForgePacket packet) {
        PacketDistributor.sendToPlayer((net.minecraft.server.level.ServerPlayer) player, packet);
    }

    public static FriendlyByteBuf newBuffer() {
        return new FriendlyByteBuf(io.netty.buffer.Unpooled.buffer());
    }
}
