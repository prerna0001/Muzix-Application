FROM openjdk:11-jdk-stretch

ADD /target/muzix-0.0.1-SNAPSHOT.jar /src/main/muzix-0.0.1-SNAPSHOT.jar
WORKDIR /src/main
ENTRYPOINT ["java","-jar","muzix-0.0.1-SNAPSHOT.jar"]