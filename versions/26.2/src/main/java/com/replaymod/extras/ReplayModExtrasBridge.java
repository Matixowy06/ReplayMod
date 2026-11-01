package com.replaymod.extras;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ReplayModExtrasBridge {
    private static final Logger LOGGER = LogManager.getLogger("ReplayModExtrasBridge");
    private static final AtomicBoolean COMMON_BOOTSTRAPPED = new AtomicBoolean(false);
    private static final AtomicBoolean CLIENT_BOOTSTRAPPED = new AtomicBoolean(false);

    public static final Path COMMON_EXTRAS_DIR = Paths.get("config", "replaymod", "extras");
    public static final Path CLIENT_EXTRAS_DIR = COMMON_EXTRAS_DIR.resolve("client");

    private ReplayModExtrasBridge() {
    }

    public static Path getCommonExtrasDir() {
        return COMMON_EXTRAS_DIR;
    }

    public static Path getClientExtrasDir() {
        return CLIENT_EXTRAS_DIR;
    }

    public static void bootstrapCommon() {
        if (!COMMON_BOOTSTRAPPED.compareAndSet(false, true)) {
            LOGGER.debug("bootstrapCommon() already called, skipping.");
            return;
        }

        LOGGER.info("ReplayMod extras: common bootstrap start");

        try {
            prepareExtrasStorage();
        } catch (Exception e) {
            LOGGER.error("Failed to prepare extras storage", e);
        }

        try {
            loadExtrasConfig();
        } catch (Exception e) {
            LOGGER.error("Failed to load extras common config", e);
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

    private static void prepareExtrasStorage() throws IOException {
        Files.createDirectories(COMMON_EXTRAS_DIR);
        Files.createDirectories(CLIENT_EXTRAS_DIR);
        LOGGER.debug("Prepared extras directories: {} and {}", COMMON_EXTRAS_DIR, CLIENT_EXTRAS_DIR);
    }

    private static void loadExtrasConfig() throws IOException {
        Path config = COMMON_EXTRAS_DIR.resolve("extras.properties");
        if (Files.notExists(config)) {
            Files.writeString(config, "enabled=true\nfeatures=basic\n");
        }
        LOGGER.debug("Extras common config ready at {}", config);
    }

    private static void registerExtrasTypes() {
        LOGGER.debug("registerExtrasTypes() placeholder for optional feature registrations");
    }

    private static void initExtrasServices() {
        LOGGER.debug("initExtrasServices() placeholder for optional feature services");
    }

    private static void loadClientExtrasConfig() throws IOException {
        Path config = CLIENT_EXTRAS_DIR.resolve("client-extras.properties");
        if (Files.notExists(config)) {
            Files.writeString(config, "client.enabled=true\nfeature.preview=false\n");
        }
        LOGGER.debug("Client extras config ready at {}", config);
    }

    private static void registerExtrasKeybinds() {
        LOGGER.debug("registerExtrasKeybinds() placeholder for optional keybinds");
    }

    private static void registerExtrasGui() {
        LOGGER.debug("registerExtrasGui() placeholder for optional settings UI");
    }

    private static void bindExtrasRenderHooks() {
        LOGGER.debug("bindExtrasRenderHooks() placeholder for optional preview hooks");
    }

    private static void registerClientExtrasEventHooks() {
        LOGGER.debug("registerClientExtrasEventHooks() placeholder for optional lifecycle hooks");
    }
}
