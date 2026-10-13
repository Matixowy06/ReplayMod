package com.replaymod.recording;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.atomic.AtomicBoolean;

public final class ReplayModRecordingBridge {
    private static final Logger LOGGER = LogManager.getLogger("ReplayModRecordingBridge");
    private static final AtomicBoolean COMMON_BOOTSTRAPPED = new AtomicBoolean(false);
    private static final AtomicBoolean CLIENT_BOOTSTRAPPED = new AtomicBoolean(false);

    private ReplayModRecordingBridge() {
    }

    public static void bootstrapCommon() {
        if (!COMMON_BOOTSTRAPPED.compareAndSet(false, true)) {
            LOGGER.debug("bootstrapCommon() already called, skipping.");
            return;
        }

        LOGGER.info("ReplayMod recording: common bootstrap start");

        try {
            initRecordingContext();
        } catch (Exception e) {
            LOGGER.error("Failed to initialize recording context", e);
        }

        try {
            loadRecordingConfig();
        } catch (Exception e) {
            LOGGER.error("Failed to load common recording config", e);
        }

        try {
            registerRecordingTypes();
        } catch (Exception e) {
            LOGGER.error("Failed to register recording types", e);
        }

        try {
            initRecordingServices();
        } catch (Exception e) {
            LOGGER.error("Failed to initialize recording services", e);
        }

        LOGGER.info("ReplayMod recording: common bootstrap finished");
    }

    public static void bootstrapClient() {
        if (!CLIENT_BOOTSTRAPPED.compareAndSet(false, true)) {
            LOGGER.debug("bootstrapClient() already called, skipping.");
            return;
        }

        bootstrapCommon();

        LOGGER.info("ReplayMod recording: client bootstrap start");

        try {
            loadClientRecordingConfig();
        } catch (Exception e) {
            LOGGER.error("Failed to load client recording config", e);
        }

        try {
            registerRecordingKeybinds();
            registerRecordingGui();
            bindRecordingRenderHooks();
        } catch (Exception e) {
            LOGGER.error("Failed to initialize client recording UI/render hooks", e);
        }

        try {
            registerClientEventHooks();
        } catch (Exception e) {
            LOGGER.error("Failed to register client recording event hooks", e);
        }

        LOGGER.info("ReplayMod recording: client bootstrap finished");
    }

    private static void initRecordingContext() {
        LOGGER.debug("initRecordingContext() placeholder");
    }

    private static void loadRecordingConfig() {
        LOGGER.debug("loadRecordingConfig() placeholder");
    }

    private static void registerRecordingTypes() {
        LOGGER.debug("registerRecordingTypes() placeholder");
    }

    private static void initRecordingServices() {
        LOGGER.debug("initRecordingServices() placeholder");
    }

    private static void loadClientRecordingConfig() {
        LOGGER.debug("loadClientRecordingConfig() placeholder");
    }

    private static void registerRecordingKeybinds() {
        LOGGER.debug("registerRecordingKeybinds() placeholder");
    }

    private static void registerRecordingGui() {
        LOGGER.debug("registerRecordingGui() placeholder");
    }

    private static void bindRecordingRenderHooks() {
        LOGGER.debug("bindRecordingRenderHooks() placeholder");
    }

    private static void registerClientEventHooks() {
        LOGGER.debug("registerClientEventHooks() placeholder");
    }
}
