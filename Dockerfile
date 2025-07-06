FROM openjdk:21-jdk
COPY build/libs/algoarena-0.0.1-SNAPSHOT.jar algoarena.jar
CMD ["java", "-jar", "algoarena.jar"]