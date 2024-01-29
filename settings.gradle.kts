pluginManagement {
    val mavenUrl1: String by settings
    val mavenUrl2: String  by settings

    repositories {
        // gradlePluginPortal()
        maven {
            url = uri(mavenUrl1)
        }
        maven {
            url = uri(mavenUrl2)
        }
    }

    plugins {
        // id("org.jlleitschuh.gradle.ktlint") version "9.2.1"
        kotlin("jvm") version "1.9.20"
        kotlin("kapt") version "1.9.20"
    }
}

rootProject.name = "fpinkotlin"

