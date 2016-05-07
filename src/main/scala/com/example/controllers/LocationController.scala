package com.example

import com.example.models.Location
import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller

class LocationController extends Controller {
  post("/location") {location: Location =>
    // println(request)
    "Location updated"
  }
}
