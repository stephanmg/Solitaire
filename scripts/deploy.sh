#!/bin/bash

wget https://services.gradle.org/distributions/gradle-6.6.1-bin.zip
unzip gradle-6.6.1-bin.zip
./gradle-6.6.1/bin/gradle -Puser=stephanmg -Pkey=$BINTRAY_API_TOKEN bintrayUpload
