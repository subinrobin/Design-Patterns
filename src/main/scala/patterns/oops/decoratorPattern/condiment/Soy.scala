package patterns.oops.decoratorPattern.condiment

import patterns.oops.decoratorPattern.beverage.Beverage
import patterns.oops.decoratorPattern.beverage.sizes.TALL
import patterns.oops.decoratorPattern.beverage.sizes.GRANDE
import patterns.oops.decoratorPattern.beverage.sizes.VENTI

class Soy(beverage: Beverage) extends CondimentDecorator(beverage) {

    override def description: String = s"${beverage.description}, Soy"

    def cost(): Double = {
        val soyCost = beverage.size match {
            case TALL   => .10
            case GRANDE => .15
            case VENTI  => .20
        }
        beverage.cost() + soyCost
    }
}
