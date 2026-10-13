plugins {
    id("java")
    id("net.neoforged.gradle.userdev") version "7.0.165"
}

version = "0.1.0"
group = "com.replaymod"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

minecraft {
    version = "1.21.11"
    mappings {
        channel = "official"
    }
}

repositories {
    mavenCentral()
    maven {
        name = "NeoForge"
        url = uri("https://maven.neoforged.net/releases")
    }
}

dependencies {
    implementation("net.neoforged:neoforge:26.2.0")
}

tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8"
    options.release.set(21)
}

tasks.withType<Jar>().configureEach {
    archiveBaseName.set("replaymod-neoforge")
}
