#!/bin/sh

export POD_NAME=$(kubectl get pods --namespace default -l "app.kubernetes.io/name=zookeeper,app.kubernetes.io/instance=my-release,app.kubernetes.io/component=zookeeper" -o jsonpath="{.items[0].metadata.name}")
    kubectl exec -it $POD_NAME -- zkCli.sh
