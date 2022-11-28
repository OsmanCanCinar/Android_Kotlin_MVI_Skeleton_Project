plugins {
    id(GradlePlugins.ANDROID_APP)
    id(GradlePlugins.HILT)
    id(GradlePlugins.KOTLIN_JETBRAINS)
    id(GradlePlugins.KOTLIN_ANDROID)
    id(GradlePlugins.SAFE_ARGS)
    id(GradlePlugins.KOTLIN_KAPT)
}

android {
    namespace = AppConfig.APP_ID
    compileSdk = AppConfig.COMPILE_SDK

    defaultConfig {
        applicationId = AppConfig.APP_ID
        minSdk = AppConfig.MIN_SDK
        targetSdk = AppConfig.TARGET_SDK
        versionCode = AppConfig.VERSION_CODE
        versionName = AppConfig.VERSION_NAME

        testInstrumentationRunner = AppConfig.TEST_INST_RUNNER
    }

    buildFeatures {
        viewBinding = true
        dataBinding = true
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }

        getByName("debug") {
            applicationIdSuffix = ".debug"
            isDebuggable = true
        }
    }

    flavorDimensions += listOf("mode", "testing")

    productFlavors {
        create("free") {
            // Assigns this product flavor to the "mode" flavor dimension.
            dimension = "mode"
            applicationIdSuffix = ".free"
            manifestPlaceholders["free"] = "free"
        }

        create("paid") {
            dimension = "mode"
            applicationIdSuffix = ".paid"
            manifestPlaceholders["paid"] = "paid"
        }

        create("qa") {
            dimension = "testing"
            applicationIdSuffix = ".qa"
            manifestPlaceholders["qa"] = "qa"
        }
    }

    java {
        sourceCompatibility = AppConfig.JAVA
        targetCompatibility = AppConfig.JAVA
    }

    compileOptions {
        sourceCompatibility = AppConfig.JAVA
        targetCompatibility = AppConfig.JAVA
    }

    kotlinOptions {
        jvmTarget = AppConfig.JVM_TARGET
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

