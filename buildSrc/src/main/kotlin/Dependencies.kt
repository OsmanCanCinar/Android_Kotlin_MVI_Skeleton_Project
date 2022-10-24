object Dependencies {
    object Android {
        const val APPCOMPAT = "androidx.appcompat:appcompat:${Versions.Android.APPCOMPAT}"
        const val MATERIAL = "com.google.android.material:material:${Versions.Android.MATERIAL}"
        const val SWIPE_LAYOUT =
            "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.Android.SWIPE_LAYOUT}"
        const val PREFERENCE =
            "androidx.preference:preference-ktx:${Versions.Android.PREFERENCE}"

        object Navigation {
            const val FRAGMENT =
                "androidx.navigation:navigation-fragment-ktx:${Versions.Android.NAVIGATION}"
            const val UI =
                "androidx.navigation:navigation-ui-ktx:${Versions.Android.NAVIGATION}"
        }

        object Room {
            const val CORE = "androidx.room:room-ktx:${Versions.Android.ROOM}"
            const val RUN_TIME = "androidx.room:room-runtime:${Versions.Android.ROOM}"
            const val COMPILER = "androidx.room:room-compiler:${Versions.Android.ROOM}"
            const val ADAPTER_RXJAVA3 = "androidx.room:room-rxjava3:${Versions.Android.ROOM}"
        }

        object LifeCycle {
            const val VIEW_MODEL =
                "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.Android.LIFE_CYCLE}"
            const val VM_SAVED_STATE =
                "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Versions.Android.LIFE_CYCLE}"
            const val LIVE_DATA =
                "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.Android.LIFE_CYCLE}"
        }

        object Ktx {
            const val CORE = "androidx.core:core-ktx:${Versions.Android.Ktx.CORE}"
            const val ACTIVITY =
                "androidx.activity:activity-ktx:${Versions.Android.Ktx.ACTIVITY}"
            const val FRAGMENT =
                "androidx.fragment:fragment-ktx:${Versions.Android.Ktx.FRAGMENT}"
        }
    }

    object Injection {
        const val CORE = "com.google.dagger:hilt-android:${Versions.Injection.CORE}"
        const val COMPILER = "com.google.dagger:hilt-compiler:${Versions.Injection.CORE}"
        const val NAVIGATION =
            "androidx.hilt:hilt-navigation-fragment:${Versions.Injection.NAVIGATION}"
    }

    object Test {
        const val ANDROIDX_JUNIT =
            "androidx.test.ext:junit:${Versions.Test.ANDROIDX_JUNIT}"
        const val ESPRESSO_CORE =
            "androidx.test.espresso:espresso-core:${Versions.Test.ESPRESSO_CORE}"
        const val JUNIT = "junit:junit:${Versions.Test.JUNIT}"
    }

    object Utilities {
        const val JETBRAINS_COROUTINES =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.Utilities.JETBRAINS_COROUTINES}"

        object Glide {
            const val CORE = "com.github.bumptech.glide:glide:${Versions.Utilities.GLIDE}"
            const val COMPILER = "com.github.bumptech.glide:compiler:${Versions.Utilities.GLIDE}"
        }

        object Retrofit {
            const val CORE = "com.squareup.retrofit2:retrofit:${Versions.Utilities.Retrofit.CORE}"
            const val GSON = "com.google.code.gson:gson:${Versions.Utilities.Retrofit.GSON}"
            const val CONVERTER_GSON =
                "com.squareup.retrofit2:converter-gson:${Versions.Utilities.Retrofit.CORE}"
            const val ADAPTER_RXJAVA =
                "com.squareup.retrofit2:adapter-rxjava3:${Versions.Utilities.Retrofit.CORE}"
        }

        object RxJava {
            const val CORE = "io.reactivex.rxjava3:rxjava:${Versions.Utilities.RXJAVA}"
            const val ANDROID = "io.reactivex.rxjava3:rxandroid:${Versions.Utilities.RXJAVA}"
        }
    }
}