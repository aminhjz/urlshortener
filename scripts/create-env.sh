minikube start --driver="docker"
minikube addons enable ingress

helm repo add bitnami https://charts.bitnami.com/bitnami
helm upgrade -i zookeeper bitnami/zookeeper

#setup cassandra init db configmap
kubectl apply -f ./environment/cassandra/initdb-configmap.yaml
helm upgrade -i tinydb bitnami/cassandra -f ./environment/cassandra/values.yaml