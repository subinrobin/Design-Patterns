package patterns.oops.commandPattern

import patterns.oops.commandPattern.command.Command
import patterns.oops.commandPattern.command.NoCommand
import scala.collection.mutable.ArrayBuffer

class RemoteControl {

    val noCommand = new NoCommand

    private val onCommands: Array[Command] = Array.fill(7)(noCommand)
    private val offCommands: Array[Command] = Array.fill(7)(noCommand)
    private var undoCommand: Command = noCommand

    def setCommand(slot: Int, onCommand: Command, offCommand: Command): Unit = {
        onCommands(slot) = onCommand
        offCommands(slot) = offCommand
    }

    def onButtonWasPushed(slot: Int) = {
        onCommands(slot).execute()
        undoCommand = onCommands(slot)
    }

    def offButtonWasPushed(slot: Int) = {
        offCommands(slot).execute()
        undoCommand = offCommands(slot)
    }

    def undoButtonWasPushed(): Unit = {
        undoCommand.undo()
    }

    override def toString(): String = {
        val buffer = ArrayBuffer.empty[String]
        buffer.append("--------Remote Control ---------")
        onCommands.zipWithIndex.foreach(f => {
            val str = s"[slot ${f._2}] ${f._1.getClass().getName()} ${offCommands(f._2).getClass().getName()}"
        })

        buffer.mkString("\n")
    }

}
