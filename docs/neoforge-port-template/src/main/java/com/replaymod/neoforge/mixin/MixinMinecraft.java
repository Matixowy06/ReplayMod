package com.replaymod.neoforge.mixin;

import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public abstract class MixinMinecraft {
    @Inject(method = "runTick()V", at = @At("HEAD"))
    private void replaymod$beforeClientTick(CallbackInfo ci) {
        ReplayModNeoForgeMixinBridge.beforeClientTick();
    }
}
