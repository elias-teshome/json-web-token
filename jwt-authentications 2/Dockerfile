FROM openjdk:latest
EXPOSE 8080
ADD target/jwt-tdd-docker.jar jwt-tdd-docker.jar
ENTRYPOINT ["java","-jar","/jwt-tdd-docker.jar"]
# after install this
# go to the project and type docker build -t name of jar dot(.)