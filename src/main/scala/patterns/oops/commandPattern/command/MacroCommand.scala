package patterns.oops.commandPattern.command

class MacroCommand(commands: Array[Command]) extends Command {
  
    def execute(): Unit = {
        commands.foreach(command => {
            command.execute()
        })
    }

    def undo(): Unit = {
        commands.foreach(command => {
            command.undo()
        })
    }

}
