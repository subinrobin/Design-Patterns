package patterns.oops.commandPattern.command

import patterns.oops.commandPattern.vendors.Stereo

class StereoOnWithCDCommand(stereo: Stereo) extends Command {
  
    def execute(): Unit = {
        stereo.on()
        stereo.setCD()
        stereo.setVolumne(11)
    }

    def undo(): Unit = {
        stereo.off()
    }
}
