package com.dvisagie.services

import com.dvisagie.ApiSettings
import org.json4s.NoTypeHints
import org.json4s.native.Serialization
import org.json4s.native.Serialization.read

class HttpService extends HttpServiceTrait {

  implicit val formats = Serialization.formats(NoTypeHints)

  def get[T](url: String)(implicit m: Manifest[T]): T = {

    val jsonString = scala.io.Source.fromURL(buildUrl(url)).mkString
    read[T](jsonString)
  }
}

object HttpService {
  def apply() = new HttpService()
}

trait HttpServiceTrait {

  val API_SECRET = ApiSettings.secret
  val API_URL = "https://maps.googleapis.com"

  def buildUrl(url: String): String = {
    s"$API_URL$url&key=$API_SECRET"
  }
}
