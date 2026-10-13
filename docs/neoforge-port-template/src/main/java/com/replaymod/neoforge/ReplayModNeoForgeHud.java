package com.replaymod.neoforge;

import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public final class ReplayModNeoForgeHud {
    private ReplayModNeoForgeHud() {
    }

    public static void render(Minecraft minecraft) {
        // TODO: migrate ReplayMod HUD rendering into NeoForge's client rendering lifecycle.
    }
}
