package patterns.oops.decoratorPattern.condiment

import patterns.oops.decoratorPattern.beverage.Beverage

class Soy(beverage: Beverage) extends CondimentDecorator(beverage) {
    
    override def description: String = s"${beverage.description}, Soy"

    def cost(): Double = beverage.cost() + .15

}
