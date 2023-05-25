#!/bin/bash

pre-push.sh
echo "Running Static Analysis"

./gradlew ktlintCheck
./gradlew detekt