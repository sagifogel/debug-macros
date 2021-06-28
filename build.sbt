name := "debug-macros"

version := "0.0.1"

lazy val root = project
  .in(file("."))
  .aggregate(main, macros)

lazy val main = project.in(file("main"))
  .settings(scalaVersion := "2.13.6")
  .settings(libraryDependencies ++= Seq(
    "org.scala-lang" % "scala-compiler" % scalaVersion.value
  ))
  .dependsOn(macros)

lazy val macros = project
  .in(file("macros"))
  .settings(scalaVersion := "2.13.6")
  .settings(scalacOptions += "-language:experimental.macros",
    libraryDependencies ++= Seq(
      "org.scala-lang" % "scala-library" % scalaVersion.value,
      "org.scala-lang" % "scala-reflect" % scalaVersion.value,
      "org.scala-lang" % "scala-compiler" % scalaVersion.value
    ))
