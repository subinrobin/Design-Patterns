package patterns.oops.commandPattern.command

import patterns.oops.commandPattern.vendors.GarageDoor

class GarageDoorCloseCommand(garageDoor: GarageDoor) extends Command {
  
    def execute(): Unit = {
        garageDoor.down()
        garageDoor.lightOff()
    }

    def undo(): Unit = {
        garageDoor.up()
        garageDoor.lightOn()
    }
}
