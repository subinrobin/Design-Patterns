Monads are functors that have the unit and flatMap methods and follow the monad rules.

```def flatMap[T](f: Y => Monad[T]) : Monad[T] = flatten(map(f))```
```def flatten[T](x: F[F[T]]): M[T]```

```def unit[T](value: T): Monad[T]```

```def map[T](f: Y => T): Monad[T] = flatMap { x => unit(f(x)) }```

**Monad Laws**
1. _Identity Law_: Doing _map_ over identity function doesn't change data -- ```x.map(i => i) == x```. Flatmap over _unit_ function also keeps data the same -- ```x.flatMap(i => unit(i)) == x```. _Unit_ method is like _zero_ element in monoids.
2. _Unit Law_: ```unit(x).flatMap { y => f(y) } == f(x); unit(x).map { y => f(x) } == unit(f(x))```
3. _Composition_:Multiple maps must be composed together. ```x.map(i => y(i)).map(i => z(i)) or x.map(i => z(y(i))```. Multiple flatMap calls must also compose, ```x.flatMap(i => y(i)).flatMap(i => z(i)) == x.flatMap(i => y(i).flatMap(j => z(j)))```

