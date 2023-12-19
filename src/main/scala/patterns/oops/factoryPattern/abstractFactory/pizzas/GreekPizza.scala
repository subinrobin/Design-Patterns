package patterns.oops.factoryPattern.abstractFactory.pizzas

import patterns.oops.factoryPattern.common.ingredientFactory.PizzaIngredientFactory

class GreekPizza(ingredientFactory: PizzaIngredientFactory) extends Pizza {

    def prepare(): Unit = {
        println(s"Preparing $name")

        dough_=(ingredientFactory.createDough())
        sauce_=(ingredientFactory.createSauce())
        cheese_=(ingredientFactory.createCheese())
    }
}
