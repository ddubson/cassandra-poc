name := """film-fox"""
version := "1.0-alpha"
organization := "com.ddubson"
scalaVersion := "2.11.6"
javacOptions ++= Seq("-source", "1.8", "-target", "1.8", "-Xlint")
mainClass in Compile := Some("com.ddubson.filmfox.Application")

libraryDependencies ++= Seq(
  "com.datastax.cassandra" % "cassandra-driver-core" % "2.1.9",
  "org.springframework" % "spring-context" % "4.2.4.RELEASE",
  "org.springframework" % "spring-aspects" % "4.2.4.RELEASE",
  "org.springframework.boot" % "spring-boot-starter-parent" % "1.3.2.RELEASE",
  "org.springframework.boot" % "spring-boot-starter-web" % "1.3.2.RELEASE",
  "com.fasterxml.jackson.core" % "jackson-databind" % "2.6.2",
  "com.fasterxml.jackson.core" % "jackson-core" % "2.6.2",
  "com.fasterxml.jackson.core" % "jackson-annotations" % "2.6.2",
  "org.springframework.data" % "spring-data-cassandra" % "1.3.4.RELEASE",
  "ch.qos.logback" % "logback-classic" % "1.1.6",
  "org.elasticsearch" % "elasticsearch" % "2.2.1",
  "org.aspectj" % "aspectjrt" % "1.8.9",

  // Test Libraries
  "junit"             % "junit"           % "4.12"  % "test",
  "com.novocode"      % "junit-interface" % "0.11"  % "test",
  "org.mockito"       % "mockito-core"    % "2.0.43-beta" % "test",
  "org.hamcrest"      % "hamcrest-core"   % "1.3" % "test"
)

dependencyOverrides ++= Set(
  "com.fasterxml.jackson.core" % "jackson-databind" % "2.6.2",
  "com.fasterxml.jackson.core" % "jackson-core" % "2.6.2",
  "com.fasterxml.jackson.core" % "jackson-annotations" % "2.6.2",
  "org.springframework" % "spring-context" % "4.2.4.RELEASE",
  "org.springframework" % "spring-aspects" % "4.2.4.RELEASE",
  "org.springframework" % "spring-tx" % "4.2.4.RELEASE",
  "com.datastax.cassandra" % "cassandra-driver-core" % "2.1.9",
  "ch.qos.logback" % "logback-classic" % "1.1.6",
  "org.aspectj" % "aspectjrt" % "1.8.9",
  "org.aspectj" % "aspectjweaver" % "1.8.9"
)