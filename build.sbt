name := "nirto-demo"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq("org.specs2" %% "specs2-core" % "3.8.4" % "test")

libraryDependencies += "com.google.guava" % "guava" % "19.0"


scalacOptions in Test ++= Seq("-Yrangepos")