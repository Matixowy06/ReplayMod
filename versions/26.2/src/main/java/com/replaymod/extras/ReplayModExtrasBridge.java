package com.replaymod.extras;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.atomic.AtomicBoolean;

public final class ReplayModExtrasBridge {
    private static final Logger LOGGER = LogManager.getLogger("ReplayModExtrasBridge");
    private static final AtomicBoolean COMMON_BOOTSTRAPPED = new AtomicBoolean(false);
    private static final AtomicBoolean CLIENT_BOOTSTRAPPED = new AtomicBoolean(false);

    private ReplayModExtrasBridge() {
    }

    public static void bootstrapCommon() {
        if (!COMMON_BOOTSTRAPPED.compareAndSet(false, true)) {
            LOGGER.debug("bootstrapCommon() already called, skipping.");
            return;
        }

        LOGGER.info("ReplayMod extras: common bootstrap start");

        try {
            initExtrasContext();
        } catch (Exception e) {
            LOGGER.error("Failed to initialize extras context", e);
        }

        try {
            loadExtrasConfig();
        } catch (Exception e) {
            LOGGER.error("Failed to load common extras config", e);
        }

        try {
            registerExtrasTypes();
        } catch (Exception e) {
            LOGGER.error("Failed to register extras types", e);
        }

        try {
            initExtrasServices();
        } catch (Exception e) {
            LOGGER.error("Failed to initialize extras services", e);
        }

        LOGGER.info("ReplayMod extras: common bootstrap finished");
    }

    public static void bootstrapClient() {
        if (!CLIENT_BOOTSTRAPPED.compareAndSet(false, true)) {
            LOGGER.debug("bootstrapClient() already called, skipping.");
            return;
        }

        bootstrapCommon();

        LOGGER.info("ReplayMod extras: client bootstrap start");

        try {
            loadClientExtrasConfig();
        } catch (Exception e) {
            LOGGER.error("Failed to load client extras config", e);
        }

        try {
            registerExtrasKeybinds();
            registerExtrasGui();
            bindExtrasRenderHooks();
        } catch (Exception e) {
            LOGGER.error("Failed to initialize client extras UI/render hooks", e);
        }

        try {
            registerClientExtrasEventHooks();
        } catch (Exception e) {
            LOGGER.error("Failed to register client extras event hooks", e);
        }

        LOGGER.info("ReplayMod extras: client bootstrap finished");
    }

    private static void initExtrasContext() {
        LOGGER.debug("initExtrasContext() placeholder");
    }

    private static void loadExtrasConfig() {
        LOGGER.debug("loadExtrasConfig() placeholder");
    }

    private static void registerExtrasTypes() {
        LOGGER.debug("registerExtrasTypes() placeholder");
    }

    private static void initExtrasServices() {
        LOGGER.debug("initExtrasServices() placeholder");
    }

    private static void loadClientExtrasConfig() {
        LOGGER.debug("loadClientExtrasConfig() placeholder");
    }

    private static void registerExtrasKeybinds() {
        LOGGER.debug("registerExtrasKeybinds() placeholder");
    }

    private static void registerExtrasGui() {
        LOGGER.debug("registerExtrasGui() placeholder");
    }

    private static void bindExtrasRenderHooks() {
        LOGGER.debug("bindExtrasRenderHooks() placeholder");
    }

    private static void registerClientExtrasEventHooks() {
        LOGGER.debug("registerClientExtrasEventHooks() placeholder");
    }
}
