FROM ubuntu:16.04
MAINTAINER Dmitriy Dubson <d.dubson@gmail.com>

# Set environment varibles
ENV version 0.1-alpha
ENV runcmd java -jar /opt/film-fox-${version}.jar

# Install JDK8
RUN apt-get update && apt-get install -y openjdk-8-jre

# Copy the binary to /opt directory
COPY build/libs/film-fox-${version}.jar /opt/

# Open port 8080 for embedded Tomcat container
EXPOSE 8080

# Create the launch script
RUN echo ${runcmd} > /opt/launch.sh && chmod +x /opt/launch.sh

# Set launch script to fire off when docker launches container
ENTRYPOINT /opt/launch.sh