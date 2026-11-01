package com.replaymod.simplepathing;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ReplayModSimplePathingBridge {
    private static final Logger LOGGER = LogManager.getLogger("ReplayModSimplePathingBridge");
    private static final AtomicBoolean COMMON_BOOTSTRAPPED = new AtomicBoolean(false);
    private static final AtomicBoolean CLIENT_BOOTSTRAPPED = new AtomicBoolean(false);

    public static final Path COMMON_SIMPLE_PATHING_DIR = Paths.get("config", "replaymod", "simplepathing");
    public static final Path CLIENT_SIMPLE_PATHING_DIR = COMMON_SIMPLE_PATHING_DIR.resolve("client");

    private ReplayModSimplePathingBridge() {
    }

    public static Path getCommonSimplePathingDir() {
        return COMMON_SIMPLE_PATHING_DIR;
    }

    public static Path getClientSimplePathingDir() {
        return CLIENT_SIMPLE_PATHING_DIR;
    }

    public static void bootstrapCommon() {
        if (!COMMON_BOOTSTRAPPED.compareAndSet(false, true)) {
            LOGGER.debug("bootstrapCommon() already called, skipping.");
            return;
        }

        LOGGER.info("ReplayMod simplepathing: common bootstrap start");

        try {
            prepareSimplePathingStorage();
        } catch (Exception e) {
            LOGGER.error("Failed to prepare simplepathing storage", e);
        }

        try {
            loadSimplePathingConfig();
        } catch (Exception e) {
            LOGGER.error("Failed to load simplepathing common config", e);
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

    private static void prepareSimplePathingStorage() throws IOException {
        Files.createDirectories(COMMON_SIMPLE_PATHING_DIR);
        Files.createDirectories(CLIENT_SIMPLE_PATHING_DIR);
        LOGGER.debug("Prepared simplepathing directories: {} and {}", COMMON_SIMPLE_PATHING_DIR, CLIENT_SIMPLE_PATHING_DIR);
    }

    private static void loadSimplePathingConfig() throws IOException {
        Path config = COMMON_SIMPLE_PATHING_DIR.resolve("simplepathing.properties");
        if (Files.notExists(config)) {
            Files.writeString(config, "enabled=true\nprecision=high\n");
        }
        LOGGER.debug("SimplePathing common config ready at {}", config);
    }

    private static void registerSimplePathingTypes() {
        LOGGER.debug("registerSimplePathingTypes() placeholder for path type registrations");
    }

    private static void initSimplePathingServices() {
        LOGGER.debug("initSimplePathingServices() placeholder for path generation and interpolation services");
    }

    private static void loadClientSimplePathingConfig() throws IOException {
        Path config = CLIENT_SIMPLE_PATHING_DIR.resolve("client-simplepathing.properties");
        if (Files.notExists(config)) {
            Files.writeString(config, "client.enabled=true\npreview.enabled=true\n");
        }
        LOGGER.debug("Client simplepathing config ready at {}", config);
    }

    private static void registerSimplePathingKeybinds() {
        LOGGER.debug("registerSimplePathingKeybinds() placeholder for path controls");
    }

    private static void registerSimplePathingGui() {
        LOGGER.debug("registerSimplePathingGui() placeholder for path settings UI");
    }

    private static void bindSimplePathingRenderHooks() {
        LOGGER.debug("bindSimplePathingRenderHooks() placeholder for route preview rendering");
    }

    private static void registerClientSimplePathingEventHooks() {
        LOGGER.debug("registerClientSimplePathingEventHooks() placeholder for path lifecycle hooks");
    }
}
