package patterns.oops.adapterPattern

import patterns.oops.adapterPattern.duck.MallardDuck
import patterns.oops.adapterPattern.turkey.WildTurkey
import patterns.oops.adapterPattern.adapter.TurkeyAdapter
import patterns.oops.adapterPattern.duck.Duck
import patterns.oops.adapterPattern.adapter.DuckAdapter
import patterns.oops.adapterPattern.turkey.Turkey
import patterns.oops.adapterPattern.adapter.ClassAdapter

object DuckTestDrive {
  
    def main(args: Array[String]): Unit = {
        val mallardDuck = new MallardDuck
        val duckAdapter = new DuckAdapter(mallardDuck)

        val wildTurkey = new WildTurkey
        val turkeyAdapter = new TurkeyAdapter(wildTurkey)

        println("Turkey says.....")
        testTurkey(wildTurkey)

        println("The Duck says.....")
        testDuck(mallardDuck)

        println("TurkeyAdapter says....")
        testDuck(turkeyAdapter)

        println("DuckAdapter says....")
        testTurkey(duckAdapter)

        val classAdapter = new ClassAdapter
        println("ClassAdapter says....")
        classAdapter.gobble()
        classAdapter.quack()
        classAdapter.fly()

    }

    def testDuck(duck: Duck) = {
        duck.quack()
        duck.fly()
    }

    def testTurkey(turkey: Turkey) = {
        turkey.gobble()
        turkey.fly()
    }
}
