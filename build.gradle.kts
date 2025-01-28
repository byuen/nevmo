plugins {
    id("org.springframework.boot") version "3.3.0"
    id("java")
}

group = "com.capitalized"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation ("org.springframework.boot:spring-boot-starter-actuator:3.4.1")
    implementation ("org.springframework.boot:spring-boot-starter-web:3.4.1")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.4.1")
    testImplementation("org.springframework.boot:spring-boot-starter-test:3.4.1")

    compileOnly("org.projectlombok:lombok:1.18.36")
    annotationProcessor("org.projectlombok:lombok:1.18.36")

    testCompileOnly("org.projectlombok:lombok:1.18.36")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.36")
    runtimeOnly("com.h2database:h2:2.3.232")

    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.8.3")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")

}

tasks.test {
    useJUnitPlatform()
}