The Decorator Pattern attaches additional responsibilities to an object dynamically. Decorators provide a flexible alternative to subclassing for extending functionality.

Be careful when choosing the areas of code that need to be extended; applying the Open-Closed Principle EVERYWHERE is wasteful and unnecessary, and can lead to complex, hard-to-understand code.

## Facts
* Decorators have the same supertype as the objects they decorate
* You can use one or more decorators to wrap an object

## OO Principles
* Encapsulate what varies
* Favor composition over inheritance
* Program to interface, not implementations
* Strive for loosely couped designs between objects that interact
* Classes should be open for extension but closed for modification

## OO Basics
* Abstraction
* Encapsulation
* Polymorphism
* Inheritance