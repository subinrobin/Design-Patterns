package patterns.oops.templateMethodPattern.beverage

import scala.util.Try

class TeaWithHook extends CaffeineBeverageWithHook {

    def brew(): Unit = {
        println("Steeping the tea")
    }

    def addCondiments():Unit = {
        println("Adding Lemon")
    }

    override def customerWantsCondiments(): Boolean = {
        val promptText = "Would you like lemon with your tea (y/n)?"
        val userInput = Try(scala.io.StdIn.readLine(promptText))
        userInput.isSuccess && userInput.get.toLowerCase().startsWith("y")
    }
}
