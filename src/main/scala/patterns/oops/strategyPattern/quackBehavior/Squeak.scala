package patterns.oops.strategyPattern.quackBehavior

class Squeak extends QuackBehavior {
    override def quack(): Unit = {
        println("squeak@@@")
    }
}
