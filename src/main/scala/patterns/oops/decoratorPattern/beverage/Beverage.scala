package patterns.oops.decoratorPattern.beverage

import patterns.oops.decoratorPattern.beverage.sizes.TALL
import patterns.oops.decoratorPattern.beverage.sizes.BeverageSize

trait Beverage {
    private var _description: String = "Unknown Beverage"

    def description: String = _description

    def description_=(value: String): Unit = {
        _description = value
    }

    private var _size: BeverageSize = TALL

    def size: BeverageSize = _size

    def size_=(value: BeverageSize): Unit = {
        _size = value
    }

    def cost(): Double
}
