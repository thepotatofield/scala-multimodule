import sbt._

object Dependencies {

  // scala version
  val scalaVersion = "2.11.8"

  // akka version
  val akkaVersion = "2.4.16"

  // play version
  val playVersion = "2.5.10"

  // resolvers
  val resolvers = Seq(
    Resolver sonatypeRepo "public"
  )

  // functional utils
  val scalaz           = "org.scalaz" %% "scalaz-core" % "7.2.8"

  // akka
  val akkaActor       = "com.typesafe.akka" %% "akka-actor" % akkaVersion
  val akkaPersistence = "com.typesafe.akka" %% "akka-persistence" % akkaVersion
  val akkaSlf4j       = "com.typesafe.akka" %% "akka-slf4j" % akkaVersion
  val akkaStream      = "com.typesafe.akka" %% "akka-stream" % akkaVersion

  // play
  val play        = "com.typesafe.play" %% "play" % playVersion
  val playWS      = "com.typesafe.play" %% "play-ws" % playVersion
  val playCache   = "com.typesafe.play" %% "play-cache" % playVersion
  val playFilters = "com.typesafe.play" %% "filters-helpers" % playVersion

  // logging
  val logback = "ch.qos.logback" % "logback-classic" % "1.1.7"

  // testing
  val scalaTest     = "org.scalatest" %% "scalatest" % "3.0.1" % "test"
  val scalaTestPlay = "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.0" % "test"
  val scalaTestMock = "org.scalamock" %% "scalamock-scalatest-support" % "3.2.2" % "test"
}
