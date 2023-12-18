package patterns.oops.factoryPattern.common.pizzaStore

import patterns.oops.factoryPattern.common.pizzas.Pizza
import patterns.oops.factoryPattern.common.PizzaType

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
