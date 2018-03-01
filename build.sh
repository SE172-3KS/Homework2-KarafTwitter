#!/usr/bin/env bash

KARAF_DEPLOY_FOLDER="<PATH_TO_KARAF_DEPLOY_FOLDER>"

mvn clean install
mv ./target/hello-world-war-1.0.0.war $KARAF_DEPLOY_FOLDER

echo "\nWAR file is moved to $KARAF_DEPLOY_FOLDER"
echo "Important: Please re-run feature:install war inside karaf"