Proxy design pattern provides an interface to something else that then gets served behind the scenes to the user. This is another example of a wrapper similar to a basic and limited decorator pattern. The relationship between proxy and wrapped object is established during compile time.

**Useful for**
In some applications, developers could face the need to provide access control to objects. Reasons include hiding implementation details, improving interaction with expensive resources, interfacing with remote resources, caching, providing lazy or eager initialization, etc

**Good for**
1. delegate expensive operations to other classes
2. do lazy operations