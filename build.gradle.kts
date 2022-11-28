// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id(GradlePlugins.ANDROID_APP) version GradlePluginVersion.ANDROID_APP apply false
    id(GradlePlugins.ANDROID_LIB) version GradlePluginVersion.ANDROID_LIB apply false
    id(GradlePlugins.HILT) version GradlePluginVersion.HILT apply false
    id(GradlePlugins.KOTLIN_JETBRAINS) version GradlePluginVersion.KOTLIN_JETBRAINS apply false
    id(GradlePlugins.SAFE_ARGS) version GradlePluginVersion.SAFE_ARGS apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}