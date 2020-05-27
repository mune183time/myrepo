FROM adoptopenjdk/openjdk11:slim
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} SpringBootGrpc.jar
ENTRYPOINT ["java","-jar","/SpringBootGrpc.jar"]
