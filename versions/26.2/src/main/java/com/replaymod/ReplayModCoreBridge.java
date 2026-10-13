package com.replaymod;

public final class ReplayModCoreBridge {
    private ReplayModCoreBridge() {
    }

    public static void bootstrapCommon() {
        // TODO: port the original Fabric core bootstrap and shared registries.
        // This phase mirrors the ReplayMod.java initialization and module registration flow.
    }

    public static void bootstrapClient() {
        // TODO: port the client-side config, GUI bootstrap, and keybinding registry.
        // This phase is intentionally kept minimal until the Fabric core classes are translated.
    }
}
