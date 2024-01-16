name := "Design-Patterns"
organization := "com.learn.patterns"
version := "1.0"

scalaVersion := "2.13.12"

libraryDependencies ++= Seq(
    "org.scalatest" %% "scalatest" % "3.2.17" % "test",
    "org.mockito" % "mockito-core" % "5.2.0" % "test", // mockito for tests
    "org.scalatestplus" %% "mockito-3-4" % "3.2.10.0" % "test",
    "org.json4s" %% "json4s-jackson" % "4.0.6",
    "com.typesafe.scala-logging" %% "scala-logging" % "3.9.5",
    //"org.slf4j" % "slf4j-reload4j" % "2.0.10",
    "org.slf4j" % "slf4j-log4j12" % "2.0.5",
    "commons-codec" % "commons-codec" % "1.15",
    "org.json4s" %% "json4s-native" % "4.0.6",
    "com.github.tototoshi" %% "scala-csv" % "1.3.10",
    "org.scala-lang.modules" %% "scala-parallel-collections" % "1.0.4",
    "org.scalaz" %% "scalaz-core" % "7.3.7",
    "com.h2database" % "h2" % "2.2.220",
)
