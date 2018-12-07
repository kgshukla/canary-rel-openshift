#!/bin/sh

# backend-main runs the application and canary. backend-main-build runs build jobs and store images
oc new-project backend-main
oc new-project backend-main-build

# frontend-main runs the application and canary. frontend-main-build runs build jobs and store images
oc new-project frontend-main
oc new-project frontend-main-build

# cicd project runs jenkins
oc new-project cicd
oc process jenkins-ephemeral -n openshift | oc create -f -
sleep 75
