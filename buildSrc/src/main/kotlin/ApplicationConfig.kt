import org.gradle.api.JavaVersion

object ApplicationConfig {
    const val APPLICATION_ID = "com.osmancancinar.skeleton"
    const val MIN_SDK = 23
    const val TARGET_SDK = 32
    const val COMPILE_SDK = 32
    const val VERSION_CODE = 1
    const val VERSION_NAME = "1.0"
    const val TEST_INST_RUNNER = "androidx.test.runner.AndroidJUnitRunner"
    const val JVM_TARGET = "1.8"
    val JAVA = JavaVersion.VERSION_1_8
}