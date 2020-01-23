# Reference App - Kubernetes and Istio

[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)

This is a simple reference application, implemented in Spring boot. These applications are Dockerised using Jib. Jib is included within maven.

This app has 3 services:

- Product Service : Provides details about the product.
- Rating Service: Provides rating for the chosen product
- Composite Service: This is an aggregator microservice, which combines the results of other 2 services.

# Design

The high level architecture of this application is as follows:

![Application Architecture](ReferenceAppArchitecture.jpg)

- All 3 services are implemented in Spring Boot 2.
- Product service and Rating service are using in-memory H2 database. The data scripts are in the resources folder. (Note: data.sql is automatically picked up by Spring JPA and loaded to DB)
- Only read operations are enabled in all 3 services.

# Building the application

## Checkout the code

```
git checkout https://github.com/abhishekjawali/reference-app.git
cd reference-app
```

## Set environment variables

Jib makes it easy to push the image to image repository directly. I have used DockerHub here. Since Jib is configured within maven, it requires the image tag name. So these will have to be set as environment variables.

```
$ export PRODUCT_SERVICE_TAG=abhishekjv/product-service:v1
$ export RATING_SERVICE_TAG=abhishekjv/rating-service:v1
$ export COMPOSITE_SERVICE_TAG=abhishekjv/composite-service:v1
```

## Build and push the image to image repo

#### Product Service

```
$ cd product-service/
$ export PRODUCT_SERVICE_TAG=abhishekjv/product-service:v1
$ mvn clean install
$ mvn compile jib:build
```

#### Rating Service

```
$ cd rating-service/
$ export RATING_SERVICE_TAG=abhishekjv/rating-service:v1
$ mvn clean install
$ mvn compile jib:build
```

#### Composite Service

```
$ cd composite-service/
$ export COMPOSITE_SERVICE_TAG=abhishekjv/composite-service:v1
$ mvn clean install
$ mvn compile jib:build
```

## To run locally

To run these applications locally as normal Spring boot application, use the profile 'dev'

```
java -jar product-service/target/product-service.jar --spring.profiles.active=dev &
java -jar rating-service/target/rating-service.jar --spring.profiles.active=dev &
java -jar composite-service/target/composite-service.jar --spring.profiles.active=dev &
```

### Get the product from product-service

```
curl localhost:9090/product/1 | jq .
```

### Get the rating of this product from rating-service

```
curl localhost:9091/rating/product/1 | jq .
```

### Use the composite service to get the product details, along with rating

```
curl localhost:9093/product/1 | jq .
```

## Next steps

1. To run the same application in Kubernetes cluster
2. To use Istio for traffic management, MASSL and telemetry
3. To use Ambassador gateway
   Refer to [Kubernetes Manifests folder to run in Kubernetes](./kubernetes-maniests)
