package com.replaymod.neoforge;

import net.neoforged.fml.loading.FMLLoader;

public final class ReplayModNeoForgeRuntimeValidator {
    private ReplayModNeoForgeRuntimeValidator() {
    }

    public static void validateRuntime() {
        NeoForgeEntry.LOG.info("Validating NeoForge runtime state for ReplayMod port scaffold");
        NeoForgeEntry.LOG.info("Mod ID: {}", NeoForgeEntry.MOD_ID);
        NeoForgeEntry.LOG.info("Distribution: {}", FMLLoader.getDist());
        NeoForgeEntry.LOG.info("Current environment dist: {}", FMLLoader.getCurrentEnvironment().getDist());

        if (FMLLoader.getDist() == null) {
            NeoForgeEntry.LOG.warn("NeoForge distribution is not yet resolved during startup");
        }

        if (ReplayModNeoForgeNetwork.CHANNEL == null) {
            NeoForgeEntry.LOG.warn("NeoForge channel is not initialized");
        }

        NeoForgeEntry.LOG.info("Runtime validation complete for ReplayMod NeoForge port scaffold");
    }
}
