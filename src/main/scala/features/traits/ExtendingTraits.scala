package features.traits

trait Ping {
  def ping(): Unit = {
    System.out.println("ping")
  }
}

trait Pong {
  def pong(): Unit = {
    System.out.println("pong")
  }
}

trait PingPong extends Ping with Pong {
  def pingPong(): Unit = {
    ping()
    pong()
  }
}

object Runner extends PingPong {
  def main(args: Array[String]): Unit = {
    pingPong()
  }
}
