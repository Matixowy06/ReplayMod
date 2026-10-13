package com.replaymod.neoforge.mixin;

public final class ReplayModNeoForgeMixinBridge {
    private ReplayModNeoForgeMixinBridge() {
    }

    public static void beforeClientTick() {
        // TODO: route the original ReplayMod client-tick hook into NeoForge-compatible lifecycle.
        // This is the migration seam between the legacy Fabric/Loom mixin hook and the NeoForge port.
    }
}
