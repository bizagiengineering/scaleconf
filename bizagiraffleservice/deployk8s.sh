#!/bin/bash

echo "Delete previous deployment and service"
kubectl delete deployment,service scaleconf --ignore-not-found --now

echo "Create Kubernetes deployment"
kubectl create -f scaleconf.yaml

echo "Expose Kubernetes deployment"
kubectl expose deployments scaleconf --port=8080 --target-port=8080 --type=LoadBalancer