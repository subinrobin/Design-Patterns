package patterns.oops.facadePattern.systems

class Amplifier {
  
    var _tuner: Tuner = _
    var _player: StreamingPlayer = _

    def on(): Unit = {
        println("amp on")
    }

    def off(): Unit = {
        println("amp off")
    }

    def tuner_=(value: Tuner) = {
        _tuner = value
    }

    def player_=(value: StreamingPlayer) = {
        _player = value
    }

    def player = _player
    
    def setStereoSound(): Unit = {
        player.setSurroundAudio()
    }

    def setSurroundSound(): Unit = {
        player.setSurroundAudio()
    }

    def setVolume(volume: Int): Unit = {
        println(s"volume set to $volume")
    }

    override def toString(): String = {
        "Inside Amplifier"
    }
}
