
//Imports
import sbt._

object Dependencies {

  //List of Versions
  val V = new {
    val scalaTest                 = "3.0.5"
  }

  //List of Dependencies
  val scalaTest                   = "org.scalatest" %% "scalatest" % V.scalaTest % "test"

  //Group Common Dependencies
  val commonDependencies: Seq[ModuleID] = Seq(
    scalaTest
  )

}
