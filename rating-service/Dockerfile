FROM java:8-jdk-alpine

COPY ./target/rating-service.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch rating-service.jar'

ENTRYPOINT ["java","-jar","rating-service.jar"]