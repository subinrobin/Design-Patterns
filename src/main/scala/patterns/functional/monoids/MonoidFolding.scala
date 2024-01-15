package patterns.functional

import patterns.functional.monoids.Monoid

package object monoids {
    val intAddition: Monoid[Int] = new Monoid[Int] {
        val zero: Int = 0

        override def op(l: Int, r: Int): Int = l + r
    }

    val intMultiplication: Monoid[Int] = new Monoid[Int] {
        val zero: Int = 1

        override def op(l: Int, r: Int): Int = l * r
    }

    val stringConcatenation: Monoid[String] = new Monoid[String] {
        val zero: String = ""

        override def op(l: String, r: String): String = l + r
    }

}

object MonoidFolding {
    import monoids._
    def main(args: Array[String]): Unit = {
        val strings = List("This is\n", "a list of\n", "strings!")
        val numbers = List(1, 2, 3, 4, 5, 6)
        System.out.println(s"Left folded:\n${strings.foldLeft(stringConcatenation.zero)(stringConcatenation.op)}")
        System.out.println(s"Right folded:\n${strings.foldRight(stringConcatenation.zero)(stringConcatenation.op)}")
        System.out.println(s"6! is: ${numbers.foldLeft(intMultiplication.zero)(intMultiplication.op)}")
    }
}

object MonoidOperations {
    def fold[T](list: List[T], m: Monoid[T]): T = list.foldLeft(m.zero)(m.op)
}

object MonoidFoldingGeneric {
    import monoids._
    def main(args: Array[String]): Unit = {
        val strings = List("This is\n", "a list of\n", "strings!")
        val numbers = List(1, 2, 3, 4, 5, 6)
        System.out.println(s"Left folded:\n${MonoidOperations.fold(strings, stringConcatenation)}")
        System.out.println(s"Right folded:\n${MonoidOperations.fold(strings, stringConcatenation)}")
        System.out.println(s"6! is: ${MonoidOperations.fold(numbers, intMultiplication)}")
    }
}

// A and B are of different types in below example
// for such scenario should add possibility of mapping the type of original list to different type
object MonoidOperationsDifferentTypes {
    def fold[T](list: List[T], m: Monoid[T]): T = foldMap(list, m)(identity)

    // support method for 2 different types. use some casting function
    def foldMap[T, Y](list: List[T], m: Monoid[Y])(f: T => Y): Y =
        list.foldLeft(m.zero) {
            case (t, y) => m.op(t, f(y))
        }
}

object MonoidFoldingDifferentTypes {
    import monoids._
    def main(args: Array[String]): Unit = {
        val strings = List("This is\n", "a list of\n", "strings!")
        val numbers = List(1, 2, 3, 4, 5, 6)
        println(MonoidOperationsDifferentTypes.foldMap(strings, intAddition)((s: String) => 0))
        println(MonoidOperationsDifferentTypes.foldMap(numbers, stringConcatenation)((n: Int) => n.toString))
    }
}
