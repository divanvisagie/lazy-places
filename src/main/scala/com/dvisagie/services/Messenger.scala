package com.dvisagie.services

import com.dvisagie.models.SystemMessage
import com.rabbitmq.client.{Channel, Connection, ConnectionFactory}
import org.json4s.NoTypeHints
import org.json4s.native.Serialization
import org.json4s.native.Serialization.write

class Messenger {
  private val QUEUE_NAME: String = "places"
  implicit val formats = Serialization.formats(NoTypeHints)


  def send(message: String) : Unit = {
    val factory: ConnectionFactory = new ConnectionFactory
    factory.setHost("localhost")
    val connection: Connection = factory.newConnection
    val channel: Channel = connection.createChannel


    channel.queueDeclare(QUEUE_NAME, false, false, false, null)
    channel.basicPublish("", QUEUE_NAME, null, message.getBytes())


    channel.close()
    connection.close()
  }

  def send(message: SystemMessage): Unit = {
    send(write(message))
  }

}
object Messenger {
  def apply() = new Messenger()
}