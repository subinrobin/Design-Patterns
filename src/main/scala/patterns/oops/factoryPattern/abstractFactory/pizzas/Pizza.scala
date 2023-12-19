package patterns.oops.factoryPattern.abstractFactory.pizzas

import patterns.oops.factoryPattern.common.veggies.Veggies
import scala.collection.mutable.ListBuffer
import patterns.oops.factoryPattern.common.sauce.Sauce
import patterns.oops.factoryPattern.common.cheese.Cheese
import patterns.oops.factoryPattern.common.pepperoni.Pepperoni
import patterns.oops.factoryPattern.common.clam.Clams
import patterns.oops.factoryPattern.common.dough.Dough

trait Pizza {
    private var _name: String = _
    private var _dough: Dough = _
    private var _sauce: Sauce = _
    private var _veggies: ListBuffer[Veggies] = _
    private var _cheese: Cheese = _
    private var _pepperoni: Pepperoni = _
    private var _clam: Clams = _

    def prepare(): Unit

    def bake(): Unit = {
        println("Bake for 25 minutes at 350")
    }

    def cut(): Unit = {
        println("Cutting the pizza into diagonal slices")
    }

    def box(): Unit = {
        println("Place pizza in official PizzaStore box")
    }

    override def toString(): String

    def name: String = _name

    def sauce: Sauce = _sauce

    def veggies: ListBuffer[Veggies] = _veggies

    def cheese: Cheese = _cheese

    def pepperoni: Pepperoni = _pepperoni

    def clam: Clams = _clam

    def dough: Dough = _dough

    def name_=(value: String) = {
        _name = value
    }

    def sauce_=(value: Sauce) = {
        _sauce = value
    }

    def veggies_=(value: ListBuffer[Veggies]) = {
        _veggies = value
    }

    def cheese_=(value: Cheese) = {
        _cheese = value
    }

    def pepperoni_=(value: Pepperoni) = {
        _pepperoni = value
    }

    def clam_=(value: Clams) = {
        _clam = value
    }

    def dough_=(value: Dough) = {
        _dough = value
    }
}
