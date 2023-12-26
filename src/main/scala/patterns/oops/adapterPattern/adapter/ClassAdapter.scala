package patterns.oops.adapterPattern.adapter

import patterns.oops.adapterPattern.duck.Duck
import patterns.oops.adapterPattern.turkey.Turkey
import patterns.oops.adapterPattern.duck.MallardDuck
import patterns.oops.adapterPattern.turkey.WildTurkey

class ClassAdapter extends Duck with Turkey {
  
    private val duck = new MallardDuck
    private val turkey = new WildTurkey

    def quack(): Unit = {
        duck.quack()
    }
    
    def gobble(): Unit = {
        turkey.gobble()
    }
    
    def fly(): Unit = {
        duck.fly()
    }
    
}
