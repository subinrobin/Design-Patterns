package patterns.oops.decoratorPattern.condiment

import patterns.oops.decoratorPattern.beverage.Beverage

class Whip(beverage: Beverage) extends CondimentDecorator(beverage) {
    
    override def description: String = s"${beverage.description}, Whip"

    def cost(): Double = beverage.cost() + .10

}
