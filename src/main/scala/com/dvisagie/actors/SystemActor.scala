package com.dvisagie.actors

import akka.actor.{Actor, Props}
import akka.event.Logging
import com.dvisagie.models.{Location, PlaceListResult}
import com.dvisagie.services.HttpService

class PlaceFinder  {
  var httpService = HttpService()
  def getPlacesForLocation(location: Location): PlaceListResult = {

    val radius = 5000
    val urlMidsection = s"/maps/api/place/nearbysearch/json?location=${location.toString}&radius=$radius&type=restaurant"

    val placeListResult = httpService.get[PlaceListResult](urlMidsection)
    placeListResult
  }
}

class SystemActor extends Actor {

  val log = Logging.getLogger(context.system, this)

  def receive = {
    case location: Location =>
      val placeService = new PlaceFinder()
      val listProcessingActor = context.system.actorOf(ResultProcessorActor.props)

      listProcessingActor ! placeService.getPlacesForLocation(location).results
    case _ =>
      log.info(s"${this.getClass.getSimpleName}: Unhandled Message")
  }
}
object SystemActor {
  val props = Props[SystemActor]
}

