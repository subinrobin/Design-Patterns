A functor is a term that comes from category theory in mathematics. It is a requirement for monads.

In Scala, a functor is a class that has a map method and conforms to a few laws(functor laws).

map method for functor of F[T] type takes a function from T to Y as a parameter and returns a F[Y] as a result.

**functor laws**
1. identity function
2. multiple maps must compose together. It should make no difference if we do operation ```map(map(x)(i => y(i)))(i => z(i)) or map(x)(i => z(y(i)))```
3. map function preserves the structure of the data, it just changes the representation. it does not add or remove elements, change their order and so on.
   
For example, we can now safely postpone different mappings of data in time or just do them all together, and be sure that the final result will be the same.

functors set a specific set of laws on their operations (map, in this case) that must be in place and allow us to automatically reason about their results and effects.