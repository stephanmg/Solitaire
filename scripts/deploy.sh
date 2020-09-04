./gradlew jar
./gradlew bundle
./gradlew -Puser=stephanmg -Pkey=$BINTRAY_API_TOKEN bintrayUpload
