Command design pattern encapsulates the information needed to perform an action at a later stage and pass this information to the object that will be running the actual code. Useful for things like supporting undo actions, implementing parallel processing or simply optimizing code by deferring and possibly avoiding code execution.

**Good for**
1. to delay, log or sequence methods calls
2. decouples invoker from object that performs the operations

**Not Good for**
1. It can receive any Unit data in the by-name parameter which are irrelevant