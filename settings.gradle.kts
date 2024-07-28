rootProject.name = "Formula1KMP"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        gradlePluginPortal()
        maven("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/dev/")
    }
}

dependencyResolutionManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/ktor/eap")
        maven("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/dev/")
    }
}

include(
    ":app",
    ":core:base",
    ":core:network",
    ":core:model",
    ":core:ui",
    ":core:utils",
    ":feature:starter:di",
    ":feature:starter:data",
    ":feature:starter:domain",
    ":feature:starter:presentation",
    ":feature:drivers:di",
    ":feature:drivers:data",
    ":feature:drivers:domain",
    ":feature:drivers:presentation",
    ":feature:teams:di",
    ":feature:teams:data",
    ":feature:teams:domain",
    ":feature:teams:presentation",
    ":androidApp",
    ":desktopApp",
    ":webApp"
)

