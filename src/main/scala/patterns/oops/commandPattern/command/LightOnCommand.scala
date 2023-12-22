package patterns.oops.commandPattern.command

import patterns.oops.commandPattern.vendors.Light

class LightOnCommand(light: Light) extends Command {
  
    def execute(): Unit = light.on()

    def undo(): Unit = light.off()
}
