FROM ubuntu:16.04
MAINTAINER Dmitriy Dubson <d.dubson@gmail.com>

RUN apt-get update && apt-get install -y openjdk-8-jre
COPY build/libs/film-fox-0.1-alpha.jar /opt/
EXPOSE 8080
RUN echo 'java -jar /opt/film-fox-0.1-alpha.jar' > /opt/launch.sh && chmod +x /opt/launch.sh
ENTRYPOINT /opt/launch.sh