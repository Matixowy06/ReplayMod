package com.replaymod;

public final class ReplayModRecordingBridge {
    private ReplayModRecordingBridge() {
    }

    public static void bootstrapCommon() {
        // Fabric: ReplayModRecording is initialized as part of ReplayMod module registration.
        // NeoForge: keep the startup sequence aligned and delegate the real migration here.
    }

    public static void bootstrapClient() {
        // Fabric client setup: register packet handlers, GUI hooks and recording entrypoints.
        // NeoForge: keep the bridge explicit and migrate the client startup here.
    }
}
