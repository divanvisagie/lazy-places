package com.dvisagie

import com.dvisagie.models.Location
import com.google.inject.Inject
import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller

class LocationController @Inject()(placesService: PlacesService) extends Controller {
  post("/location") {location: Location =>
    // println(request)
    placesService.processLocation(location)
    "Location updated"
  }
}
