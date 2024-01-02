package features.mixinCompositions

import features.traits.{Alarm, Connector, ConnectorWithHelper, Notifier}

class Watch(brand: String, initialTime: Long) {
    def getTime(): Long = System.currentTimeMillis() - initialTime
}

class WatchWithConnector(brand: String, initialTime: Long) extends Connector {

    override def connect(): Unit = {
        println("connect in watch connector")
    }

    override def close(): Unit = {
        println("close in watch connector")
    }

    def getTime(): Long = System.currentTimeMillis() - initialTime
}

object WatchUser { // simple traits
    def main(args: Array[String]): Unit = {
        val expensiveWatch = new Watch("expensive brand", 1000L)
            with Alarm
            with Notifier {
            override def trigger(): String = "The alarm was triggered."
            override def clear(): Unit = {
                System.out.println("Alarm cleared.")
            }
            override val notificationMessage: String = "Alarm is running!"
        }
        val cheapWatch = new Watch("cheap brand", 1000L) with Alarm {
            override def trigger(): String = "The alarm was triggered."
        }

        // show some watch usage.
        System.out.println(expensiveWatch.trigger())
        expensiveWatch.printNotification()
        System.out.println(s"The time is ${expensiveWatch.getTime()}.")
        expensiveWatch.clear()

        System.out.println(cheapWatch.trigger())
        System.out.println("Cheap watches cannot manually stop the alarm...")
    }
}

object ReallyExpensiveWatchUser { // complex traits (which also have extends)
    def main(args: Array[String]): Unit = {
        // ConnectorWithHelper extends Connector, hence watch also should
        // extend Connector for below instantiation to work.
        val reallyExpensiveWatch =
            new WatchWithConnector("really expensive brand", 1000L)
                with ConnectorWithHelper {
                override def connect(): Unit = {
                    System.out.println("Connected with another connector.")
                }
                override def close(): Unit = {
                    System.out.println("Closed with another connector.")
                }
            }

        System.out.println("Using the really expensive watch.")
        reallyExpensiveWatch.findDriver()
        reallyExpensiveWatch.connect()
        reallyExpensiveWatch.close()
    }
}

trait AlarmNotifier {
    this: Notifier =>

    def trigger(): String
}

object SelfTypeWatchUser {
    def main(args: Array[String]): Unit = {
        // AlarmNotifier can be extended by a class only if it extends Notifier as well
        // val watch1 = new Watch("alarm with notification", 1000L) with AlarmNotifier {}
        val watch = new Watch("alarm with notification", 1000L)
            with AlarmNotifier
            with Notifier {
            override def trigger(): String = "Alarm triggered."

            override def clear(): Unit = {
                System.out.println("Alarm cleared.")
            }

            override val notificationMessage: String = "The notification."
        }

        System.out.println(watch.trigger())
        watch.printNotification()
        System.out.println(s"The time is ${watch.getTime()}.")
        watch.clear()
    }
}
