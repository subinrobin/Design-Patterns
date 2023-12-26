package patterns.oops.adapterPattern.duckExample.adapter

import patterns.oops.adapterPattern.duckExample.turkey.Turkey
import patterns.oops.adapterPattern.duckExample.duck.Duck
import scala.util.Random

class DuckAdapter(duck: Duck) extends Turkey {
    
    def gobble(): Unit = {
        duck.quack()
    }

    def fly(): Unit = {
        if(Random.nextInt() == 5) {
            duck.fly()
        }
    }
}
