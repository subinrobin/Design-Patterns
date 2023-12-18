package patterns.oops.factoryPattern.common.pizzas.nyStyle

import patterns.oops.factoryPattern.common.pizzas.Pizza

class NYStyleGreekPizza extends Pizza {
    val name: String = "NY Style Greek Pizza"
    val dough: String = "Thin Crust Dough 3"
    val sauce: String = "Marinara Sauce 3"

    toppings.addOne("Grated Reggiano Cheese 3")
}
