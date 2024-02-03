import com.varabyte.kobweb.gradle.application.util.configAsKobwebApplication
import kotlinx.html.link

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.kobweb.application)
    // alias(libs.plugins.kobwebx.markdown)
}

group = "nl.nickkoepr.site"
version = "1.0-SNAPSHOT"

kobweb {
    app {
        index {

            head.add {
                link(rel = "stylesheet", href = "/fonts/faces.css")
            }

            description.set("Powered by Kobweb")
        }
    }
}

kotlin {
    configAsKobwebApplication("site")

    sourceSets {
        commonMain.dependencies {
            implementation(compose.runtime)
        }

        jsMain.dependencies {
            implementation(compose.html.core)
            implementation(libs.kobweb.core)
            implementation(libs.kobweb.silk)
            implementation(libs.silk.icons.fa)
            // implementation(libs.kobwebx.markdown)
            
        }
    }
}
