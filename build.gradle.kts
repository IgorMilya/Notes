// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.3" apply false
    id ("com.android.library") version "7.1.2" apply false
    id ("org.jetbrains.kotlin.android") version "1.6.10" apply false
    id ("org.jetbrains.kotlin.kapt") version "1.6.20" apply false
}

buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("io.realm:realm-gradle-plugin:10.17.0")
        classpath ("com.android.tools.build:gradle:7.0.0")
    }
}


task("clean", type = Delete::class) {
    delete(rootProject.buildDir)
}
