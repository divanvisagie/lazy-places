package com.example.models

/**
  * Created by divan on 2016/05/07.
  */

trait SystemMessage
case class Place(name: String, location: Location) extends SystemMessage

