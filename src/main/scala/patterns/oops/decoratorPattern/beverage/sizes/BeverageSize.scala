package patterns.oops.decoratorPattern.beverage.sizes

sealed trait BeverageSize

case object TALL extends BeverageSize

case object GRANDE extends BeverageSize

case object VENTI extends BeverageSize