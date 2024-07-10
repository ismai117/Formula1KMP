import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion
import org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalDistributionDsl
import org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kotlinx.serialization)
}

kotlin {

    js(IR) {
        moduleName = "webApp"
        browser {
            @OptIn(ExperimentalDistributionDsl::class)
            distribution {
                outputDirectory.set(projectDir.resolve("output"))
            }
        }
        binaries.executable()
    }

    @OptIn(org.jetbrains.kotlin.gradle.ExperimentalWasmDsl::class)
    wasmJs {
        moduleName = "webApp"
        browser {
            commonWebpackConfig {
                outputFileName = "webApp.js"
            }
        }
        binaries.executable()
    }

    @OptIn(ExperimentalKotlinGradlePluginApi::class)
    compilerOptions {
        languageVersion.set(KotlinVersion.KOTLIN_2_0)
    }

    sourceSets {

        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodel.compose)
            implementation(libs.androidx.navigation.compose)
            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.kotlinx.serialization.json)
            implementation(libs.bundles.ktor.common)
            implementation(libs.bundles.koin.common)
            implementation(libs.napier)
            implementation(libs.multiplatformSettings)
            implementation(libs.bundles.coil.common)
            implementation(libs.colormath)
            implementation(libs.colormath.compose)
            implementation(libs.constraintlayout)
            implementation("dev.chrisbanes.material3:material3-window-size-class-multiplatform:0.5.0")
        }

        jsMain.dependencies {
            implementation(libs.ktor.client.js)
        }

    }
}

