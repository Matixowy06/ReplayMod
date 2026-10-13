package com.replaymod.editor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.atomic.AtomicBoolean;

public final class ReplayModEditorBridge {
    private static final Logger LOGGER = LogManager.getLogger("ReplayModEditorBridge");
    private static final AtomicBoolean COMMON_BOOTSTRAPPED = new AtomicBoolean(false);
    private static final AtomicBoolean CLIENT_BOOTSTRAPPED = new AtomicBoolean(false);

    private ReplayModEditorBridge() {
    }

    public static void bootstrapCommon() {
        if (!COMMON_BOOTSTRAPPED.compareAndSet(false, true)) {
            LOGGER.debug("bootstrapCommon() already called, skipping.");
            return;
        }

        LOGGER.info("ReplayMod editor: common bootstrap start");

        try {
            initEditorContext();
        } catch (Exception e) {
            LOGGER.error("Failed to initialize editor context", e);
        }

        try {
            loadEditorConfig();
        } catch (Exception e) {
            LOGGER.error("Failed to load common editor config", e);
        }

        try {
            registerEditorTypes();
        } catch (Exception e) {
            LOGGER.error("Failed to register editor types", e);
        }

        try {
            initEditorServices();
        } catch (Exception e) {
            LOGGER.error("Failed to initialize editor services", e);
        }

        LOGGER.info("ReplayMod editor: common bootstrap finished");
    }

    public static void bootstrapClient() {
        if (!CLIENT_BOOTSTRAPPED.compareAndSet(false, true)) {
            LOGGER.debug("bootstrapClient() already called, skipping.");
            return;
        }

        bootstrapCommon();

        LOGGER.info("ReplayMod editor: client bootstrap start");

        try {
            loadClientEditorConfig();
        } catch (Exception e) {
            LOGGER.error("Failed to load client editor config", e);
        }

        try {
            registerEditorKeybinds();
            registerEditorGui();
            bindEditorRenderHooks();
        } catch (Exception e) {
            LOGGER.error("Failed to initialize client editor UI/render hooks", e);
        }

        try {
            registerClientEditorEventHooks();
        } catch (Exception e) {
            LOGGER.error("Failed to register client editor event hooks", e);
        }

        LOGGER.info("ReplayMod editor: client bootstrap finished");
    }

    private static void initEditorContext() {
        LOGGER.debug("initEditorContext() placeholder");
    }

    private static void loadEditorConfig() {
        LOGGER.debug("loadEditorConfig() placeholder");
    }

    private static void registerEditorTypes() {
        LOGGER.debug("registerEditorTypes() placeholder");
    }

    private static void initEditorServices() {
        LOGGER.debug("initEditorServices() placeholder");
    }

    private static void loadClientEditorConfig() {
        LOGGER.debug("loadClientEditorConfig() placeholder");
    }

    private static void registerEditorKeybinds() {
        LOGGER.debug("registerEditorKeybinds() placeholder");
    }

    private static void registerEditorGui() {
        LOGGER.debug("registerEditorGui() placeholder");
    }

    private static void bindEditorRenderHooks() {
        LOGGER.debug("bindEditorRenderHooks() placeholder");
    }

    private static void registerClientEditorEventHooks() {
        LOGGER.debug("registerClientEditorEventHooks() placeholder");
    }
}
