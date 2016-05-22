
enablePlugins(ScalaJSPlugin)

name                       := "CesiumScala"

scalaVersion               := "2.11.8"

scalaJSStage in Global := FastOptStage

libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.9.0"

jsDependencies += RuntimeDOM

// creates single js resource file for easy integration in html page
skip in packageJSDependencies := false

// copy  javascript files to js folder, that are generated using fastOptJS/fullOptJS

crossTarget in(Compile, fullOptJS) := file("js")

crossTarget in(Compile, fastOptJS) := file("js")

crossTarget in(Compile, packageJSDependencies) := file("js")

crossTarget in(Compile, packageScalaJSLauncher) := file("js")

crossTarget in(Compile, packageMinifiedJSDependencies) := file("js")

scalacOptions += "-feature"

scalaJSUseRhino in Global := false