package patterns.oops.adapterPattern.adapter

import patterns.oops.adapterPattern.turkey.Turkey
import patterns.oops.adapterPattern.duck.Duck
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
