package com.replaymod.replay;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ReplayModReplayBridge {
    private static final Logger LOGGER = LogManager.getLogger("ReplayModReplayBridge");
    private static final AtomicBoolean COMMON_BOOTSTRAPPED = new AtomicBoolean(false);
    private static final AtomicBoolean CLIENT_BOOTSTRAPPED = new AtomicBoolean(false);

    public static final Path COMMON_REPLAY_DIR = Paths.get("config", "replaymod", "replay");
    public static final Path CLIENT_REPLAY_DIR = COMMON_REPLAY_DIR.resolve("client");

    private ReplayModReplayBridge() {
    }

    public static Path getCommonReplayDir() {
        return COMMON_REPLAY_DIR;
    }

    public static Path getClientReplayDir() {
        return CLIENT_REPLAY_DIR;
    }

    public static void bootstrapCommon() {
        if (!COMMON_BOOTSTRAPPED.compareAndSet(false, true)) {
            LOGGER.debug("bootstrapCommon() already called, skipping.");
            return;
        }

        LOGGER.info("ReplayMod replay: common bootstrap start");

        try {
            prepareReplayStorage();
        } catch (Exception e) {
            LOGGER.error("Failed to prepare replay storage", e);
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

    private static void prepareReplayStorage() throws IOException {
        Files.createDirectories(COMMON_REPLAY_DIR);
        Files.createDirectories(CLIENT_REPLAY_DIR);
        LOGGER.debug("Prepared replay directories: {} and {}", COMMON_REPLAY_DIR, CLIENT_REPLAY_DIR);
    }

    private static void loadReplayConfig() throws IOException {
        Path config = COMMON_REPLAY_DIR.resolve("replay.properties");
        if (Files.notExists(config)) {
            Files.writeString(config, "enabled=true\nmode=local\n");
        }
        LOGGER.debug("Replay common config ready at {}", config);
    }

    private static void registerReplayTypes() {
        LOGGER.debug("registerReplayTypes() placeholder for session/model type registration");
    }

    private static void initReplayServices() {
        LOGGER.debug("initReplayServices() placeholder for playback manager and state services");
    }

    private static void loadClientReplayConfig() throws IOException {
        Path config = CLIENT_REPLAY_DIR.resolve("client-replay.properties");
        if (Files.notExists(config)) {
            Files.writeString(config, "client.enabled=true\npreview.enabled=true\n");
        }
        LOGGER.debug("Client replay config ready at {}", config);
    }

    private static void registerReplayKeybinds() {
        LOGGER.debug("registerReplayKeybinds() placeholder for replay controls");
    }

    private static void registerReplayGui() {
        LOGGER.debug("registerReplayGui() placeholder for replay menu/UI integration");
    }

    private static void bindReplayRenderHooks() {
        LOGGER.debug("bindReplayRenderHooks() placeholder for playback-specific rendering");
    }

    private static void registerClientReplayEventHooks() {
        LOGGER.debug("registerClientReplayEventHooks() placeholder for client playback lifecycle events");
    }
}
