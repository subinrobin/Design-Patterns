package patterns.behavioral.command

import scala.collection.mutable.ListBuffer

class RobotByNameController {
    val history = ListBuffer[() => Unit]()

    def issueCommand(command: => Unit): Unit = {
        command _ +=: history
        command
    }

    def showHistory(): Unit = {
        history.foreach(println)
    }
}

object RobotByNameExample {
    def main(args: Array[String]): Unit = {
        val robot = Robot()
        val robotController = new RobotByNameController
        robotController.issueCommand(MakeSandwichCommand(robot).execute())
        robotController.issueCommand(PourJuiceCommand(robot).execute())
        System.out.println("I'm eating and having some juice.")
        robotController.issueCommand(CleanUpCommand(robot).execute())
        System.out.println("Here is what I asked my robot to do:")
        robotController.showHistory()
    }
}
