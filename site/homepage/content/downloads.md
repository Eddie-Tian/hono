+++
title = "Downloads"
menu = "main"
linkTitle = "Download"
weight = 150
+++

## Binaries

Eclipse Hono's service components are provided by means of pre-built Docker images available from
[Docker Hub](https://hub.docker.com/u/eclipse/). These container images can be deployed to popular
container orchestration platforms like Kubernetes and OpenShift.

The [Eclipse IoT Packages](https://www.eclipse.org/packages/) project hosts the
[Hono Helm chart](https://github.com/eclipse/packages/tree/master/charts/hono)
which can be used to install the most recent release of Hono to a Kubernetes cluster
using the [Helm package manager](https://helm.sh).
Please refer to the [deployment guide]({{% doclink "/deployment/helm-based-deployment/" %}})
for installation instructions.

A Java based command line client for consuming telemetry data and events from Hono is available for download from

* [Eclipse Hono 1.2.2 Command Line Client](https://www.eclipse.org/downloads/download.php?file=/hono/hono-cli-1.2.2-exec.jar)

The client requires a Java 11 runtime environment to run.

Please refer to the [Admin Guide]({{% doclink "/admin-guide/hono-client-configuration/" %}}) for details regarding the command
line options that the client supports.

### Milestones

The newest features and bug fixes are available in *milestones* that are published every 4 -6 weeks.
Please note that these milestones represent the latest *state of development* which also means that APIs or features may
change from one milestone to the other. Milestones are mainly intended for testing purposes and should generally not
be used in a production environment.

* [Eclipse Hono 1.3.0-M2 Command Line Client](https://www.eclipse.org/downloads/download.php?file=/hono/hono-cli-1.3.0-M2-exec.jar)
* [Eclipse Hono 1.3.0-M1 Command Line Client](https://www.eclipse.org/downloads/download.php?file=/hono/hono-cli-1.3.0-M1-exec.jar)

Please refer to the *Using specific Container Images* section of [Hono's Helm chart](https://github.com/eclipse/packages/tree/master/charts/hono)
for information regarding the installation of milestone container images.

## Source Code

The source code can be cloned or downloaded from [Hono's GitHub repository](https://github.com/eclipse/hono).
The [Building from Source]({{% doclink "/dev-guide/building_hono/" %}}) guide provides instructions on how to build Hono locally.

## Release Notes

For a list of the changes in this release, take a look at the [release notes]({{< relref "release-notes" >}}).

## Previous versions

* [Eclipse Hono 1.2.1 Command Line Client](https://www.eclipse.org/downloads/download.php?file=/hono/hono-cli-1.2.1-exec.jar)
* [Eclipse Hono 1.2.0 Command Line Client](https://www.eclipse.org/downloads/download.php?file=/hono/hono-cli-1.2.0-exec.jar)
* [Eclipse Hono 1.1.2 Command Line Client](https://www.eclipse.org/downloads/download.php?file=/hono/hono-cli-1.1.2-exec.jar)
* [Eclipse Hono 1.1.1 Command Line Client](https://www.eclipse.org/downloads/download.php?file=/hono/hono-cli-1.1.1-exec.jar)
* [Eclipse Hono 1.1.0 Command Line Client](https://www.eclipse.org/downloads/download.php?file=/hono/hono-cli-1.1.0-exec.jar)
* [Eclipse Hono 1.0.4 Helm Chart](https://www.eclipse.org/downloads/download.php?file=/hono/eclipse-hono-1.0.4-chart.tar.gz)
* [Eclipse Hono 1.0.4 Command Line Client](https://www.eclipse.org/downloads/download.php?file=/hono/hono-cli-1.0.4-exec.jar)
* [Eclipse Hono 1.0.3 Helm Chart](https://www.eclipse.org/downloads/download.php?file=/hono/eclipse-hono-1.0.3-chart.tar.gz)
* [Eclipse Hono 1.0.3 Command Line Client](https://www.eclipse.org/downloads/download.php?file=/hono/hono-cli-1.0.3-exec.jar)
* [Eclipse Hono 1.0.2 Helm Chart](https://www.eclipse.org/downloads/download.php?file=/hono/eclipse-hono-1.0.2-chart.tar.gz)
* [Eclipse Hono 1.0.2 Command Line Client](https://www.eclipse.org/downloads/download.php?file=/hono/hono-cli-1.0.2-exec.jar)
* [Eclipse Hono 1.0.1 Helm Chart](https://www.eclipse.org/downloads/download.php?file=/hono/eclipse-hono-1.0.1-chart.tar.gz)
* [Eclipse Hono 1.0.1 Command Line Client](https://www.eclipse.org/downloads/download.php?file=/hono/hono-cli-1.0.1-exec.jar)
* [Eclipse Hono 1.0.0 Archive](https://www.eclipse.org/downloads/download.php?file=/hono/eclipse-hono-1.0.0-chart.tar.gz)
* [Eclipse Hono 1.0.0 Command Line Client](https://www.eclipse.org/downloads/download.php?file=/hono/hono-cli-1.0.0-exec.jar)
