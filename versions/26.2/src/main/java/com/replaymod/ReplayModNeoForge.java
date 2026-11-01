package com.replaymod;

import com.replaymod.bootstrap.ReplayModBootstrap;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLLoader;

@Mod("replaymod")
public class ReplayModNeoForge {
    public ReplayModNeoForge() {
        ReplayModBootstrap.bootstrapCommon();

        if (FMLLoader.getDist() == Dist.CLIENT) {
            ReplayModBootstrap.bootstrapClient();
        }
    }
}
