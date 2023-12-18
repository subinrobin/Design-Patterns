package patterns.oops.factoryPattern.common.pizzas.chicagoStyle

import patterns.oops.factoryPattern.common.pizzas.Pizza

class ChicagoStyleClamPizza extends Pizza {
    val name: String = "Chicago Style Clam Pizza"
    val dough: String = "Extra Thick Crust Dough 2"
    val sauce: String = "Plum Tomato Sauce 2"

    toppings.addOne("Shredded Mozzarella Cheese 2")
}
