## FilmFox

[![Build Status](https://travis-ci.org/ddubson/film-fox.svg?branch=master)](https://travis-ci.org/ddubson/film-fox)
[![Code Climate](https://codeclimate.com/github/ddubson/film-fox/badges/gpa.svg)](https://codeclimate.com/github/ddubson/film-fox)

### Premise

Movie listing app that lets you view/list movies, search for movies, add movies, favorite movies, rate movies, etc. More details to come.

### Running instructions
1. Start Apache Cassandra (v2.2.5) local cluster
2. Start App by running: **sbt clean run** (You can also use built in Typesafe activator as an alternative)

### Development environment setup
- Run Vagrant included in this repository to set up a single-node Elasticsearch and Cassandra instance cluster

***
### The Stack
#### Build
* SBT 0.13.11
* Vagrant 1.8.1
#### Container
* Spring Boot 1.3.2
#### Dependency Injection
* Spring Framework 4.2.4
#### Data Persistence
* Apache Cassandra 2.2.5 (Spring Data Cassandra 1.3.4)
* Elasticsearch 2.2.1 (Native Java Client)
#### Front End
* Bower
* AngularJS 1.5.0
* Twitter Bootstrap 3.3.6