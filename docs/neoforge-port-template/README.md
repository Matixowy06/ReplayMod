# NeoForge 26.2 port template

This folder is a safe, isolated scaffold for a NeoForge 26.2 port of ReplayMod.

It intentionally does not touch the live Fabric-based build in the repository root.

What is included:
- NeoForge MDK-style Gradle setup
- placeholder mod entrypoint
- placeholder `neoforge.mods.toml`
- the minimal project structure needed to start porting ReplayMod into NeoForge 26.2

Why this exists:
- the current fork `Matixowy06/ReplayMod` is still a Fabric/Loom build
- 26.2 is present as a Yarn/Fabric compatibility node, not as a NeoForge loader target
- a direct patch of the existing build would be unsafe

Next step in the actual port:
1. Move ReplayMod bootstrap classes into this scaffold.
2. Port input/event hooks to NeoForge event bus.
3. Port mixins and networking.
4. Port rendering and GUI layers.
5. Validate with `./gradlew compileJava` and `runClient`.
