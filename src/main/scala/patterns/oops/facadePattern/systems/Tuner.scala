package patterns.oops.facadePattern.systems

class Tuner(amplifier: Amplifier) {
  
    def on(): Unit = {
        println("tuner on")
        println(amplifier.on())
    }

    def off(): Unit = {
        println("tuner off")
    }

    def setAm(): Unit = {
        println("set AM")
    }

    def setFm(): Unit = {
        println("set FM")
    }

    def setFrequency(): Unit = {
        println("set Frequency")
    }    

    override def toString(): String = {
        "Inside Tuner"
    }
}
