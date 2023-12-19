package patterns.oops.factoryPattern.abstractFactory.pizzas

import patterns.oops.factoryPattern.common.ingredientFactory.PizzaIngredientFactory

class VeggiePizza(ingredientFactory: PizzaIngredientFactory) extends Pizza {
  
    def prepare(): Unit = {
         println(s"Preparing $name")
    }
}
