#!/usr/bin/env bash
sudo wget -qO - https://packages.elastic.co/GPG-KEY-elasticsearch | sudo apt-key add -
echo "deb http://packages.elastic.co/elasticsearch/2.x/debian stable main" | sudo tee -a /etc/apt/sources.list.d/elasticsearch-2.x.list
sudo apt-get update
sudo apt-get install -y elasticsearch

# Bind to current host
sudo echo "network.bind_host: 0" >> /etc/elasticsearch/elasticsearch.yml

# Disable node discovery for local environments
sudo echo "discovery.zen.ping.multicast.enabled: false" >> /etc/elasticsearch/elasticsearch.yml
sudo echo "discovery.zen.ping.unicast.hosts: [\"127.0.0.1\"]" >> /etc/elasticsearch/elasticsearch.yml

# Make Daemon executable
sudo chmod +x /etc/init.d/elasticsearch

# Install as service
sudo update-rc.d elasticsearch defaults 95 10

# Start service by default
service elasticsearch start