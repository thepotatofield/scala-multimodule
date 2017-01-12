import sbt._
import sbt.Keys._
import Settings._
import Dependencies._

lazy val common = scalaModule(ProjectModule("common")).settings(
  version := "1.0-SNAPSHOT",
  libraryDependencies ++= Seq(
    scalaz,
    logback
  )
)

lazy val play = playModule(ProjectModule("play")).settings(
  version := "1.0-SNAPSHOT"
).dependsOn(common).aggregate(common)

lazy val root = project.in(file("."))
   .aggregate(common, play)
