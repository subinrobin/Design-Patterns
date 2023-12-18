package patterns.oops.decoratorPattern.condiment

import patterns.oops.decoratorPattern.beverage.Beverage

abstract class CondimentDecorator(beverage: Beverage) extends Beverage {

    def description: String
}
