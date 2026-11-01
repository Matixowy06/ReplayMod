package com.replaymod.render;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ReplayModRenderBridge {
    private static final Logger LOGGER = LogManager.getLogger("ReplayModRenderBridge");
    private static final AtomicBoolean COMMON_BOOTSTRAPPED = new AtomicBoolean(false);
    private static final AtomicBoolean CLIENT_BOOTSTRAPPED = new AtomicBoolean(false);

    public static final Path COMMON_RENDER_DIR = Paths.get("config", "replaymod", "render");
    public static final Path CLIENT_RENDER_DIR = COMMON_RENDER_DIR.resolve("client");

    private ReplayModRenderBridge() {
    }

    public static Path getCommonRenderDir() {
        return COMMON_RENDER_DIR;
    }

    public static Path getClientRenderDir() {
        return CLIENT_RENDER_DIR;
    }

    public static void bootstrapCommon() {
        if (!COMMON_BOOTSTRAPPED.compareAndSet(false, true)) {
            LOGGER.debug("bootstrapCommon() already called, skipping.");
            return;
        }

        LOGGER.info("ReplayMod render: common bootstrap start");

        try {
            prepareRenderStorage();
        } catch (Exception e) {
            LOGGER.error("Failed to prepare render storage", e);
        }

        try {
            loadRenderConfig();
        } catch (Exception e) {
            LOGGER.error("Failed to load render common config", e);
        }

        try {
            registerRenderTypes();
        } catch (Exception e) {
            LOGGER.error("Failed to register render types", e);
        }

        try {
            initRenderServices();
        } catch (Exception e) {
            LOGGER.error("Failed to initialize render services", e);
        }

        LOGGER.info("ReplayMod render: common bootstrap finished");
    }

    public static void bootstrapClient() {
        if (!CLIENT_BOOTSTRAPPED.compareAndSet(false, true)) {
            LOGGER.debug("bootstrapClient() already called, skipping.");
            return;
        }

        bootstrapCommon();

        LOGGER.info("ReplayMod render: client bootstrap start");

        try {
            loadClientRenderConfig();
        } catch (Exception e) {
            LOGGER.error("Failed to load client render config", e);
        }

        try {
            registerRenderKeybinds();
            registerRenderGui();
            bindRenderHooks();
        } catch (Exception e) {
            LOGGER.error("Failed to initialize client render UI/render hooks", e);
        }

        try {
            registerClientRenderEventHooks();
        } catch (Exception e) {
            LOGGER.error("Failed to register client render event hooks", e);
        }

        LOGGER.info("ReplayMod render: client bootstrap finished");
    }

    private static void prepareRenderStorage() throws IOException {
        Files.createDirectories(COMMON_RENDER_DIR);
        Files.createDirectories(CLIENT_RENDER_DIR);
        LOGGER.debug("Prepared render directories: {} and {}", COMMON_RENDER_DIR, CLIENT_RENDER_DIR);
    }

    private static void loadRenderConfig() throws IOException {
        Path config = COMMON_RENDER_DIR.resolve("render.properties");
        if (Files.notExists(config)) {
            Files.writeString(config, "enabled=true\nquality=medium\n");
        }
        LOGGER.debug("Render common config ready at {}", config);
    }

    private static void registerRenderTypes() {
        LOGGER.debug("registerRenderTypes() placeholder for render pipeline registration");
    }

    private static void initRenderServices() {
        LOGGER.debug("initRenderServices() placeholder for pipeline manager and frame services");
    }

    private static void loadClientRenderConfig() throws IOException {
        Path config = CLIENT_RENDER_DIR.resolve("client-render.properties");
        if (Files.notExists(config)) {
            Files.writeString(config, "client.enabled=true\nwireframe=false\n");
        }
        LOGGER.debug("Client render config ready at {}", config);
    }

    private static void registerRenderKeybinds() {
        LOGGER.debug("registerRenderKeybinds() placeholder for render shortcuts");
    }

    private static void registerRenderGui() {
        LOGGER.debug("registerRenderGui() placeholder for render settings UI");
    }

    private static void bindRenderHooks() {
        LOGGER.debug("bindRenderHooks() placeholder for viewport/event render hooks");
    }

    private static void registerClientRenderEventHooks() {
        LOGGER.debug("registerClientRenderEventHooks() placeholder for render lifecycle integration");
    }
}
