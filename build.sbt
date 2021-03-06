
enablePlugins(ScalaJSPlugin)

name := "cesiumscala"

organization := "com.github.workingDog"

version := (version in ThisBuild).value

scalaJSStage in Global := FullOptStage //FastOptStage

scalaVersion := "2.11.11"

crossScalaVersions := Seq("2.11.1", "2.12.2")

libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.9.1"

jsDependencies += RuntimeDOM

skip in packageJSDependencies := false

homepage := Some(url("https://github.com/workingDog/CesiumScala"))

licenses := Seq("Apache 2" -> url("http://www.apache.org/licenses/LICENSE-2.0"))

scalacOptions ++= Seq(
  "-deprecation", // Emit warning and location for usages of deprecated APIs.
  "-feature", // Emit warning and location for usages of features that should be imported explicitly.
  "-unchecked", // Enable additional warnings where generated code depends on assumptions.
  "-Xlint" // Enable recommended additional warnings.
)

// to make the images available to the scaladocs
lazy val copyDocAssetsTask = taskKey[Unit]("Copy doc images")

copyDocAssetsTask := {
  val sourceDir = file("./images")
  val targetDir = (target in (Compile, doc) ).value / "cesium/images"
  IO.copyDirectory(sourceDir, targetDir)
}

copyDocAssetsTask <<= copyDocAssetsTask triggeredBy (doc in Compile)

