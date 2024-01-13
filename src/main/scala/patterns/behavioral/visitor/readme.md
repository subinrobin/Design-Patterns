Visitor design pattern helps us add new operations to existing object structure without modifying them.

**Good for**
1. applications with large object hierarchies, where adding new functionality involves lots of refactoring

**Not Good for**
1. could be bulky and lots of boilerplate code.
2. if some component is not designed to support the pattern, we cannot use it, if not allowed to change original code.