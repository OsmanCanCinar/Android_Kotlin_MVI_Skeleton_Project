object Dependencies {

    object AndroidX {
        const val APPCOMPAT = "androidx.appcompat:appcompat:${Versions.AndroidX.APPCOMPAT}"
        const val ACTIVITY = "androidx.activity:activity-ktx:${Versions.AndroidX.ACTIVITY}"
        const val KTX_CORE = "androidx.core:core-ktx:${Versions.AndroidX.KTX_CORE}"
        const val LIFE_CYCLE =
            "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.AndroidX.LIFE_CYCLE}"
        const val LIFE_CYCLE_SAVED_STATE =
            "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Versions.AndroidX.LIFE_CYCLE}"
        const val LIVE_DATA =
            "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.AndroidX.LIFE_CYCLE}"
        const val NAVIGATION =
            "androidx.navigation:navigation-fragment-ktx:${Versions.AndroidX.NAVIGATION}"
        const val NAVIGATION_UI =
            "androidx.navigation:navigation-ui-ktx:${Versions.AndroidX.NAVIGATION}"
        const val PREFERENCE = "androidx.preference:preference-ktx:${Versions.AndroidX.PREFERENCE}"
        const val SWIPER_REFRESH =
            "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.AndroidX.SWIPER_REFRESH}"
        const val ROOM = "androidx.room:room-ktx:${Versions.AndroidX.ROOM}"
        const val ROOM_RUN_TIME = "androidx.room:room-runtime:${Versions.AndroidX.ROOM}"
        const val ROOM_COMPILER = "androidx.room:room-compiler:${Versions.AndroidX.ROOM}"
        const val ROOM_RXJAVA3 = "androidx.room:room-rxjava3:${Versions.AndroidX.ROOM}"
    }

    object Google {
        const val GSON = "com.google.code.gson:gson:${Versions.Google.GSON}"
        const val MATERIAL = "com.google.android.material:material:${Versions.Google.MATERIAL}"
    }

    object Gradle {
        const val ANDROID_APP = "com.android.application"
        const val ANDROID_LIBRARY = "com.android.library"
        const val JETBRAINS_KOTLIN = "org.jetbrains.kotlin.android"
        const val KOTLIN_KAPT = "kotlin-kapt"
        const val KOTLIN_ANDROID = "kotlin-android"
        const val SAFE_ARGS = "androidx.navigation.safeargs.kotlin"
    }

    object Test {
        const val ANDROIDX_JUNIT =
            "androidx.test.ext:junit:${Versions.Test.ANDROIDX_JUNIT}"
        const val ESPRESSO_CORE =
            "androidx.test.espresso:espresso-core:${Versions.Test.ESPRESSO_CORE}"
        const val JUNIT = "junit:junit:${Versions.Test.JUNIT}"
    }

    object Util {
        const val GLIDE = "com.github.bumptech.glide:glide:${Versions.Util.GLIDE}"
        const val JETBRAINS_COROUTINES =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.Util.JETBRAINS_COROUTINES}"
        const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.Util.RETROFIT}"
        const val RETROFIT_GSON = "com.squareup.retrofit2:converter-gson:${Versions.Util.RETROFIT}"
        const val RETROFIT_RXJAVA =
            "com.squareup.retrofit2:adapter-rxjava3:${Versions.Util.RETROFIT}"
        const val RXJAVA = "io.reactivex.rxjava3:rxjava:${Versions.Util.RXJAVA}"
        const val RXJAVA_ANDROID = "io.reactivex.rxjava3:rxandroid:${Versions.Util.RXJAVA}"
    }
}

object Versions {
    object AndroidX {
        const val APPCOMPAT = "1.5.1"
        const val ACTIVITY = "1.6.0"
        const val KTX_CORE = "1.8.0"
        const val LIFE_CYCLE = "2.5.1"
        const val NAVIGATION = "2.5.2"
        const val PREFERENCE = "1.2.0"
        const val SWIPER_REFRESH = "1.1.0"
        const val ROOM = "2.4.3"
    }

    object Google {
        const val GSON = "2.9.1"
        const val MATERIAL = "1.7.0"
    }

    object Gradle {
        const val ANDROID_APP = "7.3.0"
        const val ANDROID_LIBRARY = "7.3.0"
        const val JETBRAINS_KOTLIN = "1.7.10"
        const val SAFE_ARGS = "2.5.2"
    }

    object Test {
        const val ANDROIDX_JUNIT = "1.1.3"
        const val ESPRESSO_CORE = "3.4.0"
        const val JUNIT = "4.1"
    }

    object Util {
        const val GLIDE = "4.14.2"
        const val JETBRAINS_COROUTINES = "1.3.9"
        const val JVM_TARGET = "1.8"
        const val RETROFIT = "2.9.0"
        const val RXJAVA = "3.0.0"
    }
}


