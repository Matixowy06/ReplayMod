package com.replaymod.neoforge;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.event.TickEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;

import static com.replaymod.neoforge.NeoForgeEntry.MOD_ID;

@EventBusSubscriber(modid = MOD_ID, bus = net.neoforged.bus.api.EventBus.MOD, value = Dist.CLIENT)
public final class ReplayModNeoForgeEvents {
    private ReplayModNeoForgeEvents() {
    }

    @SubscribeEvent
    public static void onCommonSetup(FMLCommonSetupEvent event) {
        // TODO: bridge ReplayMod setup logic from the old Fabric/Loom lifecycle into NeoForge.
        // This is where registration, networking setup, and replay startup code should be moved.
    }

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            // TODO: migrate ReplayMod client tick logic from the old platform-specific hook.
        }
    }

    @SubscribeEvent
    public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
        // TODO: move replay/session startup hooks here if they were tied to Fabric/Forge lifecycle.
    }
}
