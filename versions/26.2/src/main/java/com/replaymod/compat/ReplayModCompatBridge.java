package com.replaymod.compat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.atomic.AtomicBoolean;

public final class ReplayModCompatBridge {
    private static final Logger LOGGER = LogManager.getLogger("ReplayModCompatBridge");
    private static final AtomicBoolean COMMON_BOOTSTRAPPED = new AtomicBoolean(false);
    private static final AtomicBoolean CLIENT_BOOTSTRAPPED = new AtomicBoolean(false);

    private ReplayModCompatBridge() {
    }

    public static void bootstrapCommon() {
        if (!COMMON_BOOTSTRAPPED.compareAndSet(false, true)) {
            LOGGER.debug("bootstrapCommon() already called, skipping.");
            return;
        }

        LOGGER.info("ReplayMod compat: common bootstrap start");

        try {
            initCompatContext();
        } catch (Exception e) {
            LOGGER.error("Failed to initialize compat context", e);
        }

        try {
            loadCompatConfig();
        } catch (Exception e) {
            LOGGER.error("Failed to load common compat config", e);
        }

        try {
            registerCompatTypes();
        } catch (Exception e) {
            LOGGER.error("Failed to register compat types", e);
        }

        try {
            initCompatServices();
        } catch (Exception e) {
            LOGGER.error("Failed to initialize compat services", e);
        }

        LOGGER.info("ReplayMod compat: common bootstrap finished");
    }

    public static void bootstrapClient() {
        if (!CLIENT_BOOTSTRAPPED.compareAndSet(false, true)) {
            LOGGER.debug("bootstrapClient() already called, skipping.");
            return;
        }

        bootstrapCommon();

        LOGGER.info("ReplayMod compat: client bootstrap start");

        try {
            loadClientCompatConfig();
        } catch (Exception e) {
            LOGGER.error("Failed to load client compat config", e);
        }

        try {
            registerCompatKeybinds();
            registerCompatGui();
            bindCompatRenderHooks();
        } catch (Exception e) {
            LOGGER.error("Failed to initialize client compat UI/render hooks", e);
        }

        try {
            registerClientCompatEventHooks();
        } catch (Exception e) {
            LOGGER.error("Failed to register client compat event hooks", e);
        }

        LOGGER.info("ReplayMod compat: client bootstrap finished");
    }

    private static void initCompatContext() {
        LOGGER.debug("initCompatContext() placeholder");
    }

    private static void loadCompatConfig() {
        LOGGER.debug("loadCompatConfig() placeholder");
    }

    private static void registerCompatTypes() {
        LOGGER.debug("registerCompatTypes() placeholder");
    }

    private static void initCompatServices() {
        LOGGER.debug("initCompatServices() placeholder");
    }

    private static void loadClientCompatConfig() {
        LOGGER.debug("loadClientCompatConfig() placeholder");
    }

    private static void registerCompatKeybinds() {
        LOGGER.debug("registerCompatKeybinds() placeholder");
    }

    private static void registerCompatGui() {
        LOGGER.debug("registerCompatGui() placeholder");
    }

    private static void bindCompatRenderHooks() {
        LOGGER.debug("bindCompatRenderHooks() placeholder");
    }

    private static void registerClientCompatEventHooks() {
        LOGGER.debug("registerClientCompatEventHooks() placeholder");
    }
}
