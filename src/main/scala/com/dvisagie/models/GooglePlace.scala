package com.dvisagie.models


class Location(val lat: Double, val lng: Double) {
  override def toString: String = {
    s"$lat,$lng"
  }
}
object Location{
  def apply(lat: Double,lng: Double) = new Location(lat,lng)
}

case class Geometry(location: Location)

class Photo(
  val width: Int,
  val height: Int,
  val photo_reference: String
) {}


class Result(
  val geometry: Geometry,
  val id: String,
  val name: String,
  val reference: String,
  val photos: List[Photo]
) {}

class PlaceListResult(
  val results: List[Result]
) {}
