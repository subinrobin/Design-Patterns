package patterns.oops.proxyPattern.states

import scala.util.Random

class HasQuarterState(gumballMachine: GumballMachine) extends State {

    def insertQuarter(): Unit = {
        println("You can't insert another quarter")
    }

    def ejectQuarter(): Unit = {
        println("Quarter returned")
        gumballMachine.state_=(gumballMachine.noQuarterState)
    }

    def turnCrank(): Unit = {
        println("You turned crank...")
        val winner = Random.nextInt(10)
        if (winner == 0 && gumballMachine.count > 1) {
            gumballMachine.state_=(gumballMachine.winnerState)
        } else {
            gumballMachine.state_=(gumballMachine.soldState)
        }
    }

    def dispense(): Unit = {
        println("No gumball dispensed")
    }

}
