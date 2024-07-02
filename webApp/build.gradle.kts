import org.jetbrains.compose.ExperimentalComposeLibrary

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kotlinx.serialization)
    alias(libs.plugins.sqlDelight)
}

applyKtorWasmWorkaround("3.0.0-wasm2")

kotlin {
    js {
        browser()
        binaries.executable()
    }

//    wasmJs {
//        browser()
//        binaries.executable()
//    }

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
            implementation(libs.bundles.ktor.common)
            implementation(libs.kotlinx.serialization.json)
            implementation(libs.bundles.koin.common)
            implementation(libs.napier)
            implementation(libs.colormath)
            implementation(libs.colormath.compose)
            implementation(libs.constraintlayout)
            implementation(libs.multiplatformSettings)
            api("io.github.qdsfdhvh:image-loader:1.8.1")
            implementation(libs.bundles.sqlDelight.common)
        }

        commonTest.dependencies {
            implementation(libs.kotlin.test)
            @OptIn(ExperimentalComposeLibrary::class)
            implementation(compose.uiTest)
            implementation(libs.kotlinx.coroutines.test)
        }

        jsMain.dependencies {
            implementation(compose.html.core)
            implementation(libs.ktor.client.js)
            implementation(libs.sqlDelight.driver.js)
            implementation(devNpm("copy-webpack-plugin", "9.1.0"))
        }

    }
}

compose.experimental {
    web.application {}
}

fun Project.applyKtorWasmWorkaround(version: String) {
    configurations.all {
        if (name.startsWith("wasmJs")) {
            resolutionStrategy.eachDependency {
                if (requested.group.startsWith("io.ktor") &&
                    requested.name.startsWith("ktor-")
                ) {
                    useVersion(version)
                }
            }
        }
    }
}

sqldelight {
    databases {
        create("AppDatabase") {
            // Database configuration here.
            // https://cashapp.github.io/sqldelight
            packageName.set("org.ncgroup.formula1kmp.db")
        }
    }
}
