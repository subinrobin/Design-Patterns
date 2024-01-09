package patterns.behavioral.command

import scala.collection.mutable.ListBuffer

case class Robot() {
    def cleanUp(): Unit = System.out.println("Cleaning up.")
    def pourJuice(): Unit = System.out.println("Pouring juice.")
    def makeSandwich(): Unit = System.out.println("Making a sandwich.")
}

trait RobotCommand {
    def execute(): Unit
}

case class MakeSandwichCommand(robot: Robot) extends RobotCommand {
    override def execute(): Unit = robot.makeSandwich()
}

case class PourJuiceCommand(robot: Robot) extends RobotCommand {
    override def execute(): Unit = robot.pourJuice()
}

case class CleanUpCommand(robot: Robot) extends RobotCommand {
    override def execute(): Unit = robot.cleanUp()
}

class RobotController {
    val history = ListBuffer[RobotCommand]()

    def issueCommand(command: RobotCommand): Unit = {
        command +=: history
        command.execute()
    }

    def showHistory(): Unit = {
        history.foreach(println)
    }
}

object RobotExample {
    def main(args: Array[String]): Unit = {
        val robot = Robot()
        val robotController = new RobotController
        robotController.issueCommand(MakeSandwichCommand(robot))
        robotController.issueCommand(PourJuiceCommand(robot))
        System.out.println("I'm eating and having some juice.")
        robotController.issueCommand(CleanUpCommand(robot))
        System.out.println("Here is what I asked my robot to do:")
        robotController.showHistory()
    }
}