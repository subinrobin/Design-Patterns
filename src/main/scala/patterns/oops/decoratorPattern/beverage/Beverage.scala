package patterns.oops.decoratorPattern.beverage

trait Beverage {
    private var _description = "Unknown Beverage"

    def description: String = _description

    def desciption_=(value: String): Unit = {
        _description = value
    }

    def cost(): Double
}
