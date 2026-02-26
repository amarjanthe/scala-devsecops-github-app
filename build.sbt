enablePlugins(JavaAppPackaging)
name := "scala-devsecops-app"
version := "1.0.0"

scalaVersion := "2.13.12"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-http" % "10.2.10",
  "com.typesafe.akka" %% "akka-stream" % "2.6.20",
  "ch.qos.logback" % "logback-classic" % "1.4.14",
  "org.scalatest" %% "scalatest" % "3.2.18" % Test
)

Test / fork := true
