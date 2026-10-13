package com.replaymod;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = ReplayModNeoForge.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class ReplayModNeoForgeClient {
    private ReplayModNeoForgeClient() {
    }

    @SubscribeEvent
    public static void onCommonSetup(FMLCommonSetupEvent event) {
        // TODO: port common setup logic from Fabric entrypoints and core registration.
    }

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        // TODO: port the client bootstrap, GUI registration and ReplayMod module initializers.
    }
}
