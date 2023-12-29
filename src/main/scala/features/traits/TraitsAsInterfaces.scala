package features.traits

trait Alarm {
    def trigger(): String
}

trait Notifier {
    val notificationMessage: String

    def printNotification(): Unit = {
        System.out.println(notificationMessage)
    }

    def clear()
}

class NotifierImpl(val notificationMessage: String) extends Notifier {
    override def clear(): Unit = System.out.println("cleared")
}
