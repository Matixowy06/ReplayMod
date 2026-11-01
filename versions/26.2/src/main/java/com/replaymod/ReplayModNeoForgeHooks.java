package com.replaymod;

import com.replaymod.bootstrap.ReplayModBootstrap;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

public final class ReplayModNeoForgeHooks {
    private ReplayModNeoForgeHooks() {
    }

    public static void register(IEventBus modBus) {
        modBus.addListener(ReplayModNeoForgeHooks::onCommonSetup);
        modBus.addListener(ReplayModNeoForgeHooks::onClientSetup);
    }

    private static void onCommonSetup(FMLCommonSetupEvent event) {
        ReplayModBootstrap.bootstrapCommon();
    }

    private static void onClientSetup(FMLClientSetupEvent event) {
        ReplayModBootstrap.bootstrapClient();
    }
}
