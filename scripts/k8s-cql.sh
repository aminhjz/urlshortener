#!/bin/sh

export CASSANDRA_PASSWORD=$(kubectl get secret --namespace default cassandra -o jsonpath="{.data.cassandra-password}" | base64 --decode)

kubectl run --namespace default cassandra-client --rm --tty -i --restart='Never' \
   --env CASSANDRA_PASSWORD=$CASSANDRA_PASSWORD \
    \
   --image docker.io/bitnami/cassandra:3.11.9-debian-10-r52 -- bash

cqlsh -u tiny -p $CASSANDRA_PASSWORD cassandra