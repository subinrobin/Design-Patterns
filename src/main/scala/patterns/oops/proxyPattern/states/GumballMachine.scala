package patterns.oops.proxyPattern.states

class GumballMachine(val location: String, numberGumballs: Int) {

    val soldOutState: State = new SoldOutState(this)
    val noQuarterState: State = new NoQuarterState(this)
    val hasQuarterState: State = new HasQuarterState(this)
    val soldState: State = new SoldState(this)
    val winnerState: State = new WinnerState(this)

    private var _state: State = _

    def state = _state

    def state_=(value: State) = {
        _state = value
    }

    private var _count = numberGumballs

    def count = _count

    if (numberGumballs > 0) {
        state = noQuarterState
    } else {
        state = soldOutState
    }

    def insertQuarter(): Unit = {
        state.insertQuarter()
    }

    def ejectQuarter(): Unit = {
        state.ejectQuarter()
    }

    def turnCrank(): Unit = {
        state.turnCrank()
        state.dispense()
    }

    def releaseBall(): Unit = {
        println("A gumball comes rolling out the slot...")
        if (_count > 0) {
            _count -= 1
        }
    }

    override def toString(): String = {
        s"State: $state, count: $count"
    }

}
