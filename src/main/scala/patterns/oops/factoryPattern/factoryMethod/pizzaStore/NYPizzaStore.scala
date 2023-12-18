package patterns.oops.factoryPattern.factoryMethod.pizzaStore

import patterns.oops.factoryPattern.common.pizzaStore.PizzaStore
import patterns.oops.factoryPattern.common.pizzas.Pizza
import patterns.oops.factoryPattern.common._
import patterns.oops.factoryPattern.common.pizzas.nyStyle._

class NYPizzaStore extends PizzaStore {
  
    def createPizza(pizzaType: PizzaType): Pizza = {
        pizzaType match {
            case CHEESE    => new NYStyleCheesePizza
            case CLAM      => new NYStyleClamPizza
            case GREEK     => new NYStyleGreekPizza
            case PEPPERONI => new NYStylePepperoniPizza
            case VEGGIE    => new NYStyleVeggiePizza
        }
    }
}
