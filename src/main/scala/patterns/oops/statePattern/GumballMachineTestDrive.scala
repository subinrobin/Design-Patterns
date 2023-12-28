package patterns.oops.statePattern

import patterns.oops.statePattern.gumball.GumballMachine

object GumballMachineTestDrive {
  
    def main(args: Array[String]): Unit = {
        val gumballMachine = new GumballMachine(5)
        println(gumballMachine)

        gumballMachine.insertQuarter()
        gumballMachine.turnCrank()

        println(gumballMachine)

        gumballMachine.insertQuarter()
        gumballMachine.ejectQuarter()
        gumballMachine.turnCrank()

        println(gumballMachine)

        gumballMachine.insertQuarter()
        gumballMachine.turnCrank()
        gumballMachine.insertQuarter()
        gumballMachine.turnCrank()
        gumballMachine.ejectQuarter()

        println(gumballMachine)

        gumballMachine.insertQuarter()
        gumballMachine.insertQuarter()
        gumballMachine.turnCrank()
        gumballMachine.insertQuarter()
        gumballMachine.turnCrank()
        gumballMachine.insertQuarter()
        gumballMachine.turnCrank()

        println(gumballMachine)
    }
}
