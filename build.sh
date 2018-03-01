#!/usr/bin/env bash

KARAF_DEPLOY_FOLDER="/Users/selingchen/Downloads/apache-karaf-4.0.10/deploy"

mvn clean install
mv ./target/twitter-api-3ks-1.0.0.war $KARAF_DEPLOY_FOLDER

echo "\nWAR file is moved to $KARAF_DEPLOY_FOLDER"
echo "Important: Please re-run feature:install war inside karaf"