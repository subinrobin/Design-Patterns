package patterns.oops.commandPattern

import patterns.oops.commandPattern.vendors.Light
import patterns.oops.commandPattern.command.LightOnCommand
import patterns.oops.commandPattern.vendors.GarageDoor
import patterns.oops.commandPattern.command.GarageDoorOpenCommand

object SimpleRemoteControlTest {
  
    def main(args: Array[String]): Unit = {
        val remote = new SimpleRemoteControl
        val light = new Light("kitchen")
        val garageDoor = new GarageDoor
        val lightOn = new LightOnCommand(light)
        val garageOpen = new GarageDoorOpenCommand(garageDoor)

        remote.slot_=(lightOn)
        remote.buttonWasPressed()
        remote.slot_=(garageOpen)
        remote.buttonWasPressed()

    }   
}
