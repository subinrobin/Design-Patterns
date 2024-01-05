name := "Design-Patterns"
organization := "com.learn.patterns"
version := "1.0"

scalaVersion := "2.13.12"

libraryDependencies ++= Seq(
    "org.scalatest" %% "scalatest" % "3.2.17" % "test",
    "org.json4s" %% "json4s-jackson" % "4.0.6",
    "com.typesafe.scala-logging" %% "scala-logging" % "3.9.5",
    //"org.slf4j" % "slf4j-reload4j" % "2.0.10",
    "org.slf4j" % "slf4j-log4j12" % "2.0.5",
    "commons-codec" % "commons-codec" % "1.15",
    "org.json4s" %% "json4s-native" % "4.0.6",
)
