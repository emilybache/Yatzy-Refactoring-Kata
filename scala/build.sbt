val scala3Version = "3.7.3"

lazy val root = project
  .in(file("."))
  .settings(
    name := "Yatzy1-refactoring",
    version := "1.0",
    scalaVersion := scala3Version,
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.2.19" % Test
    )
  )
