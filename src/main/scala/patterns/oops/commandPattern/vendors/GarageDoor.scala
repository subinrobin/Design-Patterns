package patterns.oops.commandPattern.vendors

class GarageDoor {
  
    def up(): Unit = {
        println("move up garage door")
    }

    def down(): Unit = {
        println("move down garage door")
    }

    def stop(): Unit = {
        println("stop garage door movement")
    }

    def lightOn(): Unit = {
        println("switch on garage light")
    }

    def lightOff(): Unit = {
        println("switch off garage light")
    }
}
