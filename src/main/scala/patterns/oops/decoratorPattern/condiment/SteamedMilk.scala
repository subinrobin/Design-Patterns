package patterns.oops.decoratorPattern.condiment

import patterns.oops.decoratorPattern.beverage.Beverage

class SteamedMilk(beverage: Beverage) extends CondimentDecorator(beverage) {
    
    override def description: String = s"${beverage.description}, Steamed Milk"

    def cost(): Double = beverage.cost() + .10

}