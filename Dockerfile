FROM openjdk:8u191-jre-alpine

RUN apk add curl jq

#workspace
WORKDIR /usr/share/workspace

# ADD .jar under target from host into this image
ADD target/selenium-docker.jar			selenium-docker.jar
ADD target/selenium-docker-tests.jar	selenium-docker-tests.jar
ADD target/libs							libs

# All the dependencies should be added here
# ADD suite files
ADD bookFlight-module.xml	bookFlight-module.xml
ADD search-module.xml		search-module.xml

#ADD health check script
ADD healthcheck1.sh			healthcheck1.sh

# BROWSER
# HUB_HOST
# MODULE

ENTRYPOINT sh healthcheck1.sh
