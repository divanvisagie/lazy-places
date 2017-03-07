package com.dvisagie

object ApiSettings {
  def secret : String = {
    sys.env("GOOGLE_API_SECRET")
  }
}
