package patterns.oops.templateMethodPattern.beverage

trait CaffeineBeverageWithHook {
  
    final def prepareRecipe(): Unit = {
        boilWater()
        brew()
        pourInCup()
        if(customerWantsCondiments()) {
            addCondiments()
        }
    }

    def brew(): Unit

    def addCondiments(): Unit

    def boilWater(): Unit = {
        println("Boiling water")
    }

    def pourInCup(): Unit = {
        println("Pouring into cup")
    }

    def customerWantsCondiments(): Boolean = { // empty or default implementation
        true
    }
}
