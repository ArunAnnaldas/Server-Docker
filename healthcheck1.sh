#!/usr/bin/env bash
# Environment Variables
# HUB_HOST
# BROWSER
# MODULE

echo "Checking if hub is ready - $HUB_HOST"

#while [ "$( curl -s http://172.20.10.5:4444/wd/hub/status | jq -r .value.ready )" != "true" ]
#do
#	sleep 1
#done

# start the java command
java -cp selenium-docker.jar:selenium-docker-tests.jar:libs/* \
    -DHUB_HOST=172.20.10.5 \
    -DBROWSER=chrome \
    org.testng.TestNG search-module.xml