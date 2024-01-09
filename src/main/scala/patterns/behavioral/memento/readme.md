Memento design pattern provides the ability to execute an undo action in order to restore an object to a previous state.

_Originator_ - object whose state to be restored
_Caretaker_ - object that triggers the changes to the originator object and uses memento objects for rollback, if needed
_Memento_ - object that carries the actual state of the originator and can be used to restore to one of the previous states

momento object can be handled only by originator. caretaker and all other classes can just store it.

**Pitfalls**
1. try to save state in value objects as mutable type will have side effects
2. more memory required for unlimited undo operation
3. scala is immutable, but momento pattern is not