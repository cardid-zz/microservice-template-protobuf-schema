import java.util.Properties

plugins {
    java
    kotlin("jvm") version "1.8.20"
    `maven-publish`
}

val props = Properties()
val propertiesFile = file("$rootDir/local.properties")
if (propertiesFile.exists()) {
    propertiesFile.inputStream().use { props.load(it) }
}

val springVersion by extra { "2.6.0" }
val vertxVersion by extra { "4.2.1" }
val grpcVersion by extra { "1.50.1" }


group = "info.test"

repositories {
    mavenCentral()
}

sourceSets {
    main {
        java.srcDirs("$project.rootDir/gen/java")
    }
}

java {
    // Конфигурация Java, если нужна
}

tasks.compileKotlin {
    // Конфигурация компиляции Kotlin, если нужна
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("javax.annotation:javax.annotation-api:1.3.2")

    api("org.jetbrains.kotlinx:kotlinx-coroutines-slf4j:1.6.4")
    api("io.vertx:vertx-grpc:$vertxVersion") {
        exclude(group = "io.grpc", module = "grpc-protobuf")
    }
    api("io.vertx:vertx-lang-kotlin-coroutines:$vertxVersion")
    api("io.grpc:grpc-protobuf:$grpcVersion")
    api("io.grpc:grpc-stub:$grpcVersion")
    api("io.grpc:grpc-netty:$grpcVersion")
}

repositories {
    mavenLocal()

    val nexusUsername = props.getProperty("nexus.username") ?: System.getenv("NEXUS_USERNAME")
    val nexusPassword = props.getProperty("nexus.password") ?: System.getenv("NEXUS_PASSWORD")
    val nexusCentral = props.getProperty("nexus.central") ?: System.getenv("NEXUS_CENTRAL")
    val nexusSnapshots = props.getProperty("nexus.snapshots") ?: System.getenv("NEXUS_SNAPSHOTS")
    val nexusReleases = props.getProperty("nexus.releases") ?: System.getenv("NEXUS_RELEASES")


    fun RepositoryHandler.addNexusRepository(nexusUrl: String?, u: String?, p: String?) {
        nexusUrl?.takeIf { it.isNotBlank() }?.let { repoUrl ->
            maven {
                url = uri(repoUrl)
                credentials {
                    username = u
                    password = p
                }
            }
        }
    }

    addNexusRepository(nexusCentral, nexusUsername, nexusPassword)
    addNexusRepository(nexusSnapshots, nexusUsername, nexusPassword)
    addNexusRepository(nexusReleases, nexusUsername, nexusPassword)


    publishing {
        repositories {
            addNexusRepository(nexusReleases, nexusUsername, nexusPassword)
        }

        publications {
            create<MavenPublication>("maven") {
                groupId = "info.test"
                artifactId = "protojava"
                version = project.property("version") as String
                from(components["java"])
            }
        }

    }
}