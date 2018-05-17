package com.zeab.akka.actorsystemfactory

trait LogLevels {
  val error = "error"
  val warn = "warning"
  val debug = "debug"
  val info = "info"
  val off = "off"
  val fatal = "fatal"
  val trace = "trace"
}

object LogLevels extends LogLevels