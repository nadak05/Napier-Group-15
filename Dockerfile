FROM openjdk:latest
#COPY ./target/seMethods-0.1.0.1-jar-with-dependencies.jar /tmp
COPY ./target/devops.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "devops.jar", "world:3306", "30000"]
#ENTRYPOINT ["java", "-jar", "seMethods-0.1.0.1-jar-with-dependencies.jar"]