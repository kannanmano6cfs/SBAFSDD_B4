From openjdk:21-slim

WORKDIR /app

Copy target/ExKubedemo-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8091

ENTRYPOINT ["java","-jar","app.jar"]