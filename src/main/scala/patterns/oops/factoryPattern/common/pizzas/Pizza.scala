package patterns.oops.factoryPattern.common.pizzas

import scala.collection.mutable.ListBuffer

trait Pizza {
    val name: String
    val dough: String
    val sauce: String
    val toppings: ListBuffer[String] = ListBuffer.empty[String]

    def prepare(): Unit = {
        println("prepare dough")
        toppings.foreach(topping => println(s"  $topping"))
    }

    def bake(): Unit = {
        println("bake in oven")
    }

    def cut(): Unit = {
        println("cut into pieces")
    }

    def box(): Unit = {
        println("put into box")
    }

}
