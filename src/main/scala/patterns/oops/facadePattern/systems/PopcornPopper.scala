package patterns.oops.facadePattern.systems

class PopcornPopper {
  
    def on(): Unit = {
        println("popcorn popper on")
    }

    def off(): Unit = {
        println("popcorn popper off")
    }

    def pop(): Unit = {
        println("pop the corns")
    }

    override def toString(): String = {
        "Inside popper"
    }
}
