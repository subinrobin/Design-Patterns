package patterns.oops.factoryPattern.common.pizzas.chicagoStyle

import patterns.oops.factoryPattern.common.pizzas.Pizza

class ChicagoStyleCheesePizza extends Pizza {
    val name: String = "Chicago Style Cheese Pizza"
    val dough: String = "Extra Thick Crust Dough 1"
    val sauce: String = "Plum Tomato Sauce 1"

    toppings.addOne("Shredded Mozzarella Cheese 1")
}
