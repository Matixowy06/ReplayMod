package com.replaymod;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;

@Mod(ReplayModNeoForge.MOD_ID)
public final class ReplayModNeoForge {
    public static final String MOD_ID = "replaymod";

    public ReplayModNeoForge(IEventBus modEventBus) {
        modEventBus.addListener(this::onCommonSetup);
        NeoForge.EVENT_BUS.register(this);
    }

    private void onCommonSetup(final FMLCommonSetupEvent event) {
        // TODO: port Fabric entrypoints, hooks, registry logic and Mixin integrations here.
    }
}
