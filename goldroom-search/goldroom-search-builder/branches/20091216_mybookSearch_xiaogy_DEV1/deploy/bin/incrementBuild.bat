cd ..
cd ..
call mvn package -Dmaven.test.skip=true
cd target
call java -jar goldroom-search-builder-0.0.1-SNAPSHOT-jar-with-dependencies.jar inc /home/intlbcds/work/index/ 5 8 23