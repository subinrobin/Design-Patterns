package patterns.oops.adapterPattern.duckExample.adapter

import patterns.oops.adapterPattern.duckExample.duck.Duck
import patterns.oops.adapterPattern.duckExample.turkey.Turkey

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
