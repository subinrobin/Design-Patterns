package patterns.oops.factoryPattern.simpleFactory

import patterns.oops.factoryPattern.common.PizzaType
import patterns.oops.factoryPattern.common.pizzas.Pizza

class PizzaStore {

    def orderPizza(pizzaType: PizzaType): Pizza = {
        val pizza = SimplePizzaFactory.createPizza(pizzaType)
        pizza.prepare()
        pizza.bake()
        pizza.cut()
        pizza.box()

        pizza
    }
}
