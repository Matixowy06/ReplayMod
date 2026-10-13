package com.replaymod.neoforge;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;

public final class ReplayModNeoForgeBootstrap {
    private ReplayModNeoForgeBootstrap() {
    }

    public static void bootstrap(IEventBus modEventBus, ModContainer modContainer) {
        // TODO: migrate ReplayMod startup sequence from the existing Fabric/Loom setup into NeoForge.
        // Planned order:
        // 1. deferred registration
        // 2. mod lifecycle subscriptions
        // 3. client/server startup hooks
        // 4. replay system registration
        // 5. render/network migration
        NeoForgeEntry.LOG.info("NeoForge bootstrap helper invoked for ReplayMod port scaffold");
    }
}
