package patterns.functional.monoids

// Scala representation of a monoid
trait Monoid[T] {
    def op(l: T, r: T): T // algebraic expression
    def zero: T // identity element
}
