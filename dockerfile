FROM openjdk:11
COPY target/dockerspring.jar dockerspring.jar
ENTRYPOINT ["java","-jar","dockerspring.jar"]