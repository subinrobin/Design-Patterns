package patterns.oops.factoryPattern.abstractFactory.pizzaStores

import patterns.oops.factoryPattern.abstractFactory.pizzas.Pizza
import patterns.oops.factoryPattern.common.ingredientFactory.NYPizzaIngredientFactory
import patterns.oops.factoryPattern.common._
import patterns.oops.factoryPattern.abstractFactory.pizzas.CheesePizza
import patterns.oops.factoryPattern.abstractFactory.pizzas.ClamPizza
import patterns.oops.factoryPattern.abstractFactory.pizzas.PepperoniPizza
import patterns.oops.factoryPattern.abstractFactory.pizzas.VeggiePizza
import patterns.oops.factoryPattern.abstractFactory.pizzas.GreekPizza

class NYPizzaStore extends PizzaStore {

    val ingredientFactory = new NYPizzaIngredientFactory

    def createPizza(pizzaType: PizzaType): Pizza = {

        val pizza =
            pizzaType match {
                case CHEESE =>
                    new CheesePizza(ingredientFactory)
                case CLAM =>
                    new ClamPizza(ingredientFactory)
                case PEPPERONI =>
                    new PepperoniPizza(ingredientFactory)
                case VEGGIE =>
                    new VeggiePizza(ingredientFactory)
                case GREEK =>
                    new GreekPizza(ingredientFactory)
            }

            pizza.name_=(s"NEW YORK STYLE ${pizzaType} pizza")

            pizza
    }

}
