Template design pattern defers algorithm steps to subclasses using template methods.

**Not Good for**
1. when frameworks built using template patter becomes large, its harder to extend a huge class and implement few of its methods. In this case, passing an interface to the constructor and using it in the skeleton might be better idea (strategy pattern)