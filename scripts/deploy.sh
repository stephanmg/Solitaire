#!/bin/bash

wget https://services.gradle.org/distributions/gradle-6.6.1-bin.zip
unzip gradle-6.6.1-bin.zip
ls -l
./gradle-6.6.1/bin/gradle -Puser=stephanmg -Pkey=$BINTRAY_API_TOKEN -Psha=$(git rev-parse HEAD) jar
./gradle-6.6.1/bin/gradle -Puser=stephanmg -Pkey=$BINTRAY_API_TOKEN -Psha=$(git rev-parse HEAD) bundle
./gradle-6.6.1/bin/gradle -Puser=stephanmg -Pkey=$BINTRAY_API_TOKEN -Psha=$(git rev-parse HEAD) bintrayUpload
ls -l
