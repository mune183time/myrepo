FROM adoptopenjdk/openjdk11:slim
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} SpringBootDocker.jar
ENTRYPOINT ["java","-jar","/SpringBootDocker.jar"]
