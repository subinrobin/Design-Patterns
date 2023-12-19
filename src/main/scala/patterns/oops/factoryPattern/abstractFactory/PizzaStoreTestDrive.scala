package patterns.oops.factoryPattern.abstractFactory

import patterns.oops.factoryPattern.abstractFactory.pizzaStores.NYPizzaStore
import patterns.oops.factoryPattern.common.CHEESE
import patterns.oops.factoryPattern.abstractFactory.pizzaStores.ChicagoPizzaStore
import patterns.oops.factoryPattern.common.CLAM

object PizzaStoreTestDrive {
  def main(args: Array[String]): Unit = {
    val nyPizzaStore = new NYPizzaStore
    nyPizzaStore.orderPizza(CHEESE)

    val chicagoPizzaStore = new ChicagoPizzaStore
    chicagoPizzaStore.orderPizza(CLAM)
  }
}
