package patterns.oops.commandPattern.command

import patterns.oops.commandPattern.vendors.GarageDoor

class GarageDoorOpenCommand(garageDoor: GarageDoor) extends Command {

    def execute(): Unit = {
        garageDoor.up()
        garageDoor.lightOn()
    }

    def undo(): Unit = {
        garageDoor.lightOn()
        garageDoor.down()
    }
}
