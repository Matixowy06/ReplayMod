package com.replaymod.neoforge;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.TickEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;

import static com.replaymod.neoforge.NeoForgeEntry.MOD_ID;

@EventBusSubscriber(modid = MOD_ID, bus = net.neoforged.bus.api.EventBus.FORGE, value = Dist.CLIENT)
public final class ReplayModNeoForgeClientEvents {
    private ReplayModNeoForgeClientEvents() {
    }

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            // TODO: move ReplayMod client tick logic here.
            NeoForgeEntry.LOG.debug("Client tick hook reached for ReplayMod NeoForge scaffold");
        }
    }

    @SubscribeEvent
    public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
        // TODO: move ReplayMod login/session startup hooks here.
        NeoForgeEntry.LOG.debug("Player login hook reached for ReplayMod NeoForge scaffold");
    }
}
