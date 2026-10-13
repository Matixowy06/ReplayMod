package com.replaymod.neoforge;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.network.NetworkRegistry;
import net.neoforged.neoforge.network.simple.SimpleChannel;

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
        // TODO: migrate ReplayMod packet registration from the old platform-specific implementation.
        // Planned migration:
        // 1. define replay packets
        // 2. register encoders/decoders
        // 3. bind client/server message handling
        // 4. validate replay sync and recording state
        registerPackets();
    }

    public static void registerPackets() {
        // TODO: replace with actual ReplayMod packet registration.
    }

    public static void encodePacket(FriendlyByteBuf buf, Object payload) {
        // TODO: replace with packet serialization for replay events.
    }
}
