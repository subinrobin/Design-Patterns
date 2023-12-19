package patterns.oops.factoryPattern.abstractFactory.pizzaStores

import patterns.oops.factoryPattern.common.PizzaType
import patterns.oops.factoryPattern.abstractFactory.pizzas.Pizza

trait PizzaStore {
    def createPizza(pizzaType: PizzaType): Pizza

    def orderPizza(pizzaType: PizzaType): Pizza = {
        val pizza: Pizza = createPizza(pizzaType)

        pizza.prepare()
        pizza.bake()
        pizza.cut()
        pizza.box()

        pizza
    }
}
