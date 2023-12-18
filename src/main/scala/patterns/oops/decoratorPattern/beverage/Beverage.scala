package patterns.oops.decoratorPattern.beverage

trait Beverage {
    private var _description: String = "Unknown Beverage"

    def description: String = _description

    def description_=(value: String): Unit = {
        _description = value
    }

    def cost(): Double
}
