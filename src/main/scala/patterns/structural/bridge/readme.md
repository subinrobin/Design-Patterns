The bridge pattern helps to decouple an abstraction from its implementation so that the two can vary independently. This is similar to adapter pattern, but used for our application.

**Good for**
1. avoids exponential number of classes 
2. separation of hierarchies allows to independently extend without affecting the other one

**Not Good for**
1. should use some creational design patterns to pick implementation