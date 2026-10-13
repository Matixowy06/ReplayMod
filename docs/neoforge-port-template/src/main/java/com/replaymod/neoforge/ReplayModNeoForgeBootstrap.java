package com.replaymod.neoforge;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;

public final class ReplayModNeoForgeBootstrap {
    private ReplayModNeoForgeBootstrap() {}

    public static void bootstrap(IEventBus modEventBus, ModContainer modContainer) {
        // TODO: migrate ReplayMod bootstrap sequence from Fabric/Loom logic to NeoForge lifecycle.
        // Planned migration order:
        // 1. register deferred registries
        // 2. subscribe mod lifecycle events
        // 3. hook client/server entrypoints
        // 4. wire replay systems into NeoForge events
        // 5. validate rendering and networking
    }
}
