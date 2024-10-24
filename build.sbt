ThisBuild / scalaVersion := "3.3.4"
ThisBuild / organization := "com.jarrahtechnology"
ThisBuild / versionScheme := Some("early-semver")
ThisBuild / githubOwner := "jarrahtech"
ThisBuild / githubRepository := "jarrah-util"

lazy val root = project.in(file(".")).
  aggregate(util.js, util.jvm).
  settings(
    publish := {},
    publishLocal := {},
  )

lazy val util = crossProject(JSPlatform, JVMPlatform).in(file(".")).
  settings(
    name := "jarrah-util",
    version := "0.7.1",    

    resolvers ++= Resolver.sonatypeOssRepos("public"),
    resolvers += Resolver.githubPackages("jarrahtech"),

    libraryDependencies += "org.scalatest" %%% "scalatest" % "3.2.19" % "test",
    libraryDependencies += "org.scalatest" %%% "scalatest-funsuite" % "3.2.19" % "test",

    wartremoverErrors ++= Warts.unsafe,

    Test / logBuffered := false,    
  ).
  jvmSettings(
    scalacOptions ++= Seq(
      "-encoding", "utf8", 
      "-Xfatal-warnings",  
      "-deprecation",
    ),
    libraryDependencies += "org.scala-js" %% "scalajs-stubs" % "1.1.0" % "provided",
    Test / testOptions += Tests.Argument(TestFrameworks.ScalaTest, "-fW", "./target/scalatest.txt"),  
  ).
  jsSettings(
  )

lazy val utilJS = util.js
lazy val utilJVM = util.jvm