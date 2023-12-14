package patterns.oops.strategyPattern.quackBehavior

class MuteQuack extends QuackBehavior {
    override def quack(): Unit = {
        println("Dumb$$$$")
    }
}
