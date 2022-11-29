#!/bin/sh

docker run --rm \
    -v $1:/test/ \
    -w /test \
    openjdk:17-jdk \
    javac demo.java