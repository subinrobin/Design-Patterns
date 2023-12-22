package patterns.oops.commandPattern

import patterns.oops.commandPattern.command.Command

class SimpleRemoteControl {

    private var _slot: Command = _

    def slot_=(value: Command) = {
        _slot = value
    }

    def slot: Command = _slot

    def buttonWasPressed(): Unit = {
        slot.execute
    }
}
