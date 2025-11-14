val scala3Version = "3.7.4"

lazy val root = project
  .in(file("."))
  .settings(
    name := "Yatzy1-refactoring",
    version := "1.10.0",
    scalaVersion := "3.7.4",
      libraryDependencies ++= Seq(
        "com.approvaltests" % "approvaltests" % "25.7.0" % Test,
        "org.junit.jupiter" % "junit-jupiter-api" % "6.0.1" % Test,
        "org.junit.jupiter" % "junit-jupiter-engine" % "6.0.1" % Test
    )
  )
