// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id(Dependencies.Gradle.ANDROID_APP) version Versions.Gradle.ANDROID_APP apply false
    id(Dependencies.Gradle.ANDROID_LIBRARY) version Versions.Gradle.ANDROID_LIBRARY apply false
    id(Dependencies.Gradle.JETBRAINS_KOTLIN) version Versions.Gradle.JETBRAINS_KOTLIN apply false
    id(Dependencies.Gradle.SAFE_ARGS) version Versions.Gradle.SAFE_ARGS apply false
}

tasks.register<Delete>("clean") {
    delete(rootProject.buildDir)
}