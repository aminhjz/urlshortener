#!/bin/sh

./mvnw clean install
docker build . -t aminhjz/urlshortener