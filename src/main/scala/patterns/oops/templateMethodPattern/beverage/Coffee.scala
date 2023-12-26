package patterns.oops.templateMethodPattern.beverage

class Coffee extends CaffeineBeverage {

    def brew(): Unit = {
        println("Drippipng Coffee through filter")
    }

    def addCondiments():Unit = {
        println("Adding Sugar and Milk")
    }
}
