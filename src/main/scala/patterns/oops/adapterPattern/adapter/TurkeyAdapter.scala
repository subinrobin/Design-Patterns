package patterns.oops.adapterPattern.adapter

import patterns.oops.adapterPattern.duck.Duck
import patterns.oops.adapterPattern.turkey.Turkey

class TurkeyAdapter(turkey: Turkey) extends Duck {
  
    def quack(): Unit = {
        turkey.gobble()
    }

    def fly(): Unit = {
        for(i <- 1 to 5) {
            turkey.fly()
        }
    }
}
