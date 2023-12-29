package patterns.oops.proxyPattern.states

class NoQuarterState(gumballMachine: GumballMachine) extends State {

    def insertQuarter(): Unit = {
        println("You inserted a quarter")
        gumballMachine.state_=(gumballMachine.hasQuarterState)
    }

    def ejectQuarter(): Unit = {
        println("You haven't inserted a quarter")
    }

    def turnCrank(): Unit = {
        println("You turned, but there's no quarter")
    }

    def dispense(): Unit = {
        println("You need to pay first")
    }

}
