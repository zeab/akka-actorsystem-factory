
//Imports
import Common._
import Dependencies._

lazy val asf = (project in file("."))
  .settings(baseProjectSettings: _*)
  .settings(libraryDependencies ++= commonDependencies)
  .enablePlugins(Artifactory)