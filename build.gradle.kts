plugins {
    alias(libs.plugins.kotlin)
    alias(libs.plugins.shadow)
    alias(libs.plugins.ktorfit)
    alias(libs.plugins.ksp)
    id("maven-publish")
}

group = "gg.flyte"
version = "2.0.0"

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
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}


publishing {
    repositories {
        maven {
            name = "flyte-repository"
            url = uri(
                "https://repo.flyte.gg/${
                    if (version.toString().endsWith("-SNAPSHOT")) "snapshots" else "releases"
                }"
            )
            credentials {
                username = System.getenv("MAVEN_NAME") ?: property("mavenUser").toString()
                password = System.getenv("MAVEN_SECRET") ?: property("mavenPassword").toString()
            }
        }
    }

    publishing {
        publications {
            create<MavenPublication>("maven") {
                groupId = group.toString()
                artifactId = "twilight"
                version = version.toString()

                from(components["java"])
            }
        }
    }
}