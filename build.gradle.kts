import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.10"
    id("io.papermc.paperweight.userdev") version "1.3.5"
    id("net.minecrell.plugin-yml.bukkit") version "0.5.1"
    id("xyz.jpenilla.run-paper") version "1.0.6"
    java
}
val mcVersion = "1.19"

group = "de.spurkomet"
version = "$mcVersion"

repositories {
    mavenCentral()
    maven("https://repo.md-5.net/content/groups/public/")
    maven("https://repo.dmulloy2.net/repository/public/")
    maven("https://papermc.io/repo/repository/maven-public/")
}

dependencies {
    // PaperMC Dependency
    paperDevBundle("$mcVersion-R0.1-SNAPSHOT")

    // KSpigot dependency
    compileOnly("net.axay:kspigot:1.19.0")
    compileOnly("org.apache.httpcomponents:httpclient:4.5.13")
    compileOnly("org.apache.httpcomponents:httpmime:4.5.13")
    compileOnly("com.comphenix.protocol:ProtocolLib:4.7.0")
    compileOnly("LibsDisguises:LibsDisguises:10.0.28")
    compileOnly("io.papermc.paper:paper-api:${mcVersion}-R0.1-SNAPSHOT")
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "17"
        }
    }
    build {
        dependsOn(reobfJar)
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

bukkit {
    name = "AUtils"
    description = "Utils von Adrian und SpurKomet für appleogames"
    apiVersion = "1.19"
    authors = listOf(
        "SpurKomet",
        "DrHadrian",
    )
    main = "$group.autils.InternalMainClass"
    version = getVersion().toString()
    libraries = listOf(
        "net.axay:kspigot:1.19.0",
        "org.apache.httpcomponents:httpclient:4.5.13",
        "org.apache.httpcomponents:httpmime:4.5.13"
    )

}