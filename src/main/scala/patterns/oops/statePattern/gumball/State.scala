package patterns.oops.statePattern.gumball

sealed trait State

case object HAS_QUARTER extends State

case object NO_QUARTER extends State

case object SOLD_OUT extends State

case object SOLD extends State
