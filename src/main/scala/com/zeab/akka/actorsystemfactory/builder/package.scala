package com.zeab.akka.actorsystemfactory

package object builder {

  object ActorSystemFactory{

    def addCustomDispatcher(dispatchers:String):CustomDispatchers = CustomDispatchers(List(dispatchers))
    def addCustomDispatchers(dispatchers:List[String]):CustomDispatchers = CustomDispatchers(dispatchers)
    def addBaseSettings = ???
    def addWebServerSettings = ???
    def addClusterSettings = ???

    case class CustomDispatchers(dispatchers:List[String]){

      def addCustomDispatcher(dispatchers:String):CustomDispatchers = ??? //copy(dispatchers + List(dispatchers).mkString("", "", ""))


      def toActorSystemConfig() = ActorSystemConfig().toString
    }



    case class ActorSystemConfig(customDispatchers:Option[String] = None,
                                 loggingSettings:Option[String] = None,
                                 webServerSettings:Option[String] = None,
                                 clusterSettings:Option[String] = None){
      override def toString: String =
        s"""###Custom Dispatchers###
           |${customDispatchers.getOrElse("###No Custom Dispatchers Defined###")}
           |
           |###Akka###
           |akka {
           |###ClusterSettings###
           |${clusterSettings.getOrElse("###No Cluster Settings Defined###")}
           |}""".stripMargin
    }

    override def toString: String = ActorSystemConfig.toString

  }

}



//ActorSystemFactory

//CustomDispatchers
//Logging
//WebServer
//Cluster