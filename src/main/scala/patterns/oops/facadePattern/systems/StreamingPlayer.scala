package patterns.oops.facadePattern.systems

class StreamingPlayer {
  
    val _amplifier = new Amplifier

    def on(): Unit = {
        println("streaming player on")
    }

    def off(): Unit = {
        println("streaming player off")
    }

    def pause(): Unit = {
        println("streaming player pause")
    }

    def play(movie: String): Unit = {
        println(s"streaming player play $movie")
    }

    def setSurroundAudio(): Unit = {
        println("set surround audio")
    }

    def setTwoChannelAudio(): Unit = {
        println("set 2 channel audio")
    }

    def stop(): Unit = {
        println("stop streaming player")
    }

    override def toString(): String = {
        "Inside Streaming Player"
    }
}
