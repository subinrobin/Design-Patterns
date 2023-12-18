package patterns.oops.decoratorPattern.condiment

import patterns.oops.decoratorPattern.beverage.Beverage
import patterns.oops.decoratorPattern.beverage.sizes.BeverageSize

abstract class CondimentDecorator(beverage: Beverage) extends Beverage {

    def description: String

    override def size: BeverageSize = beverage.size
}
