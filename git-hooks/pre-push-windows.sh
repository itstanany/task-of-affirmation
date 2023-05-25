#!C:/Program\ Files/Git/usr/bin/sh.exe
pre-push.sh
echo "Running Static Analysis"

./gradlew ktlintCheck
./gradlew detekt