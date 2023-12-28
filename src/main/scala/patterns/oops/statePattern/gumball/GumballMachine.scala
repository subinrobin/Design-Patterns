package patterns.oops.statePattern.gumball

class GumballMachine(private var count: Int) {

    private var state: State = SOLD_OUT

    if (count > 0) {
        state = NO_QUARTER
    }

    def insertQuarter(): Unit = {
        state match {
            case HAS_QUARTER =>
                println("You can't insert another quarter")
            case NO_QUARTER =>
                println("You inserted a quarter")
                state = HAS_QUARTER
            case SOLD_OUT =>
                println("You can't insert a quarter, the machine is sold out")
            case SOLD =>
                println("Please wait, we're already giving you a gumball")
        }
    }

    def ejectQuarter(): Unit = {
        state match {
            case HAS_QUARTER =>
                println("Quarter returned")
                state = NO_QUARTER
            case NO_QUARTER =>
                println("You haven't inserted a quarter")
            case SOLD =>
                println("Sorry, you already turned the crank")
            case SOLD_OUT =>
                println("You can't eject, you haven't inserted a quarter yet")
        }
    }

    def turnCrank(): Unit = {
        state match {
            case SOLD =>
                println("Turning twice doesn't get you another gumball")
            case NO_QUARTER =>
                println("You turned but there's no quarter")
            case SOLD_OUT =>
                println("You turned, but there are no gumballs")
            case HAS_QUARTER =>
                println("You turned...")
                state = SOLD
                dispense()
        }
    }

    def dispense(): Unit = {
        state match {
            case SOLD =>
                println("A gumball comes rolling out the slot")
                count -= 1
                if (count == 0) {
                    println("Oops, out of gumballs")
                    state = SOLD_OUT
                } else {
                    state = NO_QUARTER
                }
            case NO_QUARTER =>
                println("You need to pay first")
            case SOLD_OUT =>
                println("No gumball dispensed")
            case HAS_QUARTER =>
                println("You need to turn the crank")

        }
    }

    override def toString(): String = {
        s"State: $state, count: $count"
    }

    def refill(count: Int) = {
        this.count += count
    }
}
