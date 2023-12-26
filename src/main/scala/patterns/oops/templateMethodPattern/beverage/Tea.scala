package patterns.oops.templateMethodPattern.beverage

class Tea extends CaffeineBeverage {

    def brew(): Unit = {
        println("Steeping the tea")
    }

    def addCondiments():Unit = {
        println("Adding Lemon")
    }
}
