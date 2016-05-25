FROM ubuntu:16.04
MAINTAINER Dmitriy Dubson <d.dubson@gmail.com>

# Set environment varibles
ENV workspace /opt/filmfox
ENV version 0.1-alpha

# Open port 8080 for embedded Tomcat container
EXPOSE 8080

# Install JDK8
RUN apt-get update && apt-get install -y openjdk-8-jdk dos2unix && export JAVA_HOME=/usr/java/default/

ADD . ${workspace}
WORKDIR ${workspace}
RUN rm -rf ${workspace}/build && dos2unix ${workspace}/gradlew && chmod +x ${workspace}/gradlew && bash ${workspace}/gradlew build
RUN java -jar ${workspace}/build/libs/film-fox-${version}.jar
