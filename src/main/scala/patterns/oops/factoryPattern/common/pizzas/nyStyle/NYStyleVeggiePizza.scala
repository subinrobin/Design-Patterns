package patterns.oops.factoryPattern.common.pizzas.nyStyle

import patterns.oops.factoryPattern.common.pizzas.Pizza

class NYStyleVeggiePizza extends Pizza {

    val name: String = "NY Style Veggie Pizza"
    val dough: String = "Thin Crust Dough 5"
    val sauce: String = "Marinara Sauce 5"

    toppings.addOne("Grated Reggiano Cheese 5")
}
