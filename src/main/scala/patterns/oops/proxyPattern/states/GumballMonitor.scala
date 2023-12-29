package patterns.oops.proxyPattern.states

class GumballMonitor(gumballMachine: GumballMachine) {
  
    def report(): Unit = {
        println(s"Gumball Machine: ${gumballMachine.location}")
        println(s"Current Inventory: ${gumballMachine.count} gumballs")
        println(s"Current state: ${gumballMachine.state}")
    }
}
