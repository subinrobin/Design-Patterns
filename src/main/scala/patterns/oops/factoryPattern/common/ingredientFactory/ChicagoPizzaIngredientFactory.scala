package patterns.oops.factoryPattern.common.ingredientFactory

import patterns.oops.factoryPattern.common.cheese.Cheese
import patterns.oops.factoryPattern.common.cheese.MozarellaCheese
import patterns.oops.factoryPattern.common.clam.Clams
import patterns.oops.factoryPattern.common.clam.FrozenClams
import patterns.oops.factoryPattern.common.dough.Dough
import patterns.oops.factoryPattern.common.dough.ThickCrustDough
import patterns.oops.factoryPattern.common.pepperoni.Pepperoni
import patterns.oops.factoryPattern.common.pepperoni.SlicedPepperoni
import patterns.oops.factoryPattern.common.sauce.Sauce
import patterns.oops.factoryPattern.common.sauce.PlumTomatoSauce
import patterns.oops.factoryPattern.common.veggies.Veggies
import patterns.oops.factoryPattern.common.veggies.BlackOlives
import patterns.oops.factoryPattern.common.veggies.EggPlant
import patterns.oops.factoryPattern.common.veggies.Spinach
import scala.collection.mutable.ListBuffer

class ChicagoPizzaIngredientFactory extends PizzaIngredientFactory {
  
    def createCheese(): Cheese = new MozarellaCheese

    def createClam(): Clams = new FrozenClams

    def createDough(): Dough = new ThickCrustDough
        
    def createPepperoni(): Pepperoni = new SlicedPepperoni

    def createSauce(): Sauce = new PlumTomatoSauce

    def createVeggies(): ListBuffer[Veggies] = ListBuffer(new BlackOlives, new EggPlant, new Spinach)
    
}
