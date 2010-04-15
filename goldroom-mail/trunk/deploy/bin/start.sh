#!/bin/sh
cd ../..
~/program/maven/bin/mvn package -Dmaven.test.skip=true
cd target

java -jar goldroom-mail-0.0.1-SNAPSHOT-jar-with-dependencies.jar
