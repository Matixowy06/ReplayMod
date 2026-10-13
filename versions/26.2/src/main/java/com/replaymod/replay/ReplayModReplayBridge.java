package com.replaymod.replay;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.atomic.AtomicBoolean;

public final class ReplayModReplayBridge {
    private static final Logger LOGGER = LogManager.getLogger("ReplayModReplayBridge");
    private static final AtomicBoolean COMMON_BOOTSTRAPPED = new AtomicBoolean(false);
    private static final AtomicBoolean CLIENT_BOOTSTRAPPED = new AtomicBoolean(false);

    private ReplayModReplayBridge() {
    }

    public static void bootstrapCommon() {
        if (!COMMON_BOOTSTRAPPED.compareAndSet(false, true)) {
            LOGGER.debug("bootstrapCommon() already called, skipping.");
            return;
        }

        LOGGER.info("ReplayMod replay: common bootstrap start");

        try {
            initReplayContext();
        } catch (Exception e) {
            LOGGER.error("Failed to initialize replay context", e);
        }

        try {
            loadReplayConfig();
        } catch (Exception e) {
            LOGGER.error("Failed to load common replay config", e);
        }

        try {
            registerReplayTypes();
        } catch (Exception e) {
            LOGGER.error("Failed to register replay types", e);
        }

        try {
            initReplayServices();
        } catch (Exception e) {
            LOGGER.error("Failed to initialize replay services", e);
        }

        LOGGER.info("ReplayMod replay: common bootstrap finished");
    }

    public static void bootstrapClient() {
        if (!CLIENT_BOOTSTRAPPED.compareAndSet(false, true)) {
            LOGGER.debug("bootstrapClient() already called, skipping.");
            return;
        }

        bootstrapCommon();

        LOGGER.info("ReplayMod replay: client bootstrap start");

        try {
            loadClientReplayConfig();
        } catch (Exception e) {
            LOGGER.error("Failed to load client replay config", e);
        }

        try {
            registerReplayKeybinds();
            registerReplayGui();
            bindReplayRenderHooks();
        } catch (Exception e) {
            LOGGER.error("Failed to initialize client replay UI/render hooks", e);
        }

        try {
            registerClientReplayEventHooks();
        } catch (Exception e) {
            LOGGER.error("Failed to register client replay event hooks", e);
        }

        LOGGER.info("ReplayMod replay: client bootstrap finished");
    }

    private static void initReplayContext() {
        LOGGER.debug("initReplayContext() placeholder");
    }

    private static void loadReplayConfig() {
        LOGGER.debug("loadReplayConfig() placeholder");
    }

    private static void registerReplayTypes() {
        LOGGER.debug("registerReplayTypes() placeholder");
    }

    private static void initReplayServices() {
        LOGGER.debug("initReplayServices() placeholder");
    }

    private static void loadClientReplayConfig() {
        LOGGER.debug("loadClientReplayConfig() placeholder");
    }

    private static void registerReplayKeybinds() {
        LOGGER.debug("registerReplayKeybinds() placeholder");
    }

    private static void registerReplayGui() {
        LOGGER.debug("registerReplayGui() placeholder");
    }

    private static void bindReplayRenderHooks() {
        LOGGER.debug("bindReplayRenderHooks() placeholder");
    }

    private static void registerClientReplayEventHooks() {
        LOGGER.debug("registerClientReplayEventHooks() placeholder");
    }
}
