package com.dvisagie.modules

import com.dvisagie.PlacesService
import com.google.inject.{Provides, Singleton}
import com.twitter.inject.TwitterModule

object PlacesModule extends TwitterModule{

  @Singleton
  @Provides
  def providesPlacesService: PlacesService = {
    PlacesService()
  }
}
