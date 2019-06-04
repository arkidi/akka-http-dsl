package com.packt.chapter9

import akka.http.scaladsl.server._
import akka.http.scaladsl.server.Directives._
import scala.collection.mutable

trait InMemoryStorageRestApi[K, V] {
  implicit val fixedPath: String

  def composeRoute(cache: mutable.Map[K, V]) = {
    versionOneRoute {
      temperaturePathRoute {
        handleAllMethods(cache)
      }
    }
  }

  private def versionOneRoute(route: Route) = pathPrefix("v1") {
    route
  }

  private def temperaturePathRoute(route: Route) = pathPrefix(fixedPath) {
    route
  }

  def handleAllMethods(cache: mutable.Map[K, V]) = {
    get {handleGet(cache)} ~
    put {handlePut(cache)} ~
    post {handlePost(cache)} ~
    delete {handleDelete(cache)}
  }

  def handleGet(cache: mutable.Map[K, V]): Route
  def handlePut(cache: mutable.Map[K, V]): Route
  def handlePost(cache: mutable.Map[K, V]): Route
  def handleDelete(cache: mutable.Map[K, V]): Route

}
