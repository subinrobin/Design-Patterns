The builder design pattern helps to create instances of classes using class methods rather than class constructors. It is useful when a class need multiple versions of its constructor. This pattern uses an extra object, called builder, to receive and store initialization parameters before building the final version of an object.

**Good for**
1. to create complex object, which otherwise require to define many constructors
2. makes object creation easier, cleaner and readable

**Not Good for**
1. type-safe builder had advanced logic
2. java like implementation has lot of duplicate code