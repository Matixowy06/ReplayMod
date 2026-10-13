package com.replaymod.neoforge;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod.EventBusSubscriber
public final class ReplayModNeoForgeEventRegistrar {
    private ReplayModNeoForgeEventRegistrar() {
    }

    public static void register(IEventBus modEventBus) {
        // TODO: explicit registration point for ReplayMod-specific event handlers.
        // This is a migration aid while moving from the Fabric/Loom model to NeoForge event registration.
    }
}
