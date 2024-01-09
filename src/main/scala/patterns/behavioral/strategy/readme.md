Strategy design pattern enables us to define a family of algorithms and select a specific one at runtime. This pattern helps with encapsulation as each algorithm can be separately define and then injected into the classes that use it. Different implementations are also interchangeable.

**Good for**
1. Change implementation during runtime

**Not Good for**
1. Methods could be defined in an object, class, case class, trait.. Different approaches not good while working as a team.