plugins {
    id("java")
    application
}

application {
    mainClass.set("org.iakimova.robot.Main")
}

group = "org.iakimova.robot"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}