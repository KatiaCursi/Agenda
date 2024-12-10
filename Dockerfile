FROM maven:4.0.0-openjdk-17-slim AS build
COPY . /home/app/Agenda
RUN mvn -v
RUN mvn -f /home/app/Agenda/pom.xml clean package

#Step 2 - Run appointment-backend
FROM openjdk:17-slim
COPY --from=build /home/app/Agenda/target/*.jar /usr/local/lib/Agenda.jar
VOLUME /tmp
EXPOSE 8080:8080
ENTRYPOINT ["java", "-jar", "/usr/local/lib/Agenda.jar"]
