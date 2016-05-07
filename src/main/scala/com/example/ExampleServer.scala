package com.example

import com.twitter.finagle.http.{Response, Request}
import com.twitter.finatra.http.HttpServer
import com.twitter.finatra.http.filters.{CommonFilters, LoggingMDCFilter, TraceIdMDCFilter}
import com.twitter.finatra.http.routing.HttpRouter
import com.example.modules.PlacesModule

object ExampleServerMain extends ExampleServer

class ExampleServer extends HttpServer {

  override def defaultFinatraHttpPort = ":9999"

  override val modules = Seq(
    PlacesModule
  )

  override def configureHttp(router: HttpRouter) {
    router
      .filter[LoggingMDCFilter[Request, Response]]
      .filter[TraceIdMDCFilter[Request, Response]]
      .filter[CommonFilters]
      .add[PingController]
      .add[LocationController]
  }

}
