FROM openjdk:11
EXPOSE 8080
COPY target/thymeleaf-0.0.1-SNAPSHOT.jar thymeleaf.jar
ENTRYPOINT ["java","-jar","/thymeleaf.jar"]