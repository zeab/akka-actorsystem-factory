package com.zeab.akka.actorsystemfactory



trait ActorSystemFactory {


  case object WebServerSettings{
    case class Server(backlog:String, pipelingLimit:String, requestTimeout:String) {
      def addBacklog(backlog:String):Server = copy(backlog, pipelingLimit, requestTimeout)

    }

    case object HostConnectionPool{

    }

    case object Client{

    }

  }


  def webServerSettings():String ={

    val backlog = Some("")


    s"""http {
       |   server {
       |     backlog = $sizeOfHttpPool
       |     pipelining-limit = $sizeOfHttpPool
       |     request-timeout = $serverRequestResponseTimeout
       |   }
       |
       |   host-connection-pool {
       |     max-connections = $sizeOfHttpPool
       |     max-open-requests = $sizeOfHttpPool
       |     #idle-timeout = 1 s
       |   }
       |
       |   client {
       |     connecting-timeout = $clientConnectionTimeout
       |   }
       |
       |}""".stripMargin
  }


  //WebServerSettings
    //Server
      //backlog
      //pipe
      //requestimeout
    //hostconnectionpool
    //client


}

object ActorSystemFactory extends ActorSystemFactory
