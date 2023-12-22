package patterns.oops.commandPattern.command

class NoCommand extends Command {
    
    def execute(): Unit = {
        println("No assignement")
    }

    def undo(): Unit = {
        println("no assignment")
    }
}
