package patterns.oops.facadePattern.systems

class Projector(player: StreamingPlayer) {
  
    def on(): Unit = {
        println("projector on")
    }

    def off(): Unit = {
        println("projector off")
    }

    def tvMode(): Unit = {
        println("start tv mode")
    }

    def wideScreenMode(): Unit = {
        println("widescreen enabled")
    }

    override def toString(): String = {
        "Inside Projector"
    }
}
