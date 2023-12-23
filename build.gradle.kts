plugins {
    id("java")
}

group = "oev"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.testng:testng:7.8.0")
    testImplementation("ch.qos.logback:logback-classic:1.4.12")
    testImplementation("com.codeborne:selenide:7.0.4")
}

tasks.test {
    useTestNG()
}