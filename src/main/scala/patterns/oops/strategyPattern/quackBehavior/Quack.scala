package patterns.oops.strategyPattern.quackBehavior

class Quack extends QuackBehavior {
    override def quack(): Unit = {
        println("quack")
    }
}
