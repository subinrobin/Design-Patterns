package features.mixinCompositions

// Both traits have the same method signature
// But implementation is only one while extending both
// getTime cannot be differentiated with different return types
// causes compile error
trait FormalGreeting {
    def hello(): String

    // def getTime(): String
}

trait InformalGreeting {
    def hello(): String

    // def getTime(): Int
}

class Greeter extends FormalGreeting with InformalGreeting {
    override def hello(): String = "Good morning, sir/madam!"

}

object GreeterUser {
    def main(args: Array[String]): Unit = {
        val greeter = new Greeter()
        System.out.println(greeter.hello())
    }
}

trait A {
    def hello(): String = "Hello, I am trait A!"
}

trait B {
    def hello(): String = "Hello, I am trait B!"
}

object Clashing extends A with B { // as both trait has impl, shd be overridden here
    override def hello(): String = super[A].hello()

    def main(args: Array[String]): Unit = {
        System.out.println(hello())
    }
}

trait C {
    def value(a: Int): Int = a
}

trait D {
    def value(a: Int): String = a.toString
}

object Example {

    // alternate approach to handle same method signrature but different return types
    val c = new C {}
    val d = new D {}

    def main(args: Array[String]): Unit = {
        System.out.println(s"c.value: ${c.value(10)}")
        System.out.println(s"d.value: ${d.value(10)}")
    }
}
