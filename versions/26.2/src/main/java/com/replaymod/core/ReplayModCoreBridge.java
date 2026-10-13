package com.replaymod.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ReplayModCoreBridge {
    private static final Logger LOGGER = LogManager.getLogger("ReplayModCoreBridge");
    private static final AtomicBoolean COMMON_BOOTSTRAPPED = new AtomicBoolean(false);
    private static final AtomicBoolean CLIENT_BOOTSTRAPPED = new AtomicBoolean(false);

    public static final Path COMMON_DATA_DIR = Paths.get("config", "replaymod");
    public static final Path CLIENT_DATA_DIR = COMMON_DATA_DIR.resolve("client");

    private ReplayModCoreBridge() {
    }

    public static Path getCommonDataDir() {
        return COMMON_DATA_DIR;
    }

    public static Path getClientDataDir() {
        return CLIENT_DATA_DIR;
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

    private static void setupDataDirectories() throws IOException {
        Files.createDirectories(COMMON_DATA_DIR);
        Files.createDirectories(CLIENT_DATA_DIR);
        LOGGER.debug("Prepared ReplayMod data directories: {} and {}", COMMON_DATA_DIR, CLIENT_DATA_DIR);
    }

    private static void loadCommonConfig() throws IOException {
        Path configFile = COMMON_DATA_DIR.resolve("common.properties");
        if (Files.notExists(configFile)) {
            Files.writeString(configFile, "mod=ReplayMod\nversion=1\n");
        }
        LOGGER.debug("Common configuration ready at {}", configFile);
    }

    private static void initNetworking() {
        LOGGER.debug("initNetworking() initialized (network layer stub)");
    }

    private static void registerCapabilitiesAndSerializers() {
        LOGGER.debug("registerCapabilitiesAndSerializers() placeholder for common registry");
    }

    private static void initBackgroundServices() {
        LOGGER.debug("initBackgroundServices() placeholder for background task scheduler");
    }

    private static void loadClientConfig() throws IOException {
        Path configFile = CLIENT_DATA_DIR.resolve("client.properties");
        if (Files.notExists(configFile)) {
            Files.writeString(configFile, "client.enabled=true\n");
        }
        LOGGER.debug("Client configuration ready at {}", configFile);
    }

    private static void registerKeybindings() {
        LOGGER.debug("registerKeybindings() placeholder for client keybind registration");
    }

    private static void registerGuiHandlers() {
        LOGGER.debug("registerGuiHandlers() placeholder for UI integration");
    }

    private static void initRenderHooks() {
        LOGGER.debug("initRenderHooks() placeholder for render pipeline integration");
    }

    private static void registerClientEventListeners() {
        LOGGER.debug("registerClientEventListeners() placeholder for client event bus registration");
    }
}
