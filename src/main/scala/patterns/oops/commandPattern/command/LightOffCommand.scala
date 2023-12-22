package patterns.oops.commandPattern.command

import patterns.oops.commandPattern.vendors.Light

class LightOffCommand(light: Light) extends Command {
  
    def execute(): Unit = {
        light.off()
    }

    def undo(): Unit = light.on()
}
