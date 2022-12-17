#!/bin/sh

docker run --rm \
    -v /$1/*.jar:/work.jar \
    openjdk:17 \
    java -jar /work.jar