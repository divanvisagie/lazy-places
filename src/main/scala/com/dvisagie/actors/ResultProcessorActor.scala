package com.dvisagie.actors

import akka.actor.{Actor, Props}
import akka.event.Logging
import com.dvisagie.models.{Place, Result}
import com.dvisagie.services.Messenger


class ResultProcessorActor extends Actor {
  val log = Logging.getLogger(context.system, this)

  def receive = {

    case resultList: List[Result @unchecked] =>
      log.info(s"processing list ${resultList.mkString(",")}")

      resultList.foreach(x => {
        Messenger().send(
          Place(
            x.name,
            x.geometry.location
          )
        )
        s"mapping ${x.name}"
      })
    case _ =>
      log.info(s"${this.getClass.getSimpleName}: Unhandled Message")

  }
}
object ResultProcessorActor {
  val props = Props[ResultProcessorActor]
}

