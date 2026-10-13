package com.replaymod.neoforge;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.network.NetworkRegistry;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.simple.SimpleChannel;

import static com.replaymod.neoforge.NeoForgeEntry.MOD_ID;

@EventBusSubscriber(modid = MOD_ID, bus = net.neoforged.bus.api.EventBus.MOD)
public final class ReplayModNeoForgeNetwork {
    private static final String PROTOCOL_VERSION = "1";

    public static final SimpleChannel CHANNEL = NetworkRegistry.newSimpleChannel(
        ResourceLocation.fromNamespaceAndPath("replaymod", "main"),
        () -> PROTOCOL_VERSION,
        PROTOCOL_VERSION::equals,
        PROTOCOL_VERSION::equals
    );

    private ReplayModNeoForgeNetwork() {
    }

    @SubscribeEvent
    public static void onCommonSetup(FMLCommonSetupEvent event) {
        // TODO: migrate ReplayMod packet registration from the legacy Fabric/Loom networking stack.
        // Planned migration:
        // 1. define replay packets
        // 2. register encoders/decoders
        // 3. bind client/server message handling
        // 4. validate replay sync and recording state
        NeoForgeEntry.LOG.info("NeoForge network scaffold initialized for ReplayMod port");
    }

    public static void sendToServer(Object payload) {
        // TODO: replace with actual ReplayMod packet dispatch.
        PacketDistributor.sendToServer(payload);
    }

    public static void encodePayload(FriendlyByteBuf buffer, Object payload) {
        // TODO: move ReplayMod packet serialization here.
    }
}
