State design pattern allows us to choose a different behavior of an object based on the objects internal state.

**Difference with strategy pattern**
1. strategy pattern is about how an action is performed. usually an algorithm that produces same results as other algorithms.
2. state pattern is about what action is performed. depending on state, an object could do different things

**Good for**
1. makes code readable and gets rid of conditional statements

**Not Good for**
1. careful about side effects caused by state change