#!/bin/bash

echo "Delete previous deployment and service"
kubectl delete deployment scaleconf --ignore-not-found --now

echo "Create Kubernetes deployment"
kubectl create -f scaleconf.yaml

echo "Expose Kubernetes deployment"
