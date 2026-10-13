# NeoForge 26.2 Port Plan for ReplayMod

This document records the actual state of the current fork and the required work needed to port it to NeoForge 26.2.

## Current repo state

The repository at `Matixowy06/ReplayMod` is currently structured as a multi-version Fabric/Loom project and is not a NeoForge project.

Key evidence from the current build files:

- `root.gradle.kts` uses `gg.essential.loom` and multi-version preprocessing.
- `root.gradle.kts` defines:
  - `createNode("26.2", 26_02_00, "yarn")`
- `build.gradle.kts` contains Fabric-specific logic such as:
  - `if (platform.isFabric)`
  - Fabric API module declarations
  - `modImplementation(fabricApi.module(...))`
- `gradle.properties` points to Fabric Loom configuration and `fabric-loader`.

This means the project is currently a Fabric-targeted multi-version build and not a NeoForge 26.2 build.

## Why this is not a simple change

Porting ReplayMod to NeoForge 26.2 requires changing more than a single Gradle line. The project depends on platform-specific assumptions in several areas:

- build system and loader
- mod bootstrap entrypoints
- event system and lifecycle
- mixin configuration and refmaps
- networking / packet registration
- client rendering and GUI hooks
- library compatibility for replay and capture logic

## Required work

### 1. Replace the build model

The project should be rebuilt from a NeoForge MDK 26.2 template or a clean NeoForge 26.2 Gradle setup.

Required changes:

- move away from Loom/Fabric setup in `root.gradle.kts`
- replace Fabric-specific dependency wiring in `build.gradle.kts`
- update `settings.gradle.kts` to a NeoForge-compatible project structure
- align `gradle.properties` with NeoForge 26.2 toolchain and mappings

### 2. Port mod bootstrap

All platform-specific entrypoints must be updated to NeoForge class usage, e.g.:

- `@Mod`
- `IEventBus`
- `ModLoadingContext`
- `DeferredRegister`
- NeoForge event subscribers

The current project contains Fabric/Forge assumptions via:

- `platform.isFabric`
- `platform.isLegacyForge`
- `loom` configuration

These must be rewritten or split into NeoForge-compatible code paths.

### 3. Port the event system

ReplayMod relies heavily on client/server hooks for:

- world updates
- rendering events
- input events
- GUI overlays
- playback capture and replay state

These must be migrated to NeoForge event APIs, such as:

- `ClientTickEvent`
- `RenderLevelStageEvent`
- `RegisterGuiOverlaysEvent`
- `EntityJoinLevelEvent`
- `TickEvent`

### 4. Port mixins and access transforms

The current build explicitly enables Mixin legacy behavior:

- `loom.mixin.useLegacyMixinAp = true`
- `defaultRefmapName.set("mixins.replaymod.refmap.json")`

NeoForge uses its own mixin and mod loading pipeline. The existing Mixin config and target classes must be validated against NeoForge mappings and loading rules.

### 5. Port networking

ReplayMod almost certainly has custom packet/channels and replay data synchronization logic. NeoForge networking differs from Fabric networking and typically requires:

- custom packet registration
- `SimpleChannel`
- `PacketDistributor`
- serializers and message handlers

### 6. Port rendering and HUD code

This is likely the highest-risk part of the port because ReplayMod does rendering, overlays, and recording capture. Any client-rendering code must be revalidated against NeoForge's render event lifecycle and GUI rendering pipeline.

### 7. Validate compatibility libraries

The project includes:

- `libs/ReplayStudio`
- `jGui`

These may still be usable, but they must be checked for assumptions about Fabric or Forge APIs before being included in the NeoForge build.

## Safe execution order

This should not be done as a single monolithic patch. The safe order is:

1. Create a stable NeoForge build template for the project.
2. Get the project compiling with NeoForge without runtime errors.
3. Port core mod bootstrap.
4. Port events and lifecycle glue.
5. Port networking and rendering.
6. Port replay logic and recording features.
7. Validate gameplay and replay flows in dev run.

## Current branch

The work is being tracked on:

- `port/neoforge-26.2`

## Recommendation

The correct next action is to replace the current build setup with a clean NeoForge 26.2 MDK baseline, then port the ReplayMod code into that structure. A direct patch of the current Fabric-based project would be risky and likely incomplete.

This document is intentionally conservative: it reflects the actual state of the code and avoids guessing about unverified NeoForge compatibility.
