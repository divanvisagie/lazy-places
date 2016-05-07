package com.example.services

import com.rabbitmq.client.{Channel, Connection, ConnectionFactory}

class Messenger {
  private val QUEUE_NAME: String = "places"


  def send(message: String) : Unit = {
    val factory: ConnectionFactory = new ConnectionFactory
    factory.setHost("localhost")
    val connection: Connection = factory.newConnection
    val channel: Channel = connection.createChannel


    channel.queueDeclare(QUEUE_NAME, false, false, false, null)
    channel.basicPublish("", QUEUE_NAME, null, message.getBytes())
    System.out.println(" [x] Sent '" + message + "'")


    channel.close()
    connection.close()
  }

}
object Messenger {
  def apply() = new Messenger()
}