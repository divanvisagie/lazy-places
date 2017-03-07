package com.dvisagie

import com.dvisagie.actors.SystemActor
import com.dvisagie.models._
import akka.actor.ActorSystem


class PlacesService {

  val system = ActorSystem("place-service-system")
  val systemActor = system.actorOf(SystemActor.props, "systemActor")

  def processLocation(location: Location) = {
    systemActor ! location
  }
}

object PlacesService {
  def apply() = new PlacesService()
}
