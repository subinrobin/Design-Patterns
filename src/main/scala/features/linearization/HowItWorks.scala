package features.linearization

class Animal extends AnyRef
class Dog extends Animal

// Animal -> AnyRef -> Any
// Dog -> Animal -> AnyRef -> Any

// class A extends B with T1 with T2.
// A +: T2L +: T1L +: BL +: AnyRef +: Any.

trait Test1 {
    println("inside test1")
}

trait Test2 {
    println("inside test2")
}

abstract class absTest1 {
    println("abstract1")
}

object TestRunner extends absTest1 with Test1 with Test2 {
    println("TestRunner initiate")
    def main(args: Array[String]): Unit = {
        println("run main")
    }
}
