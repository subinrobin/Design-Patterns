package patterns.oops.factoryPattern.common.pizzas.chicagoStyle

import patterns.oops.factoryPattern.common.pizzas.Pizza

class ChicagoStylePepperoniPizza extends Pizza {
    val name: String = "Chicago Style Pepperoni Pizza"
    val dough: String = "Extra Thick Crust Dough 4"
    val sauce: String = "Plum Tomato Sauce 4"

    toppings.addOne("Shredded Mozzarella Cheese 4")
}
