FROM openjdk:8u201-jdk-alpine3.9

ENV LANG=C.UTF-8 LC_ALL=C.UTF-8

VOLUME /tmp

ADD target/_01SpringSecurityDemo01-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]

EXPOSE 8081