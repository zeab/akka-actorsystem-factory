package com.zeab.akka.actorsystemfactory

trait CustomDispatchers {

  /** Object used to define a Blocking Fixed Thread Dispatcher of a given name, thread size and throughput*/
  def blockingFixedThreadIoDispatcher(name:String, threadSize:String = "5120", throughput:String = "1"): String = {
    s"""$name {
       |  type = Dispatcher
       |  executor = "thread-pool-executor"
       |  thread-pool-executor {
       |    fixed-pool-size = $threadSize
       |  }
       |  throughput = $throughput
       |}"""
  }

  //TODO Add Dynamic Threading

  //TODO Add Fork join Threading

  //TODO I think there is another one... check

}

object CustomDispatchers extends CustomDispatchers
