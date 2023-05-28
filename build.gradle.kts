plugins {
    id("com.github.johnrengelman.shadow") version "7.1.1"
    kotlin("jvm") version "1.8.0"
    id("maven-publish")
}

group = "gg.flyte"
version = "1.1.1"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("com.squareup.okhttp3:okhttp:4.10.0")
    implementation("com.google.code.gson:gson:2.10.1")
    implementation("org.apache.commons:commons-io:1.3.2")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(11)
}