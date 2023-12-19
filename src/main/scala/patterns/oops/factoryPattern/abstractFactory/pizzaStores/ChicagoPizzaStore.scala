package patterns.oops.factoryPattern.abstractFactory.pizzaStores

import patterns.oops.factoryPattern.common.ingredientFactory.ChicagoPizzaIngredientFactory
import patterns.oops.factoryPattern.common.PizzaType
import patterns.oops.factoryPattern.common._
import patterns.oops.factoryPattern.abstractFactory.pizzas._

class ChicagoPizzaStore extends PizzaStore {
    val ingredientFactory = new ChicagoPizzaIngredientFactory

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

        pizza.name_=(s"CHICAGO STYLE ${pizzaType} pizza")

        pizza
    }
}
