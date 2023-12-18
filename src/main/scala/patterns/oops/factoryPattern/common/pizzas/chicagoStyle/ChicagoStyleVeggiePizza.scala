package patterns.oops.factoryPattern.common.pizzas.chicagoStyle

import patterns.oops.factoryPattern.common.pizzas.Pizza

class ChicagoStyleVeggiePizza extends Pizza {
    val name: String = "Chicago Style Veggie Pizza"
    val dough: String = "Extra Thick Crust Dough 5"
    val sauce: String = "Plum Tomato Sauce 5"

    toppings.addOne("Shredded Mozzarella Cheese 5")
}
