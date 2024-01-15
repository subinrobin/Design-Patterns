package patterns.functional.monoids

object MonoidComposition {
    def compose[T, Y](a: Monoid[T], b: Monoid[Y]): Monoid[(T, Y)] =
        new Monoid[(T, Y)] {
            val zero: (T, Y) = (a.zero, b.zero)

            override def op(l: (T, Y), r: (T, Y)): (T, Y) =
                (a.op(l._1, r._1), b.op(l._2, r._2))
        }

    def mapMerge[K, V](a: Monoid[V]): Monoid[Map[K, V]] =
        new Monoid[Map[K, V]] {
            override def zero: Map[K, V] = Map()

            override def op(l: Map[K, V], r: Map[K, V]): Map[K, V] =
                (l.keySet ++ r.keySet).foldLeft(zero) {
                    case (res, key) => res.updated(key, a.op(l.getOrElse(key,
                        a.zero), r.getOrElse(key, a.zero)))
                }
        }
}

object ComposedMonoid {
    def main(args: Array[String]): Unit = {
        val numbers = Array(1, 2, 3, 4, 5, 6)
        val sumAndProduct = MonoidComposition.compose(intAddition, intMultiplication)
        System.out.println(s"The sum and product is: ${MonoidOperationsBF.balancedFold(numbers, sumAndProduct)(i => (i, i))}")
    }
}

object FeatureCounting {
    def main(args: Array[String]): Unit = {
        val features = Array("hello", "features", "for", "ml", "hello",
            "for", "features")
        val counterMonoid: Monoid[Map[String, Int]] = MonoidComposition.mapMerge(intAddition)
        System.out.println(s"The features are: ${MonoidOperationsBF.balancedFold(features, counterMonoid)(i => Map(i -> 1))}")
    }
}

object FeatureCountingOneOff {
    def main(args: Array[String]): Unit = {
        val features = Array("hello", "features", "for", "ml", "hello",
            "for", "features")
        System.out.println(s"The features are: ${
            features.foldLeft(Map[String, Int]()) {
                case (res, feature) => res.updated(feature,
                    res.getOrElse(feature, 0) + 1)
            }
        }")
    }
}