package patterns.oops.factoryPattern.common.pizzas.plainStyle

import patterns.oops.factoryPattern.common.pizzas.Pizza

class ClamPizza extends Pizza {
    val name: String = "Clam Pizza"
    val dough: String = "Plain Dough 2"
    val sauce: String = "Ketchup 2"

    toppings.addOne("Plain Cheese 2")
}
