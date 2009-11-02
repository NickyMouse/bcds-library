#!/bin/sh
cd ../..
~/program/maven/bin/mvn package -Dmaven.test.skip=true
cd target
INDEX_PATH=/home/intlbcds/work/index/
BUILD_INTERVAL_MINUTES=60
START_HOUR=0
END_HOUR=23
java -jar goldroom-search-builder-0.0.1-SNAPSHOT-jar-with-dependencies.jar full $INDEX_PATH $BUILD_INTERVAL_MINUTES $START_HOUR $END_HOUR
