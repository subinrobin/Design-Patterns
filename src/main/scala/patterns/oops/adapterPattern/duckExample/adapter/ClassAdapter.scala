package patterns.oops.adapterPattern.duckExample.adapter

import patterns.oops.adapterPattern.duckExample.duck.Duck
import patterns.oops.adapterPattern.duckExample.turkey.Turkey
import patterns.oops.adapterPattern.duckExample.duck.MallardDuck
import patterns.oops.adapterPattern.duckExample.turkey.WildTurkey

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
