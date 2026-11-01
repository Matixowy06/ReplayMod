package com.replaymod.editor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ReplayModEditorBridge {
    private static final Logger LOGGER = LogManager.getLogger("ReplayModEditorBridge");
    private static final AtomicBoolean COMMON_BOOTSTRAPPED = new AtomicBoolean(false);
    private static final AtomicBoolean CLIENT_BOOTSTRAPPED = new AtomicBoolean(false);

    public static final Path COMMON_EDITOR_DIR = Paths.get("config", "replaymod", "editor");
    public static final Path CLIENT_EDITOR_DIR = COMMON_EDITOR_DIR.resolve("client");

    private ReplayModEditorBridge() {
    }

    public static Path getCommonEditorDir() {
        return COMMON_EDITOR_DIR;
    }

    public static Path getClientEditorDir() {
        return CLIENT_EDITOR_DIR;
    }

    public static void bootstrapCommon() {
        if (!COMMON_BOOTSTRAPPED.compareAndSet(false, true)) {
            LOGGER.debug("bootstrapCommon() already called, skipping.");
            return;
        }

        LOGGER.info("ReplayMod editor: common bootstrap start");

        try {
            prepareEditorStorage();
        } catch (Exception e) {
            LOGGER.error("Failed to prepare editor storage", e);
        }

        try {
            loadEditorConfig();
        } catch (Exception e) {
            LOGGER.error("Failed to load editor common config", e);
        }

        try {
            registerEditorTypes();
        } catch (Exception e) {
            LOGGER.error("Failed to register editor types", e);
        }

        try {
            initEditorServices();
        } catch (Exception e) {
            LOGGER.error("Failed to initialize editor services", e);
        }

        LOGGER.info("ReplayMod editor: common bootstrap finished");
    }

    public static void bootstrapClient() {
        if (!CLIENT_BOOTSTRAPPED.compareAndSet(false, true)) {
            LOGGER.debug("bootstrapClient() already called, skipping.");
            return;
        }

        bootstrapCommon();

        LOGGER.info("ReplayMod editor: client bootstrap start");

        try {
            loadClientEditorConfig();
        } catch (Exception e) {
            LOGGER.error("Failed to load client editor config", e);
        }

        try {
            registerEditorKeybinds();
            registerEditorGui();
            bindEditorRenderHooks();
        } catch (Exception e) {
            LOGGER.error("Failed to initialize client editor UI/render hooks", e);
        }

        try {
            registerClientEditorEventHooks();
        } catch (Exception e) {
            LOGGER.error("Failed to register client editor event hooks", e);
        }

        LOGGER.info("ReplayMod editor: client bootstrap finished");
    }

    private static void prepareEditorStorage() throws IOException {
        Files.createDirectories(COMMON_EDITOR_DIR);
        Files.createDirectories(CLIENT_EDITOR_DIR);
        LOGGER.debug("Prepared editor directories: {} and {}", COMMON_EDITOR_DIR, CLIENT_EDITOR_DIR);
    }

    private static void loadEditorConfig() throws IOException {
        Path config = COMMON_EDITOR_DIR.resolve("editor.properties");
        if (Files.notExists(config)) {
            Files.writeString(config, "enabled=true\nmode=timeline\n");
        }
        LOGGER.debug("Editor common config ready at {}", config);
    }

    private static void registerEditorTypes() {
        LOGGER.debug("registerEditorTypes() placeholder for editor model registrations");
    }

    private static void initEditorServices() {
        LOGGER.debug("initEditorServices() placeholder for timeline and selection services");
    }

    private static void loadClientEditorConfig() throws IOException {
        Path config = CLIENT_EDITOR_DIR.resolve("client-editor.properties");
        if (Files.notExists(config)) {
            Files.writeString(config, "client.enabled=true\npreview.enabled=true\n");
        }
        LOGGER.debug("Client editor config ready at {}", config);
    }

    private static void registerEditorKeybinds() {
        LOGGER.debug("registerEditorKeybinds() placeholder for editor controls");
    }

    private static void registerEditorGui() {
        LOGGER.debug("registerEditorGui() placeholder for editor windows and panels");
    }

    private static void bindEditorRenderHooks() {
        LOGGER.debug("bindEditorRenderHooks() placeholder for editor viewport rendering");
    }

    private static void registerClientEditorEventHooks() {
        LOGGER.debug("registerClientEditorEventHooks() placeholder for editor lifecycle hooks");
    }
}
