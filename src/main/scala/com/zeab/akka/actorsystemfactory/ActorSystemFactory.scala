package com.zeab.akka.actorsystemfactory

import scala.util.{Failure, Success, Try}

trait ActorSystemFactory {

  /** Checks the log level*/
  def logLevelCheck:String ={
    Try(sys.env(Envs.logLevel)) match {
      case Success(value) =>
        value.toLowerCase match {
          case LogLevels.info | LogLevels.debug | LogLevels.error | LogLevels.warn | LogLevels.off =>
            value
          case _ =>
            throw new Exception(s"Environment variable ${Envs.logLevel} value $value does not match a required value ${LogLevels.info} | ${LogLevels.error} | ${LogLevels.debug} | ${LogLevels.warn} | ${LogLevels.off}")
            ""
        }
      case Failure(_) =>
        LogLevels.info
    }
  }

  def getActorSystemConfig(): String ={

    //TODO Move these into a dsl or something
    val customDispatchers:Option[List[String]] = None
    val clusterSettings1:Option[String] = None
    //is in a docker
    //is seednode

    //Cluster settings
    //externalHostBind
    //externalPortBind
    //internalHostBind
    //internalPostBind
    //seednodes
    //roles


    val dispatchers:String = customDispatchers match {
      case Some(d) =>
        d.mkString("", "\n\n", "")
      case None =>
        "#No Custom Dispatchers Defined"
    }

    val clusterSettings:String = clusterSettings1 match {
      case Some(settings) =>
        ""
      case None =>
        ""
    }

    s"""###Custom Dispatchers###
       |$dispatchers
       |
       |###Akka###
       |akka {
       |
       |###ClusterSettings###
       |$clusterSettings
       |}""".stripMargin
  }

}

object ActorSystemFactory extends ActorSystemFactory
