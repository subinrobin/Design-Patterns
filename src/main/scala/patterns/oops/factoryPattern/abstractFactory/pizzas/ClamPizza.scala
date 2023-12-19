package patterns.oops.factoryPattern.abstractFactory.pizzas

import patterns.oops.factoryPattern.common.ingredientFactory.PizzaIngredientFactory

class ClamPizza(ingredientFactory: PizzaIngredientFactory) extends Pizza {

    def prepare(): Unit = {
        println(s"preparing $name")

        dough_=(ingredientFactory.createDough())
        sauce_=(ingredientFactory.createSauce())
        cheese_=(ingredientFactory.createCheese())
        clam_=(ingredientFactory.createClam())
    }
}
