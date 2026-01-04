plugins {
  id("org.jetbrains.intellij") version "1.15.0"
  id("me.filippov.gradle.jvm.wrapper") version "0.14.0"
}

version = "1.0.2"

repositories {
  mavenCentral()
}

intellij {
  version.set("2025.3")
  type.set("IC")
}

tasks {
  withType<JavaCompile> {
    sourceCompatibility = "17"
    targetCompatibility = "17"
  }

  patchPluginXml {
    sinceBuild.set("253")
    untilBuild.set("253.*")
  }

  buildSearchableOptions {
    enabled = false
  }

  publishPlugin {
    token.set(System.getenv("PUBLISH_TOKEN"))
  }
}
