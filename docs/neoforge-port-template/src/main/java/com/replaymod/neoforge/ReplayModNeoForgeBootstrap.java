package com.replaymod.neoforge;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;

public final class ReplayModNeoForgeBootstrap {
    private ReplayModNeoForgeBootstrap() {
    }

    public static void bootstrap(IEventBus modEventBus, ModContainer modContainer) {
        // 1. deferred registration
        // 2. mod lifecycle subscriptions
        // 3. client/server startup hooks
        // 4. replay system registration
        // 5. render/network migration
        modEventBus.register(ReplayModNeoForgeNetwork.class);
        NeoForgeEntry.LOG.info("NeoForge bootstrap helper invoked for ReplayMod port scaffold");
    }
}
