package patterns.oops.proxyPattern.states

import patterns.oops.proxyPattern.states.GumballMachine

class SoldOutState(gumballMachine: GumballMachine) extends State {
  
    def insertQuarter(): Unit = {
        println("You can't insert a quarter, the machine is sold out")
    }
    
    def ejectQuarter(): Unit = {
        println("You can't eject, you haven't inserted a quarter yet")
    }
    
    def turnCrank(): Unit = {
        println("You turned crank, but there are no gumballs")
    }
    
    def dispense(): Unit = {
        println("No gumball dispensed")
    }


}
