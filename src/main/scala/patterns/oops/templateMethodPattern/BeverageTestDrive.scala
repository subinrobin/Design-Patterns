package patterns.oops.templateMethodPattern

import patterns.oops.templateMethodPattern.beverage.TeaWithHook
import patterns.oops.templateMethodPattern.beverage.CoffeeWithHook

object BeverageTestDrive {
  
    def main(args: Array[String]): Unit = {
        val teaHook = new TeaWithHook
        val coffeeHook = new CoffeeWithHook

        println("Making tea....")
        teaHook.prepareRecipe()

        println("Making Coffee...")
        coffeeHook.prepareRecipe()
    }
}
