package com.replaymod;

import com.replaymod.compat.ReplayModCompatBridge;
import com.replaymod.core.ReplayModCoreBridge;
import com.replaymod.editor.ReplayModEditorBridge;
import com.replaymod.extras.ReplayModExtrasBridge;
import com.replaymod.recording.ReplayModRecordingBridge;
import com.replaymod.render.ReplayModRenderBridge;
import com.replaymod.replay.ReplayModReplayBridge;
import com.replaymod.simplepathing.ReplayModSimplePathingBridge;
import net.neoforged.fml.common.Mod;

@Mod("replaymod")
public class ReplayModNeoForge {
    public ReplayModNeoForge() {
        ReplayModCoreBridge.bootstrapClient();
        ReplayModRecordingBridge.bootstrapClient();
        ReplayModReplayBridge.bootstrapClient();
        ReplayModRenderBridge.bootstrapClient();
        ReplayModSimplePathingBridge.bootstrapClient();
        ReplayModEditorBridge.bootstrapClient();
        ReplayModExtrasBridge.bootstrapClient();
        ReplayModCompatBridge.bootstrapClient();
    }
}
