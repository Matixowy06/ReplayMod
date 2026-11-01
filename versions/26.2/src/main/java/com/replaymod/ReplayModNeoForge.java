package com.replaymod;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod("replaymod")
public class ReplayModNeoForge {
    public ReplayModNeoForge(IEventBus modBus) {
        ReplayModNeoForgeHooks.register(modBus);
    }
}
