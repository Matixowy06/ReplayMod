package com.replaymod;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod(ReplayModNeoForge.MOD_ID)
public final class ReplayModNeoForge {
    public static final String MOD_ID = "replaymod";

    public ReplayModNeoForge(IEventBus modEventBus) {
        modEventBus.addListener(ReplayModNeoForgeClient::onCommonSetup);
        modEventBus.addListener(ReplayModNeoForgeClient::onClientSetup);
    }
}
