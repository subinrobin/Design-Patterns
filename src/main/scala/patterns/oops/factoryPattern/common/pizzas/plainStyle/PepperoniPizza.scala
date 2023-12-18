package patterns.oops.factoryPattern.common.pizzas.plainStyle

import patterns.oops.factoryPattern.common.pizzas.Pizza

class PepperoniPizza  extends Pizza {
    val name: String = "Pepperoni Pizza"
    val dough: String = "Plain Dough 4"
    val sauce: String = "Ketchup 4"

    toppings.addOne("Plain Cheese 4")
}
