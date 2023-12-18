package patterns.oops.factoryPattern.common.ingredientFactory
import patterns.oops.factoryPattern.common.sauce.Sauce
import patterns.oops.factoryPattern.common.cheese.Cheese
import patterns.oops.factoryPattern.common.veggies.Veggies
import patterns.oops.factoryPattern.common.dough.Dough
import patterns.oops.factoryPattern.common.clam.Clams
import patterns.oops.factoryPattern.common.pepperoni.Pepperoni
import patterns.oops.factoryPattern.common.dough.ThinCrustDough
import patterns.oops.factoryPattern.common.sauce.MarianaSauce
import patterns.oops.factoryPattern.common.cheese.RegiannoCheese
import scala.collection.mutable.ListBuffer
import patterns.oops.factoryPattern.common.veggies.Garlic
import patterns.oops.factoryPattern.common.veggies.Onion
import patterns.oops.factoryPattern.common.veggies.Mushroom
import patterns.oops.factoryPattern.common.veggies.RedPepper
import patterns.oops.factoryPattern.common.pepperoni.SlicedPepperoni
import patterns.oops.factoryPattern.common.clam.FreshClams

class NYPizzaIngredientFactory extends PizzaIngredientFactory {
  
    def createDough(): Dough = new ThinCrustDough
    
    def createSauce(): Sauce = new MarianaSauce
    
    def createCheese(): Cheese = new RegiannoCheese
    
    def createVeggies(): ListBuffer[Veggies] = ListBuffer(new Garlic, new Onion, new Mushroom, new RedPepper)
    
    def createPepperoni(): Pepperoni = new SlicedPepperoni
    
    def createClam(): Clams = new FreshClams
    
}
