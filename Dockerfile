FROM openjdk:8u191-jre-alpine

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

# BROWSER
# HUB_HOST
# MODULE
ENTRYPOINT java -cp selenium-docker.jar:selenium-docker-tests.jar:libs/* -DBROWSER=$BROWSER -DHUB_HOST=$HUB_HOST org.testng.TestNG $MODULE
