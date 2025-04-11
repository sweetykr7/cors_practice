plugins {
    id("java")
    id("maven-publish")
}

group = "me.nettee"
version = "0.1.0-rc3"

repositories {
    mavenCentral()
}

dependencies {
    // Choose: api("org.springframework:spring-webmvc") vs
    // compileOnly("org.springframework:spring-webmvc")
    compileOnly("org.springframework:spring-webmvc:6.2.2")
    compileOnly("org.springframework.boot:spring-boot-autoconfigure:3.4.2")

    implementation("org.springframework.boot:spring-boot-starter-web:3.4.2")
}

tasks.test {
    useJUnitPlatform()
}

// [2] Add task script to publish
publishing {
    publications {
        //
        create<MavenPublication>("cors-core") {
            from(components["java"])
            groupId = "com.github.sweetykr7"
            artifactId = project.name
            version = project.version.toString()
        }
    }
}

tasks.publishToMavenLocal.configure {
    // assemble 작업 후 publishToMavenLocal 실행
    //  assemble: 프로젝트의 아티팩트를 생성합니다. (jar 파일 등)
    //  publishToMavenLocal: 빌드된 아티팩트를 로컬 저장소에 저장합니다. (.m2/repository)
    dependsOn("assemble")
}

//tasks.bootJar {
//    enabled = false
//}

tasks.jar {
    enabled = true
    archiveClassifier.set("") // remove suffix "-plain"
    // 다운로드 하려는 파일 이름: example-error-code-api-0.1.0.jar
    // 위 명령 누락 때 파일 이름: example-error-code-api-0.1.0-plain.jar
}

//test