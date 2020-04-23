FROM java:8-jdk-alpine

COPY ./target/composite-service.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch composite-service.jar'

ENTRYPOINT ["java","-Dspring.profiles.active=k8s","-jar","composite-service.jar"]