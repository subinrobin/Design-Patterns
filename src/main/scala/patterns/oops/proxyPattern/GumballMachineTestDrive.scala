package patterns.oops.proxyPattern

import patterns.oops.proxyPattern.states.GumballMachine
import patterns.oops.proxyPattern.states.GumballMonitor

object GumballMachineTestDrive {
  
    def main(args: Array[String]): Unit = {
        val count = 112

        val gumballMachine = new GumballMachine("Austin", count)

        val monitor = new GumballMonitor(gumballMachine)

        monitor.report()
    }
}
