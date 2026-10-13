package com.replaymod.neoforge;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderGuiEvent;
import net.neoforged.neoforge.client.event.RegisterGuiOverlaysEvent;

import static com.replaymod.neoforge.NeoForgeEntry.MOD_ID;

@EventBusSubscriber(modid = MOD_ID, bus = net.neoforged.bus.api.EventBus.FORGE, value = Dist.CLIENT)
public final class ReplayModNeoForgeRenderEvents {
    private ReplayModNeoForgeRenderEvents() {
    }

    @SubscribeEvent
    public static void onRegisterGuiOverlays(RegisterGuiOverlaysEvent event) {
        // TODO: register ReplayMod HUD/overlay elements in NeoForge GUI system.
        NeoForgeEntry.LOG.info("NeoForge GUI overlay registry reached");
    }

    @SubscribeEvent
    public static void onRenderGui(RenderGuiEvent.Post event) {
        // TODO: route ReplayMod HUD drawing into NeoForge render pipeline.
    }
}
