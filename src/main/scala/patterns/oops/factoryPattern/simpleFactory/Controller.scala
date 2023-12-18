package patterns.oops.factoryPattern.simpleFactory

import patterns.oops.factoryPattern.common.VEGGIE

object Controller {
    def main(args: Array[String]): Unit = {
        val store = new PizzaStore
        store.orderPizza(VEGGIE)
    }
}
