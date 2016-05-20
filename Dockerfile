FROM ubuntu:16.04
MAINTAINER Dmitriy Dubson <d.dubson@gmail.com>

# Set environment varibles
ENV workspace /opt/filmfox
ENV version 0.1-alpha
ENV runcmd java -jar ${workspace}/film-fox-${version}.jar

# Open port 8080 for embedded Tomcat container
EXPOSE 8080

# Install JDK8
RUN apt-get update && apt-get install -y openjdk-8-jre

ADD . ${workspace}
WORKDIR ${workspace}
RUN sh ${workspace}/gradlew build
CMD ${runcmd}
