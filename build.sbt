name := """cassandra-data"""

version := "1.0"

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  "junit"             % "junit"           % "4.12"  % "test",
  "com.novocode"      % "junit-interface" % "0.11"  % "test",
  "com.datastax.cassandra" % "cassandra-driver-core" % "2.1.9",
  "org.springframework" % "spring-context" % "4.2.4.RELEASE",
  "org.springframework.boot" % "spring-boot-starter-parent" % "1.3.2.RELEASE",
  "org.springframework.boot" % "spring-boot-starter-web" % "1.3.2.RELEASE",
  "com.fasterxml.jackson.core" % "jackson-databind" % "2.6.2",
  "com.fasterxml.jackson.core" % "jackson-core" % "2.6.2",
  "com.fasterxml.jackson.core" % "jackson-annotations" % "2.6.2"
)

dependencyOverrides +="com.fasterxml.jackson.core" % "jackson-databind" % "2.6.2"
dependencyOverrides += "com.fasterxml.jackson.core" % "jackson-core" % "2.6.2"
dependencyOverrides += "com.fasterxml.jackson.core" % "jackson-annotations" % "2.6.2"
