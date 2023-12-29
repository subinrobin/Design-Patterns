package features.abstractAndSelfTypes

// Subtype Polymorphism, run time
abstract class Item {
    def pack: String
}

class Fruit extends Item {
    override def pack: String = "I'm a fruit and I'm packed in a bag."
}

class Drink extends Item {
    override def pack: String = "I'm a drink and I'm packed in a bottle."
}

object SubtypePolymorphismExample {
    def main(args: Array[String]): Unit = {
        val shoppingBasket: List[Item] = List(
          new Fruit,
          new Drink
        )
        shoppingBasket.foreach(i => System.out.println(i.pack))
    }
}

// Parametric polymorphism inf fp was shown in generics earlier (AbstractTypes.scala)

// Ad hoc polymorphism (somewhat similar to function overloading), compile time
trait Adder1[T] {
    def sum(a: T, b: T): T
}

object Adder1 {
    def sum[T: Adder1](a: T, b: T): T = implicitly[Adder1[T]].sum(a, b)

    implicit val int2Adder: Adder1[Int] = new Adder1[Int] {
        override def sum(a: Int, b: Int): Int = a + b
    }

    implicit val string2Adder: Adder1[String] =
        (a: String, b: String) => s"$a concatenated with $b"

    implicit def numeric2Adder[T: Numeric]: Adder1[T] = new Adder1[T] {
        override def sum(a: T, b: T): T = implicitly[Numeric[T]].plus(a, b)
    }
}

object AdhocPolymorphismExample {
    import Adder1._
    def main(args: Array[String]): Unit = {
        System.out.println(s"The sum of 1 + 2 is ${sum(1, 2)}")
        System.out.println(s"The sum of abc + def is ${sum("abc", "def")}")
        System.out.println(s"The sum of 1.2 + 6.5 is ${sum(1.2, 6.5)}")
    }
}
