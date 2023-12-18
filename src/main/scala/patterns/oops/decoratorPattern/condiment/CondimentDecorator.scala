package patterns.oops.decoratorPattern.condiment

import patterns.oops.decoratorPattern.beverage.Beverage

trait CondimentDecorator extends Beverage {
    val beverage: Beverage

    def description_=(value: String): Unit
}
