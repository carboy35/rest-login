FROM adoptopenjdk/openjdk8:alpine-jre
ADD target/rest-login-0.0.1.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]