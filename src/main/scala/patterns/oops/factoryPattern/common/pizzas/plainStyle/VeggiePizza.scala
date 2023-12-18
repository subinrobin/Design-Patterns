package patterns.oops.factoryPattern.common.pizzas.plainStyle

import patterns.oops.factoryPattern.common.pizzas.Pizza

class VeggiePizza extends Pizza {
    val name: String = "Veggie Pizza"
    val dough: String = "Plain Dough 5"
    val sauce: String = "Ketchup 5"

    toppings.addOne("Plain Cheese 5")
}
