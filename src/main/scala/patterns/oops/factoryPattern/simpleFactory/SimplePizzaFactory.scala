package patterns.oops.factoryPattern.simpleFactory

import patterns.oops.factoryPattern.common.PizzaType
import patterns.oops.factoryPattern.common.pizzas.Pizza
import patterns.oops.factoryPattern.common.CHEESE
import patterns.oops.factoryPattern.common.pizzas.plainStyle.CheesePizza
import patterns.oops.factoryPattern.common.CLAM
import patterns.oops.factoryPattern.common.pizzas.plainStyle.ClamPizza
import patterns.oops.factoryPattern.common.GREEK
import patterns.oops.factoryPattern.common.pizzas.plainStyle.GreekPizza
import patterns.oops.factoryPattern.common.PEPPERONI
import patterns.oops.factoryPattern.common.pizzas.plainStyle.PepperoniPizza
import patterns.oops.factoryPattern.common.VEGGIE
import patterns.oops.factoryPattern.common.pizzas.plainStyle.VeggiePizza

object SimplePizzaFactory {

    def createPizza(pizzaType: PizzaType): Pizza = {
        pizzaType match {
            case CHEESE    => new CheesePizza
            case CLAM      => new ClamPizza
            case GREEK     => new GreekPizza
            case PEPPERONI => new PepperoniPizza
            case VEGGIE    => new VeggiePizza
        }
    }
}
