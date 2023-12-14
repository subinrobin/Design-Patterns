package patterns.oops.strategyPattern.ducks

import patterns.oops.strategyPattern.flyBehavior.FlyNoWay
import patterns.oops.strategyPattern.quackBehavior.MuteQuack

class ModelDuck extends Duck {
    flyBehavior = new FlyNoWay
    quackBehavior = new MuteQuack

    def display(): Unit = {
        println("I am a model duck")
    }
}
