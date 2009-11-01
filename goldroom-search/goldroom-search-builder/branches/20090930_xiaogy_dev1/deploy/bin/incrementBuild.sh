#!/bin/bash
cd ../..
mvn package -Dmaven.test.skip=true
cd target
INDEX_PATH=/home/admin/index/
BUILD_INTERVAL_MINUTES=5
START_HOUR=6
END_HOUR=23

java -jar goldroom-search-builder-0.0.1-SNAPSHOT-jar-with-dependencies.jar inc $INDEX_PATH $BUILD_INTERVAL_MINUTES $START_HOUR $END_HOUR