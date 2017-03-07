package com.dvisagie.models

trait SystemMessage
case class Place(name: String, location: Location) extends SystemMessage

