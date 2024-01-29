import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "org.example"
version = "1.0-SNAPSHOT"
description = "functional-programming-in-kotlin-book"
java.sourceCompatibility = JavaVersion.VERSION_17

plugins {
    // id("org.jlleitschuh.gradle.ktlint")
    kotlin("jvm")
    kotlin("kapt")
}

val mavenUrl1 by properties
val mavenUrl2 by properties

repositories {
    // mavenLocal()
    // mavenCentral()
    maven {
        url = uri(mavenUrl1!!)
    }
    maven {
        url = uri(mavenUrl2!!)
    }
}

val test by tasks.getting(Test::class) {
    useJUnitPlatform { }
}

// val arrowVersion = "0.10.2"
val arrowVersion = "0.11.0"
dependencies {
    api(kotlin("stdlib"))
    implementation("io.arrow-kt:arrow-core-data:$arrowVersion")
    implementation("io.arrow-kt:arrow-fx:$arrowVersion")
    implementation("io.arrow-kt:arrow-mtl:$arrowVersion")
    implementation("io.arrow-kt:arrow-syntax:$arrowVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-collections-immutable:0.2")
    implementation("io.github.microutils:kotlin-logging:1.7.8")
    implementation("org.awaitility:awaitility:4.0.2")
    // was runtime
    implementation("org.slf4j:slf4j-simple:1.7.28")

    // need this at compile level for chapter 8
    // was testImplementation
    implementation("io.kotlintest:kotlintest-runner-junit5:3.3.2")
    kapt("io.arrow-kt:arrow-meta:$arrowVersion")
}

sourceSets {
    main {
        kotlin {
            include("chapter1/**/*.kt")
            include("chapter2/**/*.kt")
            include("chapter3/**/*.kt")
            include("chapter4/**/*.kt")
            include("chapter5/**/*.kt")
            include("chapter6/**/*.kt")
            include("chapter7/**/*.kt")
            include("chapter8/**/*.kt")
            include("chapter9/**/*.kt")
            // include("chapter10/**/*.kt")
            // include("chapter11/**/*.kt")
            // include("chapter12/**/*.kt")
            // include("chapter13/**/*.kt")
        }
    }
}

/*
repositories {
    jcenter()
    maven("https://dl.bintray.com/kotlin/kotlinx")
}
 */

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = "17"
        suppressWarnings = false // true
    }
}

tasks {
    wrapper {
        gradleVersion = "8.5"
        distributionType = Wrapper.DistributionType.ALL
    }

    test {
        useJUnitPlatform()

        testLogging {
            events("passed", "skipped", "failed")
        }

        reports {
            html.required.set(true)
        }
    }
}

/*
ktlint {
    verbose.set(true)
    disabledRules.set(
        setOf(
            "comment-spacing",
            "filename",
            "import-ordering",
            "no-line-break-before-assignment"
        )
    )
}
 */

kapt {
    useBuildCache = false
}
