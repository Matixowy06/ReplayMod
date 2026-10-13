# NeoForge 26.2 Port Template

This folder is a safe starter scaffold for the NeoForge 26.2 port of ReplayMod.

Important:
- This is not a completed port.
- It is intentionally kept isolated from the live Fabric build.
- The goal is to provide a clean NeoForge 26.2 base that can accept ReplayMod sources in stages.

Next steps:
1. Align the target NeoForge/Minecraft version precisely with the final compatibility target.
2. Move the ReplayMod bootstrap classes into this project.
3. Port event hooks, mixins, networking, and render layers one by one.
4. Validate with `./gradlew compileJava` and `runClient`.
