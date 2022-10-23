plugins {
    id(Dependencies.Gradle.ANDROID_APP)
    id(Dependencies.Gradle.HILT)
    id(Dependencies.Gradle.JETBRAINS_KOTLIN)
    id(Dependencies.Gradle.KOTLIN_ANDROID)
    id(Dependencies.Gradle.SAFE_ARGS)
    id(Dependencies.Gradle.KOTLIN_KAPT)
}

android {
    namespace = "com.osmancancinar.skeleton"
    compileSdk = 32

    defaultConfig {
        applicationId = "com.osmancancinar.skeleton"
        minSdk = 23
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        viewBinding = true
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = Versions.Util.JVM_TARGET
    }
}

dependencies {
    implementation(Dependencies.AndroidX.APPCOMPAT)
    implementation(Dependencies.AndroidX.KTX_CORE)
    implementation(Dependencies.AndroidX.LIFE_CYCLE)
    implementation(Dependencies.AndroidX.LIFE_CYCLE_SAVED_STATE)
    implementation(Dependencies.AndroidX.LIVE_DATA)
    implementation(Dependencies.AndroidX.NAVIGATION)
    implementation(Dependencies.AndroidX.NAVIGATION_UI)
    implementation(Dependencies.AndroidX.PREFERENCE)
    implementation(Dependencies.AndroidX.ROOM)
    implementation(Dependencies.AndroidX.ROOM_RUN_TIME)
    implementation(Dependencies.AndroidX.ROOM_RXJAVA3)
    implementation(Dependencies.AndroidX.SWIPER_REFRESH)
    implementation(Dependencies.Google.GSON)
    implementation(Dependencies.Google.HILT)
    implementation(Dependencies.Google.MATERIAL)
    implementation(Dependencies.Util.GLIDE)
    implementation(Dependencies.Util.JETBRAINS_COROUTINES)
    implementation(Dependencies.Util.RETROFIT)
    {
        exclude(module = "okhttp")
    }
    implementation(Dependencies.Util.RETROFIT_GSON)
    implementation(Dependencies.Util.RETROFIT_RXJAVA)
    implementation(Dependencies.Util.RXJAVA)
    implementation(Dependencies.Util.RXJAVA_ANDROID)
    testImplementation(Dependencies.Test.JUNIT)
    testImplementation(Dependencies.Test.ANDROIDX_JUNIT)
    testImplementation(Dependencies.Test.ESPRESSO_CORE)
    kapt(Dependencies.AndroidX.ROOM_COMPILER)
    kapt(Dependencies.Google.HILT_COMPILER)
    kapt(Dependencies.Util.GLIDE)
}

kapt {
    correctErrorTypes = true
}

