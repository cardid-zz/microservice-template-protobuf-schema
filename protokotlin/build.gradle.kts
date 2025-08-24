import com.google.protobuf.gradle.id
import java.util.Properties

plugins {
    kotlin("jvm") version "1.8.20"
    application
    id("maven-publish")
    id("com.google.protobuf") version "0.9.4"
}

group = "info.test"

dependencies {
    api("com.google.protobuf:protobuf-java:3.22.2")

    api("io.grpc:grpc-kotlin-stub:1.4.1")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    implementation("io.github.mscheong01:krotoDC-core:1.0.5")

    api("io.grpc:grpc-protobuf:1.54.0")
    runtimeOnly("io.grpc:grpc-netty:1.54.0")

    implementation("io.github.microutils:kotlin-logging:1.12.5")
    implementation("org.slf4j:slf4j-api:1.7.32")
}

kotlin {
    jvmToolchain(17)
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:3.22.0"
    }

    plugins {
        id("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:1.54.0"
        }
        id("krotoDC") {
            artifact = "io.github.mscheong01:protoc-gen-krotoDC:1.0.5:jdk8@jar"
        }
    }

    // Указываем пути к папкам с файлами Proto
    sourceSets.getByName("main") {
        proto {
            srcDir("${buildDir}/my-proto")
        }
    }

    generateProtoTasks {
        all().forEach {
            if (it.name == "generateProto") {
                copyProto() // копирует прото файлы в папку из которой будут генерироваться файлы
            }

            it.plugins {
                id("grpc")
                id("krotoDC")
            }
        }
    }
}

data class ProtoService(
    val dirName: String,
    val excludeFiles: List<String> = emptyList()
)

fun copyFolder(service: ProtoService) {
    val protoPath = File("$projectDir").parentFile.path
    val sourceDir = File("$protoPath/${service.dirName}")
    val targetDir = File("${buildDir}/my-proto/${service.dirName}")
    copyFilesRecursively(sourceDir, targetDir, service.excludeFiles)
}

fun copyFilesRecursively(sourceDir: File, targetDir: File, excludeFiles: List<String>) {
    println("Copy from $sourceDir to $targetDir")
    sourceDir.listFiles()?.forEach { file ->
        val targetFile = File(targetDir, file.name)
        if (!excludeFiles.contains(file.name)) {
            if (file.isDirectory) {
                targetFile.mkdir()
                copyFilesRecursively(file, targetFile, excludeFiles)
            } else {
                file.copyTo(targetFile, true)
            }
        }
    }
}

fun copyProto() {
    // В данный момент мы можем перечислить сервисы которые мы хотим чтобы использовались при генерации
    // так же можем указать какие файлы исключить, в данный момент наблюдается проблема для ряда API это
    // можно либо исправить либо забить и не использовать kroto для него
    val services = listOf(
        ProtoService("common"),
        ProtoService("gen"),
        ProtoService("google"),
        ProtoService("gradle"),
        ProtoService("options"),
    )

    services.forEach { copyFolder(it) }
}

repositories {
    mavenLocal()
}

// сборка исходников
tasks {
    val sourcesJar by creating(Jar::class) {
        archiveClassifier.set("sources")
        from(sourceSets["main"].allSource)
    }
}

val props = Properties()
val propertiesFile = file("$rootDir/local.properties")
if (propertiesFile.exists()) {
    propertiesFile.inputStream().use { props.load(it) }
}

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

repositories {
    mavenCentral()
    mavenLocal()

    addNexusRepository(nexusCentral, nexusUsername, nexusPassword)
    addNexusRepository(nexusSnapshots, nexusUsername, nexusPassword)
    addNexusRepository(nexusReleases, nexusUsername, nexusPassword)
}

publishing {
    repositories {
        addNexusRepository(nexusReleases, nexusUsername, nexusPassword)
    }

    publications {
        create<MavenPublication>("maven") {
            groupId = "info.test"
            artifactId = "protokotlin"
            version = project.properties["version"].toString()
            from(components["java"])
            artifact(tasks.named<Jar>("sourcesJar")) // деплой исходников в maven
        }
    }
}


