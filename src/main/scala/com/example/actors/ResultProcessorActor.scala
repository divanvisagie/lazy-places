package com.example.actors


import akka.actor.{Actor, ActorRef, Props}
import akka.event.Logging
import com.example.models.Result
import com.example.services.Messenger


class ResultProcessorActor extends Actor {
  val log = Logging.getLogger(context.system, this)

  def receive = {

    case resultList: List[Result @unchecked] =>
      log.info(s"processing list ${resultList.mkString(",")}")

      val documentList = resultList.map(x => {
        s"mapping ${x.name}"
        Messenger().send(x.name)
      })
      log.info(s"wrote ${documentList.mkString(",")}")
    case _ =>
      log.info(s"${this.getClass.getSimpleName}: Unhandled Message")

  }
}
object ResultProcessorActor {
  val props = Props[ResultProcessorActor]
}

