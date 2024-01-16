package features.fp.monads

sealed trait Option1[A] extends Monad[A]

case class Some1[A](a: A) extends Option1[A] {
    override def unit[Y](value: Y): Monad[Y] = Some1(value)

    override def flatMap[Y](f: (A) => Monad[Y]): Monad[Y] = f(a)
}

case class None1[A]() extends Option1[A] {
    override def unit[Y](value: Y): Monad[Y] = None1()

    override def flatMap[Y](f: (A) => Monad[Y]): Monad[Y] = None1()
}

case class Doer_v2() {
    def getAlgorithm(isFail: Boolean): Option1[Algorithm_v2] =
        if (isFail) {
            None1()
        } else {
            Some1(Algorithm_v2())
        }
}

case class Algorithm_v2() {
    def getImplementation(isFail: Boolean, left: Int, right: Int): Option1[Implementation] =
        if (isFail) {
            None1()
        } else {
            Some1(Implementation(left, right))
        }
}

object MonadExample {
    def main(args: Array[String]): Unit = {
        System.out.println(s"The result is: ${compute(Some1(Doer_v2()), 10, 16)}")
    }

    def compute(doer: Option1[Doer_v2], left: Int, right: Int) =
        for {
            d <- doer
            a <- d.getAlgorithm(false)
            i <- a.getImplementation(false, left, right)
        } yield i.compute

    // OR THIS WAY:
    //  doer.flatMap {
    //    d =>
    //      d.getAlgorithm(false).flatMap {
    //        a =>
    //          a.getImplementation(false, left, right).map {
    //            i => i.compute
    //          }
    //      }
    //  }
}