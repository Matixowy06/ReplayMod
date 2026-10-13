package com.replaymod.render;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.atomic.AtomicBoolean;

public final class ReplayModRenderBridge {
    private static final Logger LOGGER = LogManager.getLogger("ReplayModRenderBridge");
    private static final AtomicBoolean COMMON_BOOTSTRAPPED = new AtomicBoolean(false);
    private static final AtomicBoolean CLIENT_BOOTSTRAPPED = new AtomicBoolean(false);

    private ReplayModRenderBridge() {
    }

    public static void bootstrapCommon() {
        if (!COMMON_BOOTSTRAPPED.compareAndSet(false, true)) {
            LOGGER.debug("bootstrapCommon() already called, skipping.");
            return;
        }

        LOGGER.info("ReplayMod render: common bootstrap start");

        try {
            initRenderContext();
        } catch (Exception e) {
            LOGGER.error("Failed to initialize render context", e);
        }

        try {
            loadRenderConfig();
        } catch (Exception e) {
            LOGGER.error("Failed to load common render config", e);
        }

        try {
            registerRenderTypes();
        } catch (Exception e) {
            LOGGER.error("Failed to register render types", e);
        }

        try {
            initRenderServices();
        } catch (Exception e) {
            LOGGER.error("Failed to initialize render services", e);
        }

        LOGGER.info("ReplayMod render: common bootstrap finished");
    }

    public static void bootstrapClient() {
        if (!CLIENT_BOOTSTRAPPED.compareAndSet(false, true)) {
            LOGGER.debug("bootstrapClient() already called, skipping.");
            return;
        }

        bootstrapCommon();

        LOGGER.info("ReplayMod render: client bootstrap start");

        try {
            loadClientRenderConfig();
        } catch (Exception e) {
            LOGGER.error("Failed to load client render config", e);
        }

        try {
            registerRenderKeybinds();
            registerRenderGui();
            bindRenderHooks();
        } catch (Exception e) {
            LOGGER.error("Failed to initialize client render UI/render hooks", e);
        }

        try {
            registerClientRenderEventHooks();
        } catch (Exception e) {
            LOGGER.error("Failed to register client render event hooks", e);
        }

        LOGGER.info("ReplayMod render: client bootstrap finished");
    }

    private static void initRenderContext() {
        LOGGER.debug("initRenderContext() placeholder");
    }

    private static void loadRenderConfig() {
        LOGGER.debug("loadRenderConfig() placeholder");
    }

    private static void registerRenderTypes() {
        LOGGER.debug("registerRenderTypes() placeholder");
    }

    private static void initRenderServices() {
        LOGGER.debug("initRenderServices() placeholder");
    }

    private static void loadClientRenderConfig() {
        LOGGER.debug("loadClientRenderConfig() placeholder");
    }

    private static void registerRenderKeybinds() {
        LOGGER.debug("registerRenderKeybinds() placeholder");
    }

    private static void registerRenderGui() {
        LOGGER.debug("registerRenderGui() placeholder");
    }

    private static void bindRenderHooks() {
        LOGGER.debug("bindRenderHooks() placeholder");
    }

    private static void registerClientRenderEventHooks() {
        LOGGER.debug("registerClientRenderEventHooks() placeholder");
    }
}
