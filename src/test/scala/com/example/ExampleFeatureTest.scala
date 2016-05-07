package com.example

import com.twitter.finagle.http.Status.Ok
import com.twitter.finatra.http.test.EmbeddedHttpServer
import com.twitter.inject.server.FeatureTest

class ExampleFeatureTest extends FeatureTest {

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
            "lat": 10,
            "lng" : 10
          }
          """,
        andExpect = Ok,
        withBody = "Location updated")
    }
  }
}
