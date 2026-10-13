plugins {
    java
    idea
    eclipse
    id("net.neoforged.gradle.userdev") version "7.0.187"
}

group = "com.replaymod"
version = "0.1.0-port-template"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
    withSourcesJar()
}

minecraft {
    version = "1.21.2-20250113.1636"
    mappings("official", "1.21.2")
    copyIdeResources = true

    runs {
        create("client") {
            client()
            ideConfigGenerated = true
        }
        create("server") {
            server()
            ideConfigGenerated = true
        }
    }
}

repositories {
    mavenCentral()
    maven("https://maven.neoforged.net/releases")
}

tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8"
}

tasks.jar {
    archiveBaseName.set("replaymod-neoforge-port-template")
}
