package patterns.oops.factoryPattern.common.ingredientFactory

import patterns.oops.factoryPattern.common.dough.Dough
import patterns.oops.factoryPattern.common.sauce.Sauce
import patterns.oops.factoryPattern.common.cheese.Cheese
import patterns.oops.factoryPattern.common.veggies.Veggies
import patterns.oops.factoryPattern.common.pepperoni.Pepperoni
import patterns.oops.factoryPattern.common.clam.Clams
import scala.collection.mutable.ListBuffer

trait PizzaIngredientFactory {
  def createDough(): Dough

  def createSauce(): Sauce

  def createCheese(): Cheese

  def createVeggies(): ListBuffer[Veggies]

  def createPepperoni(): Pepperoni

  def createClam(): Clams
}
