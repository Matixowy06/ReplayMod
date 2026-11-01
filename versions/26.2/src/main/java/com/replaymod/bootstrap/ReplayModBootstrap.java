package com.replaymod.bootstrap;

import com.replaymod.compat.ReplayModCompatBridge;
import com.replaymod.core.ReplayModCoreBridge;
import com.replaymod.editor.ReplayModEditorBridge;
import com.replaymod.extras.ReplayModExtrasBridge;
import com.replaymod.recording.ReplayModRecordingBridge;
import com.replaymod.render.ReplayModRenderBridge;
import com.replaymod.replay.ReplayModReplayBridge;
import com.replaymod.simplepathing.ReplayModSimplePathingBridge;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class ReplayModBootstrap {
    private static final Logger LOGGER = LogManager.getLogger("ReplayModBootstrap");

    private ReplayModBootstrap() {
    }

    public static void bootstrapCommon() {
        LOGGER.info("ReplayMod bootstrap: common initialization start");

        ReplayModCoreBridge.bootstrapCommon();
        ReplayModRecordingBridge.bootstrapCommon();
        ReplayModReplayBridge.bootstrapCommon();
        ReplayModRenderBridge.bootstrapCommon();
        ReplayModSimplePathingBridge.bootstrapCommon();
        ReplayModEditorBridge.bootstrapCommon();
        ReplayModExtrasBridge.bootstrapCommon();
        ReplayModCompatBridge.bootstrapCommon();

        LOGGER.info("ReplayMod bootstrap: common initialization finished");
    }

    public static void bootstrapClient() {
        LOGGER.info("ReplayMod bootstrap: client initialization start");

        ReplayModCoreBridge.bootstrapClient();
        ReplayModRecordingBridge.bootstrapClient();
        ReplayModReplayBridge.bootstrapClient();
        ReplayModRenderBridge.bootstrapClient();
        ReplayModSimplePathingBridge.bootstrapClient();
        ReplayModEditorBridge.bootstrapClient();
        ReplayModExtrasBridge.bootstrapClient();
        ReplayModCompatBridge.bootstrapClient();

        LOGGER.info("ReplayMod bootstrap: client initialization finished");
    }
}
