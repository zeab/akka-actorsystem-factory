
//Imports
import sbt.Keys._
import sbt._

object Common {

  //Manually update Version and Major numbers but auto update Minor number
  val projectVersion : String = s"1.0.0"

  //Holds the base project settings
  val baseProjectSettings: Seq[Def.Setting[_]] = Seq(
    version := projectVersion,
    scalaVersion := "2.12.6",
    organization := "zeab"
  )

  //Add the library's to this list that need to be excluded. Below is excluding certain log4j lib's
  val excludeSettings: Seq[Def.Setting[_]] = Seq(
    //libraryDependencies ~= { _.map(_.exclude("org.slf4j", "slf4j-log4j12")) }
  )

}