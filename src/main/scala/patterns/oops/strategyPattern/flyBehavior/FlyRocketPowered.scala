package patterns.oops.strategyPattern.flyBehavior

class FlyRocketPowered extends FlyBehavior {
    def fly() = {
        println("super fast with rocket powered")
    }
}
