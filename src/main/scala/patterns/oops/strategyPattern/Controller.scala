package patterns.oops.strategyPattern

import patterns.oops.strategyPattern.ducks.Duck
import patterns.oops.strategyPattern.ducks.MallardDuck
import patterns.oops.strategyPattern.ducks.ModelDuck
import patterns.oops.strategyPattern.flyBehavior.FlyRocketPowered

object Controller {
    def main(args: Array[String]): Unit = {
        val mallard: Duck = new MallardDuck
        mallard.performQuack()
        mallard.performFly()

        val model: Duck = new ModelDuck
        model.performFly()
        model.setFlyBehavior(new FlyRocketPowered())
        model.performFly()
    }
}
