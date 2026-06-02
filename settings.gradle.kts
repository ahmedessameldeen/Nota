pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Nota"

include(":core:domain")
include(":core:database")
include(":core:ui")
include(":feature:notes")
include(":androidApp")
