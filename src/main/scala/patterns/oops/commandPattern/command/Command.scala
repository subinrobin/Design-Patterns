package patterns.oops.commandPattern.command

trait Command {
  
    def execute(): Unit

    def undo(): Unit
}
