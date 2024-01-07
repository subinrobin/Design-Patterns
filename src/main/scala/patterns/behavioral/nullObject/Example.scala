package patterns.behavioral.nullObject

case class Message(number: Int) {
    def print(): String = s"This is a message with number: $number."
}

import java.util.concurrent.ConcurrentLinkedQueue
import scala.util.Random

// queue simulation
class DataGenerator extends Runnable {
    val MAX_VAL = 10
    val MAX_TIME = 10000
    private var isStop = false
    private val queue: ConcurrentLinkedQueue[Int] = new ConcurrentLinkedQueue[Int]()

    override def run(): Unit = {
        val random = new Random()
        while (!isStop) {
            Thread.sleep(random.nextInt(MAX_TIME))
            queue.add(random.nextInt(MAX_VAL))
        }
    }

    def getMessage(): Option[Message] = {
        // Option(null) returns None
        val value = queue.poll()
        println(s"get message value: $value")
        Option(value).map(number => Message(number))
    }

    def requestStop(): Unit = this.synchronized {
        isStop = true
    }
}

object MessageExample {
    val TIMES_TO_TRY = 10
    val MAX_TIME = 5000

    def main(args: Array[String]): Unit = {
        val generator = new DataGenerator
        // start the generator in another thread
        new Thread(generator).start()
        val random = new Random()
        (0 to TIMES_TO_TRY).foreach {
            time =>
                Thread.sleep(random.nextInt(MAX_TIME))
                System.out.println("Getting next message...")
                generator.getMessage().foreach(m =>
                    System.out.println(m.print()))
        }
        generator.requestStop()
    }
}

object Test {
    def main(args: Array[String]): Unit = {
        val queue: ConcurrentLinkedQueue[Int] = new ConcurrentLinkedQueue[Int]()
        queue.add(10)
        println(queue.poll())
        println(queue.poll())
        println(Option(queue.poll()))
    }
}