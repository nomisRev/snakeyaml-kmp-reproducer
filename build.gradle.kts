plugins {
    kotlin("jvm") version "1.9.23"
}

group = "io.github.nomisrev"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
  implementation("org.yaml:snakeyaml:2.1")
  implementation("it.krzeminski:snakeyaml-engine-kmp:3.0.0")
  implementation("com.charleskorn.kaml:kaml:0.60.0")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}