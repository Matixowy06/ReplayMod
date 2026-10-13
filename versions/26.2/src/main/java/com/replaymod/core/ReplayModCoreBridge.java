package com.replaymod.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.atomic.AtomicBoolean;

public final class ReplayModCoreBridge {
    private static final Logger LOGGER = LogManager.getLogger("ReplayModCoreBridge");
    private static final AtomicBoolean COMMON_BOOTSTRAPPED = new AtomicBoolean(false);
    private static final AtomicBoolean CLIENT_BOOTSTRAPPED = new AtomicBoolean(false);

    private ReplayModCoreBridge() {
    }

    public static void bootstrapCommon() {
        if (!COMMON_BOOTSTRAPPED.compareAndSet(false, true)) {
            LOGGER.debug("bootstrapCommon() already called, skipping.");
            return;
        }

        LOGGER.info("ReplayMod: common bootstrap start");

        try {
            setupDataDirectories();
        } catch (Exception e) {
            LOGGER.error("Failed to prepare data directories", e);
        }

        try {
            loadCommonConfig();
        } catch (Exception e) {
            LOGGER.error("Failed to load common config", e);
        }

        try {
            initNetworking();
        } catch (Exception e) {
            LOGGER.error("Failed to initialize networking", e);
        }

        try {
            registerCapabilitiesAndSerializers();
        } catch (Exception e) {
            LOGGER.error("Failed to register capabilities/serializers", e);
        }

        try {
            initBackgroundServices();
        } catch (Exception e) {
            LOGGER.error("Failed to start background services", e);
        }

        LOGGER.info("ReplayMod: common bootstrap finished");
    }

    public static void bootstrapClient() {
        if (!CLIENT_BOOTSTRAPPED.compareAndSet(false, true)) {
            LOGGER.debug("bootstrapClient() already called, skipping.");
            return;
        }

        bootstrapCommon();

        LOGGER.info("ReplayMod: client bootstrap start");

        try {
            loadClientConfig();
        } catch (Exception e) {
            LOGGER.error("Failed to load client config", e);
        }

        try {
            registerKeybindings();
            registerGuiHandlers();
            initRenderHooks();
        } catch (Exception e) {
            LOGGER.error("Failed to initialize client UI/rendering", e);
        }

        try {
            registerClientEventListeners();
        } catch (Exception e) {
            LOGGER.error("Failed to register client event listeners", e);
        }

        LOGGER.info("ReplayMod: client bootstrap finished");
    }

    private static void setupDataDirectories() {
        LOGGER.debug("setupDataDirectories() placeholder");
    }

    private static void loadCommonConfig() {
        LOGGER.debug("loadCommonConfig() placeholder");
    }

    private static void initNetworking() {
        LOGGER.debug("initNetworking() placeholder");
    }

    private static void registerCapabilitiesAndSerializers() {
        LOGGER.debug("registerCapabilitiesAndSerializers() placeholder");
    }

    private static void initBackgroundServices() {
        LOGGER.debug("initBackgroundServices() placeholder");
    }

    private static void loadClientConfig() {
        LOGGER.debug("loadClientConfig() placeholder");
    }

    private static void registerKeybindings() {
        LOGGER.debug("registerKeybindings() placeholder");
    }

    private static void registerGuiHandlers() {
        LOGGER.debug("registerGuiHandlers() placeholder");
    }

    private static void initRenderHooks() {
        LOGGER.debug("initRenderHooks() placeholder");
    }

    private static void registerClientEventListeners() {
        LOGGER.debug("registerClientEventListeners() placeholder");
    }
}
