/*
ThisBuild / scalaVersion := "3.2.0"
ThisBuild / organization := "com.jarrahtechnology"
ThisBuild / versionScheme := Some("early-semver")

lazy val root = (project in file("."))
  .settings(
    name := "jarrah-util",
    version := "0.3.1",

    scalacOptions ++= Seq(
      "-encoding", "utf8", // Option and arguments on same line
      "-Xfatal-warnings",  // New lines for each options
      "-deprecation",
    ),

    githubOwner := "jarrahtech",
    githubRepository := "jarrah-util",

    resolvers ++= Resolver.sonatypeOssRepos("public"),
    resolvers += Resolver.githubPackages("jarrahtech"),
    libraryDependencies += "org.scalatest" %%% "scalatest" % "3.2.15" % "test",
    libraryDependencies += "org.scalatest" %%% "scalatest-funsuite" % "3.2.15" % "test",

    wartremoverErrors ++= Warts.unsafe
  )

*/
ThisBuild / scalaVersion := "3.2.0"
ThisBuild / organization := "com.jarrahtechnology"
ThisBuild / versionScheme := Some("early-semver")

lazy val root = project.in(file(".")).
  aggregate(util.js, util.jvm).
  settings(
    githubOwner := "jarrahtech",
    githubRepository := "jarrah-util",

    publish := {},
    publishLocal := {},   

    resolvers ++= Resolver.sonatypeOssRepos("public"),
    resolvers += Resolver.githubPackages("jarrahtech"),

    libraryDependencies += "org.scalatest" %%% "scalatest" % "3.2.15" % "test",
    libraryDependencies += "org.scalatest" %%% "scalatest-funsuite" % "3.2.15" % "test",

    wartremoverErrors ++= Warts.unsafe,
  )

lazy val util = crossProject(JSPlatform, JVMPlatform).in(file(".")).
  settings(
    name := "jarrah-util",
    version := "0.3.2",
  ).
  jvmSettings(
    // Add JVM-specific settings here
    scalacOptions ++= Seq(
      "-encoding", "utf8", // Option and arguments on same line
      "-Xfatal-warnings",  // New lines for each options
      "-deprecation",
    ),
  ).
  jsSettings(
    // Add JS-specific settings here
    scalaJSUseMainModuleInitializer := true,
  )

