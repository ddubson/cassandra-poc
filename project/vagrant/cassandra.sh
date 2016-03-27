#!/usr/bin/env bash
sudo echo "deb http://www.apache.org/dist/cassandra/debian 22x main" | sudo tee -a /etc/apt/sources.list.d/cassandra.sources.list

sudo gpg --keyserver pgp.mit.edu --recv-keys F758CE318D77295D
sudo gpg --export --armor F758CE318D77295D | sudo apt-key add -

sudo gpg --keyserver pgp.mit.edu --recv-keys 2B5C1B00
sudo gpg --export --armor 2B5C1B00 | sudo apt-key add -

sudo gpg --keyserver pgp.mit.edu --recv-keys 0353B12C
sudo gpg --export --armor 0353B12C | sudo apt-key add -

sudo apt-get update
sudo apt-get install -y cassandra
sudo service cassandra stop
sudo sed -i 's/CMD_PATT="Dcassandra-pidfile=.*cassandra\.pid"/CMD_PATT="cassandra"/g' /etc/init.d/cassandra
sudo sed -i 's/rpc_address: localhost/rpc_address: 192.168.33.10/g' /etc/cassandra/cassandra.yaml
sudo update-rc.d cassandra defaults 95 10
sudo service cassandra start