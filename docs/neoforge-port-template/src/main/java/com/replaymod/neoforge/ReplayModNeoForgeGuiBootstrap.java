package com.replaymod.neoforge;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.event.TickEvent;

public final class ReplayModNeoForgeGuiBootstrap {
    private ReplayModNeoForgeGuiBootstrap() {
    }

    public static void bootstrapClient(ModContainer modContainer) {
        // TODO: register NeoForge client rendering bootstrap for ReplayMod GUI/HUD.
    }

    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            // TODO: route ReplayMod GUI refresh logic into NeoForge client tick lifecycle.
        }
    }

    public static void onFmlClientSetup(FMLClientSetupEvent event) {
        // TODO: initialize the NeoForge client GUI layer for ReplayMod.
    }
}
