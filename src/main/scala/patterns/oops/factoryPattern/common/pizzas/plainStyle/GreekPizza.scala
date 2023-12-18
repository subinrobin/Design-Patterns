package patterns.oops.factoryPattern.common.pizzas.plainStyle

import patterns.oops.factoryPattern.common.pizzas.Pizza

class GreekPizza extends Pizza {
    val name: String = "Greek Pizza"
    val dough: String = "Plain Dough 3"
    val sauce: String = "Ketchup 3"

    toppings.addOne("Plain Cheese 3")
}
