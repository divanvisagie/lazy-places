package com.example.modules

import com.example.PlacesService
import com.google.inject.{Provides, Singleton}
import com.twitter.inject.TwitterModule

/**
  * Created by divan on 2016/05/07.
  */
object PlacesModule extends TwitterModule{

  @Singleton
  @Provides
  def providesPlacesService: PlacesService = {
    PlacesService()
  }
}
