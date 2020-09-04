gradle -Puser=stephanmg -Pkey=$BINTRAY_API_TOKEN jar
gradle -Puser=stephanmg -Pkey=$BINTRAY_API_TOKEN bundle
gradle -Puser=stephanmg -Pkey=$BINTRAY_API_TOKEN bintrayUpload
