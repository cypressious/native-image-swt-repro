plugins {
    kotlin("jvm") version "1.8.0"
    application
    id("org.graalvm.buildtools.native") version "0.9.19"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.eclipse.swt:org.eclipse.swt.win32.win32.x86_64:4.3")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
}

application {
    mainClass.set("info.rakhman.native_repro.MainKt")
}
