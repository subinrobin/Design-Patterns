package patterns.oops.templateMethodPattern.beverage

trait CaffeineBeverage {
  
    final def prepareRecipe(): Unit = {
        boilWater()
        brew()
        pourInCup()
        addCondiments()
    }

    def brew(): Unit

    def addCondiments(): Unit

    def boilWater(): Unit = {
        println("Boiling water")
    }

    def pourInCup(): Unit = {
        println("Pouring into cup")
    }

    def hook(): Unit = { // empty or default implementation

    }
}
