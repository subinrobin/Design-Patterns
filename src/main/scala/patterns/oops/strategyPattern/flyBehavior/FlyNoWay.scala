package patterns.oops.strategyPattern.flyBehavior

class FlyNoWay extends FlyBehavior {
    def fly(): Unit = {
        println("I cannot fly..")
    }
}
