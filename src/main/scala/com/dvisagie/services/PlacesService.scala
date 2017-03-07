package com.example

import com.example.actors.SystemActor
import com.example.models._
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
