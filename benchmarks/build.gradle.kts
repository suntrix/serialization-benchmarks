import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi

plugins {
//    alias(libs.plugins.goncalossilva.resources)
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlinx.serialization)
    alias(libs.plugins.ksp)
}

group = "suntrix.serialization.benchmarks"
version = "1.0"

@OptIn(ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    val hostOs = System.getProperty("os.name")
    val isArm64 = System.getProperty("os.arch") == "aarch64"
    val isMingwX64 = hostOs.startsWith("Windows")
    val nativeTarget = when {
        hostOs == "Mac OS X" && isArm64 -> macosArm64()
        hostOs == "Mac OS X" && !isArm64 -> macosX64()
        hostOs == "Linux" && isArm64 -> linuxArm64()
        hostOs == "Linux" && !isArm64 -> linuxX64()
        isMingwX64 -> mingwX64()
        else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
    }

    nativeTarget.apply {
        binaries {
            executable {
                entryPoint = "suntrix.serialization.benchmarks.main"
            }
        }
    }

    jvm {
        withJava()
        compilations.all {
            kotlinOptions.jvmTarget = "17"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.goncalossilva.resources)
                implementation(libs.kotlinx.serialization.json)
            }
        }

        val jvmMain by getting {
            dependencies {
                implementation(libs.gson)
                implementation(libs.moshi)
                implementation(libs.moshi.adapters)
            }
        }
    }
}

dependencies {
    add("kspJvm", libs.moshi.kotlin.codegen.get())
}
