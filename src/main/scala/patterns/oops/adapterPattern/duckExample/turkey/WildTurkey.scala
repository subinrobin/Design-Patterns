package patterns.oops.adapterPattern.duckExample.turkey

class WildTurkey extends Turkey {
  
    def gobble(): Unit = {
        println("gobble gobble")
    }

    def fly(): Unit = {
        println("I'm flying a short distance")
    }
}
