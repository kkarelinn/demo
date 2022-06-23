FROM openjdk:16-alpine
ADD /target/demo-1.0.war demo.war
COPY src/main/resources src/main/resources
EXPOSE 8888
ENTRYPOINT ["java", "-jar", "demo.war"]