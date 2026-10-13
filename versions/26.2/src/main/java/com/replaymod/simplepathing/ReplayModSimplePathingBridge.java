package com.replaymod.simplepathing;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.atomic.AtomicBoolean;

public final class ReplayModSimplePathingBridge {
    private static final Logger LOGGER = LogManager.getLogger("ReplayModSimplePathingBridge");
    private static final AtomicBoolean COMMON_BOOTSTRAPPED = new AtomicBoolean(false);
    private static final AtomicBoolean CLIENT_BOOTSTRAPPED = new AtomicBoolean(false);

    private ReplayModSimplePathingBridge() {
    }

    public static void bootstrapCommon() {
        if (!COMMON_BOOTSTRAPPED.compareAndSet(false, true)) {
            LOGGER.debug("bootstrapCommon() already called, skipping.");
            return;
        }

        LOGGER.info("ReplayMod simplepathing: common bootstrap start");

        try {
            initSimplePathingContext();
        } catch (Exception e) {
            LOGGER.error("Failed to initialize simplepathing context", e);
        }

        try {
            loadSimplePathingConfig();
        } catch (Exception e) {
            LOGGER.error("Failed to load common simplepathing config", e);
        }

        try {
            registerSimplePathingTypes();
        } catch (Exception e) {
            LOGGER.error("Failed to register simplepathing types", e);
        }

        try {
            initSimplePathingServices();
        } catch (Exception e) {
            LOGGER.error("Failed to initialize simplepathing services", e);
        }

        LOGGER.info("ReplayMod simplepathing: common bootstrap finished");
    }

    public static void bootstrapClient() {
        if (!CLIENT_BOOTSTRAPPED.compareAndSet(false, true)) {
            LOGGER.debug("bootstrapClient() already called, skipping.");
            return;
        }

        bootstrapCommon();

        LOGGER.info("ReplayMod simplepathing: client bootstrap start");

        try {
            loadClientSimplePathingConfig();
        } catch (Exception e) {
            LOGGER.error("Failed to load client simplepathing config", e);
        }

        try {
            registerSimplePathingKeybinds();
            registerSimplePathingGui();
            bindSimplePathingRenderHooks();
        } catch (Exception e) {
            LOGGER.error("Failed to initialize client simplepathing UI/render hooks", e);
        }

        try {
            registerClientSimplePathingEventHooks();
        } catch (Exception e) {
            LOGGER.error("Failed to register client simplepathing event hooks", e);
        }

        LOGGER.info("ReplayMod simplepathing: client bootstrap finished");
    }

    private static void initSimplePathingContext() {
        LOGGER.debug("initSimplePathingContext() placeholder");
    }

    private static void loadSimplePathingConfig() {
        LOGGER.debug("loadSimplePathingConfig() placeholder");
    }

    private static void registerSimplePathingTypes() {
        LOGGER.debug("registerSimplePathingTypes() placeholder");
    }

    private static void initSimplePathingServices() {
        LOGGER.debug("initSimplePathingServices() placeholder");
    }

    private static void loadClientSimplePathingConfig() {
        LOGGER.debug("loadClientSimplePathingConfig() placeholder");
    }

    private static void registerSimplePathingKeybinds() {
        LOGGER.debug("registerSimplePathingKeybinds() placeholder");
    }

    private static void registerSimplePathingGui() {
        LOGGER.debug("registerSimplePathingGui() placeholder");
    }

    private static void bindSimplePathingRenderHooks() {
        LOGGER.debug("bindSimplePathingRenderHooks() placeholder");
    }

    private static void registerClientSimplePathingEventHooks() {
        LOGGER.debug("registerClientSimplePathingEventHooks() placeholder");
    }
}
