package com.zeab.akka.actorsystemfactory

trait Envs {

  val logLevel = "log_level"
  val isLocal = "is_local"
  val isDocker = "is_docker"
  val dockerHost = "docker_host"
  val dockerPort = "docker_port"

}

object Envs extends Envs