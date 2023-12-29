package patterns.oops.proxyPattern.states

class WinnerState(gumballMachine: GumballMachine) extends State {

    def insertQuarter(): Unit = {
        println("Please wait, we're already giving you a gumball")
    }

    def ejectQuarter(): Unit = {
        println("Sorry, you already turned the crank")
    }

    def turnCrank(): Unit = {
        println("Truning twice doesn't get you another gumball!")
    }

    def dispense(): Unit = {
        gumballMachine.releaseBall()
        if (gumballMachine.count == 0) {
            gumballMachine.state_=(gumballMachine.soldOutState)
        } else {
            gumballMachine.releaseBall()
            println("YOU'RE A WINNER! You got 2 gumballs for your quarter")
            if (gumballMachine.count > 0) {
                gumballMachine.state_=(gumballMachine.noQuarterState)
            } else {
                println("Oops, out of gumballs")
                gumballMachine.state_=(gumballMachine.soldOutState)
            }
        }
    }

}
