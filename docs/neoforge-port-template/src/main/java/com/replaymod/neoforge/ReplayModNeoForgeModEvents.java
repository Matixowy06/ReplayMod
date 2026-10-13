package com.replaymod.neoforge;

import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

import static com.replaymod.neoforge.NeoForgeEntry.MOD_ID;

@EventBusSubscriber(modid = MOD_ID, bus = net.neoforged.bus.api.EventBus.MOD)
public final class ReplayModNeoForgeModEvents {
    private ReplayModNeoForgeModEvents() {
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void onCommonSetup(FMLCommonSetupEvent event) {
        // TODO: migrate ReplayMod setup logic from the old Fabric/Loom lifecycle here.
        // Planned migration tasks:
        // 1. replay registry setup
        // 2. packet/channel initialization
        // 3. startup/session preparation
        // 4. client + server bootstrap seams
        NeoForgeEntry.LOG.info("NeoForge common setup reached for ReplayMod port scaffold");
    }
}
