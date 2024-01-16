A monoid is a purely algebraic structure, which means that it is defined only by its algebra. All monoids must conform to the so-called monoid laws.

**Algebraic:** It is defined only by its algebra, for eg, operations it supports and the laws it conforms to.

1. monoid contains a T type
2. monoid contains one associative binary operation. _op(op(x, y), z) == op(x, op(y, z))_ x, y, z of T type
3. must have an identity element

With the use of monoids, we can easily facilitate parallel computation and build complex calculations from small pieces.

Monoid support _composition_. If A and B are monoids, then their product(A, B) is also a monoid.

**When to use?**
1. Monoid represented code can have simpler representations(not scalable).
2. Monoids allows us to write generic and reusable code.
3. With monoids, we can focus on simple operations and then just compose them together than build concrete implementations for everything we want.
4. Monoids not worth for _one-off_ functions.