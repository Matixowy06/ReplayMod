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
        bootstrapModules("common");
    }

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
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
            case "core" -> {
                // TODO: port ReplayMod core bootstrap and shared registries.
            }
            case "recording" -> {
                // TODO: port ReplayModRecording startup and common networking hooks.
            }
            case "replay" -> {
                // TODO: port ReplayModReplay startup and replay lifecycle events.
            }
            case "render" -> {
                // TODO: port ReplayModRender init and render pipeline setup.
            }
            default -> {
                // non-core phases are handled in client bootstrap
            }
        }
    }

    private static void handleClientBootstrap(String moduleId) {
        switch (moduleId) {
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
                // core/common modules already handled above
            }
        }
    }
}
