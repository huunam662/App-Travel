FROM openjdk:21-jdk

WORKDIR /app

COPY ./build/libs/travel-0.0.1-SNAPSHOT.jar /app

RUN ./gradlew clean build

EXPOSE 8080

ENTRYPOINT ["java", "-cp", "app:app/lib/*"]