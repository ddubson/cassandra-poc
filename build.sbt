name := """film-fox"""

version := "1.0-alpha"

organization := "com.ddubson"

scalaVersion := "2.11.6"

mainClass in Compile := Some("com.ddubson.filmfox.Application")

libraryDependencies ++= Seq(
  "com.datastax.cassandra" % "cassandra-driver-core" % "2.1.9",
  "org.springframework" % "spring-context" % "4.2.4.RELEASE",
  "org.springframework.boot" % "spring-boot-starter-parent" % "1.3.2.RELEASE",
  "org.springframework.boot" % "spring-boot-starter-web" % "1.3.2.RELEASE",
  "com.fasterxml.jackson.core" % "jackson-databind" % "2.6.2",
  "com.fasterxml.jackson.core" % "jackson-core" % "2.6.2",
  "com.fasterxml.jackson.core" % "jackson-annotations" % "2.6.2",
  "org.springframework.data" % "spring-data-cassandra" % "1.3.4.RELEASE",
  "ch.qos.logback" % "logback-classic" % "1.1.6",

  // Test Libraries
  "junit"             % "junit"           % "4.12"  % "test",
  "com.novocode"      % "junit-interface" % "0.11"  % "test",
  "org.mockito"       % "mockito-core"    % "2.0.43-beta" % "test",
  "org.hamcrest"      % "hamcrest-core"   % "1.3" % "test"
)

dependencyOverrides +="com.fasterxml.jackson.core" % "jackson-databind" % "2.6.2"
dependencyOverrides += "com.fasterxml.jackson.core" % "jackson-core" % "2.6.2"
dependencyOverrides += "com.fasterxml.jackson.core" % "jackson-annotations" % "2.6.2"
dependencyOverrides += "org.springframework" % "spring-context" % "4.2.4.RELEASE"
dependencyOverrides += "com.datastax.cassandra" % "cassandra-driver-core" % "2.1.9"
dependencyOverrides += "ch.qos.logback" % "logback-classic" % "1.1.6"
