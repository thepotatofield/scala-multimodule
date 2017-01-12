import play.sbt.PlayScala
import play.sbt.routes.RoutesKeys._
import sbt.Keys._
import sbt._
import scoverage.ScoverageKeys._
import org.scalastyle.sbt.ScalastylePlugin._

object Settings {

  private val commonOrganisation = "dev.nico"

  private val commonVersion = "0.1.0-SNAPSHOT"

  private val commonCompileOptions = Seq(
    "-target:jvm-1.8",
    "-encoding", "UTF-8",
    "-unchecked",
    "-deprecation",
    "-feature",
    "-language:reflectiveCalls",
    "-language:implicitConversions",
    "-language:dynamics",
    "-language:higherKinds",
    "-Ywarn-dead-code"
  )

  private val commonSettings = Seq(
    organization := commonOrganisation,
    version := commonVersion,
    scalaVersion := Dependencies.scalaVersion,
    resolvers ++= Dependencies.resolvers,
    fork in test := true,
    fork in run := true,
    parallelExecution in Test := true,
    scalacOptions ++= commonCompileOptions,
    javaOptions ++= Seq("-Xmx4096m", "-Xms512m"),
    coverageEnabled := false,
    scalastyleFailOnError := true
  )

  case class ProjectModule(modulePath: String) {
    val name = modulePath.split(s"\\/").last
    val path = s"modules/$modulePath"
  }

  def scalaModule(projectModule: ProjectModule): Project = {
    Project(projectModule.name, file(projectModule.path))
      .settings(commonSettings: _*)
  }

  def playModule(projectModule: ProjectModule): Project = {
    scalaModule(projectModule)
      .enablePlugins(PlayScala)
      .settings(
        routesGenerator := InjectedRoutesGenerator,
        libraryDependencies ++= Seq(
          Dependencies.play
        )
      )
  }

}
