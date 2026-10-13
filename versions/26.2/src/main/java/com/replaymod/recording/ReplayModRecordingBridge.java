package com.replaymod.recording;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ReplayModRecordingBridge {
    private static final Logger LOGGER = LogManager.getLogger("ReplayModRecordingBridge");
    private static final AtomicBoolean COMMON_BOOTSTRAPPED = new AtomicBoolean(false);
    private static final AtomicBoolean CLIENT_BOOTSTRAPPED = new AtomicBoolean(false);

    public static final Path COMMON_RECORDING_DIR = Paths.get("config", "replaymod", "recording");
    public static final Path CLIENT_RECORDING_DIR = COMMON_RECORDING_DIR.resolve("client");

    private ReplayModRecordingBridge() {
    }

    public static Path getCommonRecordingDir() {
        return COMMON_RECORDING_DIR;
    }

    public static Path getClientRecordingDir() {
        return CLIENT_RECORDING_DIR;
    }

    public static void bootstrapCommon() {
        if (!COMMON_BOOTSTRAPPED.compareAndSet(false, true)) {
            LOGGER.debug("bootstrapCommon() already called, skipping.");
            return;
        }

        LOGGER.info("ReplayMod recording: common bootstrap start");

        try {
            prepareRecordingStorage();
        } catch (Exception e) {
            LOGGER.error("Failed to prepare recording storage", e);
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
            registerClientRecordingEventHooks();
        } catch (Exception e) {
            LOGGER.error("Failed to register client recording event hooks", e);
        }

        LOGGER.info("ReplayMod recording: client bootstrap finished");
    }

    private static void prepareRecordingStorage() throws IOException {
        Files.createDirectories(COMMON_RECORDING_DIR);
        Files.createDirectories(CLIENT_RECORDING_DIR);
        LOGGER.debug("Prepared recording directories: {} and {}", COMMON_RECORDING_DIR, CLIENT_RECORDING_DIR);
    }

    private static void loadRecordingConfig() throws IOException {
        Path config = COMMON_RECORDING_DIR.resolve("recording.properties");
        if (Files.notExists(config)) {
            Files.writeString(config, "enabled=true\nformat=mcpr\n");
        }
        LOGGER.debug("Recording common config ready at {}", config);
    }

    private static void registerRecordingTypes() {
        LOGGER.debug("registerRecordingTypes() placeholder for packet/session registrations");
    }

    private static void initRecordingServices() {
        LOGGER.debug("initRecordingServices() placeholder for capture manager and stream services");
    }

    private static void loadClientRecordingConfig() throws IOException {
        Path config = CLIENT_RECORDING_DIR.resolve("client-recording.properties");
        if (Files.notExists(config)) {
            Files.writeString(config, "client.enabled=true\nrecording.preview=false\n");
        }
        LOGGER.debug("Client recording config ready at {}", config);
    }

    private static void registerRecordingKeybinds() {
        LOGGER.debug("registerRecordingKeybinds() placeholder for recording controls");
    }

    private static void registerRecordingGui() {
        LOGGER.debug("registerRecordingGui() placeholder for recording UI registration");
    }

    private static void bindRecordingRenderHooks() {
        LOGGER.debug("bindRecordingRenderHooks() placeholder for overlay/preview rendering");
    }

    private static void registerClientRecordingEventHooks() {
        LOGGER.debug("registerClientRecordingEventHooks() placeholder for lifecycle hooks");
    }
}
