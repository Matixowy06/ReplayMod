package com.replaymod;

public final class ReplayModReplayBridge {
    private static boolean commonBootstrapped;
    private static boolean clientBootstrapped;

    private ReplayModReplayBridge() {
    }

    public static void bootstrapCommon() {
        if (commonBootstrapped) {
            return;
        }

        // Mirrors ReplayModReplay construction:
        // - register replay settings
        // - initialize the camera controller registry
        // - keep replay after recording, before render
        commonBootstrapped = true;
    }

    public static void bootstrapClient() {
        if (clientBootstrapped) {
            return;
        }

        // Mirrors ReplayModReplay.initClient():
        // - register classic and vanilla camera controllers
        // - install replay GUI handlers
        // - configure replay keybindings
        bootstrapCommon();
        clientBootstrapped = true;
    }
}
