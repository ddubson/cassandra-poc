#!/usr/bin/env bash
sudo apt-get -y update
sudo apt-get install python-software-properties
sudo add-apt-repository ppa:webupd8team/java && apt-get update
sudo echo debconf shared/accepted-oracle-license-v1-1 select true | sudo debconf-set-selections
sudo echo debconf shared/accepted-oracle-license-v1-1 seen true | sudo debconf-set-selections
sudo apt-get install -y oracle-java8-installer
sudo echo "America/New_York" > /etc/timezone