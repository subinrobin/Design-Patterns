package patterns.oops.strategyPattern.ducks

import patterns.oops.strategyPattern.flyBehavior.FlyBehavior
import patterns.oops.strategyPattern.quackBehavior.QuackBehavior

trait Duck {
    var flyBehavior: FlyBehavior = _
    var quackBehavior: QuackBehavior = _

    def display(): Unit

    def performFly(): Unit = {
        flyBehavior.fly()
    }

    def performQuack(): Unit = {
        quackBehavior.quack()
    }

    def swim(): Unit = {
        println("All ducks float.....")
    }

    def setFlyBehavior(flyBehavior: FlyBehavior): Unit = {
        this.flyBehavior = flyBehavior
    }

    def setQuackBehavior(quackBehavior: QuackBehavior): Unit = {
        this.quackBehavior = quackBehavior
    }
}
