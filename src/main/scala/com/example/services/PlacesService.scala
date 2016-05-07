package com.example

import com.example.models._


class PlacesService {
  var httpService = HttpService()
  def getPlacesForLocation(location: Location): PlaceListResult = {

    val radius = 500
    val urlMidsection = s"/maps/api/place/nearbysearch/json?location=${location.toString}&radius=$radius&type=restaurant"

    val placeListResult = httpService.get[PlaceListResult](urlMidsection)
    placeListResult
  }

  def processResult(placeListResult: PlaceListResult) = {

  }
}

object PlacesService {
  def apply() = new PlacesService()
}
