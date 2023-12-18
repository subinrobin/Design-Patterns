package patterns.oops.factoryPattern.common.pizzas.nyStyle

import patterns.oops.factoryPattern.common.pizzas.Pizza

class NYStyleClamPizza extends Pizza {
    val name: String = "NY Style Clam Pizza"
    val dough: String = "Thin Crust Dough 2"
    val sauce: String = "Marinara Sauce 2"

    toppings.addOne("Grated Reggiano Cheese 2")
}
