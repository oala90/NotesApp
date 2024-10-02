// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    dependencies {
        classpath(libs.hilt.android.gradle.plugin)
        classpath (libs.kotlin.gradle.plugin)

    }
}

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    alias(libs.plugins.compose.compiler) apply false
    id("com.google.dagger.hilt.android") version "2.44" apply false
    id("com.google.devtools.ksp") version "2.0.20-1.0.24" apply false
    kotlin("kapt") version "2.0.20"
}