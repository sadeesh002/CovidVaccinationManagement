FROM adoptopenjdk:16-jre
COPY CovidVaccination*.jar   /app.jar
CMD java -jar /app.jar