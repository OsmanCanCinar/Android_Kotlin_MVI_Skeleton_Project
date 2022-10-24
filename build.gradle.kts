// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id(GradlePluginId.ANDROID_APP) version GradlePluginVersion.ANDROID_APP apply false
    id(GradlePluginId.ANDROID_LIB) version GradlePluginVersion.ANDROID_LIB apply false
    id(GradlePluginId.HILT) version GradlePluginVersion.HILT apply false
    id(GradlePluginId.KOTLIN_JETBRAINS) version GradlePluginVersion.KOTLIN_JETBRAINS apply false
    id(GradlePluginId.SAFE_ARGS) version GradlePluginVersion.SAFE_ARGS apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}