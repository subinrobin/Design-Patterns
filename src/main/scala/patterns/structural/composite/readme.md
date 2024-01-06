The composite design pattern is used to describe groups of objects that should be treated the same way as a single one. Its purpose is to compose objects into tree structures to represent whole-part hierarchies.

**useful for**
1. code duplication removal
2. avoiding errors in cases where groups of objects are generally treated the same way.

**Not Good for**
1. should be careful in case of massive hierarchies. deep recursive nested items could cause stack overflow issues.