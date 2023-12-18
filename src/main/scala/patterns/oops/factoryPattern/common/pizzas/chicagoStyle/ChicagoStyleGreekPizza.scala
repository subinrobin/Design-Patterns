package patterns.oops.factoryPattern.common.pizzas.chicagoStyle

import patterns.oops.factoryPattern.common.pizzas.Pizza

class ChicagoStyleGreekPizza extends Pizza {
    val name: String = "Chicago Style Greek Pizza"
    val dough: String = "Extra Thick Crust Dough 3"
    val sauce: String = "Plum Tomato Sauce 3"

    toppings.addOne("Shredded Mozzarella Cheese 3")
}
