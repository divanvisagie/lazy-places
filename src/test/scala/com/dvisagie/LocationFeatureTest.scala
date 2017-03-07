package com.dvisagie

import com.twitter.finagle.http.Status.Ok
import com.twitter.finatra.http.test.EmbeddedHttpServer
import com.twitter.inject.server.FeatureTest

class LocationFeatureTest extends FeatureTest {

  override val server = new EmbeddedHttpServer(new ExampleServer)

  "Server" should {
    "ping" in {
      server.httpGet(
        path = "/ping",
        andExpect = Ok,
        withBody = "pong")
    }
  }

  "Server" should {
    "Say Location updated for Post" in {
      server.httpPost(
        path = "/location",
        postBody =
          """
          {
            "lat": 31.004804799999988,
            "lng" : -29.838440499999997
          }
          """,
        andExpect = Ok,
        withBody = "Location updated")
    }
  }
}
