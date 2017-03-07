import com.typesafe.sbt.packager.docker._


name := """lazy-places"""
organization := "com.dvisagie"

version := "1.0.1"

scalaVersion := "2.11.8"

fork in run := true

javaOptions ++= Seq(
  "-Dlog.service.output=/dev/stderr",
  "-Dlog.access.output=/dev/stderr")

resolvers ++= Seq(
  Resolver.sonatypeRepo("releases"),
  "Twitter Maven" at "https://maven.twttr.com"
)

lazy val versions = new {
  val akka = "2.3.16"
  val finatra = "2.1.6"
  val guice = "4.1.0"
  val logback = "1.2.1"
  val mockito = "2.7.14"
  val scalatest = "3.0.1"
  val specs2 = "3.3.1"
  val rabbit = "4.1.0"
  val json4s = "3.5.0"
}

enablePlugins(JavaServerAppPackaging)
packageName in Docker := "divanvisagie/lazy-places"
dockerCommands += Cmd("RUN","apk add --no-cache bash")
dockerCommands := Seq(
  Cmd("FROM", "openjdk:alpine"),
  Cmd("WORKDIR", "/opt/docker"),
  Cmd("ADD", "opt /opt"),
  ExecCmd("RUN" , "chown", "-R", "daemon:daemon", "." ),
  ExecCmd("RUN", "apk", "add", "--no-cache", "bash"),
  Cmd("EXPOSE", "5000"),
  ExecCmd("ENTRYPOINT", "bin/lazy-places")
)


libraryDependencies ++= Seq(
  "com.twitter.finatra" %% "finatra-http" % versions.finatra,
  "com.twitter.finatra" %% "finatra-slf4j" % versions.finatra,
  "ch.qos.logback" % "logback-classic" % versions.logback,
  "ch.qos.logback" % "logback-classic" % versions.logback % "test",

  "com.twitter.finatra" %% "finatra-http" % versions.finatra % "test",
  "com.twitter.inject" %% "inject-server" % versions.finatra % "test",
  "com.twitter.inject" %% "inject-app" % versions.finatra % "test",
  "com.twitter.inject" %% "inject-core" % versions.finatra % "test",
  "com.twitter.inject" %% "inject-modules" % versions.finatra % "test",
  "com.google.inject.extensions" % "guice-testlib" % versions.guice % "test",

  "com.twitter.finatra" %% "finatra-http" % versions.finatra % "test" classifier "tests",
  "com.twitter.inject" %% "inject-server" % versions.finatra % "test" classifier "tests",
  "com.twitter.inject" %% "inject-app" % versions.finatra % "test" classifier "tests",
  "com.twitter.inject" %% "inject-core" % versions.finatra % "test" classifier "tests",
  "com.twitter.inject" %% "inject-modules" % versions.finatra % "test" classifier "tests",

  "org.mockito" % "mockito-core" % versions.mockito % "test",
  "org.scalatest" %% "scalatest" % versions.scalatest % "test",
  "org.specs2" %% "specs2" % versions.specs2 % "test",
  "org.json4s" % "json4s-native_2.11" % versions.json4s,
  "com.typesafe.akka" %% "akka-actor" % versions.akka,
  "com.rabbitmq" % "amqp-client" % versions.rabbit
)
