package patterns.oops.factoryPattern.common.pizzas.nyStyle

import patterns.oops.factoryPattern.common.pizzas.Pizza

class NYStyleCheesePizza extends Pizza {
    val name: String = "NY Style Cheese Pizza"
    val dough: String = "Thin Crust Dough 1"
    val sauce: String = "Marinara Sauce 1"

    toppings.addOne("Grated Reggiano Cheese 1")
}
