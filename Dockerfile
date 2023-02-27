FROM adoptopenjdk:16-jre
COPY target/CovidVaccination*.jar   /app.jar
CMD java -jar /app.jar