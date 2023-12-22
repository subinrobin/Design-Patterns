package patterns.oops.commandPattern.vendors

class Stereo {
  
    def on(): Unit = {
        println("stereo is on")
    }

    def off(): Unit = {
        println("stereo is off")
    }

    def setCD(): Unit = {
        println("set CD in stereo")
    }

    def setDvd(): Unit = {
        println("set Dvd in stereo")
    }

    def setRadio(): Unit = {
        println("set Radio in stereo")
    }

    def setVolumne(volume: Int): Unit = {
        println(s"set volume ${volume} in stereo")
    }
}

