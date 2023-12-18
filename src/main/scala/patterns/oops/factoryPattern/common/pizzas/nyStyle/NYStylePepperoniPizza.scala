package patterns.oops.factoryPattern.common.pizzas.nyStyle

import patterns.oops.factoryPattern.common.pizzas.Pizza

class NYStylePepperoniPizza extends Pizza {

    val name: String = "NY Style Pepperoni Pizza"
    val dough: String = "Thin Crust Dough 4"
    val sauce: String = "Marinara Sauce 4"

    toppings.addOne("Grated Reggiano Cheese 4")
}
