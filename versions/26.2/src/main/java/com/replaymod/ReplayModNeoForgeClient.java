package com.replaymod;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

import java.util.List;

@Mod.EventBusSubscriber(modid = ReplayModNeoForge.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class ReplayModNeoForgeClient {
    public static final List<String> BOOTSTRAP_ORDER = List.of(
            "core",
            "recording",
            "replay",
            "render",
            "simplepathing",
            "editor",
            "extras",
            "compat"
    );

    private ReplayModNeoForgeClient() {
    }

    @SubscribeEvent
    public static void onCommonSetup(FMLCommonSetupEvent event) {
        ReplayModCoreBridge.bootstrapCommon();
        bootstrapModules("common");
    }

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        ReplayModCoreBridge.bootstrapClient();
        bootstrapModules("client");
    }

    private static void bootstrapModules(String phase) {
        for (String moduleId : BOOTSTRAP_ORDER) {
            switch (phase) {
                case "common" -> handleCommonBootstrap(moduleId);
                case "client" -> handleClientBootstrap(moduleId);
                default -> {
                    // no-op
                }
            }
        }
    }

    private static void handleCommonBootstrap(String moduleId) {
        switch (moduleId) {
            case "core" -> ReplayModCoreBridge.bootstrapCommon();
            case "recording" -> ReplayModRecordingBridge.bootstrapCommon();
            case "replay" -> ReplayModReplayBridge.bootstrapCommon();
            case "render" -> {
                // TODO: port ReplayModRender setup after replay initialization is available.
            }
            default -> {
                // non-core phases handled client-side
            }
        }
    }

    private static void handleClientBootstrap(String moduleId) {
        switch (moduleId) {
            case "core" -> ReplayModCoreBridge.bootstrapClient();
            case "recording" -> ReplayModRecordingBridge.bootstrapClient();
            case "replay" -> ReplayModReplayBridge.bootstrapClient();
            case "simplepathing" -> {
                // TODO: port ReplayModSimplePathing client setup and keybindings.
            }
            case "editor" -> {
                // TODO: port ReplayModEditor GUI and editor handlers.
            }
            case "extras" -> {
                // TODO: port ReplayModExtras overlays and settings.
            }
            case "compat" -> {
                // TODO: port ReplayModCompat compatibility layer.
            }
            default -> {
                // core/common modules handled above
            }
        }
    }
}
