#!/bin/sh

eval $(minikube -p minikube docker-env)
./scripts/build.sh
helm uninstall tiny
./scripts/deploy.sh