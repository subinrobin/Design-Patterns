package patterns.oops.facadePattern.systems

class Screen {
  
    def up(): Unit = {
        println("bring up the screen")
    }

    def down(): Unit = {
        println("close down the screen")
    }

    override def toString(): String = {
        "Inside Screen"
    }
}
