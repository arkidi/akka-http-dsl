package com.packt.chapter9.akkahttp

import akka.http.scaladsl.server.{HttpApp}
import akka.http.scaladsl.settings.ServerSettings
import com.typesafe.config.ConfigFactory
import scala.collection.mutable

class TemperatureInMemoryStorageRestApi(cache: mutable.Map[String, TemperatureMeasurement]) extends HttpApp
  with InMemoryStorageRestApi[String, TemperatureMeasurement]
  with GetRequestsHandler
  with PostRequestHandler
  with PutRequestsHandler
  with DeleteRequestsHandler {

  implicit val fixedPath = "temperature"
  val route = composeRoute(cache)
}

object TemperatureInMemoryStorageRestApiApplication extends App {
  val cache = mutable.Map.empty[String, TemperatureMeasurement]

  new TemperatureInMemoryStorageRestApi(cache).startServer("0.0.0.0", 8089, ServerSettings(ConfigFactory.load()))
}