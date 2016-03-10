Proof-of-Concept for Apache Cassandra

[![Build Status](https://travis-ci.org/ddubson/cassandra-poc.svg?branch=master)](https://travis-ci.org/ddubson/cassandra-poc)

# Premise

Movie listing app that lets you view/list movies, search for movies, add movies, favorite movies, rate movies, etc.

# Technologies used
1. SBT 0.13.11
2. Spring Boot 1.3.2
3. Spring Framework 4.2.4
4. Apache Cassandra (v2.2.5, DataStax driver: 2.1.9)
5. Spring Data Cassandra (TBD)
6. AngularJS (TBD)
7. Twitter Bootstrap (TBD)

# Application running instructions
1. Start Apache Cassandra (v2.2.5) local cluster
1. Start App by: **./activator clean run**

# Development environment setup
- Apache Cassandra
    1. Get latest Docker
    2. Execute "docker build ." which builds the Docker image from Dockerfile