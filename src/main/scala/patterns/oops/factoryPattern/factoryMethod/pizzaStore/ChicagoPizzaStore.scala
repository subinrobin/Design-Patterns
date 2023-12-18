package patterns.oops.factoryPattern.factoryMethod.pizzaStore

import patterns.oops.factoryPattern.common.pizzaStore.PizzaStore
import patterns.oops.factoryPattern.common.pizzas.Pizza
import patterns.oops.factoryPattern.common._
import patterns.oops.factoryPattern.common.pizzas.chicagoStyle._

class ChicagoPizzaStore extends PizzaStore {
  
    def createPizza(pizzaType: PizzaType): Pizza = {
        pizzaType match {
            case CHEESE    => new ChicagoStyleCheesePizza
            case CLAM      => new ChicagoStyleClamPizza
            case GREEK     => new ChicagoStyleGreekPizza
            case PEPPERONI => new ChicagoStylePepperoniPizza
            case VEGGIE    => new ChicagoStyleVeggiePizza
        }
    }
}
