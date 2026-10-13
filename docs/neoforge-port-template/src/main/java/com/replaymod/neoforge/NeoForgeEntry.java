package com.replaymod.neoforge;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(NeoForgeEntry.MOD_ID)
public class NeoForgeEntry {
    public static final String MOD_ID = "replaymod_neoforge_port";
    public static final Logger LOG = LoggerFactory.getLogger(MOD_ID);

    public NeoForgeEntry(IEventBus modEventBus, ModContainer modContainer) {
        LOG.info("ReplayMod NeoForge scaffold bootstrapping...");
        LOG.info("Minecraft platform: {}", FMLLoader.getCurrentEnvironment().getDist());

        ReplayModNeoForgeBootstrap.bootstrap(modEventBus, modContainer);

        modEventBus.register(ReplayModNeoForgeModEvents.class);
        if (FMLLoader.getDist() == Dist.CLIENT) {
            modEventBus.register(ReplayModNeoForgeClientEvents.class);
        }
    }
}
