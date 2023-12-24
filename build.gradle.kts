plugins {
    alias(libs.plugins.kotlin)
    alias(libs.plugins.shadow)
    alias(libs.plugins.ktorfit)
    alias(libs.plugins.ksp)
    id("maven-publish")
}

group = "gg.flyte"
version = "1.1.3"

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.gson)
    implementation(libs.logback)

    implementation(libs.ktor.core)
    implementation(libs.ktor.cio)
    implementation(libs.ktor.content.negotiation)
    implementation(libs.ktor.serialization)
    implementation(libs.ktor.serialization.gson)
    implementation(libs.ktor.logging)

    ksp(libs.ktorfit.ksp)
    implementation(libs.ktorfit.lib)


    implementation("com.squareup.okhttp3:okhttp:4.10.0")
    implementation("org.apache.commons:commons-io:1.3.2")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}