package com.replaymod;

public final class ReplayModRecordingBridge {
    private static boolean commonBootstrapped;
    private static boolean clientBootstrapped;

    private ReplayModRecordingBridge() {
    }

    public static void bootstrapCommon() {
        if (commonBootstrapped) {
            return;
        }

        // Original ReplayModRecording responsibilities:
        // - register recording settings
        // - prepare connection event plumbing
        // - keep this module directly after core and before replay
        commonBootstrapped = true;
    }

    public static void bootstrapClient() {
        if (clientBootstrapped) {
            return;
        }

        bootstrapCommon();

        // Original ReplayModRecording.initClient() responsibilities:
        // - ConnectionEventHandler initialization
        // - GuiHandler registration
        // - packet registration for local recording / restrictions channel
        clientBootstrapped = true;
    }
}
