package patterns.oops.commandPattern

import patterns.oops.commandPattern.vendors.Light
import patterns.oops.commandPattern.vendors.GarageDoor
import patterns.oops.commandPattern.vendors.Stereo
import patterns.oops.commandPattern.command.LightOnCommand
import patterns.oops.commandPattern.command.LightOffCommand
import patterns.oops.commandPattern.command.GarageDoorOpenCommand
import patterns.oops.commandPattern.command.GarageDoorCloseCommand
import patterns.oops.commandPattern.command.StereoOnWithCDCommand
import patterns.oops.commandPattern.command.StereoOffWithCDCommand
import patterns.oops.commandPattern.command.MacroCommand

object RemoteControlTest {
  def main(args: Array[String]): Unit = {
    
    val remoteControl = new RemoteControl
    val livingRoomLight = new Light("Living Room")
    val kitchenLight = new Light("Kitchen")
    val garageDoor1 = new GarageDoor
    val garageDoor2 = new GarageDoor
    val stereo = new Stereo

    val livingRoomLightOn = new LightOnCommand(livingRoomLight)
    val livingRoomLightOff = new LightOffCommand(livingRoomLight)
    val kitchenLightOn = new LightOnCommand(kitchenLight)
    val kitchenLightOff = new LightOffCommand(kitchenLight)

    val garageDoor1OpenCommand = new GarageDoorOpenCommand(garageDoor1)
    val garageDoor2OpenCommand = new GarageDoorOpenCommand(garageDoor2)
    val garageDoor1CloseCommand = new GarageDoorCloseCommand(garageDoor1)
    val garageDoor2CloseCommand = new GarageDoorCloseCommand(garageDoor2)

    val stereoOn = new StereoOnWithCDCommand(stereo)
    val stereoOff = new StereoOffWithCDCommand(stereo)

    remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff)
    remoteControl.setCommand(1, kitchenLightOn, kitchenLightOff)
    remoteControl.setCommand(2, garageDoor1OpenCommand, garageDoor1CloseCommand)
    remoteControl.setCommand(3, garageDoor2OpenCommand, garageDoor2CloseCommand)
    remoteControl.setCommand(4, stereoOn, stereoOff)

    println(remoteControl)

    remoteControl.onButtonWasPushed(0)
    remoteControl.offButtonWasPushed(0)
    println("remote control")
    remoteControl.undoButtonWasPushed()
    remoteControl.onButtonWasPushed(1)
    remoteControl.offButtonWasPushed(1)
    remoteControl.onButtonWasPushed(2)
    remoteControl.offButtonWasPushed(2)
    remoteControl.onButtonWasPushed(3)
    remoteControl.offButtonWasPushed(3)
    remoteControl.undoButtonWasPushed()

    println(remoteControl)

    val partyOn = Array(livingRoomLightOn, kitchenLightOn, stereoOn, garageDoor1OpenCommand)
    val partyOff = Array(livingRoomLightOff, kitchenLightOff, garageDoor1CloseCommand, stereoOff)

    val partyOnMacro = new MacroCommand(partyOn)
    val partyOffMacro = new MacroCommand(partyOff)
    remoteControl.setCommand(5, partyOnMacro, partyOffMacro)

    remoteControl.onButtonWasPushed(5)
    remoteControl.offButtonWasPushed(5)
  }
}
