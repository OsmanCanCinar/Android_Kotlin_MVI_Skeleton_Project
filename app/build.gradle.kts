plugins {
    id(GradlePluginId.ANDROID_APP)
    id(GradlePluginId.HILT)
    id(GradlePluginId.KOTLIN_JETBRAINS)
    id(GradlePluginId.KOTLIN_ANDROID)
    id(GradlePluginId.SAFE_ARGS)
    id(GradlePluginId.KOTLIN_KAPT)
}

android {
    namespace = ApplicationConfig.APPLICATION_ID
    compileSdk = ApplicationConfig.COMPILE_SDK

    defaultConfig {
        applicationId = ApplicationConfig.APPLICATION_ID
        minSdk = ApplicationConfig.MIN_SDK
        targetSdk = ApplicationConfig.TARGET_SDK
        versionCode = ApplicationConfig.VERSION_CODE
        versionName = ApplicationConfig.VERSION_NAME

        testInstrumentationRunner = ApplicationConfig.TEST_INST_RUNNER
    }

    buildFeatures {
        viewBinding = true
        dataBinding = true
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    java {
        sourceCompatibility = ApplicationConfig.JAVA
        targetCompatibility = ApplicationConfig.JAVA
    }

    compileOptions {
        sourceCompatibility = ApplicationConfig.JAVA
        targetCompatibility = ApplicationConfig.JAVA
    }

    kotlinOptions {
        jvmTarget = ApplicationConfig.JVM_TARGET
    }
}

dependencies {
    implementation(Dependencies.Android.APPCOMPAT)
    implementation(Dependencies.Android.MATERIAL)
    implementation(Dependencies.Android.SWIPE_LAYOUT)
    implementation(Dependencies.Android.PREFERENCE)
    implementation(Dependencies.Android.Navigation.FRAGMENT)
    implementation(Dependencies.Android.Navigation.UI)
    implementation(Dependencies.Android.Room.CORE)
    implementation(Dependencies.Android.Room.RUN_TIME)
    implementation(Dependencies.Android.Room.ADAPTER_RXJAVA3)
    implementation(Dependencies.Android.LifeCycle.VIEW_MODEL)
    implementation(Dependencies.Android.LifeCycle.VM_SAVED_STATE)
    implementation(Dependencies.Android.LifeCycle.LIVE_DATA)
    implementation(Dependencies.Android.Ktx.ACTIVITY)
    implementation(Dependencies.Android.Ktx.FRAGMENT)
    implementation(Dependencies.Android.Ktx.CORE)
    implementation(Dependencies.Injection.CORE)
    implementation(Dependencies.Injection.NAVIGATION)
    implementation(Dependencies.Utilities.JETBRAINS_COROUTINES)
    implementation(Dependencies.Utilities.Glide.CORE)
    implementation(Dependencies.Utilities.Retrofit.CORE)
    implementation(Dependencies.Utilities.Retrofit.GSON)
    implementation(Dependencies.Utilities.Retrofit.CONVERTER_GSON)
    implementation(Dependencies.Utilities.Retrofit.ADAPTER_RXJAVA)
    implementation(Dependencies.Utilities.RxJava.CORE)
    implementation(Dependencies.Utilities.RxJava.ANDROID)

    testImplementation(Dependencies.Test.JUNIT)
    testImplementation(Dependencies.Test.ANDROIDX_JUNIT)
    testImplementation(Dependencies.Test.ESPRESSO_CORE)

    kapt(Dependencies.Android.Room.COMPILER)
    kapt(Dependencies.Injection.COMPILER)
    kapt(Dependencies.Utilities.Glide.COMPILER)
}

kapt {
    correctErrorTypes = true
}

