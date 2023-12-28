package patterns.oops.statePattern

import patterns.oops.statePattern.states.GumballMachine

object ModifiedTestDrive {
  
    def main(args: Array[String]): Unit = {
        val gumballMachine = new GumballMachine(5)

        println(gumballMachine)

        gumballMachine.insertQuarter()
        gumballMachine.turnCrank()

        print(gumballMachine)

        gumballMachine.insertQuarter()
        gumballMachine.turnCrank()
        gumballMachine.insertQuarter()
        gumballMachine.turnCrank()

        print(gumballMachine)
    }
}
