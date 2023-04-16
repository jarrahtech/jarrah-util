ThisBuild / scalaVersion := "3.2.0"
ThisBuild / organization := "com.jarrahtechnology"
ThisBuild / versionScheme := Some("early-semver")

lazy val root = (project in file("."))
  .settings(
    name := "jarrah-util",
    version := "0.3.0",

    scalacOptions ++= Seq(
      "-encoding", "utf8", // Option and arguments on same line
      "-Xfatal-warnings",  // New lines for each options
      "-deprecation",
    ),

    githubOwner := "jarrahtech",
    githubRepository := "jarrah-util",

    resolvers ++= Resolver.sonatypeOssRepos("public"),
    resolvers += Resolver.githubPackages("jarrahtech"),
    libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % "test",

    wartremoverErrors ++= Warts.unsafe
  )
