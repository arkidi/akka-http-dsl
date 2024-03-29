package com.packt.chapter9.marshaller

import akka.http.scaladsl.settings.ServerSettings
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.HttpApp
import com.typesafe.config.ConfigFactory

object MarshallingServer extends HttpApp with SpeedMeasurementMarshallingHelper {

  var measurement: Option[SpeedMeasurement] = None

  val route =
    get {
      complete {
        measurement match {
          case None => StatusCodes.NotFound -> "Speed Measurement is empty"
          case Some(value) => StatusCodes.OK -> value
        }
      }
    } ~
    post {
      entity(as[SpeedMeasurement]) { speedMeasurement =>
        complete {
          measurement = Some(speedMeasurement)
          StatusCodes.OK -> s"Speed Measurement now is $speedMeasurement"
        }
      }
    }
}

object MarshallingApplication extends App {
  MarshallingServer.startServer("0.0.0.0", 8089, ServerSettings(ConfigFactory.load))
}
