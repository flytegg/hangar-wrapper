plugins {
    alias(libs.plugins.kotlin)
    alias(libs.plugins.shadow)
    alias(libs.plugins.ktorfit)
    id("maven-publish")
}

group = "gg.flyte"
version = "1.1.3"

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.gson)
    implementation(libs.ktor.core)
    implementation(libs.ktor.cio)
    implementation(libs.ktor.content.negotiation)
    implementation(libs.ktor.serialization)
    implementation(libs.ktor.serialization.gson)
    implementation(libs.ktor.logging)
    implementation(libs.ktorfit.lib)
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}