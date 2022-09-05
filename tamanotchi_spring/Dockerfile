FROM openjdk:18

EXPOSE 8080

RUN mkdir app

WORKDIR /app

COPY target/*.jar ./app.jar

CMD ["java", "-jar", "./app.jar"]