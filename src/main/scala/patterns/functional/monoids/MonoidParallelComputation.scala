package patterns.functional.monoids

// associative, hence nested operations done independent and parallel
// eg. 4!. op(op(op(1, 2), 3), 4)
// op(op(1, 2), op(3, 4))

object MonoidOperationsBF {
    def balancedFold[T, Y](list: IndexedSeq[T], m: Monoid[Y])(f: T => Y): Y = {
        if (list.isEmpty) {
            m.zero
        } else if (list.length == 1) {
            f(list(0))
        } else {
            val (left, right) = list.splitAt(list.length / 2)
            m.op(balancedFold(left, m)(f), balancedFold(right, m)(f))
        }
    }
}

object MonoidBalancedFold {
    def main(args: Array[String]): Unit = {
        val numbers = Array(1, 2, 3, 4)
        System.out.println(s"4! is: ${MonoidOperationsBF.balancedFold(numbers, intMultiplication)(identity)}")
    }
}

object MonoidOperationsPar {
    import scala.collection.parallel.CollectionConverters._
    def foldPar[T](list: List[T], m: Monoid[T]): T =
        foldMapPar(list, m)(identity)

    def foldMapPar[T, Y](list: List[T], m: Monoid[Y])(f: T => Y): Y = {
        list.par.foldLeft(m.zero) {
            case (t, y) => m.op(t, f(y))
        }
    }
}

object MonoidFoldingGenericPar {
    def main(args: Array[String]): Unit = {
        val strings = List("This is\n", "a list of\n", "strings!")
        val numbers = List(1, 2, 3, 4, 5, 6)
        System.out.println(s"Left folded:\n${MonoidOperationsPar.foldPar(strings,
            stringConcatenation)}")
        System.out.println(s"Right folded:\n${MonoidOperationsPar.foldPar(strings,
            stringConcatenation)}")
        System.out.println(s"6! is: ${MonoidOperationsPar.foldPar(numbers,
            intMultiplication)}")
    }
}