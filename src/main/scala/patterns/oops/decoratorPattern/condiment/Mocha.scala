package patterns.oops.decoratorPattern.condiment

import patterns.oops.decoratorPattern.beverage.Beverage

class Mocha(beverage: Beverage) extends CondimentDecorator(beverage) {
    
    override def description: String = s"${beverage.description}, Mocha"

    def cost(): Double = beverage.cost() + .20
  
}
