import org.ajoberstar.grgit.Grgit

plugins {
    java
    application
    id("org.ajoberstar.grgit") version "5.2.0"
    id("org.springframework.boot") version "3.3.0"
}

val gitVersion = versionFromGit()
logger.lifecycle("Version: $gitVersion")

group = "dev.lavalink.config.server"

application {
    mainClass = "dev.lavalink.config.server.Launcher"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot:3.3.0")
    implementation("org.springframework.cloud:spring-cloud-config-server:4.2.2")
    implementation("ch.qos.logback:logback-classic:1.5.6")
    implementation("org.springframework.boot:spring-boot-starter-web:3.3.0")
}

fun versionFromGit(): String {
    Grgit.open(mapOf("currentDir" to project.rootDir)).use { git ->
        val headTag = git.tag
            .list()
            .find { it.commit.id == git.head().id }

        val clean = git.status().isClean || System.getenv("CI") != null
        if (!clean) {
            logger.lifecycle("Git state is dirty, version is a snapshot.")
        }

        return if (headTag != null && clean) headTag.name else "${git.head().id}-SNAPSHOT"
    }
}