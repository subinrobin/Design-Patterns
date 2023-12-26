package patterns.oops.templateMethodPattern.beverage

import scala.util.Try

class CoffeeWithHook extends CaffeineBeverageWithHook {

    def brew(): Unit = {
        println("Drippipng Coffee through filter")
    }

    def addCondiments(): Unit = {
        println("Adding Sugar and Milk")
    }

    override def customerWantsCondiments(): Boolean = {
        val promptText = "Would you like milk and sugar with your coffee (y/n)?"
        val userInput = Try(scala.io.StdIn.readLine(promptText))
        userInput.isSuccess && userInput.get.toLowerCase().startsWith("y")
    }
}
