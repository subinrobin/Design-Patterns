package patterns.oops.adapterPattern.duckExample.duck

class MallardDuck extends Duck {
  
    def quack(): Unit = {
        println("quack")
    }

    def fly(): Unit = {
        println("I'm flying")
    }
}
