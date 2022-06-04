plugins {
    id("org.jetbrains.kotlin.jvm") version "1.6.21"
    id("org.jetbrains.kotlin.kapt") version "1.6.21"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.6.21"
    id("com.github.johnrengelman.shadow") version "7.1.2"
    id("io.micronaut.application") version "3.4.1"
}

version = "0.1"
group = "com.ere.pgk"

val kotlinVersion = project.properties.get("kotlinVersion")
repositories {
    mavenCentral()
}

dependencies {
    kapt("io.micronaut:micronaut-http-validation:3.4.4")
    kapt("io.micronaut.openapi:micronaut-openapi:4.0.1")
    implementation("io.micronaut:micronaut-validation:3.4.4")
    implementation("io.micronaut:micronaut-http-client:3.4.4")
    implementation("io.micronaut:micronaut-jackson-databind:3.4.4")
    implementation("io.micronaut.beanvalidation:micronaut-hibernate-validator:3.0.0")
    implementation("io.micronaut.cache:micronaut-cache-caffeine:3.4.1")
    implementation("io.micronaut.liquibase:micronaut-liquibase:5.3.0")
    implementation("io.micronaut.reactor:micronaut-reactor:2.2.2")
    implementation("io.micronaut.reactor:micronaut-reactor-http-client:2.2.2")
    implementation("io.micronaut.sql:micronaut-jdbc-hikari:4.4.0")
    implementation("io.micronaut.sql:micronaut-vertx-pg-client:4.4.0")
    implementation("io.swagger.core.v3:swagger-annotations:2.2.0")
    implementation("jakarta.annotation:jakarta.annotation-api:2.1.0")

    runtimeOnly("ch.qos.logback:logback-classic:1.2.11")
    runtimeOnly("org.postgresql:postgresql:42.3.4")
    implementation("com.ongres.scram:common:2.1")
    implementation("com.ongres.scram:client:2.1")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.2")
    runtimeOnly("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.3")
    implementation("org.jetbrains.kotlin:kotlin-reflect:${kotlinVersion}")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${kotlinVersion}")
    implementation("io.micronaut.kotlin:micronaut-kotlin-extension-functions:3.2.2")
    implementation("io.micronaut.kotlin:micronaut-kotlin-runtime:3.2.2")

    testImplementation("org.testcontainers:postgresql:1.17.1")
    testImplementation("org.testcontainers:testcontainers:1.17.1")
}


application {
    mainClass.set("com.ere.pgk.ApplicationKt")
}
java {
    sourceCompatibility = JavaVersion.toVersion("11")
}

tasks {
    compileKotlin {
        kotlinOptions {
            jvmTarget = "11"
        }
    }
    compileTestKotlin {
        kotlinOptions {
            jvmTarget = "11"
        }
    }
}
graalvmNative.toolchainDetection.set(false)
micronaut {
    runtime("netty")
    testRuntime("kotest")
    processing {
        incremental(true)
        annotations("com.ere.pgk.*")
    }
}



