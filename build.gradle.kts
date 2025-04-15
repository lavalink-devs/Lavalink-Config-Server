plugins {
    java
    application
}

group = "dev.lavalink.config.server"
version = "1.0-SNAPSHOT"

application {
    mainClass = "lavalink.server.Launcher"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot:3.3.0")
    implementation("org.springframework.cloud:spring-cloud-config-server:4.2.2")
    implementation("ch.qos.logback:logback-classic:1.5.6")
}
