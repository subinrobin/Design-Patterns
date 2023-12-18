package patterns.oops.factoryPattern.common

sealed trait PizzaType

case object CHEESE extends PizzaType

case object GREEK extends PizzaType

case object PEPPERONI extends PizzaType

case object CLAM extends PizzaType

case object VEGGIE extends PizzaType
