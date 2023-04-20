ThisBuild / scalaVersion := "3.2.2"
ThisBuild / organization := "com.jarrahtechnology"
ThisBuild / versionScheme := Some("early-semver")

lazy val root = project.in(file(".")).
  aggregate(util.js, util.jvm).
  settings(
    githubOwner := "jarrahtech",
    githubRepository := "jarrah-util",

    publish := {},
    publishLocal := {},
  )

lazy val util = crossProject(JSPlatform, JVMPlatform).in(file(".")).
  settings(
    name := "jarrah-util",
    version := "0.4.0",    

    githubOwner := "jarrahtech",
    githubRepository := "jarrah-util",

    resolvers ++= Resolver.sonatypeOssRepos("public"),
    resolvers += Resolver.githubPackages("jarrahtech"),

    libraryDependencies += "org.scalatest" %%% "scalatest" % "3.2.15" % "test",
    libraryDependencies += "org.scalatest" %%% "scalatest-funsuite" % "3.2.15" % "test",

    wartremoverErrors ++= Warts.unsafe,
  ).
  jvmSettings(
    libraryDependencies += "org.scala-js" %% "scalajs-stubs" % "1.1.0" % "provided",
  ).
  jsSettings(
    
  )

lazy val utilJS = util.js
lazy val utilJVM = util.jvm