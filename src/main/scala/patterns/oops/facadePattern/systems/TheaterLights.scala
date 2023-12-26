package patterns.oops.facadePattern.systems

class TheaterLights {
  
    def on(): Unit = {
        println("Theater Lights on")
    }

    def off(): Unit = {
        println("Theater Lights off")
    }

    def dim(brightness: Int): Unit = {
        println(s"dim theater lights to $brightness")
    }

    override def toString(): String = {
        "Inside Theater Lights"
    }
}
