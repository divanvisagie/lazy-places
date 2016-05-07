package com.example

import com.example.models.Location
import com.google.inject.Inject
import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller

class LocationController @Inject()(placesService: PlacesService) extends Controller {
  post("/location") {location: Location =>
    // println(request)

    "Location updated"
  }
}
