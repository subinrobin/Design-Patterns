package patterns.oops.factoryPattern.factoryMethod

import patterns.oops.factoryPattern.factoryMethod.pizzaStore.NYPizzaStore
import patterns.oops.factoryPattern.factoryMethod.pizzaStore.ChicagoPizzaStore
import patterns.oops.factoryPattern.common.CHEESE
import patterns.oops.factoryPattern.common.pizzaStore.PizzaStore
import patterns.oops.factoryPattern.common.pizzas.Pizza

object PizzaTestDrive {
    def main(args: Array[String]): Unit = {
        val nyStore: PizzaStore = new NYPizzaStore
        val chicagoStore: PizzaStore = new ChicagoPizzaStore

        var pizza: Pizza = nyStore.orderPizza(CHEESE)
        println(s"Ethan ordered ${pizza.name}")

        pizza = chicagoStore.orderPizza(CHEESE)
        println(s"Joel ordered ${pizza.name}")
    }

}
