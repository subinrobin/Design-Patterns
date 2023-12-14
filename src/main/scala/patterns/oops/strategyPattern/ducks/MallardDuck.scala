package patterns.oops.strategyPattern.ducks

import patterns.oops.strategyPattern.quackBehavior.Quack
import patterns.oops.strategyPattern.flyBehavior.FlyWithWings

class MallardDuck extends Duck {
    quackBehavior = new Quack
    flyBehavior = new FlyWithWings

    def display(): Unit = {
        println("MallardDuck here")
    }
}
