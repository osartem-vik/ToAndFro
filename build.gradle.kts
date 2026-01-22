plugins {
    id("java")
    id("org.springframework.boot") version "3.3.4"
    id("io.spring.dependency-management") version "1.1.6"
}

group = "com.ToAndFro"
version = "1.0-SNAPSHOT"


val lombokVersion = "1.18.42"
//val junitVersion = "5.11.3"
//val mockitoVersion = "5.18.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("mysql:mysql-connector-java")
//    implementation("ch.qos.logback:logback-classic:1.4.11")
//    implementation("org.slf4j:slf4j-api:2.0.7")

    compileOnly("org.projectlombok:lombok:${lombokVersion}")
    annotationProcessor("org.projectlombok:lombok:${lombokVersion}")
    testCompileOnly("org.projectlombok:lombok:${lombokVersion}")
    testAnnotationProcessor("org.projectlombok:lombok:${lombokVersion}")

//    testImplementation(platform("org.junit:junit-bom:${junitVersion}"))
//    testImplementation("org.junit.jupiter:junit-jupiter")
//    testImplementation("org.mockito:mockito-core:${mockitoVersion}")
//    testImplementation("org.mockito:mockito-junit-jupiter:${mockitoVersion}")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.test {
    useJUnitPlatform()
}