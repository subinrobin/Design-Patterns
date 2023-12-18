package patterns.oops.decoratorPattern

import patterns.oops.decoratorPattern.beverage.Espresso
import patterns.oops.decoratorPattern.beverage.DarkRoast
import patterns.oops.decoratorPattern.condiment.Mocha
import patterns.oops.decoratorPattern.beverage.Beverage
import patterns.oops.decoratorPattern.condiment.Whip
import patterns.oops.decoratorPattern.beverage.HouseBlend
import patterns.oops.decoratorPattern.condiment.Soy

object StarbuzzCoffee {
    def main(args: Array[String]): Unit = {
        val beverage: Beverage = new Espresso
        println(s"${beverage.description} $$${beverage.cost()}")

        var beverage2: Beverage = new DarkRoast
        beverage2 = new Mocha(beverage2)
        beverage2 = new Mocha(beverage2)
        beverage2 = new Whip(beverage2)
        println(s"${beverage2.description} $$${beverage2.cost()}")

        var beverage3: Beverage = new HouseBlend
        beverage3 = new Soy(beverage3)
        beverage3 = new Mocha(beverage3)
        beverage3 = new Whip(beverage3)
        println(s"${beverage3.description} $$${beverage3.cost()}")
    }
}
