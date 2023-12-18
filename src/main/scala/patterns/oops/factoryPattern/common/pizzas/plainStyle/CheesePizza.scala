package patterns.oops.factoryPattern.common.pizzas.plainStyle

import patterns.oops.factoryPattern.common.pizzas.Pizza

class CheesePizza extends Pizza {
    val name: String = "Cheese Pizza"
    val dough: String = "Plain Dough 1"
    val sauce: String = "Ketchup 1"

    toppings.addOne("Plain Cheese 1")
}
