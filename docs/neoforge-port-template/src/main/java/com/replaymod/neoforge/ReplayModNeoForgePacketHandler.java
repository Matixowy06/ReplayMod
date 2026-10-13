package com.replaymod.neoforge;

import net.neoforged.neoforge.network.NetworkEvent;

public final class ReplayModNeoForgePacketHandler {
    private ReplayModNeoForgePacketHandler() {
    }

    public static void handleClient(ReplayModNeoForgePacket packet, NetworkEvent.Context context) {
        context.enqueueWork(() -> {
            switch (packet.getType()) {
                case SESSION_START -> {
                    // TODO: map to ReplayMod session start handling on the client.
                }
                case SESSION_STOP -> {
                    // TODO: map to ReplayMod session stop handling on the client.
                }
                case RECORDING_STATE -> {
                    // TODO: map to recording state updates on the client.
                }
                case REPLAY_STATE -> {
                    // TODO: map to replay state updates on the client.
                }
                case CLIENT_SYNC -> {
                    // TODO: map to client sync payload processing.
                }
                case SERVER_SYNC -> {
                    // TODO: map to server sync payload processing.
                }
                default -> {
                    // no-op for unknown packet types during the port migration
                }
            }
        });
    }

    public static void handleServer(ReplayModNeoForgePacket packet, NetworkEvent.Context context) {
        context.enqueueWork(() -> {
            switch (packet.getType()) {
                case SESSION_START -> {
                    // TODO: map to ReplayMod session start handling on the server.
                }
                case SESSION_STOP -> {
                    // TODO: map to ReplayMod session stop handling on the server.
                }
                case RECORDING_STATE -> {
                    // TODO: map to recording state updates on the server.
                }
                case REPLAY_STATE -> {
                    // TODO: map to replay state updates on the server.
                }
                case CLIENT_SYNC -> {
                    // TODO: map to client sync payload processing on the server.
                }
                case SERVER_SYNC -> {
                    // TODO: map to server sync payload processing on the server.
                }
                default -> {
                    // no-op for unknown packet types during the port migration
                }
            }
        });
    }

    public static void handle(NetworkEvent.Context context, ReplayModNeoForgePacket packet) {
        if (context.getDirection() == net.neoforged.neoforge.network.NetworkDirection.PLAY_TO_CLIENT) {
            handleClient(packet, context);
        } else {
            handleServer(packet, context);
        }
    }
}
